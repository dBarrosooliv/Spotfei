/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.ConexaoBD;
import DAO.PerfilDAO;
import Model.Musica;
import Model.Usuario;
import View.FramePerfilUsuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Daniel Barroso de Oliveira | Email: unfidoliveira@fei.edu.br 
 */
public class ControllerPerfil {
        
    private final FramePerfilUsuario view;
    private final Usuario user;
    
    public ControllerPerfil(FramePerfilUsuario view, Usuario user){
        this.view = view;
        this.user = user;
    }

    public Usuario getUser() {
        return user;
    }
    
    public void ApresentaCurtidasNoPainel(JPanel PainelMusica, Usuario user) {
        
        PainelMusica.removeAll();
        PainelMusica.setLayout(new BoxLayout(PainelMusica, BoxLayout.Y_AXIS));
        PainelMusica.setBackground(new Color(204, 204, 255));

        List<Musica> lista = Collections.emptyList();
        try { 
            ConexaoBD conexao = new ConexaoBD();
            PerfilDAO dao = new PerfilDAO(conexao.getConnection());
            lista = dao.buscarMusicasCurtidas(user.getUserid());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (lista.isEmpty()) {
            JLabel lblNada = new JLabel("Você ainda não curtiu nenhuma música.");
            lblNada.setFont(new Font("Ebrima", Font.PLAIN, 18));
            lblNada.setForeground(Color.DARK_GRAY);
            lblNada.setAlignmentX(Component.CENTER_ALIGNMENT);
            PainelMusica.add(lblNada);

        } else {

            for (Musica m : lista) {
                JPanel painelItem = new JPanel(new BorderLayout());
                painelItem.setBackground(new Color(204, 204, 255));
                painelItem.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

                JPanel painelEsquerda = new JPanel();
                painelEsquerda.setLayout(new BoxLayout(painelEsquerda, BoxLayout.Y_AXIS));
                painelEsquerda.setBackground(new Color(204, 204, 255));

                JLabel lblTitulo  = new JLabel(m.getTitulo());
                lblTitulo.setForeground(new Color(0, 80, 122));
                lblTitulo.setFont(new Font("Ebrima", Font.PLAIN, 20));

                JLabel lblAlbum   = new JLabel("Álbum: "   + m.getAlbum());
                lblAlbum.setFont(new Font("Ebrima", Font.PLAIN, 18));

                JLabel lblArtista = new JLabel("Artista: " + m.getArtista().getNomeartista());
                lblArtista.setFont(new Font("Ebrima", Font.PLAIN, 18));

                painelEsquerda.add(lblTitulo);
                painelEsquerda.add(lblAlbum);
                painelEsquerda.add(lblArtista);

                JPanel painelDireita = new JPanel();
                painelDireita.setLayout(new BoxLayout(painelDireita, BoxLayout.Y_AXIS));
                painelDireita.setBackground(new Color(204, 204, 255));
                painelDireita.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));

                JButton btnRemover = new JButton("X");
                btnRemover.addActionListener(e -> {
                    removerCurtidaX(m.getMusicaId());
                });
                painelDireita.add(btnRemover);
                
                painelItem.add(painelEsquerda, BorderLayout.WEST);
                painelItem.add(painelDireita, BorderLayout.EAST);
                PainelMusica.add(painelItem);
            }
        }

