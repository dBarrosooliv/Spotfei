/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * TESTE GERA JAVADOC
 * @author Daniel Barroso de Oliveira | Email: unfidoliveira@fei.edu.br 
 */
public class UserDAO {

    private Connection conexao;

    public UserDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void inserir(Usuario user) throws SQLException{
        String sql = "insert into usuarios_cadastrados (nome, username, senha) values ('"
                      + user.getNome()    + "', '"
                      + user.getUsername()+ "', '"
                      + user.getSenha()   + "')";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.execute();
        conexao.close();
    }
    
    public ResultSet consultar(Usuario user) throws SQLException{
        String sql = "select * from usuarios_cadastrados where username = ? and senha = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    
}
