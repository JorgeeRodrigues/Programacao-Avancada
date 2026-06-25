package controllers;

import java.sql.SQLException;
import main.Mensagem;
import models.DAO.UsuarioDAO;

public class UsuarioController {

    private UsuarioDAO dao = new UsuarioDAO();

    public boolean login(String usuario, String senha) {

        try {
            return dao.login(usuario, senha);

        } catch (SQLException ex) {

            Mensagem.erro("Erro ao logar: " + ex.getMessage());

            return false;
        }
    }
}