package com.jonas.iniflex.Program;

import com.jonas.iniflex.Entities.Funcionario;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,##0.00");

        List<Funcionario> listaFuncionario = new ArrayList<>();

        Funcionario Maria = new Funcionario("Maria", sdf.parse("18/10/2000"), 2009.44, "Operador");
        Funcionario Joao = new Funcionario("Joao", sdf.parse("12/05/1990"), 2284.38, "Operador");
        Funcionario Caio = new Funcionario("Caio", sdf.parse("02/05/1961"), 9836.14, "Coordenador");
        Funcionario Miguel = new Funcionario("Miguel", sdf.parse("14/10/1988"), 19119.88, "Diretor");
        Funcionario Alice = new Funcionario("Alice", sdf.parse("05/01/1995"), 2234.68, "Recepcionista");
        Funcionario Heitor = new Funcionario("Heitor", sdf.parse("19/11/1999"), 1582.72, "Operador");
        Funcionario Arthur = new Funcionario("Arthur", sdf.parse("31/03/1993"), 4071.84, "Contador");
        Funcionario Laura = new Funcionario("Laura", sdf.parse("08/07/1994"), 3017.45, "Gerente");
        Funcionario Heloisa = new Funcionario("Heloisa", sdf.parse("24/05/2003"), 1606.85, "Eletricista");
        Funcionario Helena = new Funcionario("Helena", sdf.parse("02/09/1996"), 2799.93, "Gerente");

        //3.1 ADD TODOS OS FUNCIONARIOS 
        listaFuncionario.add(Maria);
        listaFuncionario.add(Joao);
        listaFuncionario.add(Caio);
        listaFuncionario.add(Miguel);
        listaFuncionario.add(Alice);
        listaFuncionario.add(Heitor);
        listaFuncionario.add(Arthur);
        listaFuncionario.add(Laura);
        listaFuncionario.add(Heloisa);
        listaFuncionario.add(Helena);

        //3.2 REMOVE FUNCIONARIO JOAO
        listaFuncionario.remove(Joao);

        //3.3 IMPRESSAO LISTA
        System.out.println("Lista de todos os funcionarios:");
        for (Funcionario lista : listaFuncionario) {
            System.out.println(lista.getNome() + " " + sdf.format(lista.getDataNascimento()) + " " + df.format(lista.getSalario()) + " " + lista.getFuncao() + ".");
        }
        System.out.println("*****************************************************");

        //3.4 AUMENTO DE 10% AO FUNCIONARIO 
        for (Funcionario lista : listaFuncionario) {
            if (lista.getSalario() > 0) {
                lista.setSalario(lista.getSalario() + ((lista.getSalario() * 10) / 100));
            }
        }

        //3.5 AGRUPANDO OS FUNCIONARIOS POR MAP
        Map<String, List<Funcionario>> groupFunc
                = listaFuncionario.stream()
                        .collect(Collectors.groupingBy(h -> h.getFuncao()));

        //3.6 DADO DOS FUNCIONARIO POR FUNCAO
        System.out.println("Funcionários agrupados por função.");
        for (String key : groupFunc.keySet()) {
            System.out.println(key + ": " + groupFunc.get(key));
        }
        System.out.println("*********************************************");

        // 3.08 FUNCIONARIOS ANIVERSARIANTES NO MES 10 E 12
        System.out.println("Aniversariantes dos meses outubro e dezembro");
        for (Funcionario lista : listaFuncionario) {
            LocalDate month = lista.getDataNascimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (month.getMonthValue() == 10 || month.getMonthValue() == 12) {
                System.out.println(lista);
            }
        }
        System.out.println("*********************************************");

        //3.09 FUNCIONARIO COM A MAIOR IDADE  
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
        System.out.println("*********************************************");

        //3.10 LISTA FUNCIONARIO ORDEM ALFABETICA
        System.out.println("Funcionarios por Ordem Alfabetica");
        Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

        List<String> listaOrdemAlfabetica = listaFuncionario.stream()
                .map(p -> p.getNome())
                .sorted(comp)
                .collect(Collectors.toList());

        listaOrdemAlfabetica.forEach(System.out::println);
        System.out.println("*********************************************");

        //3.11 TOTAL DOS SALARIOS DOS FUNCIONARIOS
        double salarioTotal = listaFuncionario.stream()
                .map(p -> p.getSalario())
                .reduce(0.0, (x, y) -> x + y);
        System.out.println("O total dos salarios dos funcionarios eh: " + String.format("%,.2f ", salarioTotal));
        System.out.println("*********************************************");

        //3.12 Quantos salarios minimos ganha cada funcionario
        double calcSalarioMinimo = 0.00;
        for (Funcionario lista : listaFuncionario) {
            calcSalarioMinimo = lista.getSalario() / 1212.00;
            System.out.println("O Funcionario " + lista.getNome() + " recebe " + String.format("%.2f", calcSalarioMinimo) + " salarios minimos");
        }

    }

}
