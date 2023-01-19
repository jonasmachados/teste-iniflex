package com.jonas.iniflex.Entities;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Funcionario extends Pessoa {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat df = new DecimalFormat("#,##0.00");

    private BigDecimal salario;
    private String funcao;

    public Funcionario(BigDecimal salario, String funcao) {
        this.salario = salario;
        this.funcao = funcao;
    }

    public Funcionario(String nome, Date dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return getNome() + ", nasceu em " + sdf.format(getDataNascimento()) + ", possui salário de " + df.format(salario) + ", função " + funcao;

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

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

}
