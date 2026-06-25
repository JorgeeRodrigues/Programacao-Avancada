package views;

public class TelaPrincipal extends javax.swing.JFrame {

    private javax.swing.JDesktopPane desktop;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaPrincipal.class.getName());

    public TelaPrincipal() {
        initComponents();
        desktop = new javax.swing.JDesktopPane();
        setContentPane(desktop);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelTelaPrincipal = new javax.swing.JPanel();
        MenuTelaPrincipal = new javax.swing.JMenuBar();
        MenuClientes = new javax.swing.JMenu();
        MenuCadastroClientes = new javax.swing.JMenuItem();
        MenuPets = new javax.swing.JMenu();
        MenuCadastroPets = new javax.swing.JMenuItem();
        MenuAgendamentos = new javax.swing.JMenu();
        MenuCadastroAgendamentos = new javax.swing.JMenuItem();
        RelatoriosAgendamentos = new javax.swing.JCheckBoxMenuItem();
        MenuServicos = new javax.swing.JMenu();
        MenuCadastroServicos = new javax.swing.JMenuItem();
        MenuFuncionarios = new javax.swing.JMenu();
        MenuCadastroFuncionarios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout PainelTelaPrincipalLayout = new javax.swing.GroupLayout(PainelTelaPrincipal);
        PainelTelaPrincipal.setLayout(PainelTelaPrincipalLayout);
        PainelTelaPrincipalLayout.setHorizontalGroup(
            PainelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );
        PainelTelaPrincipalLayout.setVerticalGroup(
            PainelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );

        MenuClientes.setText("Clientes");

        MenuCadastroClientes.setText("Cadastrar");
        MenuCadastroClientes.addActionListener(this::MenuCadastroClientesActionPerformed);
        MenuClientes.add(MenuCadastroClientes);

        MenuTelaPrincipal.add(MenuClientes);

        MenuPets.setText("Pets");

        MenuCadastroPets.setText("Cadastrar");
        MenuCadastroPets.addActionListener(this::MenuCadastroPetsActionPerformed);
        MenuPets.add(MenuCadastroPets);

        MenuTelaPrincipal.add(MenuPets);

        MenuAgendamentos.setText("Agendamentos");
        MenuAgendamentos.addActionListener(this::MenuAgendamentosActionPerformed);

        MenuCadastroAgendamentos.setText("Cadastrar");
        MenuCadastroAgendamentos.addActionListener(this::MenuCadastroAgendamentosActionPerformed);
        MenuAgendamentos.add(MenuCadastroAgendamentos);

        RelatoriosAgendamentos.setSelected(true);
        RelatoriosAgendamentos.setText("Relatorios");
        RelatoriosAgendamentos.addActionListener(this::RelatoriosAgendamentosActionPerformed);
        MenuAgendamentos.add(RelatoriosAgendamentos);

        MenuTelaPrincipal.add(MenuAgendamentos);

        MenuServicos.setText("Serviços");

        MenuCadastroServicos.setText("Cadastrar");
        MenuCadastroServicos.addActionListener(this::MenuCadastroServicosActionPerformed);
        MenuServicos.add(MenuCadastroServicos);

        MenuTelaPrincipal.add(MenuServicos);

        MenuFuncionarios.setText("Funcionarios");

        MenuCadastroFuncionarios.setText("Cadastrar");
        MenuCadastroFuncionarios.addActionListener(this::MenuCadastroFuncionariosActionPerformed);
        MenuFuncionarios.add(MenuCadastroFuncionarios);

        MenuTelaPrincipal.add(MenuFuncionarios);

        setJMenuBar(MenuTelaPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelTelaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelTelaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuCadastroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroClientesActionPerformed
        TelaCliente tc = new TelaCliente();
        tc.setVisible(true);
    }//GEN-LAST:event_MenuCadastroClientesActionPerformed

    private void MenuCadastroPetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroPetsActionPerformed
        TelaPet tpet = new TelaPet();
        tpet.setVisible(true);
    }//GEN-LAST:event_MenuCadastroPetsActionPerformed

    private void MenuCadastroAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroAgendamentosActionPerformed
        TelaAgendamento ta = new TelaAgendamento();
        ta.setVisible(true);
    }//GEN-LAST:event_MenuCadastroAgendamentosActionPerformed

    private void MenuCadastroServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroServicosActionPerformed
        TelaServico ts = new TelaServico();
        ts.setVisible(true);
    }//GEN-LAST:event_MenuCadastroServicosActionPerformed

    private void MenuCadastroFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroFuncionariosActionPerformed
        TelaFuncionario tf = new TelaFuncionario();
    tf.setVisible(true);
    }//GEN-LAST:event_MenuCadastroFuncionariosActionPerformed

    private void MenuAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAgendamentosActionPerformed

    }//GEN-LAST:event_MenuAgendamentosActionPerformed

    private void RelatoriosAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatoriosAgendamentosActionPerformed
        TelaRelatorio tela = new TelaRelatorio();

        desktop.add(tela);
        tela.setVisible(true);
        tela.toFront();
    }//GEN-LAST:event_RelatoriosAgendamentosActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAgendamentos;
    private javax.swing.JMenuItem MenuCadastroAgendamentos;
    private javax.swing.JMenuItem MenuCadastroClientes;
    private javax.swing.JMenuItem MenuCadastroFuncionarios;
    private javax.swing.JMenuItem MenuCadastroPets;
    private javax.swing.JMenuItem MenuCadastroServicos;
    private javax.swing.JMenu MenuClientes;
    private javax.swing.JMenu MenuFuncionarios;
    private javax.swing.JMenu MenuPets;
    private javax.swing.JMenu MenuServicos;
    private javax.swing.JMenuBar MenuTelaPrincipal;
    private javax.swing.JPanel PainelTelaPrincipal;
    private javax.swing.JCheckBoxMenuItem RelatoriosAgendamentos;
    // End of variables declaration//GEN-END:variables
}
