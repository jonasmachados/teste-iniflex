package com.jonas.iniflex.Program;

import com.jonas.iniflex.Entities.Funcionario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Funcionario> listaFuncionario = new ArrayList<>();

        Funcionario joao = new Funcionario("Joao", sdf.parse("12/05/1990"), 2284.38, "Operador");
        Funcionario maria = new Funcionario("Maria", sdf.parse("18/10/2000"), 2009.44, "Operador");
        Funcionario caio = new Funcionario("Caio", sdf.parse("02/05/1961"), 9836.14, "Coordenador");
        Funcionario miguel = new Funcionario("Miguel", sdf.parse("14/10/88"), 19119.88, "Diretor");
        Funcionario alice = new Funcionario("Alice", sdf.parse("05/01/1995"), 2234.68, "Recepcionista");
        Funcionario heitor = new Funcionario("Heitor", sdf.parse("19/11/1999"), 1582.72, "Operador");
        Funcionario arthus = new Funcionario("Arthus", sdf.parse("31/03/1993"), 4071.84, "Contador");
        Funcionario laura = new Funcionario("Laura", sdf.parse("08/07/1994"), 3017.45, "Gerente");
        Funcionario heloisa = new Funcionario("Heloisa", sdf.parse("24/05/2003"), 1606.85, "Eletricista");
        Funcionario helena = new Funcionario("Helena", sdf.parse("02/09/1996"), 2799.93, "Gerente");

        listaFuncionario.add(joao);
        listaFuncionario.add(maria);
        listaFuncionario.add(caio);
        listaFuncionario.add(miguel);
        listaFuncionario.add(alice);
        listaFuncionario.add(heitor);
        listaFuncionario.add(arthus);
        listaFuncionario.add(laura);
        listaFuncionario.add(heloisa);
        listaFuncionario.add(helena);

        //Remove Joao
        listaFuncionario.remove(joao);

        //Imprimir a lista
        for (Funcionario lista : listaFuncionario) {
            System.out.println(lista.getNome() + " " + sdf.format(lista.getDataNascimento()) + " " + String.format("%.2f", lista.getSalario()) + " " + lista.getFuncao() + " .");
        }
        System.out.println("*****************************************************");

        //Aumento de  10% ao funcionario
        for (Funcionario lista : listaFuncionario) {
            if (lista.getSalario() > 0) {
                lista.setSalario(lista.getSalario() + ((lista.getSalario() * 10) / 100));
            }
        }

        //Agrupando os funcionarios por MAP
//        Map<String, Funcionario> listaMap = new LinkedHashMap<>();
//        for (Funcionario lista : listaFuncionario) {
//            listaMap.put(lista.getFuncao(), lista);
//        }
        Map<String, Funcionario> listaMap = new LinkedHashMap<>();
        for (Funcionario lista : listaFuncionario) {
            listaMap.put(lista.getFuncao(), lista);
        }

//        for (Funcionario lista : listaFuncionario) {
//            System.out.println(lista);
//        }
        System.out.println("*********************************");

        for (String key : listaMap.keySet()) {
            System.out.println(key + ": " + listaMap.get(key));
        }

        System.out.println("********************************");
        //3.10 LISTA FUNCIONARIO ORDEM ALFABETICA
        Stream<Funcionario> st1 = listaFuncionario.stream();
        List<String> names = listaFuncionario.stream()
                .map(p -> p.getNome())
                .collect(Collectors.toList());

        names.forEach(System.out::println);

    }

}
