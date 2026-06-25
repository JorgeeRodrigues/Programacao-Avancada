package main;

import javax.swing.JOptionPane;
import views.TelaLogin;
import views.TelaPrincipal;

public class ExemploTelas {

    public static void main(String[] args) {        
        try {
            // testa conexão
            ConexaoBD.getInstance().getConnection();

            // abre sistema
            TelaLogin tl = new TelaLogin();
            tl.setVisible(true);

        } catch (Exception e) {
             Mensagem.erro("Erro de conexão com o banco de dados!\nPor favor entre em contato com o suporte.");
                
        }
    }
}