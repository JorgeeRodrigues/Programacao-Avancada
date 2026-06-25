package models.DAO;

import models.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.ConexaoBD;

public class ClienteDAO {

    private ResultSet rs = null;

    public void salvar(Cliente c) throws SQLException {

        String sql = "INSERT INTO clientes (nome, email, cpf, telefone) VALUES ('"
                + c.getNome() + "','"
                + c.getEmail() + "','"
                + c.getCpf() + "','"
                + c.getTelefone() + "')";

        ConexaoBD.executeUpdate(sql);
    }

    public ArrayList<Cliente> recuperarTodos() throws SQLException {

        ArrayList<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM clientes";

        rs = ConexaoBD.executeQuery(sql);

        while (rs.next()) {

            Cliente c = new Cliente();

            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setEmail(rs.getString("email"));
            c.setCpf(rs.getString("cpf"));
            c.setTelefone(rs.getString("telefone"));

            lista.add(c);
        }

        return lista;
    }

    public boolean editar(Cliente c) throws SQLException {

        String sql = "UPDATE clientes SET "
                + "nome='" + c.getNome()
                + "', email='" + c.getEmail()
                + "', cpf='" + c.getCpf()
                + "', telefone='" + c.getTelefone()
                + "' WHERE id=" + c.getId();

        return ConexaoBD.executeUpdate(sql) > 0;
    }

    public boolean excluir(int id) throws SQLException {

        String sql = "DELETE FROM clientes WHERE id=" + id;

        return ConexaoBD.executeUpdate(sql) > 0;
    }
    
    public Cliente recuperarUm(int id) throws SQLException {

    String sql = "SELECT * FROM clientes WHERE id = " + id;

    rs = ConexaoBD.executeQuery(sql);

    if (rs.next()) {

        Cliente c = new Cliente();

        c.setId(rs.getInt("id"));
        c.setNome(rs.getString("nome"));
        c.setEmail(rs.getString("email"));
        c.setCpf(rs.getString("cpf"));
        c.setTelefone(rs.getString("telefone"));

        return c;
    }

    return null;
}
}