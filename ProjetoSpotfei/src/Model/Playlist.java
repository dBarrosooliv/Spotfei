/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * TESTE GERA JAVADOC
 * @author Daniel Barroso de Oliveira | Email: unfidoliveira@fei.edu.br 
 */
public class Playlist {
    
    private int playlistId;
    private String tituloPlaylist;
    private int userId;
    
    public Playlist() {
    }
    
    public Playlist(int playlistId, String tituloPlaylist, int userId) {
        this.playlistId = playlistId;
        this.tituloPlaylist = tituloPlaylist;
        this.userId = userId;
    }
    
    public int getPlaylistId() {
        return playlistId;
    }
    
    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }
    
    public String getTituloPlaylist() {
        return tituloPlaylist;
    }
    
    public void setTituloPlaylist(String tituloPlaylist) {
        this.tituloPlaylist = tituloPlaylist;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    // toString para exibição no ComboBox
    @Override
    public String toString() {
        return tituloPlaylist;
    }
}
