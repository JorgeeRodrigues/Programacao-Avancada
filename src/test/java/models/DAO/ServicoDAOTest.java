package models.DAO;

import main.ConexaoBD;
import models.Servico;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ServicoDAOTest {

    private ServicoDAO dao;

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

        dao = new ServicoDAO();

        try {
            ConexaoBD.executeUpdate(
                    "TRUNCATE TABLE servicos RESTART IDENTITY");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() {
        ConexaoBD.getInstance().shutdown();
    }

    @Test
    public void testInserirERecuperarServico() throws SQLException {

        Servico s = new Servico();

        s.setDescricao("Banho");
        s.setPreco(50.0);
        s.setDuracao(60);

        dao.salvar(s);

        ArrayList<Servico> lista = dao.recuperarTodos();

        assertNotNull(lista);
        assertEquals(1, lista.size());

        Servico recuperado = dao.recuperarUm(1);

        assertNotNull(recuperado);

        assertEquals(1, recuperado.getId());
        assertEquals(s.getDescricao(), recuperado.getDescricao());
        assertEquals(s.getPreco(), recuperado.getPreco(), 0.01);
        assertEquals(s.getDuracao(), recuperado.getDuracao());
    }

    @Test
    public void testEditarServico() throws SQLException {

        Servico s = new Servico();

        s.setDescricao("Banho");
        s.setPreco(50.0);
        s.setDuracao(60);

        dao.salvar(s);

        Servico modificado = new Servico();

        modificado.setId(1);
        modificado.setDescricao("Tosa");
        modificado.setPreco(80.0);
        modificado.setDuracao(90);

        dao.editar(modificado);

        Servico recuperado = dao.recuperarUm(1);

        assertNotNull(recuperado);

        assertEquals("Tosa", recuperado.getDescricao());
        assertEquals(80.0, recuperado.getPreco(), 0.01);
        assertEquals(90, recuperado.getDuracao());
    }

    @Test
    public void testExcluirServico() throws SQLException {

        Servico s = new Servico();

        s.setDescricao("Banho");
        s.setPreco(50.0);
        s.setDuracao(60);

        dao.salvar(s);

        Servico antes = dao.recuperarUm(1);

        assertNotNull(antes);

        dao.excluir(1);

        Servico depois = dao.recuperarUm(1);

        assertNull(depois);

        ArrayList<Servico> lista = dao.recuperarTodos();

        assertNotNull(lista);

        assertTrue(lista.isEmpty());
    }
}
