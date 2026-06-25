package main;
import models.DAO.*;
import java.io.*;
import java.util.ArrayList;

public class FileManager {
 

    public static void adicionarLinhaNoArquivo(String conteudoLinha, String caminhoArquivo) {
        BufferedWriter escritor = null;
        try {
            escritor = new BufferedWriter(new FileWriter(caminhoArquivo, true));
            Mensagem.confirmacao("Salvando no arquivo: " + new File(caminhoArquivo).getAbsolutePath());
            escritor.write(conteudoLinha);      // Escreve o conteúdo no arquivo
            escritor.newLine();                 // Adiciona uma quebra de linha após escrever
        } catch (IOException erro) {
            Mensagem.erro("Erro ao salvar linha no arquivo: " + erro.getMessage());
        } finally {
            try {
                if (escritor != null) {
                    escritor.close();
                }
            } catch (IOException e) {
                Mensagem.erro("Erro ao fechar o arquivo: " + e.getMessage());
            }
        }
    }

    public static ArrayList<String> lerLinhasDoArquivo(String caminhoArquivo) {
        ArrayList<String> linhasLidas = new ArrayList();
        BufferedReader leitor = null;
        try {
            leitor = new BufferedReader(new FileReader(caminhoArquivo));
            String linhaAtual;
            while ((linhaAtual = leitor.readLine()) != null) {
                linhasLidas.add(linhaAtual);
            }
        } catch (IOException erro) {
            Mensagem.erro("Erro ao ler o arquivo: " + erro.getMessage());
        } finally {
            try {
                if (leitor != null) {
                    leitor.close();
                }
            } catch (IOException e) {
               Mensagem.erro("Erro ao fechar o arquivo: " + e.getMessage());
            }
        }

        return linhasLidas;
    }
}