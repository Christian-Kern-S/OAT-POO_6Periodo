package model;

import java.util.*;

import view.LerInfo;

public abstract class Pessoa {

    private String nome;
    private String cpf;
    private Calendar Datanascimento;
    private String email;

    public Pessoa() {
    };

    public Pessoa(String nome, String cpf, String email, Calendar Datanascimento) {
        setNome(nome);
        setCpf(cpf);
        setDatanascimento(Datanascimento);
        setEmail(email);
    }

    public String getNome() {
        return nome;

    }

    public void setNome(String nome) {
        LerInfo ler = new LerInfo();
        while (nome == null || nome == "") {
            nome = ler.lerString("O campo nome nao pode estar vazio!");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        LerInfo ler = new LerInfo();
        while (cpf == null || cpf == "") {
            cpf = ler.lerString("CPF nao pode estar vazio");
        }
        this.cpf = cpf;
    }

    public Calendar getDatanascimento() {
        return this.Datanascimento;
    }

    public void setDatanascimento(Calendar Datanascimento) {
        this.Datanascimento = Datanascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        LerInfo ler = new LerInfo();
        while (email == null || email == "") {
            email = ler.lerString("O campo E-mail nao pode estar vazio!");
        }
        this.email = email;
    }

}