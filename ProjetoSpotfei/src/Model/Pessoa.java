/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Daniel Barroso de Oliveira | Email: unfidoliveira@fei.edu.br 
 */
public class Pessoa {
    
    private String nome;
    private String username;
    private String senha;
    
    public Pessoa(){
    } //Construtor não parametrizado
    
    public Pessoa(String nome){
        this.nome = nome;
    }
    
    public Pessoa(String nome, String username, String senha){
        this.nome = nome;
        this.username = username;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
