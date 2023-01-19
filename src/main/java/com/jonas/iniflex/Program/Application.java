package com.jonas.iniflex.Program;

import com.jonas.iniflex.Entities.Funcionario;
import com.jonas.iniflex.Services.Service;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Application {

    public static void main(String[] args) {

        Service service = new Service();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Funcionario Maria = new Funcionario("Maria", sdf.parse("18/10/2000"), BigDecimal.valueOf(2009.44), "Operador");
            Funcionario Joao = new Funcionario("Joao", sdf.parse("12/05/1990"), BigDecimal.valueOf(2284.38), "Operador");
            Funcionario Caio = new Funcionario("Caio", sdf.parse("02/05/1961"), BigDecimal.valueOf(9836.14), "Coordenador");
            Funcionario Miguel = new Funcionario("Miguel", sdf.parse("14/10/1988"), BigDecimal.valueOf(19119.88), "Diretor");
            Funcionario Alice = new Funcionario("Alice", sdf.parse("05/01/1995"), BigDecimal.valueOf(2234.68), "Recepcionista");
            Funcionario Heitor = new Funcionario("Heitor", sdf.parse("19/11/1999"), BigDecimal.valueOf(1582.72), "Operador");
            Funcionario Arthur = new Funcionario("Arthur", sdf.parse("31/03/1993"), BigDecimal.valueOf(4071.84), "Contador");
            Funcionario Laura = new Funcionario("Laura", sdf.parse("08/07/1994"), BigDecimal.valueOf(3017.45), "Gerente");
            Funcionario Heloisa = new Funcionario("Heloisa", sdf.parse("24/05/2003"), BigDecimal.valueOf(1606.85), "Eletricista");
            Funcionario Helena = new Funcionario("Helena", sdf.parse("02/09/1996"), BigDecimal.valueOf(2799.93), "Gerente");

            //3.1 ADD TODOS OS FUNCIONARIOS 
            service.addFuncionario(Maria);
            service.addFuncionario(Joao);
            service.addFuncionario(Caio);
            service.addFuncionario(Miguel);
            service.addFuncionario(Alice);
            service.addFuncionario(Heitor);
            service.addFuncionario(Arthur);
            service.addFuncionario(Laura);
            service.addFuncionario(Heloisa);
            service.addFuncionario(Helena);

            //3.2 REMOVER FUNCIONARIO JOAO
            service.removeFuncionario(Joao);

            //3.3 IMPRESSAO LISTA
            service.listaTodosFuncionario();
            System.out.println("\n***********************************");

            //3.4 AUMENTO DE 10% AO FUNCIONARIO 
            service.aumentoSalarioTodosFuncionarios(10);

            //3.5-3.6 AGRUPANDO OS FUNCIONARIOS POR MAP E IMPRIMINDO POR FUNCAO
            service.funcionariosMap();
            System.out.println("\n***********************************");

            // 3.08 FUNCIONARIOS ANIVERSARIANTES NO MES 10 E 12
            service.aniversariantesMes10E12();
            System.out.println("\n***********************************");

            //3.09 FUNCIONARIO COM A MAIOR IDADE 
            service.funcionarioMaisVelho();
            System.out.println("\n***********************************");

            //3.10 LISTA FUNCIONARIO ORDEM ALFABETICA
            service.listaFuncionariosOrdemAlfabetica();

            //3.11 TOTAL DOS SALARIOS DOS FUNCIONARIOS
            System.out.println("O total dos salarios dos funcionarios eh: " + String.
                    format("%,.2f ", service.totalSalarioDosFuncionarios()));
            System.out.println("\n***********************************");

            //3.12 LISTA QTD SALARIO MINIMO POR FUNCIONARIO
            service.listaQtdSalarioMinimoPorFuncionario();
            
        } catch (ParseException e) {
            System.out.println("ParseException: " + e.getMessage());
        }

    }

}
