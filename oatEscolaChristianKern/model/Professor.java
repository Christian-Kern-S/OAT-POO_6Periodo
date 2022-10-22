package model;

import java.util.*;
import view.LerInfo;

public class Professor extends Pessoa {

    private String ctps;
    private double salario;
    private boolean ativo;
    private List<Materia> materia;

    public Professor(String nome, String cpf, Calendar Datanascimento, String email, String ctps, double salario,
            boolean ativo) {
        setNome(nome);
        setCpf(cpf);
        setDatanascimento(Datanascimento);
        setEmail(email);
        setCtps(ctps);
        setAtivo(ativo);
        setSalario(salario);
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        LerInfo ler = new LerInfo();
        while (salario <= 0) {
            salario = ler.lerDouble("O campo salario nao pode ser menor que 0!");
        }
        this.salario = salario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Materia> getMateria() {
        return materia;
    }

    public void setMateria(List<Materia> materia) {
        this.materia = materia;
    }

    public String toString() {
        return "######## Professor #######\n"
                + "Nome: " + getNome()
                + "\n# CPF: " + getCpf()
                + "\n# E-mail: " + getEmail()
                + "\n# Salario: " + getSalario()
                + "\n# CTPS: " + getCtps()
                + "\n# Ativo: " + isAtivo()
                + "\n##################################";
    }

}
