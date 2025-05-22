/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.ConexaoBD;
import DAO.PerfilDAO;
import Model.Musica;
import Model.Playlist;
import Model.Usuario;
import View.FramePerfilUsuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Controlador exclusivo para funcion
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
    
    
    // METODOS DA PLAYLIST
    public void recebePlaylist(String titulo) {
        try {
            ConexaoBD conexao = new ConexaoBD();
            java.sql.Connection conn = conexao.getConnection(); 
            PerfilDAO dao = new PerfilDAO(conn);
            dao.criarNovaPlaylist(titulo, user.getUserid());
            JOptionPane.showMessageDialog(view, "Playlist '" + titulo + "' criada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Erro ao criar playlist.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
    
    public void caixaCriaPlaylist() {
        String titulo = JOptionPane.showInputDialog(view, 
            "Digite o nome da nova playlist:", 
            "Nova Playlist", 
            JOptionPane.PLAIN_MESSAGE);
        
        if (titulo != null && !titulo.trim().isEmpty()) {
            recebePlaylist(titulo);
            
            ApresentaMinhasPlaylists(user);
        }
    }
    
    public List<Playlist> buscarPlaylistsDoUsuario() {
        List<Playlist> playlists = new ArrayList<>();
        try {
            ConexaoBD conexao = new ConexaoBD(); 
            Connection conn = conexao.getConnection();
            PerfilDAO dao = new PerfilDAO(conn);
            playlists = dao.buscarPlaylistsDoUsuario(user.getUserid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playlists;
    }
    
    public void adicionarMusicaNaPlaylist(int playlistId, int musicaId) {
        try {
            ConexaoBD conexao = new ConexaoBD();
            Connection conn = conexao.getConnection();
            PerfilDAO dao = new PerfilDAO(conn);
            dao.adicionarMusicaNaPlaylist(playlistId, musicaId);
            JOptionPane.showMessageDialog(view, "Música adicionada à playlist com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Erro ao adicionar música à playlist.");
        }
    }
    
    public JComboBox<Playlist> criarComboBoxPlaylists() {
        JComboBox<Playlist> combo = new JComboBox<>();
        List<Playlist> playlists = buscarPlaylistsDoUsuario();

        for (Playlist playlist : playlists) {
            combo.addItem(playlist);
        }

        // Define como será exibido no combo
        combo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, 
                    int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Playlist) {
                    setText(((Playlist) value).getTituloPlaylist());
                }
                return this;
            }
        });

        return combo;
    }
    
    public void ApresentaMinhasPlaylists(Usuario user) {
        JPanel PainelMusica = view.getPainelMusica();
        PainelMusica.removeAll();
        PainelMusica.setLayout(new BoxLayout(PainelMusica, BoxLayout.Y_AXIS));
        PainelMusica.setBackground(new Color(204, 204, 255));

        List<Playlist> playlists = Collections.emptyList();
        try {
            ConexaoBD conexao = new ConexaoBD();
            PerfilDAO dao = new PerfilDAO(conexao.getConnection());
            playlists = dao.buscarPlaylistsDoUsuario(user.getUserid());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (playlists.isEmpty()) {
            JLabel lblNada = new JLabel("Você ainda não criou nenhuma playlist.");
            lblNada.setFont(new Font("Ebrima", Font.PLAIN, 18));
            lblNada.setForeground(Color.DARK_GRAY);
            lblNada.setAlignmentX(Component.CENTER_ALIGNMENT);
            PainelMusica.add(lblNada);
        } else {
            for (Playlist playlist : playlists) {
                JPanel painelItem = new JPanel(new BorderLayout());
                painelItem.setBackground(new Color(204, 204, 255));
                painelItem.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

                JPanel painelEsquerda = new JPanel();
                painelEsquerda.setLayout(new BoxLayout(painelEsquerda, BoxLayout.Y_AXIS));
                painelEsquerda.setBackground(new Color(204, 204, 255));

                JLabel lblTitulo = new JLabel(playlist.getTituloPlaylist());
                lblTitulo.setForeground(new Color(0, 80, 122));
                lblTitulo.setFont(new Font("Ebrima", Font.PLAIN, 20));

                // Contar quantas músicas tem na playlist

                painelEsquerda.add(lblTitulo);

                JPanel painelDireita = new JPanel();
                painelDireita.setLayout(new BoxLayout(painelDireita, BoxLayout.Y_AXIS));
                painelDireita.setBackground(new Color(204, 204, 255));
                painelDireita.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));

                JButton btnVer = new JButton("Ver Músicas");
                JButton btnExcluir = new JButton("Excluir");
                btnExcluir.setBackground(new Color(255, 100, 100));
                btnExcluir.setForeground(Color.WHITE);

                btnVer.addActionListener(e -> {
                    ApresentaMusicasNaPlaylist(playlist);
                });

                btnExcluir.addActionListener(e -> {
                    int resposta = JOptionPane.showConfirmDialog(view,
                        "Tem certeza que deseja excluir a playlist '" + playlist.getTituloPlaylist() + "'?",
                        "Confirmar Exclusão",
                        JOptionPane.YES_NO_OPTION);

                    if (resposta == JOptionPane.YES_OPTION) {
                        excluirPlaylist(playlist.getPlaylistId());
                    }
                });

                painelDireita.add(btnVer);
                painelDireita.add(Box.createVerticalStrut(5));
                painelDireita.add(btnExcluir);

                painelItem.add(painelEsquerda, BorderLayout.WEST);
                painelItem.add(painelDireita, BorderLayout.EAST);
                PainelMusica.add(painelItem);
            }
        }

        PainelMusica.revalidate();
        PainelMusica.repaint();
    }

    
    public void ApresentaMusicasNaPlaylist(Playlist playlist) {
        JPanel PainelMusica = view.getPainelMusica();
        PainelMusica.removeAll();
        PainelMusica.setLayout(new BoxLayout(PainelMusica, BoxLayout.Y_AXIS));
        PainelMusica.setBackground(new Color(204, 204, 255));

        // Cabeçalho da playlist
        JPanel painelCabecalho = new JPanel(new BorderLayout());
        painelCabecalho.setBackground(new Color(204, 204, 255));
        painelCabecalho.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel lblTituloPlaylist = new JLabel(playlist.getTituloPlaylist());
        lblTituloPlaylist.setFont(new Font("Ebrima", Font.BOLD, 22));
        lblTituloPlaylist.setForeground(new Color(0, 80, 122));

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> ApresentaMinhasPlaylists(user));

        painelCabecalho.add(lblTituloPlaylist, BorderLayout.WEST);
        painelCabecalho.add(btnVoltar, BorderLayout.EAST);
        PainelMusica.add(painelCabecalho);

        // Músicas da playlist
        List<Musica> musicas = Collections.emptyList();
        try {
            ConexaoBD conexao = new ConexaoBD();
            PerfilDAO dao = new PerfilDAO(conexao.getConnection());
            musicas = dao.buscarMusicasDaPlaylist(playlist.getPlaylistId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (musicas.isEmpty()) {
            JLabel lblVazia = new JLabel("Esta playlist está vazia.");
            lblVazia.setFont(new Font("Ebrima", Font.PLAIN, 18));
            lblVazia.setForeground(Color.GRAY);
            lblVazia.setAlignmentX(Component.CENTER_ALIGNMENT);
            PainelMusica.add(lblVazia);
        } else {
            for (Musica m : musicas) {
                JPanel painelItem = new JPanel(new BorderLayout());
                painelItem.setBackground(new Color(204, 204, 255));
                painelItem.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

                JPanel painelEsquerda = new JPanel();
                painelEsquerda.setLayout(new BoxLayout(painelEsquerda, BoxLayout.Y_AXIS));
                painelEsquerda.setBackground(new Color(204, 204, 255));

                JLabel lblTitulo = new JLabel(m.getTitulo());
                lblTitulo.setForeground(new Color(0, 80, 122));
                lblTitulo.setFont(new Font("Ebrima", Font.PLAIN, 20));

                JLabel lblAlbum = new JLabel("Álbum: " + m.getAlbum());
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

                JButton btnRemover = new JButton("Remover");
                btnRemover.addActionListener(e -> {
                    removerMusicaDaPlaylist(playlist.getPlaylistId(), m.getMusicaId(), playlist);
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
    
    private void excluirPlaylist(int playlistId) {
        try {
            ConexaoBD conexao = new ConexaoBD();
            PerfilDAO dao = new PerfilDAO(conexao.getConnection());
            dao.excluirPlaylist(playlistId);
            JOptionPane.showMessageDialog(view, "Playlist excluída com sucesso!");
            ApresentaMinhasPlaylists(user);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Erro ao excluir playlist.");
        }
    }

    private void removerMusicaDaPlaylist(int playlistId, int musicaId, Playlist playlist) {
        try {
            ConexaoBD conexao = new ConexaoBD();
            PerfilDAO dao = new PerfilDAO(conexao.getConnection());
            dao.removerMusicaDaPlaylist(playlistId, musicaId);
            JOptionPane.showMessageDialog(view, "Música removida da playlist!");
            ApresentaMusicasNaPlaylist(playlist); // Atualiza a tela
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Erro ao remover música da playlist.");
        }
    }
}
