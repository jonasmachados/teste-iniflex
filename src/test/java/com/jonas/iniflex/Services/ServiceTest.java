package com.jonas.iniflex.Services;

import com.jonas.iniflex.Entities.Funcionario;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");

    Service service = new Service();

    private static final Integer INDEX = 2;
    private static final String NOME = "Jose";
    private static final String DATA_NASCIMENTO = "15/06/1980";
    private static final BigDecimal SALARIO = BigDecimal.valueOf(2009.44);
    private static final String FUNCAO = "Operador";

    @BeforeEach
    public void setUp() {
        try {
            startDB();
        } catch (ParseException e) {
            System.out.println("ParseException: " + e.getMessage());
        }

    }

    @Test
    public void whenAddFuncionarioThenReturnSuccess() {
        try {
            service.addFuncionario(NOME, sdf.parse(DATA_NASCIMENTO), SALARIO, FUNCAO);

            Date dates = sdf2.parse(DATA_NASCIMENTO);

            assertNotNull(this);
            assertEquals(Funcionario.class, service.getListaFuncionario().get(INDEX).getClass());
            assertEquals(ArrayList.class, service.getListaFuncionario().getClass());

            assertEquals(NOME, service.getListaFuncionario().get(INDEX).getNome());
            assertEquals(dates, service.getListaFuncionario().get(INDEX).getDataNascimento());
            assertEquals(SALARIO, service.getListaFuncionario().get(INDEX).getSalario());
            assertEquals(FUNCAO, service.getListaFuncionario().get(INDEX).getFuncao());

        } catch (ParseException e) {
            System.out.println("ParseException: " + e.getMessage());
        }

    }

    @Test
    public void whenRemoveFuncionarioTheReturnSuccess() {
        service.removeFuncionario(NOME);

        assertNotNull(this);
        assertEquals(2, service.getListaFuncionario().size());
    }

    @Test
    public void whenFindListTodosFuncionarioThenReturnSuccess() {
        try {
            service.listaTodosFuncionario();

            Date dates = sdf2.parse(DATA_NASCIMENTO);

            assertNotNull(this);
            assertEquals(2, service.getListaFuncionario().size());
            assertEquals(Funcionario.class, service.getListaFuncionario().get(INDEX).getClass());

            assertEquals(NOME, service.getListaFuncionario().get(INDEX).getNome());
            assertEquals(dates, service.getListaFuncionario().get(INDEX).getDataNascimento());
            assertEquals(SALARIO, service.getListaFuncionario().get(INDEX).getSalario());
            assertEquals(FUNCAO, service.getListaFuncionario().get(INDEX).getFuncao());

        } catch (ParseException e) {
            System.out.println("ParseException: " + e.getMessage());
        }

    }

    @Test
    public void whenAumentoSalarioTodosFuncionariosReturnListaComAumento() {

        service.aumentoSalarioTodosFuncionarios(10);

        assertNotNull(this);
        assertEquals(Funcionario.class, service.getListaFuncionario().get(0).getClass());

    }

    @Test
    public void whenFindFuncionariosMapTheReturnSuccess() {

        service.funcionariosMap();

        assertNotNull(this);
    }

    @Test
    public void whenAniversariantesMes10E12theReturnListaAniversariantes() {

        service.aniversariantesMes10E12();

        assertNotNull(this);
        assertEquals(Funcionario.class, service.getListaFuncionario().get(0).getClass());
    }

    @Test
    public void whenFindFuncionarioMaisVelhoThenReturnDadosFuncionarioMaisvelho() {

        service.funcionarioMaisVelho();

        assertNotNull(this);

    }

    @Test
    public void whenFindListaFuncionariosOrdemAlfabeticaThenReturnSuccessList() {

        service.listaFuncionariosOrdemAlfabetica();

        assertNotNull(this);

    }

    @Test
    public void whenTotalSalarioDosFuncionariosThenReturnSomaDosSalarios() {

        service.totalSalarioDosFuncionarios();

        assertNotNull(this);
        assertEquals(BigDecimal.valueOf(3284.38), service.totalSalarioDosFuncionarios());

    }

    @Test
    public void whenFindListaQtdSalarioMinimoPorFuncionarioTheReturnListaSalarioMinimo() {

        service.listaQtdSalarioMinimoPorFuncionario();

        assertNotNull(this);
    }

    private void startDB() throws ParseException {
        service.addFuncionario("Joao", sdf.parse("12/05/1990"), BigDecimal.valueOf(2284.38), "Operador");
        service.addFuncionario("Fernando", sdf.parse("20/03/1980"), BigDecimal.valueOf(1000.00), "Operador");
    }
}
