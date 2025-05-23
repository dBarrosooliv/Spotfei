/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ControllerMenu;
import Model.Usuario;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * TESTE GERA JAVADOC
 * @author Daniel Barroso de Oliveira | Email: unfidoliveira@fei.edu.br 
 */
public class FrameMenu extends javax.swing.JFrame {

    private final ControllerMenu controlador;
    /**
     * Creates new form FrameMenu
     */
    public FrameMenu(Usuario user) {
        initComponents();
        this.getContentPane().setBackground(Color.decode("#f0fbff"));
        controlador = new ControllerMenu(this, user);
        TxtNome.setText(user.getNome());
        controlador.ApresentaMusicasNoPainel();
    }

    public JPanel getPainelMusica() {
        return PainelMusica;
    }

    public void setPainelMusica(JPanel PainelMusica) {
        this.PainelMusica = PainelMusica;
    }

    public JTextField getInputBusca() {
        return InputBusca;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TxtOla = new javax.swing.JLabel();
        TxtNome = new javax.swing.JLabel();
        BtSair = new javax.swing.JButton();
        BtVoltaMenu = new javax.swing.JButton();
        PainelScroll = new javax.swing.JScrollPane();
        PainelMusica = new javax.swing.JPanel();
        BtBuscarMusica = new javax.swing.JButton();
        TxtMusicasParaVoce = new javax.swing.JLabel();
        InputBusca = new javax.swing.JTextField();
        BtHistorico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(218, 255, 254));

        jPanel1.setBackground(new java.awt.Color(20, 133, 209));

        TxtOla.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        TxtOla.setForeground(new java.awt.Color(218, 255, 254));
        TxtOla.setText("Olá,");

        TxtNome.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        TxtNome.setForeground(new java.awt.Color(218, 255, 254));
        TxtNome.setText("Nome");

        BtSair.setBackground(new java.awt.Color(20, 133, 209));
        BtSair.setFont(new java.awt.Font("Ebrima", 0, 20)); // NOI18N
        BtSair.setForeground(new java.awt.Color(188, 255, 254));
        BtSair.setText("Sair");
        BtSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSairActionPerformed(evt);
            }
        });

        BtVoltaMenu.setBackground(new java.awt.Color(20, 133, 209));
        BtVoltaMenu.setFont(new java.awt.Font("Ebrima", 0, 20)); // NOI18N
        BtVoltaMenu.setForeground(new java.awt.Color(188, 255, 254));
        BtVoltaMenu.setText("Seu Perfil");
        BtVoltaMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtVoltaMenu.setMargin(new java.awt.Insets(5, 14, 3, 14));
        BtVoltaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVoltaMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(TxtOla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 375, Short.MAX_VALUE)
                .addComponent(BtVoltaMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtSair)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtVoltaMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtOla)
                                .addComponent(TxtNome)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout PainelMusicaLayout = new javax.swing.GroupLayout(PainelMusica);
        PainelMusica.setLayout(PainelMusicaLayout);
        PainelMusicaLayout.setHorizontalGroup(
            PainelMusicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
        );
        PainelMusicaLayout.setVerticalGroup(
            PainelMusicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );

        PainelScroll.setViewportView(PainelMusica);

        BtBuscarMusica.setBackground(new java.awt.Color(188, 255, 254));
        BtBuscarMusica.setFont(new java.awt.Font("Ebrima", 0, 20)); // NOI18N
        BtBuscarMusica.setForeground(new java.awt.Color(20, 133, 209));
        BtBuscarMusica.setText("Buscar");
        BtBuscarMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarMusicaActionPerformed(evt);
            }
        });

        TxtMusicasParaVoce.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        TxtMusicasParaVoce.setForeground(new java.awt.Color(51, 102, 255));
        TxtMusicasParaVoce.setText("Músicas para você...");

        BtHistorico.setBackground(new java.awt.Color(188, 255, 254));
        BtHistorico.setFont(new java.awt.Font("Ebrima", 0, 20)); // NOI18N
        BtHistorico.setForeground(new java.awt.Color(20, 133, 209));
        BtHistorico.setText("Histórico");
        BtHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtHistoricoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(BtBuscarMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(InputBusca)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BtHistorico))
                        .addComponent(PainelScroll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TxtMusicasParaVoce, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtBuscarMusica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(InputBusca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtMusicasParaVoce, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSairActionPerformed
        FrameLogin login_janela = new FrameLogin();
        login_janela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtSairActionPerformed

    private void BtVoltaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtVoltaMenuActionPerformed
        FramePerfilUsuario perfil_usuario = new FramePerfilUsuario(controlador.getUser());
        perfil_usuario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtVoltaMenuActionPerformed

    private void BtHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtHistoricoActionPerformed
        controlador.ApresentaHistoricoDePesquisa(controlador.getUser());
    }//GEN-LAST:event_BtHistoricoActionPerformed

    private void BtBuscarMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarMusicaActionPerformed
        String item_pesquisa = InputBusca.getText().toLowerCase();
        controlador.BuscarMusicas(item_pesquisa,controlador.getUser());
    }//GEN-LAST:event_BtBuscarMusicaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBuscarMusica;
    private javax.swing.JButton BtHistorico;
    private javax.swing.JButton BtSair;
    private javax.swing.JButton BtVoltaMenu;
    private javax.swing.JTextField InputBusca;
    private javax.swing.JPanel PainelMusica;
    private javax.swing.JScrollPane PainelScroll;
    private javax.swing.JLabel TxtMusicasParaVoce;
    private javax.swing.JLabel TxtNome;
    private javax.swing.JLabel TxtOla;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
