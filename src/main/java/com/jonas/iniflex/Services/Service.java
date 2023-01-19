package com.jonas.iniflex.Services;

import com.jonas.iniflex.Entities.Funcionario;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Service {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    List<Funcionario> listaFuncionario = new ArrayList<>();

    public List<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }

    public List<Funcionario> addFuncionario(String nome, Date dataNascimento, BigDecimal salario, String funcao) {
        Funcionario obj = new Funcionario(nome, dataNascimento, salario, funcao);
        listaFuncionario.add(obj);
        return listaFuncionario;
    }

    public List<Funcionario> removeFuncionario(String nome) {
        for (int i = 0; i < listaFuncionario.size(); i++) {
            if (listaFuncionario.get(i).getNome() == nome) {
                listaFuncionario.remove(listaFuncionario.get(i));
            }

        }
        return listaFuncionario;
    }

    public void listaTodosFuncionario() {
        System.out.println("Lista de todos os Funcioanarios:");
        for (int i = 0; i < listaFuncionario.size(); i++) {
            System.out.println(listaFuncionario.get(i));
        }
    }

    public List<Funcionario> aumentoSalarioTodosFuncionarios(Integer porcentagem) {
        BigDecimal porctSalario = new BigDecimal("0");
        BigDecimal salSum = new BigDecimal("0");
        for (Funcionario lista : listaFuncionario) {
            if (lista.getSalario().compareTo(new BigDecimal("0")) == 1) {
                porctSalario = (lista.getSalario().multiply(new BigDecimal(porcentagem))).divide(new BigDecimal("100"));
                salSum = lista.getSalario().add(porctSalario);
                lista.setSalario(salSum);
            }
        }
        return listaFuncionario;
    }

    public void funcionariosMap() {
        Map<String, List<Funcionario>> groupFunc
                = listaFuncionario.stream()
                        .collect(Collectors.groupingBy(h -> h.getFuncao()));

        System.out.println("Funcionários agrupados por função.");
        groupFunc.keySet().forEach(key -> {
            System.out.println(key + ": " + groupFunc.get(key));
        });
    }

    public void aniversariantesMes10E12() {
        System.out.println("Aniversariantes dos meses outubro e dezembro");
        for (Funcionario lista : listaFuncionario) {
            LocalDate month = lista.getDataNascimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (month.getMonthValue() == 10 || month.getMonthValue() == 12) {
                System.out.println(lista);
            }
        }
    }

    public void funcionarioMaisVelho() {
        String idadeInicial = new String("01/01/1900");
        LocalDate idadeInicialDate = LocalDate.parse(idadeInicial, formatter);

        long valorMinimo = 0;
        List<Long> sortedlist = new ArrayList<>();

        for (Funcionario lista : listaFuncionario) {
            LocalDate month = lista.getDataNascimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            long daysBetween = ChronoUnit.DAYS.between(idadeInicialDate, month);
            Collections.sort(sortedlist);
            sortedlist.add(daysBetween);

            valorMinimo = sortedlist.get(0);
        }

        for (Funcionario lista : listaFuncionario) {
            LocalDate month = lista.getDataNascimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            long daysBetween = ChronoUnit.DAYS.between(idadeInicialDate, month);
            if (daysBetween == valorMinimo) {
                System.out.println("Funcionario(a) com maior idade: " + lista.getNome() + ", " + sdf.format(lista.getDataNascimento()));
            }
        }
    }

    public void listaFuncionariosOrdemAlfabetica() {
        System.out.println("Funcionarios por Ordem Alfabetica:");
        Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

        List<String> listaOrdemAlfabetica = listaFuncionario.stream()
                .map(p -> p.getNome())
                .sorted(comp)
                .collect(Collectors.toList());
        listaOrdemAlfabetica.forEach(System.out::println);
    }

    public BigDecimal totalSalarioDosFuncionarios() {
        BigDecimal somaSalarios = new BigDecimal("0");
        for (Funcionario lista : listaFuncionario) {
            somaSalarios = somaSalarios.add(lista.getSalario());
        }
        return somaSalarios;
    }

    public void listaQtdSalarioMinimoPorFuncionario() {
        System.out.println("Lista de quantidade de salario minimo por funcionario.");
        for (Funcionario lista : listaFuncionario) {
            System.out.println("O(a) Funcionario " + lista.getNome() + " recebe "
                    + String.format("%.2f", lista.getSalario().
                            divide(new BigDecimal("1212"), MathContext.DECIMAL128))
                    + " salarios minimos");
        }
    }

}
