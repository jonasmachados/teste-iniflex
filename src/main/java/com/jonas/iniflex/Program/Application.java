package com.jonas.iniflex.Program;

import com.jonas.iniflex.Entities.Funcionario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import static java.util.Map.Entry.comparingByValue;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Funcionario> listaFuncionario = new ArrayList<>();

        Funcionario maria = new Funcionario("Maria", sdf.parse("18/10/2000"), 2009.44, "Operador");
        Funcionario joao = new Funcionario("Joao", sdf.parse("12/05/1990"), 2284.38, "Operador");
        Funcionario caio = new Funcionario("Caio", sdf.parse("02/05/1961"), 9836.14, "Coordenador");
        Funcionario miguel = new Funcionario("Miguel", sdf.parse("14/10/1988"), 19119.88, "Diretor");
        Funcionario alice = new Funcionario("Alice", sdf.parse("05/01/1995"), 2234.68, "Recepcionista");
        Funcionario heitor = new Funcionario("Heitor", sdf.parse("19/11/1999"), 1582.72, "Operador");
        Funcionario arthur = new Funcionario("Arthur", sdf.parse("31/03/1993"), 4071.84, "Contador");
        Funcionario laura = new Funcionario("Laura", sdf.parse("08/07/1994"), 3017.45, "Gerente");
        Funcionario heloisa = new Funcionario("Heloisa", sdf.parse("24/05/2003"), 1606.85, "Eletricista");
        Funcionario helena = new Funcionario("Helena", sdf.parse("02/09/1996"), 2799.93, "Gerente");

        //3.1 ADD TODOS OS FUNCIONARIOS 
        listaFuncionario.add(maria);
        listaFuncionario.add(joao);
        listaFuncionario.add(caio);
        listaFuncionario.add(miguel);
        listaFuncionario.add(alice);
        listaFuncionario.add(heitor);
        listaFuncionario.add(arthur);
        listaFuncionario.add(laura);
        listaFuncionario.add(heloisa);
        listaFuncionario.add(helena);

        //3.2 REMOVE FUNCIONARIO JOAO
        listaFuncionario.remove(joao);

        //3.3 IMPRESSAO LISTA
        for (Funcionario lista : listaFuncionario) {
            System.out.println(lista.getNome() + " " + sdf.format(lista.getDataNascimento()) + " " + String.format("%.2f", lista.getSalario()) + " " + lista.getFuncao() + ".");
        }
        System.out.println("*****************************************************");

        //3.4 AUMENTO DE 10% AO FUNCIONARIO 
        for (Funcionario lista : listaFuncionario) {
            if (lista.getSalario() > 0) {
                lista.setSalario(lista.getSalario() + ((lista.getSalario() * 10) / 100));
            }
        }

        //3.5 AGRUPANDO OS FUNCIONARIOS POR MAP
        Map<String, Funcionario> listaMap = new TreeMap<>();
        for (Funcionario lista : listaFuncionario) {
            listaMap.put(lista.getFuncao(), lista);
        }

        //3.6 DADO DOS FUNCIONARIO POR FUNCAO
        for (String key : listaMap.keySet()) {
            System.out.println(key + ": " + listaMap.get(key));
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
                System.out.println("Funcionario(a) com mais idade: " + lista);
            }
        }
        System.out.println("*********************************************");

        //3.10 LISTA FUNCIONARIO ORDEM ALFABETICA
        System.out.println("Ordem Alfabetica");
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
        double salarioMinimo = 1212.00;
        double calcSalarioMinimo = 0.00;
        for (Funcionario lista : listaFuncionario) {
            calcSalarioMinimo = lista.getSalario() / 1212.00;
            System.out.println("O Funcionario " + lista.getNome() + " recebe " + String.format("%.2f", calcSalarioMinimo) + " salarios minimos");
        }

    }

}
