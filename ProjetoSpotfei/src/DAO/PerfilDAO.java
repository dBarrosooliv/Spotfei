/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.ControllerPerfil;
import Model.Artista;
import Model.Musica;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
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
}
