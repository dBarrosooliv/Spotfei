/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Musica;
import Model.Artista;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * TESTE GERA JAVADOC
 * @author Daniel Barroso de Oliveira | Email: unfidoliveira@fei.edu.br 
 */
public class MenuDAO {
    
    private Connection conexao;
    
    public MenuDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    public List<Musica> consultarMusicas(){
        List<Musica> musicas = new ArrayList<>();
        String sql = "SELECT m.musicaid, m.titulo_musica, m.album, a.artistaid, a.nome_artista " +
                     "FROM musicas_cadastradas m " +
                     "JOIN artistas_cadastrados a ON m.artistaid = a.artistaid";
        
        try (java.sql.Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(sql)) {
            while (rs.next()) {
                Artista artista = new Artista();
                artista.setNomeartista(rs.getString("nome_artista"));

                Musica musica = new Musica();
                musica.setTitulo(rs.getString("titulo_musica"));
                musica.setAlbum(rs.getString("album"));
                musica.setArtista(artista);

                musicas.add(musica);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicas;
    }
    
    public void registrarPesquisa(String item_pesquisado, int userid) {
        
        if (item_pesquisado == null || item_pesquisado.trim().isEmpty()) {
            return;
        }
        
        String sql = "INSERT INTO historico_pesquisa_usuario (termo_pesquisa, userid) VALUES (?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, item_pesquisado);
            stmt.setInt(2, userid);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void curtirMusica(int userId, int musicaId) throws SQLException {
        ConexaoBD conexao = new ConexaoBD();
        Connection conn = conexao.getConnection();
        String sql = "INSERT INTO relacao_user_curtida (userid, musicaid) " +
                     "VALUES (?, ?) ON CONFLICT (userid, musicaid) DO NOTHING";
 
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, musicaId);
            stmt.executeUpdate();
        }
    }

    public void descurtirMusica(int userId, int musicaId) {
        String sql = "INSERT INTO relacao_user_descurtida (userid, musicaid) " +
                     "VALUES (?, ?) ON CONFLICT (userid, musicaid) DO NOTHING";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, musicaId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
