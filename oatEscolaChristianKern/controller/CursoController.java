package controller;

import java.util.*;
import model.*;
import java.util.function.*;

public class CursoController {
  List<Curso> cursos;

  public CursoController() {
    cursos = new ArrayList<Curso>();
  }

  public void adicionarCurso(Curso curso) {
    this.cursos.add(curso);
  }

  public void listarCursos() {
    cursos.forEach(c -> {
      System.out.println(c);
    });
  }

  public Curso findCursoByNomeCurso(String nomeCurso) {
    Predicate<Curso> filtroNome = p -> p.getNomeCurso().equalsIgnoreCase(nomeCurso);
    Curso curso = cursos.stream().filter(filtroNome).findFirst().orElse(null);
    return curso;
  }

  public List<Curso> getCursos() {
    return cursos;
  }

  public void setCursos(List<Curso> cursos) {
    this.cursos = cursos;
  }
}