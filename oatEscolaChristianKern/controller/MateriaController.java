package controller;

import java.util.*;
import model.*;
import java.util.function.*;

public class MateriaController {
  private List<Materia> materias;

  public MateriaController() {
    materias = new ArrayList<Materia>();
  }

  public void adicionarMateria(Materia materia) {
    this.materias.add(materia);
  }

  public void listarMaterias() {
    materias.forEach(m -> {
      System.out.println(m);
    });
  }

  public Materia findCursoByNomeMateria(String nomeMateria) {
    Predicate<Materia> filtroNome = p -> p.getNomeMateria().equalsIgnoreCase(nomeMateria);
    Materia materia = materias.stream().filter(filtroNome).findFirst().orElse(null);
    return materia;
  }

  public List<Materia> getMaterias() {
    return materias;
  }

  public void setMaterias(List<Materia> materias) {
    this.materias = materias;
  }

}
