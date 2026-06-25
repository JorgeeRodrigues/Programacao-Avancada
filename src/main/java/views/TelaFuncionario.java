package views;

import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.MaskFormatter;
import models.*;
import controllers.*;
import main.Mensagem;

public class TelaFuncionario extends javax.swing.JFrame {

    private FuncionarioController controller = new FuncionarioController();
    private ArrayList<Funcionario> lista = new ArrayList<>();
    private int idSelecionado = -1;

    public TelaFuncionario() {
        initComponents();
        aplicarMascara();
        setLocationRelativeTo(null);

        tblFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                int linha = tblFuncionario.getSelectedRow();

                if (linha < 0 || linha >= lista.size()) {
                    return;
                }

                Funcionario f = lista.get(linha);

                idSelecionado = f.getId();

                txtNomeFuncionario.setText(f.getNome());
                txtCpfFuncionario.setText(f.getCpf());
            }
        });

        montaTabela();
    }

    private void aplicarMascara() {
        try {

            MaskFormatter cpf = new MaskFormatter("###.###.###-##");
            cpf.setPlaceholderCharacter('_');
            cpf.install((JFormattedTextField) txtCpfFuncionario);

        } catch (Exception e) {
            Mensagem.erro("Erro ao aplicar máscara: " + e.getMessage());
        }
    }

    private boolean validarCampos() {

        if (txtNomeFuncionario.getText().trim().isEmpty()
                || txtCpfFuncionario.getText().contains("_")) {

            Mensagem.aviso("Preencha todos os campos corretamente!");
            return false;
        }

        return true;
    }

    private void montaTabela() {

        try {

            lista = controller.listar();

            tblFuncionario.setModel(new AbstractTableModel() {

                @Override
                public int getRowCount() {
                    return lista.size();
                }

                @Override
                public int getColumnCount() {
                    return 2;
                }

                @Override
                public String getColumnName(int c) {
                    return new String[]{"Nome", "CPF"}[c];
                }

                @Override
                public Object getValueAt(int r, int c) {

                    Funcionario f = lista.get(r);

                    switch (c) {
                        case 0: return f.getNome();
                        case 1: return f.getCpf();
                    }

                    return null;
                }
            });

        } catch (Exception e) {
            Mensagem.erro("Erro ao carregar tabela: " + e.getMessage());
        }
    }

    private void limpar() {

        txtNomeFuncionario.setText("");
        txtCpfFuncionario.setText("");

        tblFuncionario.clearSelection();
        idSelecionado = -1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLNomeFuncionario = new javax.swing.JLabel();
        txtNomeFuncionario = new javax.swing.JTextField();
        jLCpfFuncionario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionario = new javax.swing.JTable();
        btnExcluirFuncionario = new javax.swing.JButton();
        btnEditarFuncionario = new javax.swing.JButton();
        btnSalvarFuncionario = new javax.swing.JButton();
        txtCpfFuncionario = new javax.swing.JFormattedTextField();

        jLNomeFuncionario.setText("Nome:");

        jLCpfFuncionario.setText("CPF:");

        tblFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "CPF"
            }
        ));
        jScrollPane1.setViewportView(tblFuncionario);

        btnExcluirFuncionario.setText("Excluir");
        btnExcluirFuncionario.addActionListener(this::btnExcluirFuncionarioActionPerformed);

        btnEditarFuncionario.setText("Editar");
        btnEditarFuncionario.addActionListener(this::btnEditarFuncionarioActionPerformed);

        btnSalvarFuncionario.setText("Salvar");
        btnSalvarFuncionario.addActionListener(this::btnSalvarFuncionarioActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCpfFuncionario)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExcluirFuncionario)
                        .addGap(75, 75, 75)
                        .addComponent(btnEditarFuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(btnSalvarFuncionario)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jLNomeFuncionario)
                        .addComponent(txtNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLCpfFuncionario))
                    .addGap(7, 7, 7)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(txtCpfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirFuncionario)
                    .addComponent(btnEditarFuncionario)
                    .addComponent(btnSalvarFuncionario))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLNomeFuncionario)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLCpfFuncionario)
                    .addGap(40, 40, 40)
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

    private void btnSalvarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarFuncionarioActionPerformed
 if (!validarCampos()) return;

        try {

            Funcionario f = new Funcionario();
            f.setNome(txtNomeFuncionario.getText());
            f.setCpf(txtCpfFuncionario.getText());

            controller.salvar(f);

            Mensagem.informacao("Funcionário salvo com sucesso");

            limpar();
            montaTabela();

        } catch (Exception e) {
            Mensagem.erro("Erro ao salvar funcionário: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarFuncionarioActionPerformed

    private void btnEditarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarFuncionarioActionPerformed
       if (idSelecionado == -1) {
            Mensagem.aviso("Selecione um funcionário");
            return;
        }

        if (!validarCampos()) return;

        try {

            Funcionario f = new Funcionario();
            f.setId(idSelecionado);
            f.setNome(txtNomeFuncionario.getText());
            f.setCpf(txtCpfFuncionario.getText());

            controller.editar(f);

            Mensagem.informacao("Funcionário editado com sucesso");

            limpar();
            montaTabela();

        } catch (Exception e) {
            Mensagem.erro("Erro ao editar funcionário: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditarFuncionarioActionPerformed

    private void btnExcluirFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirFuncionarioActionPerformed
        if (idSelecionado == -1) {
            Mensagem.aviso("Selecione um funcionário");
            return;
        }

        if (Mensagem.confirmacao("Deseja realmente excluir?") != 0) {
            return;
        }

        try {
            controller.excluir(idSelecionado);

            Mensagem.informacao("Funcionário excluído com sucesso");

            limpar();
            montaTabela();

        } catch (Exception e) {
            Mensagem.erro("Erro ao excluir funcionário" + e.getMessage());
        }
    }//GEN-LAST:event_btnExcluirFuncionarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarFuncionario;
    private javax.swing.JButton btnExcluirFuncionario;
    private javax.swing.JButton btnSalvarFuncionario;
    private javax.swing.JLabel jLCpfFuncionario;
    private javax.swing.JLabel jLNomeFuncionario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFuncionario;
    private javax.swing.JFormattedTextField txtCpfFuncionario;
    private javax.swing.JTextField txtNomeFuncionario;
    // End of variables declaration//GEN-END:variables
}
