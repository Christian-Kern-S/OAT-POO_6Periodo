package model;

import java.util.function.*;
import java.util.*;
import view.LerInfo;

public class Curso {

    private String nomeCurso;
    private String descricao;
    private List<Materia> materias;
    private Calendar dataInicio;
    private boolean ativo;
    private String nomeProfe;
    private List<Aluno> alunos;

    public Curso() {
    }

    public Curso(String nomeCurso, String descricao, Calendar dataInicio) {
        setNomeCurso(nomeCurso);
        setDescricao(descricao);
        getDataInicio();
        materias = new ArrayList<>();
        alunos = new ArrayList<>();
        this.ativo = true;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        LerInfo ler = new LerInfo();
        while (nomeCurso == null || nomeCurso == "") {
            nomeCurso = ler.lerString("O campo nome não pode ser vazio!");
        }
        this.nomeCurso = nomeCurso;
    }

    public List<Materia> getMateria() {
        return materias;
    }

    public void setMateria(List<Materia> materia) {
        this.materias = materia;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Calendar getDataInicio() {
        LerInfo ler = new LerInfo();
        while (dataInicio == null) {
            dataInicio = ler.lerData("O campo de data de inicio nao pode estar vazia!");
        }
        return dataInicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        LerInfo ler = new LerInfo();
        while (descricao == null || descricao == "") {
            descricao = ler.lerString("O campo de descricao nao pode estar vazia!");
        }
        this.descricao = descricao;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void iniciarCurso() {
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void adicionarMateria(Materia materia) {
        this.materias.add(materia);
    }

    public Integer quantidadeAlunos() {
        return this.alunos.size();
    }

    public String nomeProfessores() {
        nomeProfe = "";
        this.materias.forEach(e -> {
            nomeProfe = nomeProfe + "\n" + e.getProfessor().getNome();
        });
        return nomeProfe;
    }

    public String toString() {
        return "######### Curso #########"
                + "\n# Nome do Curso: " + getNomeCurso()
                + "\n# Descricao: " + getDescricao()
                + "\n# Quantidade de Alunos: " + quantidadeAlunos()
                + "\n# Ativo: " + getAtivo()
                + "\n##############################";
    }

    public Aluno findAlunoByCpf(String cpf) {
        Predicate<Aluno> filtroCpf = p -> p.getCpf().equalsIgnoreCase(cpf);
        Aluno aluno = alunos.stream().filter(filtroCpf).findFirst().orElse(null);
        return aluno;
    }

    public Materia findMateriaByNome(String nome) {
        Predicate<Materia> filtroCpf = p -> p.getNomeMateria().equalsIgnoreCase(nome);
        Materia materia = materias.stream().filter(filtroCpf).findFirst().orElse(null);
        return materia;
    }

}