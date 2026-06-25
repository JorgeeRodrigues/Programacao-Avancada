    package models.DAO;

import models.Servico;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.ConexaoBD;

public class ServicoDAO {

    private ResultSet resultadoQ = null;

    public void salvar(Servico s) throws SQLException {
        String sql = "INSERT INTO servicos (descricao, preco, duracao) VALUES ('"
                + s.getDescricao() + "',"
                + s.getPreco() + ","
                + s.getDuracao() + ")";

        ConexaoBD.executeUpdate(sql);
    }

    public ArrayList<Servico> recuperarTodos() throws SQLException {
        ArrayList<Servico> lista = new ArrayList<>();

        String sql = "SELECT * FROM servicos";
        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Servico s = new Servico();

            s.setId(resultadoQ.getInt("id"));
            s.setDescricao(resultadoQ.getString("descricao"));
            s.setPreco(resultadoQ.getDouble("preco"));
            s.setDuracao(resultadoQ.getInt("duracao"));

            lista.add(s);
        }

        return lista;
    }

    public boolean editar(Servico s) throws SQLException {

    String sql = "UPDATE servicos SET "
            + "descricao='" + s.getDescricao()
            + "', preco=" + s.getPreco()
            + ", duracao=" + s.getDuracao()
            + " WHERE id=" + s.getId();

    return ConexaoBD.executeUpdate(sql) > 0;
}

public boolean excluir(int id) throws SQLException {

    String sql = "DELETE FROM servicos WHERE id=" + id;

    return ConexaoBD.executeUpdate(sql) > 0;
}

public Servico recuperarUm(int id) throws SQLException {

    String sql = "SELECT * FROM servicos WHERE id = " + id;

    resultadoQ = ConexaoBD.executeQuery(sql);

    if (resultadoQ.next()) {

        Servico s = new Servico();

        s.setId(resultadoQ.getInt("id"));
        s.setDescricao(resultadoQ.getString("descricao"));
        s.setPreco(resultadoQ.getDouble("preco"));
        s.setDuracao(resultadoQ.getInt("duracao"));

        return s;
    }

    return null;
}
}
