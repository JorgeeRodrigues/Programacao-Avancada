/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.text.NumberFormat;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import models.*;
import controllers.*;
import main.Mensagem;
import main.PDFManager;

/**
 *
 * @author Jorge Luís
 */
public class TelaServico extends javax.swing.JFrame {

    private ServicoController controller = new ServicoController();
    private ArrayList<Servico> lista = new ArrayList<>();
    private int idSelecionado = -1;

    public TelaServico() {
        initComponents();
        setLocationRelativeTo(null);
        tblServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int linha = tblServico.getSelectedRow();
                Servico s = lista.get(linha);

                idSelecionado = s.getId();

                txtDescricaoServico.setText(s.getDescricao());
                txtPrecoServico.setText(String.valueOf(s.getPreco()));
                txtDuracaoServico.setText(String.valueOf(s.getDuracao()));
            }
        });

        montaTabela();
    }

    private void montaTabela() {
        try {
            lista = controller.listar();

            tblServico.setModel(new AbstractTableModel() {

                public int getRowCount() {
                    return lista.size();
                }

                public int getColumnCount() {
                    return 3;
                }

                public String getColumnName(int c) {
                    return new String[]{"Descrição", "Preço", "Duração"}[c];
                }

                public Object getValueAt(int r, int c) {
                    Servico s = lista.get(r);
                    switch (c) {
                        case 0:
                            return s.getDescricao();
                        case 1:
                            return s.getPreco();
                        case 2:
                            return s.getDuracao();
                    }
                    return null;
                }
            });

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro tabela");
        }
    }

    private void limpar() {
        txtDescricaoServico.setText("");
        txtPrecoServico.setText("");
        txtDuracaoServico.setText("");
        idSelecionado = -1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtDuracaoServico = new javax.swing.JTextField();
        txtDescricaoServico = new javax.swing.JTextField();
        jLCpfFuncionario = new javax.swing.JLabel();
        jLDescricaoServico = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServico = new javax.swing.JTable();
        jLDuracaoServico = new javax.swing.JLabel();
        btnExcluirServico = new javax.swing.JButton();
        btnEditarServico = new javax.swing.JButton();
        btnSalvarServico = new javax.swing.JButton();
        txtPrecoServico = new javax.swing.JFormattedTextField();

        jLCpfFuncionario.setText("Preço (R$):");

        jLDescricaoServico.setText("Descrição:");

        tblServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Descrição", "Preço (R$)", "Duração (min)"
            }
        ));
        jScrollPane1.setViewportView(tblServico);

        jLDuracaoServico.setText("Duração (min):");

        btnExcluirServico.setText("Excluir");
        btnExcluirServico.addActionListener(this::btnExcluirServicoActionPerformed);

        btnEditarServico.setText("Editar");
        btnEditarServico.addActionListener(this::btnEditarServicoActionPerformed);

        btnSalvarServico.setText("Salvar");
        btnSalvarServico.addActionListener(this::btnSalvarServicoActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecoServico)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExcluirServico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(btnEditarServico)
                        .addGap(76, 76, 76)
                        .addComponent(btnSalvarServico)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLDescricaoServico)
                                .addComponent(txtDescricaoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLCpfFuncionario)
                                .addComponent(jLDuracaoServico)
                                .addComponent(txtDuracaoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 2, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(txtPrecoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarServico)
                    .addComponent(btnEditarServico)
                    .addComponent(btnExcluirServico))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLDescricaoServico)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtDescricaoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLCpfFuncionario)
                    .addGap(44, 44, 44)
                    .addComponent(jLDuracaoServico)
                    .addGap(4, 4, 4)
                    .addComponent(txtDuracaoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarServicoActionPerformed
        if (txtDescricaoServico.getText().trim().isEmpty()
        || txtPrecoServico.getText().trim().isEmpty()
        || txtDuracaoServico.getText().trim().isEmpty()) {

    Mensagem.aviso("Preencha todos os campos!");

    return;
}
        
        try {
            Servico s = new Servico();
            s.setDescricao(txtDescricaoServico.getText());
            s.setPreco(Double.parseDouble(txtPrecoServico.getText()));
            s.setDuracao(Integer.parseInt(txtDuracaoServico.getText()));

            controller.salvar(s);

            Mensagem.informacao("Serviço salvo com sucesso");

            limpar();
            montaTabela();

        } catch (Exception e) {
            Mensagem.erro("Erro ao salvar serviço");
        }
    }//GEN-LAST:event_btnSalvarServicoActionPerformed

    private void btnEditarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarServicoActionPerformed
        if (txtDescricaoServico.getText().trim().isEmpty()
        || txtPrecoServico.getText().trim().isEmpty()
        || txtDuracaoServico.getText().trim().isEmpty()) {

    Mensagem.aviso("Preencha todos os campos!");

    return;
}
        
        if (idSelecionado == -1) {
            Mensagem.aviso("Selecione um serviço");
            return;
        }

        try {
            Servico s = new Servico();
            s.setId(idSelecionado);
            s.setDescricao(txtDescricaoServico.getText());
            s.setPreco(Double.parseDouble(txtPrecoServico.getText()));
            s.setDuracao(Integer.parseInt(txtDuracaoServico.getText()));

            controller.editar(s);

            Mensagem.informacao("Serviço editado com sucesso");

            limpar();
            montaTabela();

        } catch (Exception e) {
            Mensagem.erro("Erro ao editar serviço");
        }
    }//GEN-LAST:event_btnEditarServicoActionPerformed

    private void btnExcluirServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirServicoActionPerformed
        if (txtDescricaoServico.getText().trim().isEmpty()
        || txtPrecoServico.getText().trim().isEmpty()
        || txtDuracaoServico.getText().trim().isEmpty()) {

    Mensagem.aviso("Preencha todos os campos!");

    return;
}
        
        if (idSelecionado == -1) {
            Mensagem.aviso("Selecione um serviço");
            return;
        }

        if (Mensagem.confirmacao("Deseja realmente excluir?") != 0) {
            return;
        }

        try {
            controller.excluir(idSelecionado);

            Mensagem.informacao("Serviço excluído com sucesso");

            limpar();
            montaTabela();

        } catch (Exception e) {
            Mensagem.erro("Erro ao excluir serviço");
        }
    }//GEN-LAST:event_btnExcluirServicoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarServico;
    private javax.swing.JButton btnExcluirServico;
    private javax.swing.JButton btnSalvarServico;
    private javax.swing.JLabel jLCpfFuncionario;
    private javax.swing.JLabel jLDescricaoServico;
    private javax.swing.JLabel jLDuracaoServico;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblServico;
    private javax.swing.JTextField txtDescricaoServico;
    private javax.swing.JTextField txtDuracaoServico;
    private javax.swing.JFormattedTextField txtPrecoServico;
    // End of variables declaration//GEN-END:variables
}
