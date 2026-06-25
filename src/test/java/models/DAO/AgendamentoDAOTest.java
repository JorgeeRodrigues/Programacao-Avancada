package models.DAO;

import main.ConexaoBD;
import models.Agendamento;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AgendamentoDAOTest {

    private AgendamentosDAO dao;

    @BeforeClass
    public static void setUpClass() {
        try {
            System.setProperty("db.config", "db-test.properties");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public static void tearDownClass() {
        try {
            ConexaoBD.getInstance().shutdown();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Before
    public void setUp() {

        ConexaoBD.getInstance().shutdown();

        dao = new AgendamentosDAO();

        try {
            ConexaoBD.executeUpdate(
                    "TRUNCATE TABLE agendamentos RESTART IDENTITY");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() {
        ConexaoBD.getInstance().shutdown();
    }

    @Test
    public void testInserirERecuperarAgendamento() throws SQLException {

        Agendamento a = new Agendamento();

        a.setCliente("João");
        a.setPet("Rex");
        a.setServico("Banho");
        a.setDataehora("20/06/2026 14:00");

        dao.salvar(a);

        ArrayList<Agendamento> lista = dao.recuperarTodos();

        assertNotNull(lista);
        assertEquals(1, lista.size());

        Agendamento recuperado = dao.recuperarUm(1);

        assertNotNull(recuperado);

        assertEquals(1, recuperado.getId());
        assertEquals(a.getCliente(), recuperado.getCliente());
        assertEquals(a.getPet(), recuperado.getPet());
        assertEquals(a.getServico(), recuperado.getServico());
        assertEquals(a.getDataehora(), recuperado.getDataehora());
    }

    @Test
    public void testEditarAgendamento() throws SQLException {

        Agendamento a = new Agendamento();

        a.setCliente("João");
        a.setPet("Rex");
        a.setServico("Banho");
        a.setDataehora("20/06/2026 14:00");

        dao.salvar(a);

        Agendamento modificado = new Agendamento();

        modificado.setId(1);
        modificado.setCliente("Maria");
        modificado.setPet("Mel");
        modificado.setServico("Tosa");
        modificado.setDataehora("21/06/2026 16:30");

        dao.editar(modificado);

        Agendamento recuperado = dao.recuperarUm(1);

        assertNotNull(recuperado);

        assertEquals("Maria", recuperado.getCliente());
        assertEquals("Mel", recuperado.getPet());
        assertEquals("Tosa", recuperado.getServico());
        assertEquals("21/06/2026 16:30", recuperado.getDataehora());
    }

    @Test
    public void testExcluirAgendamento() throws SQLException {

        Agendamento a = new Agendamento();

        a.setCliente("João");
        a.setPet("Rex");
        a.setServico("Banho");
        a.setDataehora("20/06/2026 14:00");

        dao.salvar(a);

        Agendamento antes = dao.recuperarUm(1);

        assertNotNull(antes);

        dao.excluir(1);

        Agendamento depois = dao.recuperarUm(1);

        assertNull(depois);

        ArrayList<Agendamento> lista = dao.recuperarTodos();

        assertNotNull(lista);
        assertTrue(lista.isEmpty());
    }
}
