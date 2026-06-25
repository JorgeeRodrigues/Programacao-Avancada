package models.DAO;

import models.Pet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.ConexaoBD;

public class PetDAO {

    private ResultSet rs;

    public void salvar(Pet p) throws SQLException {

        String sql = "INSERT INTO pets (nome, especie, dono, idade) VALUES ('"
                + p.getNome() + "','"
                + p.getEspecie() + "','"
                + p.getDono() + "',"
                + p.getIdade() + ")";

        ConexaoBD.executeUpdate(sql);
    }

    public ArrayList<Pet> recuperarTodos() throws SQLException {

        ArrayList<Pet> lista = new ArrayList<>();

        rs = ConexaoBD.executeQuery("SELECT * FROM pets");

        while (rs.next()) {

            Pet p = new Pet();

            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setEspecie(rs.getString("especie"));
            p.setDono(rs.getString("dono"));
            p.setIdade(rs.getInt("idade"));

            lista.add(p);
        }

        return lista;
    }

    public boolean editar(Pet p) throws SQLException {

        String sql = "UPDATE pets SET "
                + "nome='" + p.getNome()
                + "', especie='" + p.getEspecie()
                + "', dono='" + p.getDono()
                + "', idade=" + p.getIdade()
                + " WHERE id=" + p.getId();

        return ConexaoBD.executeUpdate(sql) > 0;
    }

    public boolean excluir(int id) throws SQLException {

        String sql = "DELETE FROM pets WHERE id=" + id;

        return ConexaoBD.executeUpdate(sql) > 0;
    }
    
    public Pet recuperarUm(int id) throws SQLException {

    String sql = "SELECT * FROM pets WHERE id = " + id;

    rs = ConexaoBD.executeQuery(sql);

    if (rs.next()) {

        Pet p = new Pet();

        p.setId(rs.getInt("id"));
        p.setNome(rs.getString("nome"));
        p.setEspecie(rs.getString("especie"));
        p.setDono(rs.getString("dono"));
        p.setIdade(rs.getInt("idade"));

        return p;
    }

    return null;
}
}