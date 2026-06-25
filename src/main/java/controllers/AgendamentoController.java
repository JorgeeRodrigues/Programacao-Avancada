package controllers;

import java.util.ArrayList;
import models.Agendamento;
import models.DAO.AgendamentosDAO;

public class AgendamentoController {

    private AgendamentosDAO dao = new AgendamentosDAO();

    public void salvar(Agendamento a) throws Exception {
        dao.salvar(a);
    }

    public ArrayList<Agendamento> listar() throws Exception {
        return dao.recuperarTodos();
    }

    public boolean editar(Agendamento a) throws Exception {
        return dao.editar(a);
    }

    public boolean excluir(int id) throws Exception {
        return dao.excluir(id);
    }
}