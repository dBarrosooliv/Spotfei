/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Daniel Barroso de Oliveira | Email: unfidoliveira@fei.edu.br 
 */
class Musica {
    
    private int MusicaId;
    private String titulo;
    private Artista artista; // Referência ao artista da música 
    private String album;
    
    public Musica() {
    }// Construtor Sem Parâmetro

    public Musica(String titulo, Artista artista, String album) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
    }

    public int getMusicaId() {
        return MusicaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setMusicaId(int MusicaId) {
        this.MusicaId = MusicaId;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Musica{" + "MusicaId=" + MusicaId + ", titulo=" + titulo + ", artista=" + artista + ", album=" + album + '}';
    }
    
}
