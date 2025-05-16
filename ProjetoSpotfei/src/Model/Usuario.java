 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.ConexaoBD;
import DAO.UserDAO;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Barroso de Oliveira | Email: unfidoliveira@fei.edu.br 
 */
public class Usuario extends Pessoa implements InterfaceAutenticacao {
    
    private int userid;
    private List<Musica> musicasCurtidas;

    public Usuario(String nome, String username, String senha) {
        super(nome, username, senha);
    }
    
    public Usuario(List<Musica> musicasCurtidas, String nome, String username, String senha) {
        super(nome, username, senha);
        this.musicasCurtidas = musicasCurtidas;
    }
    
    @Override
    public boolean loginUsuario() {
        ConexaoBD conexao = new ConexaoBD();
        try {
            Connection conn = conexao.getConnection();
            UserDAO dao = new UserDAO(conn);
            ResultSet res = dao.consultar(this);
            if (res.next()) {
                this.setNome(res.getString("nome")); 
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
        return false;
    }

}
