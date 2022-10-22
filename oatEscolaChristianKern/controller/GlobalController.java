package controller;

import java.util.*;
import model.*;
import view.LerInfo;

public class GlobalController {
  private PessoaController pessoas;
  private MateriaController materias;
  private CursoController cursos;

  public GlobalController() {
    pessoas = new PessoaController();
    materias = new MateriaController();
    cursos = new CursoController();
  }

  public void CadastrarNovoAluno() {
    Aluno aluno = construirAluno();

    Aluno cpf = pessoas.findAlunoByCpf(aluno.getCpf());
    if (cpf != null) {
      System.out.println("Aluno ja está cadastrado!");
      return;
    }

    Aluno nome = pessoas.findAlunoByNome(aluno.getNome());
    if (nome != null) {
      System.out.println("Aluno ja está cadastrado!");
      return;
    }

    Aluno email = pessoas.findAlunoByEmail(aluno.getEmail());
    if (email != null) {
      System.out.println("Aluno ja está cadastrado!");
      return;
    }

    this.pessoas.adicionarAluno(aluno);
    System.out.println("Aluno Cadastrado com suceso");

  }

  private Aluno construirAluno() {
    LerInfo ler = new LerInfo();
    return new Aluno(
        ler.lerString("Digite o nome do aluno: "),
        ler.lerString("Digite o CPF do aluno: "),
        ler.lerData("Digite a data de nascimento do aluno:"),
        ler.lerEmail("Digite o email do aluno: "),
        ler.letBoolean("Aluno tem necessidade especial?"),
        ler.letBoolean("Aluno é bolsista?"),
        ler.lerMatricula("Digite a Matricula do aluno: "));
  }

  public void CadastrarNovoProfessor() {
    Professor prof = construirProfessor();

    Professor cpf = pessoas.findProfessorByCpf(prof.getCpf());
    Professor nome = pessoas.findProfessorByNome(prof.getNome());
    Professor email = pessoas.findProfessorByEmail(prof.getEmail());
    if (email != null || cpf != null || nome != null) {
      System.out.println("Professor ja está cadastrado!");
      return;
    }
    this.pessoas.adicionarProfessor(prof);
    System.out.println("Professor cadastrado com sucesso!");
  }

  private Professor construirProfessor() {
    LerInfo ler = new LerInfo();
    return new Professor(
        ler.lerString("Digite o nome do professor: "),
        ler.lerString("Digite o CPF do professor: "),
        ler.lerData("Digite a data de nascimento do professor"),
        ler.lerString("Digite o email do professor: "),
        ler.lerString("Digite o CTPS do professor: "),
        ler.lerDouble("Digite o salario do professor: "),
        ler.letBoolean("Professor esta ativo? "));
  }

  public void ListarAlunos() {
    pessoas.listarAlunos();
  }

  public void ListarProfessores() {
    pessoas.listarprofs();
  }

  private Professor buscarProfe() {
    LerInfo ler = new LerInfo();
    Professor prof = null;
    while (prof == null) {
      prof = pessoas.findProfessorByCpf(ler.lerString("Digite o CPF do professor: "));
      if (prof == null) {
        System.out.println("CPF nao encontrado, tente novamente!");
      }
    }
    return prof;
  }

  private Aluno buscarAluno() {
    LerInfo ler = new LerInfo();
    Aluno aluno = null;

    while (aluno == null) {
      String entrada = ler.lerString("Digite o CPF OU E-amil do Aluno: ");

      Aluno cpf = pessoas.findAlunoByCpf(entrada);

      Aluno email = pessoas.findAlunoByEmail(entrada);

      if (cpf == null && email == null) {
        System.out.println("Aluno nao encontrado, tente novamente!");
      } else {
        if (cpf == null) {
          aluno = email;
        } else {
          aluno = cpf;
        }
      }
    }
    return aluno;
  }

  public void ConcederBolsaAluno() {
    Aluno aluno = buscarAluno();
    List<Aluno> lista = this.pessoas.getAlunos();

    lista.remove(aluno);

    aluno.setBolsista(true);

    lista.add(aluno);

    this.pessoas.setAlunos(lista);
    System.out.println(aluno.getNome() + " marcado como bolsista!");
  }

  public void CadastrarNovaMateria() {
    Materia materia = construirMateria();
    this.materias.adicionarMateria(materia);
    System.out.println("Materia Cadastrada com sucesso!");
  }

  private Materia construirMateria() {
    LerInfo ler = new LerInfo();

    return new Materia(
        ler.lerString("Digite o nome da Materia: "),
        buscarProfe());
  }

  public void ListarMaterias() {
    this.materias.listarMaterias();
  }

  private Materia buscarMateria() {
    LerInfo ler = new LerInfo();
    Materia materia = null;
    while (materia == null) {
      materia = this.materias.findCursoByNomeMateria(ler.lerString("Digite o nome da materia: "));
      if (materia == null) {
        System.out.println("Materia nao encontrado, tente novamente!");
      }
    }
    return materia;
  }

  public void AlterarProfDaMateria() {
    List<Materia> lista = this.materias.getMaterias();
    Materia materia = buscarMateria();
    Professor prof = buscarProfe();
    lista.remove(materia);
    materia.setProfessor(prof);
    lista.add(materia);
    this.materias.setMaterias(lista);
    System.out.println("Professor alterado com suceso");
  }

  public void AdicionarCurso() {
    Curso curso = construirCurso();
    this.cursos.adicionarCurso(curso);
    System.out.println("Curso Adicionado com sucesso!");
  }

  public Curso construirCurso() {
    LerInfo ler = new LerInfo();
    return new Curso(
        ler.lerString("Digite o nome do curso: "),
        ler.lerString("Digite a descricao do curso: "),
        ler.lerData("Informe a data de inicio do curso"));
  }

  public void ListarCursos() {
    this.cursos.listarCursos();
  }

  public void AdicionarAlunoNoCurso() {
    Aluno aluno = buscarAluno();
    List<Curso> lista = this.cursos.getCursos();
    Curso curso = buscarCurso();
    Aluno cpf = curso.findAlunoByCpf(aluno.getCpf());
    if (cpf != null) {
      System.out.println("Aluno ja está Matriculado nesse curso!");
      return;
    }
    lista.remove(curso);
    curso.adicionarAluno(aluno);
    lista.add(curso);
    this.cursos.setCursos(lista);
    System.out.println("Aluno Matriculado ao curso " + curso.getNomeCurso());
  }

  public void AdicionarMateriaNoCurso() {
    Materia materia = buscarMateria();
    List<Curso> lista = this.cursos.getCursos();
    Curso curso = buscarCurso();
    Materia mat = curso.findMateriaByNome(materia.getNomeMateria());
    if (mat != null) {
      System.out.println("Materia ja está adicionada nesse curso!");
      return;
    }
    lista.remove(curso);
    curso.adicionarMateria(materia);
    lista.add(curso);
    this.cursos.setCursos(lista);
    System.out.println("Nova materia cadastrada ao curso " + curso.getNomeCurso());
  }

  private Curso buscarCurso() {
    LerInfo ler = new LerInfo();
    Curso curso = null;
    while (curso == null) {
      curso = this.cursos.findCursoByNomeCurso(ler.lerString("Digite o nome do curso: "));
      if (curso == null) {
        System.out.println("Curso nao encontrado, tente novamente!");
      }
    }
    return curso;
  }

}
