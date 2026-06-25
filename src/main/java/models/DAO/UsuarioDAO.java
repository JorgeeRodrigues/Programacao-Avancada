package models.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import main.ConexaoBD;

public class UsuarioDAO {

    private ResultSet resultadoQ = null;

    public boolean login(String usuario, String senha) throws SQLException {

        String sql = ""
                + "SELECT id "
                + "FROM usuarios "
                + "WHERE usuario = '" + usuario + "' "
                + "AND senha = md5('" + senha + "')";

        resultadoQ = ConexaoBD.executeQuery(sql);

        return resultadoQ.next();
    }
}