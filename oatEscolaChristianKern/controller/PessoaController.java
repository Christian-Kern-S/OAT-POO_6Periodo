package controller;

import java.util.*;
import java.util.function.Predicate;

import model.*;

public class PessoaController {

  private List<Professor> profs;
  private List<Aluno> alunos;

  public PessoaController() {
    alunos = new ArrayList<Aluno>();
    profs = new ArrayList<Professor>();
  }

  public void adicionarProfessor(Professor prof) {
    this.profs.add(prof);
  }

  public void adicionarAluno(Aluno aluno) {
    this.alunos.add(aluno);
  }

  public Aluno findAlunoByCpf(String cpf) {
    Predicate<Aluno> filtroCpf = p -> p.getCpf().equalsIgnoreCase(cpf);
    Aluno aluno = alunos.stream().filter(filtroCpf).findFirst().orElse(null);
    return aluno;
  }

  public Aluno findAlunoByNome(String nome) {
    Predicate<Aluno> filtroNome = p -> p.getNome().equalsIgnoreCase(nome);
    Aluno aluno = alunos.stream().filter(filtroNome).findFirst().orElse(null);
    return aluno;
  }

  public Aluno findAlunoByEmail(String email) {
    Predicate<Aluno> filtroEmail = p -> p.getEmail().equalsIgnoreCase(email);
    Aluno aluno = alunos.stream().filter(filtroEmail).findFirst().orElse(null);
    return aluno;
  }

  public Professor findProfessorByCpf(String cpf) {
    Predicate<Professor> filtroCpf = p -> p.getCpf().equalsIgnoreCase(cpf);
    Professor prof = profs.stream().filter(filtroCpf).findFirst().orElse(null);
    return prof;
  }

  public Professor findProfessorByNome(String nome) {
    Predicate<Professor> filtroNome = p -> p.getNome().equalsIgnoreCase(nome);
    Professor prof = profs.stream().filter(filtroNome).findFirst().orElse(null);
    return prof;
  }

  public Professor findProfessorByEmail(String email) {
    Predicate<Professor> filtroCpf = p -> p.getEmail().equalsIgnoreCase(email);
    Professor prof = profs.stream().filter(filtroCpf).findFirst().orElse(null);
    return prof;
  }

  public void listarAlunos() {
    alunos.forEach(a -> {
      System.out.println(a);
    });
  }

  public void listarprofs() {
    profs.forEach(p -> {
      System.out.println(p);
    });
  }

  public List<Aluno> getAlunos() {
    return alunos;
  }

  public void setAlunos(List<Aluno> alunos) {
    this.alunos = alunos;
  }

  public List<Professor> getprofs() {
    return profs;
  }

  public void setprofs(List<Professor> profs) {
    this.profs = profs;
  }
}
