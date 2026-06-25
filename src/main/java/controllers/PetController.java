package controllers;

import java.util.ArrayList;
import models.Pet;
import models.DAO.PetDAO;

public class PetController {

    private PetDAO dao = new PetDAO();

    public void salvar(Pet p) throws Exception {
        dao.salvar(p);
    }

    public ArrayList<Pet> listar() throws Exception {
        return dao.recuperarTodos();
    }

    public boolean editar(Pet p) throws Exception {
        return dao.editar(p);
    }

    public boolean excluir(int id) throws Exception {
        return dao.excluir(id);
    }
}