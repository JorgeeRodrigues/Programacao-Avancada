package views;

import controllers.ClienteController;
import java.util.ArrayList;
import javax.swing.text.MaskFormatter;
import javax.swing.table.AbstractTableModel;
import main.Mensagem;
import models.Cliente;

public class TelaCliente extends javax.swing.JFrame {

    private ClienteController controller = new ClienteController();
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private int idSelecionado = -1;

    public TelaCliente() {
        initComponents();
        aplicarMascaras();
        setLocationRelativeTo(null);

        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int linha = tblCliente.getSelectedRow();

                if (linha < 0 || linha >= listaClientes.size()) {
                    return;
                }

                Cliente c = listaClientes.get(linha);

                idSelecionado = c.getId();

                txtNomeCliente.setText(c.getNome());
                txtEmailCliente.setText(c.getEmail());
                txtCpfCliente.setText(c.getCpf());
                txtTelefoneCliente.setText(c.getTelefone());
            }
        });

        montaTabela();
    }

    private void aplicarMascaras() {
        try {

            MaskFormatter cpf = new MaskFormatter("###.###.###-##");
            cpf.setPlaceholderCharacter('_');
            cpf.install(txtCpfCliente);

            MaskFormatter telefone = new MaskFormatter("(##)#####-####");
            telefone.setPlaceholderCharacter('_');
            telefone.install(txtTelefoneCliente);

        } catch (Exception e) {
            System.out.println("Erro ao aplicar máscaras: " + e.getMessage());
        }
    }

    private boolean validarCampos() {

        if (txtNomeCliente.getText().trim().isEmpty()
                || txtEmailCliente.getText().trim().isEmpty()
                || txtCpfCliente.getText().trim().isEmpty()
                || txtTelefoneCliente.getText().trim().isEmpty()) {

            Mensagem.aviso("Preencha todos os campos.");
            return false;
        }

        return true;
    }

    private void montaTabela() {
        try {

            listaClientes = controller.listar();

            tblCliente.setModel(new AbstractTableModel() {

                @Override
                public int getRowCount() {
                    return listaClientes.size();
                }

                @Override
                public int getColumnCount() {
                    return 4;
                }

                @Override
                public String getColumnName(int col) {
                    return new String[]{"Nome", "Email", "CPF", "Telefone"}[col];
                }

                @Override
                public Object getValueAt(int row, int col) {
                    Cliente c = listaClientes.get(row);

                    switch (col) {
                        case 0:
                            return c.getNome();
                        case 1:
                            return c.getEmail();
                        case 2:
                            return c.getCpf();
                        case 3:
                            return c.getTelefone();
                    }
                    return null;
                }
            });

        } catch (Exception e) {
            Mensagem.erro("Erro ao carregar tabela.\n" + e.getMessage());
        }
    }

    private void limpar() {

        txtNomeCliente.setText("");
        txtEmailCliente.setText("");
        txtCpfCliente.setText("");
        txtTelefoneCliente.setText("");

        tblCliente.clearSelection();
        idSelecionado = -1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLNomeCliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        txtNomeCliente = new javax.swing.JTextField();
        jLEmailCliente = new javax.swing.JLabel();
        txtEmailCliente = new javax.swing.JTextField();
        jLCpfCliente = new javax.swing.JLabel();
        jLTelefoneCliente = new javax.swing.JLabel();
        btnEditarCliente = new javax.swing.JButton();
        btnExcluirCliente = new javax.swing.JButton();
        btnSalvarCliente = new javax.swing.JButton();
        txtCpfCliente = new javax.swing.JFormattedTextField();
        txtTelefoneCliente = new javax.swing.JFormattedTextField();

        jLNomeCliente.setText("Nome");

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "E-mail", "CPF", "Telefone"
            }
        ));
        jScrollPane1.setViewportView(tblCliente);

        jLEmailCliente.setText("E-mail");

        jLCpfCliente.setText("CPF");

        jLTelefoneCliente.setText("Telefone");

        btnEditarCliente.setText("Editar");
        btnEditarCliente.addActionListener(this::btnEditarClienteActionPerformed);

        btnExcluirCliente.setText("Excluir");
        btnExcluirCliente.addActionListener(this::btnExcluirClienteActionPerformed);

        btnSalvarCliente.setText("Salvar");
        btnSalvarCliente.addActionListener(this::btnSalvarClienteActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCpfCliente)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExcluirCliente)
                        .addGap(65, 65, 65)
                        .addComponent(btnEditarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(btnSalvarCliente))
                    .addComponent(txtTelefoneCliente))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLNomeCliente)
                        .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLEmailCliente)
                        .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLCpfCliente)
                        .addComponent(jLTelefoneCliente)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGap(7, 7, 7)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(txtCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(txtTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirCliente)
                    .addComponent(btnSalvarCliente)
                    .addComponent(btnEditarCliente))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLNomeCliente)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLEmailCliente)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLCpfCliente)
                    .addGap(34, 34, 34)
                    .addComponent(jLTelefoneCliente)
                    .addGap(34, 34, 34)
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

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        if (idSelecionado == -1) {
            Mensagem.aviso("Selecione um cliente.");
            return;
        }

        if (!validarCampos()) {
            return;
        }

        try {

            Cliente c = new Cliente();

            c.setId(idSelecionado);
            c.setNome(txtNomeCliente.getText());
            c.setEmail(txtEmailCliente.getText());
            c.setCpf(txtCpfCliente.getText());
            c.setTelefone(txtTelefoneCliente.getText());

            controller.editar(c);
            Mensagem.informacao("Cliente editado com sucesso.");
            limpar();
            montaTabela();

        } catch (Exception e) {

            Mensagem.erro(
                    "Erro ao editar cliente.\n"
                    + e.getMessage());
        }
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void btnExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirClienteActionPerformed
        if (idSelecionado == -1) {
            Mensagem.aviso("Selecione um cliente.");
            return;
        }

        if (Mensagem.confirmacao("Deseja realmente excluir?") != 0) {
            return;
        }

        try {

            controller.excluir(idSelecionado);
            Mensagem.informacao("Cliente excluído com sucesso.");
            limpar();
            montaTabela();

        } catch (Exception e) {

            Mensagem.erro(
                    "Erro ao excluir cliente.\n"
                    + e.getMessage());
        }
    }//GEN-LAST:event_btnExcluirClienteActionPerformed

    private void btnSalvarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarClienteActionPerformed
        if (!validarCampos()) {
            return;
        }

        try {

            Cliente c = new Cliente();

            c.setNome(txtNomeCliente.getText());
            c.setEmail(txtEmailCliente.getText());
            c.setCpf(txtCpfCliente.getText());
            c.setTelefone(txtTelefoneCliente.getText());

            controller.salvar(c);
            Mensagem.informacao("Cliente salvo com sucesso.");
            limpar();
            montaTabela();

        } catch (Exception e) {

            Mensagem.erro(
                    "Erro ao salvar cliente.\n"
                    + e.getMessage());

        }
    }//GEN-LAST:event_btnSalvarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnExcluirCliente;
    private javax.swing.JButton btnSalvarCliente;
    private javax.swing.JLabel jLCpfCliente;
    private javax.swing.JLabel jLEmailCliente;
    private javax.swing.JLabel jLNomeCliente;
    private javax.swing.JLabel jLTelefoneCliente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCliente;
    private javax.swing.JFormattedTextField txtCpfCliente;
    private javax.swing.JTextField txtEmailCliente;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JFormattedTextField txtTelefoneCliente;
    // End of variables declaration//GEN-END:variables
}
