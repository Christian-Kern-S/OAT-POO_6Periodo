package model;

import java.util.*;
import view.LerInfo;

public class Aluno extends Pessoa {

    private String matricula;
    private Date dataMatricula;
    private boolean necessidadeEspecial = false;
    private boolean bolsista = false;

    public Aluno() {
    }

    public Aluno(String nome, String cpf, Calendar Datanascimento, String email, boolean bolsista,
            boolean necessidadeEspecial, String matricula) {
        setNome(nome);
        setCpf(cpf);
        setDatanascimento(Datanascimento);
        setEmail(email);
        setNecessidadeEspecial(necessidadeEspecial);
        setBolsista(bolsista);
        setMatricula(matricula);
        dataMatricula = new Date();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        LerInfo ler = new LerInfo();
        while (matricula == null || matricula == "") {
            matricula = ler.lerString("O campo de matriculas nao pode estar vazia!");
        }
        this.matricula = matricula;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public boolean isNecessidadeEspecial() {
        return necessidadeEspecial;
    }

    public void setNecessidadeEspecial(boolean necessidadeEspecial) {
        this.necessidadeEspecial = necessidadeEspecial;
    }

    public boolean isBolsista() {
        return bolsista;
    }

    public void setBolsista(boolean bolsista) {
        this.bolsista = bolsista;
    }

    public String toString() {
        return "########## ALUNO #########\n"
                + "Nome: " + getNome()
                + "\nCPF: " + getCpf()
                + "\nE-mail: " + getEmail()
                + "\nNecessidade Especial: " + isNecessidadeEspecial()
                + "\nBolsista: " + isBolsista()
                + "\nMatricula: " + getMatricula()
                + "\n################################################";
    }
}