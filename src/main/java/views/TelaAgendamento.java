package views;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import models.*;
import controllers.*;

import main.Mensagem;
import javax.swing.text.MaskFormatter;

public class TelaAgendamento extends javax.swing.JFrame {

    private AgendamentoController controller = new AgendamentoController();
    private ArrayList<Agendamento> lista = new ArrayList<>();
    private int idSelecionado = -1;

    public TelaAgendamento() {
        initComponents();
        aplicarMascaras();
        setLocationRelativeTo(null);

        tblAgendamento.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {           // quando clica na tabela

                int linha = tblAgendamento.getSelectedRow();                    // pega a linha clicada

                if (linha < 0 || linha >= lista.size()) {                       // verifica se a linha é válida
                    return;                                                     // se não for, sai do método    
                }

                Agendamento a = lista.get(linha);                               // pega o objeto da lista na posição clicada

                idSelecionado = a.getId();                                      // guarda o ID do agendamento selecionado

                txtClienteAgendamento.setText(a.getCliente());                  // joga nos campos
                txtPetAgendamento.setText(a.getPet());
                txtServicoAgendamento.setText(a.getServico());
                txtDataHoraAgendamento.setText(a.getDataehora());
            }
        });

        montaTabela();
    }

    private void montaTabela() {
        try {
            lista = controller.listar();

            tblAgendamento.setModel(new AbstractTableModel() {
                public int getRowCount() {
                    return lista.size();
                }

                public int getColumnCount() {
                    return 4;
                }

                public String getColumnName(int c) {
                    return new String[]{"Cliente", "Pet", "Serviço", "Data"}[c];
                }

                public Object getValueAt(int r, int c) {
                    Agendamento a = lista.get(r);
                    switch (c) {
                        case 0:
                            return a.getCliente();
                        case 1:
                            return a.getPet();
                        case 2:
                            return a.getServico();
                        case 3:
                            return a.getDataehora();
                    }
                    return null;
                }
            });

        } catch (Exception e) {
            Mensagem.erro("Erro ao carregar tabela:\n" + e.getMessage());
        }
    }

    private void limpar() {                                                     
        txtClienteAgendamento.setText("");                                      // limpa todos os campos da tela
        txtPetAgendamento.setText("");                                          // desmarca a tabela                
        txtServicoAgendamento.setText("");                                      // reseta a seleção
        txtDataHoraAgendamento.setValue(null);
        tblAgendamento.clearSelection();

        idSelecionado = -1;
    }

    private void aplicarMascaras() {

        try {

            MaskFormatter dataHora
                    = new MaskFormatter("##/##/#### ##:##");                    // dia/mês/ano hora:minuto
            
            dataHora.setPlaceholderCharacter('_');                              // pra ajudar o usuário a ver onde ainda falta preencher
            dataHora.install(txtDataHoraAgendamento);                           // O usuário só vai conseguir digitar nesse formato

        } catch (Exception e) {

            Mensagem.erro("Erro ao aplicar máscara: "
                    + e.getMessage());                                          // se der algum erro ao criar ou aplicar a máscara,
                                                                                // mostra uma mensagem de erro na tela      
        }
    }

    private boolean validarCampos() {

        if (txtClienteAgendamento.getText().trim().isEmpty()                    // verifica se algum dos campos (cliente, pet ou serviço) está vazio
                || txtPetAgendamento.getText().trim().isEmpty()                 // o trim() tira espaços em branco
                || txtServicoAgendamento.getText().trim().isEmpty()) {          // o isEmpty() verifica se não tem nada digitado
                                                                                // o "||" significa OU (se qualquer um estiver vazio, entra no if)
            
            Mensagem.aviso("Preencha todos os campos.");                        // mostra uma mensagem avisando que falta preencher algo
            return false;                                                       // cancela a validação e diz que está tudo inválido

        }

        if (txtDataHoraAgendamento.getText().contains("_")) {                   // verifica se ainda tem "_" no campo de data e hora
                                                                                // isso significa que o usuário não preencheu tudo da máscara

            Mensagem.aviso("Preencha a data e hora corretamente.");             // avisa que a data/hora não foi preenchida corretamente
           
            return false;                                                       // também cancela a validação
        }
        return true;                                                            // retorna liberando o cadastro
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtPetAgendamento = new javax.swing.JTextField();
        txtServicoAgendamento = new javax.swing.JTextField();
        jLDataHoraAgendamento = new javax.swing.JLabel();
        jLServicoAgendamento = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAgendamento = new javax.swing.JTable();
        jLClienteAgendamento = new javax.swing.JLabel();
        txtClienteAgendamento = new javax.swing.JTextField();
        jLPetAgendamento = new javax.swing.JLabel();
        btnExcluirAgendamento = new javax.swing.JButton();
        btnEditarAgendamento = new javax.swing.JButton();
        btnSalvarAgendamento = new javax.swing.JButton();
        txtDataHoraAgendamento = new javax.swing.JFormattedTextField();

        txtPetAgendamento.addActionListener(this::txtPetAgendamentoActionPerformed);

        txtServicoAgendamento.addActionListener(this::txtServicoAgendamentoActionPerformed);

        jLDataHoraAgendamento.setText("Data e Hora:");

        jLServicoAgendamento.setText("Serviço:");

        tblAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cliente", "Pet", "Serviço", "Data e Hora"
            }
        ));
        jScrollPane1.setViewportView(tblAgendamento);

        jLClienteAgendamento.setText("Cliente:");

        txtClienteAgendamento.addActionListener(this::txtClienteAgendamentoActionPerformed);

        jLPetAgendamento.setText("Pet:");

        btnExcluirAgendamento.setText("Excluir");
        btnExcluirAgendamento.addActionListener(this::btnExcluirAgendamentoActionPerformed);

        btnEditarAgendamento.setText("Editar");
        btnEditarAgendamento.addActionListener(this::btnEditarAgendamentoActionPerformed);

        btnSalvarAgendamento.setText("Salvar");
        btnSalvarAgendamento.addActionListener(this::btnSalvarAgendamentoActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLDataHoraAgendamento)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDataHoraAgendamento)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnExcluirAgendamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addComponent(btnEditarAgendamento)
                                .addGap(76, 76, 76)
                                .addComponent(btnSalvarAgendamento)))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLClienteAgendamento)
                        .addComponent(jLPetAgendamento)
                        .addComponent(jLServicoAgendamento)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtClienteAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPetAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtServicoAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(7, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLDataHoraAgendamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDataHoraAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirAgendamento)
                    .addComponent(btnEditarAgendamento)
                    .addComponent(btnSalvarAgendamento))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLClienteAgendamento)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtClienteAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLPetAgendamento)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtPetAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLServicoAgendamento)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtServicoAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(265, Short.MAX_VALUE)))
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

    private void btnSalvarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAgendamentoActionPerformed
        if (!validarCampos()) {                                                 // chama o método validarCampos()
                                                                                // o "!" significa NEGAÇÃO (ou seja: se NÃO estiver válido)
            
            return;                                                             // se os campos não estiverem corretos, para tudo aqui e não continua o código
        }

        try {                                                                   // começa um bloco de tentativa
                                                                                // ou seja: tudo aqui dentro pode dar erro, mas vai ser tratado depois
            
            Agendamento a = new Agendamento();                                  // cria um novo objeto Agendamento (tipo uma "ficha" vazia)
            a.setCliente(txtClienteAgendamento.getText());                      // pega o texto do campo cliente e coloca dentro do objeto
            a.setPet(txtPetAgendamento.getText());                              // pega o pet digitado e salva no objeto
            a.setServico(txtServicoAgendamento.getText());                      // pega o serviço e salva no objeto
            a.setDataehora(txtDataHoraAgendamento.getText());                   // pega a data e hora e salva no objeto
           
            controller.salvar(a);                                               // manda esse agendamento para o controller salvar no banco
            Mensagem.informacao("Agendamento salvo com sucesso");               // mostra uma mensagem dizendo que deu tudo certo
            limpar();                                                           // limpa os campos da tela depois de salvar
            montaTabela();                                                      // atualiza a tabela pra mostrar o novo agendamento

        } catch (Exception e) {                                                 // se der qualquer erro dentro do try, cai aqui
            
            Mensagem.erro(
                    "Erro ao salvar agendamento:\n"
                    + e.getMessage());                                          // mostra uma mensagem de erro com o motivo do problema
        }
    }//GEN-LAST:event_btnSalvarAgendamentoActionPerformed

    private void btnEditarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAgendamentoActionPerformed
        if (idSelecionado == -1) {                                              // verifica se nenhum agendamento foi selecionado na tabela
                                                                                // normalmente -1 significa "nada selecionado"
            Mensagem.aviso("Selecione um agendamento.");                        // mostra um aviso pedindo para o usuário selecionar um item
            return;                                                             // para o código aqui e não deixa continuar a edição
        }

        if (!validarCampos()) {                                                 // chama a validação dos campos
            return;                                                             // o "!" significa que se estiver inválido...
        }

        try {

            Agendamento a = new Agendamento();                                  // cria um novo objeto Agendamento (como uma "ficha" pra edição)

            a.setId(idSelecionado);                                             // coloca o ID do agendamento selecionado (pra saber qual atualizar no banco)
            a.setCliente(txtClienteAgendamento.getText());                      // atualiza o cliente com o valor do campo
            a.setPet(txtPetAgendamento.getText());                              // atualiza o pet
            a.setServico(txtServicoAgendamento.getText());                      // atualiza o serviço
            a.setDataehora(txtDataHoraAgendamento.getText());                   // atualiza a data e hora

            controller.editar(a);                                               // manda o objeto atualizado para o controller salvar as mudanças no banco
            Mensagem.informacao("Agendamento editado com sucesso");             // mostra mensagem de sucesso
            limpar();                                                           // limpa os campos da tela
            montaTabela();                                                      // atualiza a tabela para mostrar os dados atualizados

        } catch (Exception e) {                                                 // caso dê erro em qualquer parte do try, cai aqui

            Mensagem.erro(
                    "Erro ao editar agendamento:\n"
                    + e.getMessage());                                          // mostra o erro para o usuário
        }
    }//GEN-LAST:event_btnEditarAgendamentoActionPerformed

    private void btnExcluirAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirAgendamentoActionPerformed
        if (idSelecionado == -1) {                                              
            Mensagem.aviso("Selecione um agendamento.");                        
            return;
        }

        if (Mensagem.confirmacao("Deseja realmente excluir?") != 0) {           // pede confirmação do usuário
            return; 
        }

        try {

            controller.excluir(idSelecionado);                                  // exclui do banco
            Mensagem.informacao("Agendamento excluído com sucesso");
            limpar();                                                           // limpa a tela
            montaTabela();                                                      // atualiza a tabela

        } catch (Exception e) {

            Mensagem.erro(
                    "Erro ao excluir agendamento:\n"                            // ou mostra erro se der problema
                    + e.getMessage());                                          
        }
    }//GEN-LAST:event_btnExcluirAgendamentoActionPerformed

    private void txtClienteAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteAgendamentoActionPerformed
    }//GEN-LAST:event_txtClienteAgendamentoActionPerformed

    private void txtPetAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPetAgendamentoActionPerformed
    }//GEN-LAST:event_txtPetAgendamentoActionPerformed

    private void txtServicoAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServicoAgendamentoActionPerformed
    }//GEN-LAST:event_txtServicoAgendamentoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarAgendamento;
    private javax.swing.JButton btnExcluirAgendamento;
    private javax.swing.JButton btnSalvarAgendamento;
    private javax.swing.JLabel jLClienteAgendamento;
    private javax.swing.JLabel jLDataHoraAgendamento;
    private javax.swing.JLabel jLPetAgendamento;
    private javax.swing.JLabel jLServicoAgendamento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAgendamento;
    private javax.swing.JTextField txtClienteAgendamento;
    private javax.swing.JFormattedTextField txtDataHoraAgendamento;
    private javax.swing.JTextField txtPetAgendamento;
    private javax.swing.JTextField txtServicoAgendamento;
    // End of variables declaration//GEN-END:variables
}
