/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.ControllerPerfil;
import Model.Artista;
import Model.Musica;
import Model.Playlist;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 * TESTE GERA JAVADOC
 * @author Daniel Barroso de Oliveira | Email: unfidoliveira@fei.edu.br 
 */
public class PerfilDAO{
    
    private ControllerPerfil controlador;
    private Connection conexao;
    
    public PerfilDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Musica> buscarMusicasCurtidas(int userId) throws SQLException {
        List<Musica> lista = new ArrayList<>();
        String sql = 
            "SELECT m.musicaid, m.titulo_musica, m.album, m.artistaid, a.nome_artista " +
            "FROM relacao_user_curtida r " +
            "JOIN musicas_cadastradas m ON r.musicaid = m.musicaid " +
            "JOIN artistas_cadastrados a ON m.artistaid = a.artistaid " +
            "WHERE r.userid = ? " +
            "ORDER BY m.titulo_musica";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Musica m = new Musica();
                    m.setMusicaId(rs.getInt("musicaid"));
                    m.setTitulo(rs.getString("titulo_musica"));
                    m.setAlbum(rs.getString("album"));
                    Artista art = new Artista();
                    art.setArtistaid(rs.getInt("artistaid"));
                    art.setNomeartista(rs.getString("nome_artista"));
                    m.setArtista(art);
                    lista.add(m);
                }
            }
        }
        return lista;
    }
    
    public List<Musica> buscarMusicasDescurtidas(int userId) throws SQLException {
        List<Musica> lista = new ArrayList<>();
        String sql =
            "SELECT m.musicaid, m.titulo_musica, m.album, m.artistaid, a.nome_artista " +
            "FROM relacao_user_descurtida r " +
            "JOIN musicas_cadastradas m ON r.musicaid = m.musicaid " +
            "JOIN artistas_cadastrados a ON m.artistaid = a.artistaid " +
            "WHERE r.userid = ? " +
            "ORDER BY m.titulo_musica";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Musica m = new Musica();
                    m.setMusicaId(rs.getInt("musicaid"));
                    m.setTitulo(rs.getString("titulo_musica"));
                    m.setAlbum(rs.getString("album"));

                    Artista art = new Artista();
                    art.setArtistaid(rs.getInt("artistaid"));
                    art.setNomeartista(rs.getString("nome_artista"));
                    m.setArtista(art);

                    lista.add(m);
                }
            }
        }

        return lista;
    }
    
    public List<String> buscarHistoricoCuridasRemovidas(int userId) throws SQLException {
        List<String> lista = new ArrayList<>();
            String sql =
                "SELECT m.titulo_musica " +
                "FROM historico_descurtida h " +
                "JOIN musicas_cadastradas m ON h.musicaid = m.musicaid " +
                "WHERE h.userid = ? " +
                "ORDER BY h.id_descurtida DESC " +
                "LIMIT 10";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        lista.add(rs.getString("titulo_musica"));
                    }
            }
        }
    return lista;
    }
    
    public void removerCurtidaColarHistorico(int userId, int musicaId) throws SQLException {
            
        conexao.setAutoCommit(false);
        try {
            String sqlDel = 
                "DELETE FROM relacao_user_curtida WHERE userid = ? AND musicaid = ?";
            try (PreparedStatement p = conexao.prepareStatement(sqlDel)) {
                p.setInt(1, userId);
                p.setInt(2, musicaId);
                p.executeUpdate();
            }

            String sqlIns = 
                "INSERT INTO historico_descurtida (userid, musicaid) VALUES (?, ?)";
            try (PreparedStatement p = conexao.prepareStatement(sqlIns)) {
                p.setInt(1, userId);
                p.setInt(2, musicaId);
                p.executeUpdate();
            }

            conexao.commit();
        } catch (SQLException e) {
            conexao.rollback();
            throw e;
        } finally {

            conexao.setAutoCommit(true);
        }
    }
    
    public void removerDescurtida(int userId, int musicaId) throws SQLException {
        String sql = "DELETE FROM relacao_user_descurtida WHERE userid = ? AND musicaid = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, musicaId);
            stmt.executeUpdate();
        }
    }
    
    
    //METODOS PARA PLAYLISTS

    public List<Playlist> buscarPlaylistsDoUsuario(int userId) throws SQLException {
        List<Playlist> playlists = new ArrayList<>();
        String sql = "SELECT playlistid, titulo_playlist FROM playlist WHERE userid = ? ORDER BY titulo_playlist";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Playlist playlist = new Playlist();
                    playlist.setPlaylistId(rs.getInt("playlistid"));
                    playlist.setTituloPlaylist(rs.getString("titulo_playlist"));
                    playlist.setUserId(userId);
                    playlists.add(playlist);
                }
            }
        }
        return playlists;
    }

    public void criarNovaPlaylist(String tituloPlaylist, int userId) throws SQLException {
        if (tituloPlaylist == null || tituloPlaylist.trim().isEmpty()) {
            throw new IllegalArgumentException("Título da playlist não pode estar vazio");
        }

        String sql = "INSERT INTO playlist (titulo_playlist, userid) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, tituloPlaylist.trim());
            stmt.setInt(2, userId);
            stmt.executeUpdate();
        }
    }

    public void adicionarMusicaNaPlaylist(int playlistId, int musicaId) throws SQLException {
        String sql = "INSERT INTO relacao_playlist_musica (playlistid, musicaid) " +
                     "VALUES (?, ?) ON CONFLICT (playlistid, musicaid) DO NOTHING";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, playlistId);
            stmt.setInt(2, musicaId);
            stmt.executeUpdate();
        }
    }

    public List<Musica> buscarMusicasDaPlaylist(int playlistId) throws SQLException {
        List<Musica> musicas = new ArrayList<>();
        String sql = 
            "SELECT m.musicaid, m.titulo_musica, m.album, m.artistaid, a.nome_artista " +
            "FROM relacao_playlist_musica r " +
            "JOIN musicas_cadastradas m ON r.musicaid = m.musicaid " +
            "JOIN artistas_cadastrados a ON m.artistaid = a.artistaid " +
            "WHERE r.playlistid = ? " +
            "ORDER BY m.titulo_musica";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, playlistId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Musica m = new Musica();
                    m.setMusicaId(rs.getInt("musicaid"));
                    m.setTitulo(rs.getString("titulo_musica"));
                    m.setAlbum(rs.getString("album"));

                    Artista artista = new Artista();
                    artista.setArtistaid(rs.getInt("artistaid"));
                    artista.setNomeartista(rs.getString("nome_artista"));
                    m.setArtista(artista);

                    musicas.add(m);
                }
            }
        }
        return musicas;
    }

    public void removerMusicaDaPlaylist(int playlistId, int musicaId) throws SQLException {
        String sql = "DELETE FROM relacao_playlist_musica WHERE playlistid = ? AND musicaid = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, playlistId);
            stmt.setInt(2, musicaId);
            stmt.executeUpdate();
        }
    }

    public void excluirPlaylist(int playlistId) throws SQLException {
        conexao.setAutoCommit(false);
        try {
            // Primeiro remove todas as músicas da playlist
            String sqlMusicas = "DELETE FROM relacao_playlist_musica WHERE playlistid = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sqlMusicas)) {
                stmt.setInt(1, playlistId);
                stmt.executeUpdate();
            }

            // Depois remove a playlist
            String sqlPlaylist = "DELETE FROM playlist WHERE playlistid = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sqlPlaylist)) {
                stmt.setInt(1, playlistId);
                stmt.executeUpdate();
            }

            conexao.commit();
        } catch (SQLException e) {
            conexao.rollback();
            throw e;
        } finally {
            conexao.setAutoCommit(true);
        }
    }
}