        PainelMusica.revalidate();
        PainelMusica.repaint();
    }
    
    public void ApresentaDescurtidasNoPainel(JPanel PainelMusica, Usuario user) {
        
        PainelMusica.removeAll();
        PainelMusica.setLayout(new BoxLayout(PainelMusica, BoxLayout.Y_AXIS));
        PainelMusica.setBackground(new Color(204, 204, 255));

        List<Musica> lista = Collections.emptyList();
        try {
            ConexaoBD conexao = new ConexaoBD();
            PerfilDAO dao = new PerfilDAO(conexao.getConnection());
            lista = dao.buscarMusicasDescurtidas(user.getUserid());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (lista.isEmpty()) {
            JLabel lblNada = new JLabel("Você ainda não curtiu nenhuma música.");
            lblNada.setFont(new Font("Ebrima", Font.PLAIN, 18));
            lblNada.setForeground(Color.DARK_GRAY);
            lblNada.setAlignmentX(Component.CENTER_ALIGNMENT);
            PainelMusica.add(lblNada);

        } else {

            for (Musica m : lista) {
                JPanel painelItem = new JPanel(new BorderLayout());
                painelItem.setBackground(new Color(204, 204, 255));
                painelItem.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

                JPanel painelEsquerda = new JPanel();
                painelEsquerda.setLayout(new BoxLayout(painelEsquerda, BoxLayout.Y_AXIS));
                painelEsquerda.setBackground(new Color(204, 204, 255));

                JLabel lblTitulo  = new JLabel(m.getTitulo());
                lblTitulo.setForeground(new Color(0, 80, 122));
                lblTitulo.setFont(new Font("Ebrima", Font.PLAIN, 20));

                JLabel lblAlbum   = new JLabel("Álbum: "   + m.getAlbum());
                lblAlbum.setFont(new Font("Ebrima", Font.PLAIN, 18));

                JLabel lblArtista = new JLabel("Artista: " + m.getArtista().getNomeartista());
                lblArtista.setFont(new Font("Ebrima", Font.PLAIN, 18));

                painelEsquerda.add(lblTitulo);
                painelEsquerda.add(lblAlbum);
                painelEsquerda.add(lblArtista);

                JPanel painelDireita = new JPanel();
                painelDireita.setLayout(new BoxLayout(painelDireita, BoxLayout.Y_AXIS));
                painelDireita.setBackground(new Color(204, 204, 255));
                painelDireita.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));

                JButton btnRemover = new JButton("X");

                btnRemover.addActionListener(e -> {
                     removerDescurtidaX(m.getMusicaId());
                });
                painelDireita.add(btnRemover);

                painelItem.add(painelEsquerda, BorderLayout.WEST);
                painelItem.add(painelDireita, BorderLayout.EAST);
                PainelMusica.add(painelItem);
                
            }
        }

        PainelMusica.revalidate();
        PainelMusica.repaint();
    }
    
    public void removerCurtidaX(int musicaId) {
        try {
            PerfilDAO dao = new PerfilDAO(new ConexaoBD().getConnection());
            dao.removerCurtidaColarHistorico(user.getUserid(), musicaId);
            ApresentaCurtidasNoPainel(view.getPainelMusica(), user);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Erro ao remover curtida.");
        }
    }
    
    public void removerDescurtidaX(int musicaId) {//Escolhi apenas remover esses , sem adicionar no histórico
        try {
            PerfilDAO dao = new PerfilDAO(new ConexaoBD().getConnection());
            dao.removerDescurtida(user.getUserid(), musicaId);
            ApresentaDescurtidasNoPainel(view.getPainelMusica(), user);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Erro ao remover descurtida.");
        }
    }
    
    public void ApresentaHistoricoRemovidas(Usuario user) {
        JPanel PainelMusica = view.getPainelMusica();
        PainelMusica.removeAll();
        PainelMusica.setLayout(new BoxLayout(PainelMusica, BoxLayout.Y_AXIS));
        PainelMusica.setBackground(new Color(204, 204, 255));

        // Busca os títulos das músicas descurtidas
        List<String> historico = Collections.emptyList();
        try {
            ConexaoBD conexao = new ConexaoBD();
            PerfilDAO dao = new PerfilDAO(conexao.getConnection());
            // você vai criar este método no DAO:
            historico = dao.buscarHistoricoCuridasRemovidas(user.getUserid());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (historico.isEmpty()) {
            JLabel lblNada = new JLabel("Nenhuma descurtida recente.");
            lblNada.setFont(new Font("Ebrima", Font.PLAIN, 18));
            lblNada.setForeground(Color.DARK_GRAY);
            lblNada.setAlignmentX(Component.CENTER_ALIGNMENT);
            PainelMusica.add(lblNada);
        } else {
            for (String titulo : historico) {
                JPanel item = new JPanel(new FlowLayout(FlowLayout.LEFT));
                item.setBackground(new Color(204, 204, 255));

                JLabel lblTermo = new JLabel("> " + titulo);
                lblTermo.setFont(new Font("Ebrima", Font.PLAIN, 18));
                lblTermo.setForeground(new Color(0, 80, 122));

                item.add(lblTermo);
                PainelMusica.add(item);
            }
        }

        PainelMusica.revalidate();
        PainelMusica.repaint();
    }
}
