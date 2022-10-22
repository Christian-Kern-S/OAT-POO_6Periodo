package model;

import view.LerInfo;

public class Materia {
    private String nomeMateria;
    private Professor professor;

    public Materia(String nomeMateria, Professor professor) {
        setProfessor(professor);
        setNomeMateria(nomeMateria);
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        LerInfo ler = new LerInfo();
        while (nomeMateria == null || nomeMateria == "") {
            nomeMateria = ler.lerString("O campo de nome da materia nao pode estar vazio!");
        }
        this.nomeMateria = nomeMateria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String toString() {
        return "####### Materia ########"
                + "\nNome Da Materia: " + getNomeMateria()
                + "\nProfessor: " + getProfessor().getNome()
                + "\n##############################";
    }

}