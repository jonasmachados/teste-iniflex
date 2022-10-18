package com.jonas.iniflex.Entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Funcionario extends Pessoa {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Double salario;
    private String funcao;

    public Funcionario(Double salario, String funcao) {
        this.salario = salario;
        this.funcao = funcao;
    }

    public Funcionario(String nome, Date dataNascimento, Double salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return getNome();
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.salario);
        hash = 23 * hash + Objects.hashCode(this.funcao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.funcao, other.funcao)) {
            return false;
        }
        if (!Objects.equals(this.salario, other.salario)) {
            return false;
        }
        return true;
    }

    public double aumento10(double _10PorCento) {
        return salario = salario + ((salario * 10) / 100);
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

}
