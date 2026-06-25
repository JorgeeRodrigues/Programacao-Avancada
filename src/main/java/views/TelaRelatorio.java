package views;

import controllers.*;
import main.Mensagem;
import main.PDFManager;

public class TelaRelatorio extends javax.swing.JInternalFrame {

    public TelaRelatorio() {
        initComponents();
        cmbGerarPDF.removeAllItems();

        cmbGerarPDF.addItem("Clientes");
        cmbGerarPDF.addItem("Pets");
        cmbGerarPDF.addItem("Funcionários");
        cmbGerarPDF.addItem("Serviços");
        cmbGerarPDF.addItem("Agendamentos");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGerarPDF1 = new javax.swing.JButton();
        cmbGerarPDF = new javax.swing.JComboBox<>();

        btnGerarPDF1.setText("Gerar PDF");
        btnGerarPDF1.addActionListener(this::btnGerarPDF1ActionPerformed);

        cmbGerarPDF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Agendamentos", "Clientes", "Funcionários", "Pets", "Serviços" }));
        cmbGerarPDF.addActionListener(this::cmbGerarPDFActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(btnGerarPDF1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addComponent(cmbGerarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbGerarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250)
                .addComponent(btnGerarPDF1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarPDF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarPDF1ActionPerformed
         if (cmbGerarPDF.getSelectedItem() == null) {
        Mensagem.erro("Selecione uma opção antes de gerar o PDF.");
        return;
    }

    String opcao = cmbGerarPDF.getSelectedItem().toString();

    try {
        switch (opcao) {

            case "Clientes":
                ClienteController clienteController = new ClienteController();
                PDFManager.gerar(clienteController.listar(), "relatorio_clientes.pdf");
                Mensagem.informacao("PDF de clientes gerado com sucesso!");
                break;

            case "Pets":
                PetController petController = new PetController();
                PDFManager.gerar(petController.listar(), "relatorio_pets.pdf");
                Mensagem.informacao("PDF de pets gerado com sucesso!");
                break;

            case "Funcionários":
                FuncionarioController funcionarioController = new FuncionarioController();
                PDFManager.gerar(funcionarioController.listar(), "relatorio_funcionarios.pdf");
                Mensagem.informacao("PDF de funcionários gerado com sucesso!");
                break;

            case "Serviços":
                ServicoController servicoController = new ServicoController();
                PDFManager.gerar(servicoController.listar(), "relatorio_servicos.pdf");
                Mensagem.informacao("PDF de serviços gerado com sucesso!");
                break;

            case "Agendamentos":
                AgendamentoController agendamentoController = new AgendamentoController();
                PDFManager.gerar(agendamentoController.listar(), "relatorio_agendamentos.pdf");
                Mensagem.informacao("PDF de agendamentos gerado com sucesso!");
                break;
        }

    } catch (Exception e) {
        Mensagem.erro("Erro ao gerar PDF: " + e.getMessage());
    }
    }//GEN-LAST:event_btnGerarPDF1ActionPerformed

    private void cmbGerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGerarPDFActionPerformed

    }//GEN-LAST:event_cmbGerarPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarPDF1;
    private javax.swing.JComboBox<String> cmbGerarPDF;
    // End of variables declaration//GEN-END:variables
}
