
package models.DAO;


import main.ConexaoBD;
import models.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteDAOTest {

    private ClienteDAO dao;

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

    dao = new ClienteDAO();

    try {
        ConexaoBD.executeUpdate(
                "TRUNCATE TABLE agendamentos, pets, clientes, funcionarios, servicos RESTART IDENTITY CASCADE;");
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }

    @After
    public void tearDown() {
        ConexaoBD.getInstance().shutdown();
    }

    @Test
    public void testInserirERecuperarCliente() throws SQLException {

        Cliente c = new Cliente();

        c.setNome("Jorge");
        c.setEmail("jorge@gmail.com");
        c.setCpf("123.456.789-00");
        c.setTelefone("(48)99999-9999");

        dao.salvar(c);

        ArrayList<Cliente> lista = dao.recuperarTodos();

        assertNotNull(lista);
        assertEquals(1, lista.size());

        Cliente recuperado = dao.recuperarUm(1);

        assertNotNull(recuperado);

        assertEquals(1, recuperado.getId());
        assertEquals(c.getNome(), recuperado.getNome());
        assertEquals(c.getEmail(), recuperado.getEmail());
        assertEquals(c.getCpf(), recuperado.getCpf());
        assertEquals(c.getTelefone(), recuperado.getTelefone());
    }

    @Test
    public void testEditarCliente() throws SQLException {

        Cliente c = new Cliente();

        c.setNome("Jorge");
        c.setEmail("jorge@gmail.com");
        c.setCpf("123.456.789-00");
        c.setTelefone("(48)99999-9999");

        dao.salvar(c);

        Cliente modificado = new Cliente();

        modificado.setId(1);
        modificado.setNome("Pedro");
        modificado.setEmail("pedro@gmail.com");
        modificado.setCpf("111.222.333-44");
        modificado.setTelefone("(48)98888-8888");

        dao.editar(modificado);

        Cliente recuperado = dao.recuperarUm(1);

        assertNotNull(recuperado);

        assertEquals("Pedro", recuperado.getNome());
        assertEquals("pedro@gmail.com", recuperado.getEmail());
        assertEquals("111.222.333-44", recuperado.getCpf());
        assertEquals("(48)98888-8888", recuperado.getTelefone());
    }

    @Test
    public void testExcluirCliente() throws SQLException {

        Cliente c = new Cliente();

        c.setNome("Jorge");
        c.setEmail("jorge@gmail.com");
        c.setCpf("123.456.789-00");
        c.setTelefone("(48)99999-9999");

        dao.salvar(c);

        Cliente antes = dao.recuperarUm(1);

        assertNotNull(antes);

        dao.excluir(1);

        Cliente depois = dao.recuperarUm(1);

        assertNull(depois);

        ArrayList<Cliente> lista = dao.recuperarTodos();

        assertNotNull(lista);

        assertTrue(lista.isEmpty());
    }
}

