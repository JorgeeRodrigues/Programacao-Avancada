package controllers;

import java.util.ArrayList;
import models.Cliente;
import models.DAO.ClienteDAO;

public class ClienteController {

    private ClienteDAO dao = new ClienteDAO();

    public void salvar(Cliente c) throws Exception {
        dao.salvar(c);
    }

    public ArrayList<Cliente> listar() throws Exception {
        return dao.recuperarTodos();
    }

    public boolean editar(Cliente c) throws Exception {
        return dao.editar(c);
    }

    public boolean excluir(int id) throws Exception {
        return dao.excluir(id);
    }
}