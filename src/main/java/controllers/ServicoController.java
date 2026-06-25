package controllers;

import java.util.ArrayList;
import models.Servico;
import models.DAO.ServicoDAO;

public class ServicoController {

    private ServicoDAO dao = new ServicoDAO();

    public void salvar(Servico s) throws Exception {
        dao.salvar(s);
    }

    public ArrayList<Servico> listar() throws Exception {
        return dao.recuperarTodos();
    }

    public boolean editar(Servico s) throws Exception {
        return dao.editar(s);
    }

    public boolean excluir(int id) throws Exception {
        return dao.excluir(id);
    }
}