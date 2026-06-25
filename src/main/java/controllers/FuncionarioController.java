package controllers;

import java.util.ArrayList;
import models.Funcionario;
import models.DAO.FuncionarioDAO;

public class FuncionarioController {

    private FuncionarioDAO dao = new FuncionarioDAO();

    public void salvar(Funcionario f) throws Exception {
        dao.salvar(f);
    }

    public ArrayList<Funcionario> listar() throws Exception {
        return dao.recuperarTodos();
    }

    public boolean editar(Funcionario f) throws Exception {
        return dao.editar(f);
    }

    public boolean excluir(int id) throws Exception {
        return dao.excluir(id);
    }
}