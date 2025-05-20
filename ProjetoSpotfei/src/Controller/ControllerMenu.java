/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Usuario;
import DAO.MenuDAO;
import DAO.ConexaoBD;
import Model.Artista;
import Model.Musica;
import View.FrameMenu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Daniel Barroso de Oliveira | Email: unfidoliveira@fei.edu.br 
 */
public class ControllerMenu {
    
    private final FrameMenu view;
    private final Usuario user;
    
    public ControllerMenu(FrameMenu view, Usuario user){
        this.view = view;
        this.user = user;
    }

    public Usuario getUser() {
        return user;
    }
    
    public List<Musica> ListarMusicas() {
        List<Musica> musicas = new ArrayList<>(); 

        try {
            ConexaoBD conexao = new ConexaoBD();
            Connection conn = conexao.getConnection();
            MenuDAO dao = new MenuDAO(conn);
            musicas = dao.consultarMusicas(); 
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }

        return musicas;
    }
    
    public List<String> buscarHistorico(int userId) {
        ConexaoBD conexao = new ConexaoBD();
        List<String> pesquisas = new ArrayList<>();
        String sql = "SELECT termo_pesquisa FROM historico_pesquisa_usuario " +
                     "WHERE userid = ? " +
                     "ORDER BY id_pesquisa DESC LIMIT 10";

        try {
            Connection conn = conexao.getConnection(); 
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, userId);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    pesquisas.add(rs.getString("termo_pesquisa"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pesquisas;
    }
    
    public void ApresentaMusicasNoPainel() {
        
        JPanel PainelMusica = view.getPainelMusica();
        PainelMusica.removeAll();
        PainelMusica.setLayout(new BoxLayout(PainelMusica, BoxLayout.Y_AXIS));

        List<Musica> lista = ListarMusicas();

        for (Musica m : lista) {
            JPanel painelItem = new JPanel(new BorderLayout());
            painelItem.setBackground(new Color(204, 204, 255));
            painelItem.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

            // Painel de textos 
            JPanel painelEsquerda = new JPanel();
            painelEsquerda.setLayout(new BoxLayout(painelEsquerda, BoxLayout.Y_AXIS));
            painelEsquerda.setBackground(new Color(204, 204, 255));

            JLabel lblTitulo = new JLabel(m.getTitulo());
            lblTitulo.setForeground(new Color(0, 80, 122));
            lblTitulo.setFont(new Font("Ebrima", Font.PLAIN, 20));

            JLabel lblAlbum = new JLabel("Álbum: " + m.getAlbum());
            lblAlbum.setFont(new Font("Ebrima", Font.PLAIN, 18));

            JLabel lblArtista = new JLabel("Artista: " + m.getArtista());
            lblArtista.setFont(new Font("Ebrima", Font.PLAIN, 18));

            painelEsquerda.add(lblTitulo);
            painelEsquerda.add(lblAlbum);
            painelEsquerda.add(lblArtista);

            // Painel de botões 
            JPanel painelDireita = new JPanel();
            painelDireita.setLayout(new BoxLayout(painelDireita, BoxLayout.Y_AXIS));
            painelDireita.setBackground(new Color(204, 204, 255));
            painelDireita.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0)); // espaçamento esquerdo

            JButton btnDescurtir = new JButton("Descurtir");
            JButton btnCurtir = new JButton("Curtir");
            JButton btnAddPlaylist = new JButton("+ Playlist");
            JComboBox<String> comboPlaylists = new JComboBox<>();
            comboPlaylists.addItem("Playlist 1");
            comboPlaylists.addItem("Playlist 2");
            
            painelDireita.add(btnCurtir);
            painelDireita.add(Box.createVerticalStrut(5));
            painelDireita.add(btnDescurtir);
            painelDireita.add(Box.createVerticalStrut(5));
            painelDireita.add(btnAddPlaylist);
            painelDireita.add(Box.createVerticalStrut(5));
            painelDireita.add(comboPlaylists);

            painelItem.add(painelEsquerda, BorderLayout.WEST);
            painelItem.add(painelDireita, BorderLayout.EAST);

            PainelMusica.add(painelItem);
        }

        PainelMusica.revalidate();
        PainelMusica.repaint();
    }

