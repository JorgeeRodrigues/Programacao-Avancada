package models.DAO;

import models.Agendamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.ConexaoBD;

public class AgendamentosDAO {

    private ResultSet resultadoQ = null;

    
    
    public void salvar(Agendamento a) throws SQLException {

        String sql = "INSERT INTO agendamentos "
                + "(cliente, pet, servico, dataehora) VALUES ('"
                + a.getCliente() + "','"
                + a.getPet() + "','"
                + a.getServico() + "','"
                + a.getDataehora() + "')";

        ConexaoBD.executeUpdate(sql);
    }

    public ArrayList<Agendamento> recuperarTodos() throws SQLException {

        ArrayList<Agendamento> lista = new ArrayList<>();

        resultadoQ = ConexaoBD.executeQuery("SELECT * FROM agendamentos");

        while (resultadoQ.next()) {

            Agendamento a = new Agendamento();

            a.setId(resultadoQ.getInt("id"));
            a.setCliente(resultadoQ.getString("cliente"));
            a.setPet(resultadoQ.getString("pet"));
            a.setServico(resultadoQ.getString("servico"));
            a.setDataehora(resultadoQ.getString("dataehora"));

            lista.add(a);
        }

        return lista;
    }

    public boolean editar(Agendamento a) throws SQLException {

        String sql = "UPDATE agendamentos SET "
                + "cliente='" + a.getCliente()
                + "', pet='" + a.getPet()
                + "', servico='" + a.getServico()
                + "', dataehora='" + a.getDataehora()
                + "' WHERE id=" + a.getId();

        return ConexaoBD.executeUpdate(sql) > 0;
    }

    public boolean excluir(int id) throws SQLException {

        String sql = "DELETE FROM agendamentos WHERE id=" + id;

        return ConexaoBD.executeUpdate(sql) > 0;
    }
    
    public Agendamento recuperarUm(int id) throws SQLException {

    String sql = "SELECT * FROM agendamentos WHERE id = " + id;

    resultadoQ = ConexaoBD.executeQuery(sql);

    if (resultadoQ.next()) {

        Agendamento a = new Agendamento();

        a.setId(resultadoQ.getInt("id"));
        a.setCliente(resultadoQ.getString("cliente"));
        a.setPet(resultadoQ.getString("pet"));
        a.setServico(resultadoQ.getString("servico"));
        a.setDataehora(resultadoQ.getString("dataehora"));

        return a;
    }

    return null;
}
}