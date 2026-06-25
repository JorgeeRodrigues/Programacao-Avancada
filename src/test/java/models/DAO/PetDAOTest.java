
package models.DAO;

import main.ConexaoBD;
import models.Pet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PetDAOTest {

    private PetDAO dao;

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

        dao = new PetDAO();

        try {
            ConexaoBD.executeUpdate(
                    "TRUNCATE TABLE pets RESTART IDENTITY");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() {
        ConexaoBD.getInstance().shutdown();
    }

    @Test
    public void testInserirERecuperarPet() throws SQLException {

        Pet p = new Pet();

        p.setNome("Rex");
        p.setEspecie("Cachorro");
        p.setDono("Jorge");
        p.setIdade(3);

        dao.salvar(p);

        ArrayList<Pet> lista = dao.recuperarTodos();

        assertNotNull(lista);
        assertEquals(1, lista.size());

        Pet recuperado = dao.recuperarUm(1);

        assertNotNull(recuperado);

        assertEquals(1, recuperado.getId());
        assertEquals(p.getNome(), recuperado.getNome());
        assertEquals(p.getEspecie(), recuperado.getEspecie());
        assertEquals(p.getDono(), recuperado.getDono());
        assertEquals(p.getIdade(), recuperado.getIdade());
    }

    @Test
    public void testEditarPet() throws SQLException {

        Pet p = new Pet();

        p.setNome("Rex");
        p.setEspecie("Cachorro");
        p.setDono("Jorge");
        p.setIdade(3);

        dao.salvar(p);

        Pet modificado = new Pet();

        modificado.setId(1);
        modificado.setNome("Mel");
        modificado.setEspecie("Gato");
        modificado.setDono("Pedro");
        modificado.setIdade(5);

        dao.editar(modificado);

        Pet recuperado = dao.recuperarUm(1);

        assertNotNull(recuperado);

        assertEquals("Mel", recuperado.getNome());
        assertEquals("Gato", recuperado.getEspecie());
        assertEquals("Pedro", recuperado.getDono());
        assertEquals(5, recuperado.getIdade());
    }

    @Test
    public void testExcluirPet() throws SQLException {

        Pet p = new Pet();

        p.setNome("Rex");
        p.setEspecie("Cachorro");
        p.setDono("Jorge");
        p.setIdade(3);

        dao.salvar(p);

        Pet antes = dao.recuperarUm(1);

        assertNotNull(antes);

        dao.excluir(1);

        Pet depois = dao.recuperarUm(1);

        assertNull(depois);

        ArrayList<Pet> lista = dao.recuperarTodos();

        assertNotNull(lista);

        assertTrue(lista.isEmpty());
    }
}

