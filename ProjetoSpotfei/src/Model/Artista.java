/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Barroso de Oliveira | Email: unfidoliveira@fei.edu.br 
 */
public class Artista extends Pessoa {
    private int artistaid;
    private String nomeartista;
    private List<Musica> musicas;
    
    public Artista(){//Construtor vazio
    }
    
    public Artista(String nomeartista, List musicas) {
        super(nomeartista);
        this.nomeartista = nomeartista;
        this.musicas = new ArrayList<>();
    }

    public String getNomeartista() {
        return nomeartista;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setNomeartista(String nomeartista) {
        this.nomeartista = nomeartista;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    public void setArtistaid(int artistaid) {
        this.artistaid = artistaid;
    }

    public int getArtistaid() {
        return artistaid;
    }

    @Override
    public String toString() {
        return nomeartista != null ? nomeartista : "Artista sem nome";
    }
    
}
