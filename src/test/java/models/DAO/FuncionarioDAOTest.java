package models.DAO;

import main.ConexaoBD;
import models.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FuncionarioDAOTest {

    private FuncionarioDAO dao;

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

        dao = new FuncionarioDAO();

        try {
            ConexaoBD.executeUpdate(
                    "TRUNCATE TABLE funcionarios RESTART IDENTITY");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() {
        ConexaoBD.getInstance().shutdown();
    }

    @Test
    public void testInserirERecuperarFuncionario() throws SQLException {

        Funcionario f = new Funcionario();

        f.setNome("Carlos");
        f.setCpf("123.456.789-00");

        dao.salvar(f);

        ArrayList<Funcionario> lista = dao.recuperarTodos();

        assertNotNull(lista);
        assertEquals(1, lista.size());

        Funcionario recuperado = dao.recuperarUm(1);

        assertNotNull(recuperado);

        assertEquals(1, recuperado.getId());
        assertEquals(f.getNome(), recuperado.getNome());
        assertEquals(f.getCpf(), recuperado.getCpf());
    }

    @Test
    public void testEditarFuncionario() throws SQLException {

        Funcionario f = new Funcionario();

        f.setNome("Carlos");
        f.setCpf("123.456.789-00");

        dao.salvar(f);

        Funcionario modificado = new Funcionario();

        modificado.setId(1);
        modificado.setNome("Marcos");
        modificado.setCpf("987.654.321-00");

        dao.editar(modificado);

        Funcionario recuperado = dao.recuperarUm(1);

        assertNotNull(recuperado);

        assertEquals("Marcos", recuperado.getNome());
        assertEquals("987.654.321-00", recuperado.getCpf());
    }

    @Test
    public void testExcluirFuncionario() throws SQLException {

        Funcionario f = new Funcionario();

        f.setNome("Carlos");
        f.setCpf("123.456.789-00");

        dao.salvar(f);

        Funcionario antes = dao.recuperarUm(1);

        assertNotNull(antes);

        dao.excluir(1);

        Funcionario depois = dao.recuperarUm(1);

        assertNull(depois);

        ArrayList<Funcionario> lista = dao.recuperarTodos();

        assertNotNull(lista);

        assertTrue(lista.isEmpty());
    }
}