    public void BuscarMusicas(String item, Usuario user){
        
        try {
            ConexaoBD conexao = new ConexaoBD();
            Connection conn = conexao.getConnection();
            MenuDAO dao = new MenuDAO(conn);
            dao.registrarPesquisa(item,user.getUserid()); 
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
        
        JPanel PainelMusica = view.getPainelMusica();
        PainelMusica.removeAll();
        PainelMusica.setLayout(new BoxLayout(PainelMusica, BoxLayout.Y_AXIS));

        List<Musica> lista = ListarMusicas();
        boolean encontrou = false;

        for (Musica m : lista) {
            Artista artista = m.getArtista();
            if (m.getTitulo().toLowerCase().contains(item) || 
                m.getAlbum().toLowerCase().contains(item) || 
                artista.getNomeartista().toLowerCase().contains(item)) {

                JPanel painelItem = new JPanel(new BorderLayout());
                painelItem.setBackground(new Color(204, 204, 255));
                painelItem.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

                // Painel de textos 
                JPanel painelEsquerda = new JPanel();
                painelEsquerda.setLayout(new BoxLayout(painelEsquerda, BoxLayout.Y_AXIS));
                painelEsquerda.setBackground(new Color(204, 204, 255));

                JLabel lblTitulo = new JLabel(m.getTitulo());
                lblTitulo.setForeground(new Color(0, 80, 122));
                lblTitulo.setFont(new Font("Ebrima", Font.PLAIN, 20));

                JLabel lblAlbum = new JLabel("Álbum: " + m.getAlbum());
                lblAlbum.setFont(new Font("Ebrima", Font.PLAIN, 18));

                JLabel lblArtista = new JLabel("Artista: " + m.getArtista());
                lblArtista.setFont(new Font("Ebrima", Font.PLAIN, 18));

                painelEsquerda.add(lblTitulo);
                painelEsquerda.add(lblAlbum);
                painelEsquerda.add(lblArtista);

                // Botões
                JPanel painelDireita = new JPanel();
                painelDireita.setLayout(new BoxLayout(painelDireita, BoxLayout.Y_AXIS));
                painelDireita.setBackground(new Color(204, 204, 255));
                painelDireita.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));

                JButton btnCurtir = new JButton("Curtir");
                JButton btnDescurtir = new JButton("Descurtir");
                JButton btnAddPlaylist = new JButton("+ Playlist");
                JComboBox<String> comboPlaylists = new JComboBox<>();
                comboPlaylists.setMaximumSize(new Dimension(200, 30));
                comboPlaylists.addItem("Playlist 1");
                comboPlaylists.addItem("Playlist 2");

                painelDireita.add(btnCurtir);
                painelDireita.add(Box.createVerticalStrut(5));
                painelDireita.add(btnDescurtir);
                painelDireita.add(Box.createVerticalStrut(5));
                painelDireita.add(btnAddPlaylist);
                painelDireita.add(Box.createVerticalStrut(5));
                painelDireita.add(comboPlaylists);

                painelItem.add(painelEsquerda, BorderLayout.WEST);
                painelItem.add(painelDireita, BorderLayout.EAST);

                PainelMusica.add(painelItem);
                encontrou = true;
            }
        }

        if (!encontrou) {
            JPanel painelItem = new JPanel(new BorderLayout());
            painelItem.setBackground(new Color(204, 204, 255));
            painelItem.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            JLabel lblNada = new JLabel("Nada encontrado :(");
            lblNada.setFont(new Font("Ebrima", Font.PLAIN, 20));
            lblNada.setForeground(Color.DARK_GRAY);
            lblNada.setHorizontalAlignment(SwingConstants.CENTER);

            painelItem.add(lblNada, BorderLayout.CENTER);
            PainelMusica.add(painelItem);
        }

        PainelMusica.revalidate();
        PainelMusica.repaint();
    }
    
    public void ApresentaHistoricoDePesquisa(Usuario user) {
        JPanel PainelMusica = view.getPainelMusica();
        PainelMusica.removeAll();
        PainelMusica.setLayout(new BoxLayout(PainelMusica, BoxLayout.Y_AXIS));
        PainelMusica.setBackground(new Color(204, 204, 255));

        List<String> historico = buscarHistorico(user.getUserid());

        if (historico.isEmpty()) {
            JLabel lblNada = new JLabel("Nenhuma pesquisa recente.");
            lblNada.setFont(new Font("Ebrima", Font.PLAIN, 18));
            lblNada.setForeground(Color.DARK_GRAY);
            lblNada.setAlignmentX(Component.CENTER_ALIGNMENT);
            PainelMusica.add(lblNada);
        } else {
            for (String termo : historico) {
                JPanel item = new JPanel();
                item.setBackground(new Color(204, 204, 255));
                item.setLayout(new FlowLayout(FlowLayout.LEFT));

                JLabel lblTermo = new JLabel("> " + termo);
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
