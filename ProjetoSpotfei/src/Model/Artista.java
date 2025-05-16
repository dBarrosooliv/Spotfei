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
class Artista extends Pessoa {
    private String nomeartista;
    private List<Musica> musicas;
    
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

    @Override
    public String toString() {
        return "Artista{" + "nomeartista=" + nomeartista + ", musicas=" + musicas + '}';
    }
    
}
