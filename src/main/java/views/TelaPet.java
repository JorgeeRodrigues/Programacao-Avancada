package views;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import models.*;
import controllers.*;
import main.Mensagem;


public class TelaPet extends javax.swing.JFrame {

    private PetController controller = new PetController();
    private ArrayList<Pet> lista = new ArrayList<>();
    private int idSelecionado = -1;

    public TelaPet() {
        initComponents();
        setLocationRelativeTo(null);
        tblPet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int linha = tblPet.getSelectedRow();
                Pet p = lista.get(linha);

                idSelecionado = p.getId();

                txtNomePet.setText(p.getNome());
                txtEspeciePet.setText(p.getEspecie());
                txtDonoPet.setText(p.getDono());
                txtIdadePet.setText(String.valueOf(p.getIdade()));
            }
        });
        montaTabela();
    }

    private void montaTabela() {
        try {
            lista = controller.listar();

            tblPet.setModel(new AbstractTableModel() {

                public int getRowCount() {
                    return lista.size();
                }

                public int getColumnCount() {
                    return 4;
                }

                public String getColumnName(int c) {
                    return new String[]{"Nome", "Espécie", "Dono", "Idade"}[c];
                }

                public Object getValueAt(int r, int c) {
                    Pet p = lista.get(r);
                    switch (c) {
                        case 0:
                            return p.getNome();
                        case 1:
                            return p.getEspecie();
                        case 2:
                            return p.getDono();
                        case 3:
                            return p.getIdade();
                    }
                    return null;
                }
            });

        } catch (Exception e) {
            Mensagem.erro ("Erro ao carregar tabela");
        }
    }

    private void limpar() {
        txtNomePet.setText("");
        txtEspeciePet.setText("");
        txtDonoPet.setText("");
        txtIdadePet.setText("");
        idSelecionado = -1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDonoPet1 = new javax.swing.JTextField();
        txtDonoPet2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLDonoPet = new javax.swing.JLabel();
        txtNomePet = new javax.swing.JTextField();
        txtIdadePet = new javax.swing.JTextField();
        txtEspeciePet = new javax.swing.JTextField();
        jlNomePet = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPet = new javax.swing.JTable();
        jlEspeciePet = new javax.swing.JLabel();
        jLIdadePet = new javax.swing.JLabel();
        btnExcluirPet = new javax.swing.JButton();
        btnEditarPet = new javax.swing.JButton();
        btnSalvarPet = new javax.swing.JButton();
        txtDonoPet = new javax.swing.JTextField();

        jLDonoPet.setText("Dono (Cliente):");

        jlNomePet.setText("Nome:");

        tblPet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Espécie", "Dono (Cliente)", "Idade (anos)"
            }
        ));
        jScrollPane1.setViewportView(tblPet);

        jlEspeciePet.setText("Espécie:");

        jLIdadePet.setText("Idade (anos):");

        btnExcluirPet.setText("Excluir");
        btnExcluirPet.addActionListener(this::btnExcluirPetActionPerformed);

        btnEditarPet.setText("Editar");
        btnEditarPet.addActionListener(this::btnEditarPetActionPerformed);

        btnSalvarPet.setText("Salvar");
        btnSalvarPet.addActionListener(this::btnSalvarPetActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExcluirPet)
                        .addGap(74, 74, 74)
                        .addComponent(btnEditarPet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvarPet))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdadePet, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDonoPet, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLIdadePet))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlNomePet)
                                .addComponent(jlEspeciePet)
                                .addComponent(jLDonoPet)
                                .addComponent(txtNomePet, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEspeciePet, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 2, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 138, Short.MAX_VALUE)
                .addComponent(txtDonoPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLIdadePet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdadePet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirPet)
                    .addComponent(btnEditarPet)
                    .addComponent(btnSalvarPet)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jlNomePet)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtNomePet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jlEspeciePet)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtEspeciePet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLDonoPet)
                    .addGap(98, 98, 98)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(30, Short.MAX_VALUE)))
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

    private void btnSalvarPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarPetActionPerformed
        try {
            Pet p = new Pet();
            p.setNome(txtNomePet.getText());
            p.setEspecie(txtEspeciePet.getText());
            p.setDono(txtDonoPet.getText());
            p.setIdade(Integer.parseInt(txtIdadePet.getText()));

            controller.salvar(p);

            Mensagem.informacao("Pet salvo com sucesso");

            limpar();
            montaTabela();

        } catch (Exception e) {
            Mensagem.erro("Erro ao salvar pet ");
        }
    }//GEN-LAST:event_btnSalvarPetActionPerformed

    private void btnEditarPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPetActionPerformed
        if (idSelecionado == -1) {
            Mensagem.aviso("Selecione um pet");
            return;
        }

        try {
            Pet p = new Pet();
            p.setId(idSelecionado);
            p.setNome(txtNomePet.getText());
            p.setEspecie(txtEspeciePet.getText());
            p.setDono(txtDonoPet.getText());
            p.setIdade(Integer.parseInt(txtIdadePet.getText()));

            controller.editar(p);

            Mensagem.informacao("Pet editado com sucesso");

            limpar();
            montaTabela();

        } catch (Exception e) {
            Mensagem.erro("Erro ao editar pet ");
        }
    }//GEN-LAST:event_btnEditarPetActionPerformed

    private void btnExcluirPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirPetActionPerformed
        if (idSelecionado == -1) {
            Mensagem.aviso("Selecione um pet");
            return;
        }

        if (Mensagem.confirmacao("Deseja realmente excluir?") != 0) {
            return;
        }

        try {
            controller.excluir(idSelecionado);

            Mensagem.informacao("Pet excluído com sucesso");

            limpar();
            montaTabela();

        } catch (Exception e) {
            Mensagem.erro("Erro ao excluir pet");
        }
    }//GEN-LAST:event_btnExcluirPetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarPet;
    private javax.swing.JButton btnExcluirPet;
    private javax.swing.JButton btnSalvarPet;
    private javax.swing.JLabel jLDonoPet;
    private javax.swing.JLabel jLIdadePet;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlEspeciePet;
    private javax.swing.JLabel jlNomePet;
    private javax.swing.JTable tblPet;
    private javax.swing.JTextField txtDonoPet;
    private javax.swing.JTextField txtDonoPet1;
    private javax.swing.JTextField txtDonoPet2;
    private javax.swing.JTextField txtEspeciePet;
    private javax.swing.JTextField txtIdadePet;
    private javax.swing.JTextField txtNomePet;
    // End of variables declaration//GEN-END:variables
}
