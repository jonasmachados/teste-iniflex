package com.jonas.iniflex.Entities;

import java.util.Date;

public class Pessoa {

    private String nome;
    private Date dataNascimento;

    public Pessoa() {
    }

    public Pessoa(String nome, Date dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Application "
                + "nome: " + nome
                + ", datade nascimento: " + dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
