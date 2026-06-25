package models.DAO;

import models.Funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.ConexaoBD;

public class FuncionarioDAO {

    private ResultSet resultadoQ = null;

    public void salvar(Funcionario f) throws SQLException {
        String sql = "INSERT INTO funcionarios (nome, cpf) VALUES ('"
                + f.getNome() + "','"
                + f.getCpf() + "')";

        ConexaoBD.executeUpdate(sql);
    }

    public ArrayList<Funcionario> recuperarTodos() throws SQLException {
        ArrayList<Funcionario> lista = new ArrayList<>();

        String sql = "SELECT * FROM funcionarios";
        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Funcionario f = new Funcionario();

            f.setId(resultadoQ.getInt("id"));
            f.setNome(resultadoQ.getString("nome"));
            f.setCpf(resultadoQ.getString("cpf"));

            lista.add(f);
        }

        return lista;
    }

    public boolean editar(Funcionario f) throws SQLException {

    String sql = "UPDATE funcionarios SET "
            + "nome='" + f.getNome()
            + "', cpf='" + f.getCpf()
            + "' WHERE id=" + f.getId();

    return ConexaoBD.executeUpdate(sql) > 0;
}

public boolean excluir(int id) throws SQLException {

    String sql = "DELETE FROM funcionarios WHERE id=" + id;

    return ConexaoBD.executeUpdate(sql) > 0;
}
    public Funcionario recuperarUm(int id) throws SQLException {

    String sql = "SELECT * FROM funcionarios WHERE id = " + id;

    resultadoQ = ConexaoBD.executeQuery(sql);

    if (resultadoQ.next()) {

        Funcionario f = new Funcionario();

        f.setId(resultadoQ.getInt("id"));
        f.setNome(resultadoQ.getString("nome"));
        f.setCpf(resultadoQ.getString("cpf"));

        return f;
    }

    return null;
}
    
}