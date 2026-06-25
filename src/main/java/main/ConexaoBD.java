package main;

import java.sql.*;
import java.io.*;
import java.util.*;

public class ConexaoBD {

    private static ConexaoBD instancia = null;
    private Connection conexao = null;

    public ConexaoBD() {
        try {
            // Carrega informações do arquivo de propriedades
            Properties prop = new Properties();
            prop.load(new FileInputStream("db.properties"));
            String dbdriver = prop.getProperty("db.driver");
            String dburl = prop.getProperty("db.url");
            String dbuser = prop.getProperty("db.user");
            String dbsenha = prop.getProperty("db.senha");

            // Carrega Driver do Banco de Dados
            Class.forName(dbdriver);

            conexao = DriverManager.getConnection(dburl, dbuser, dbsenha);

        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }

    public static ConexaoBD getInstance() {
        if (instancia == null) {
            instancia = new ConexaoBD();
        }
        return instancia;
    }

    public Connection getConnection() {
        if (conexao == null) {
            throw new RuntimeException("conexao==null");
        }
        return conexao;
    }

    public static int executeUpdate(String sql) throws SQLException {
        return ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);
    }

    public static ResultSet executeQuery(String sql) throws SQLException {
        return ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
    }

    public void shutdown() {
        try {
            conexao.close();
            instancia = null;
            conexao = null;
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

}
