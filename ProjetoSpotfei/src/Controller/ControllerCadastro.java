/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConexaoBD;
import DAO.UserDAO;
import Model.Usuario;
import View.FrameCadastro;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Contém método para salvar usuário no banco de dados com auxílio do DAO
 * @author Daniel Barroso de Oliveira | Email: unfidoliveira@fei.edu.br 
 */
public class ControllerCadastro {

    private final FrameCadastro view;
    
    public ControllerCadastro(FrameCadastro view){
        this.view = view;
    }
    
    public void SalvarCadastro(){
        String nome = view.getCampoNome().getText();
        String username = view.getCampoUsuario().getText();
        String senha = view.getCampoSenha().getText();
        System.out.println(nome);
        System.out.println(username);
        System.out.println(senha);

        Usuario user = new Usuario(nome,username,senha);
        
        ConexaoBD conexao = new ConexaoBD();
        try {
            Connection conn = conexao.getConnection();
            UserDAO dao = new UserDAO(conn);
            dao.inserir(user);
            JOptionPane.showMessageDialog(view, "Usuario Cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex){
                ex.printStackTrace(); 
                 JOptionPane.showMessageDialog(view, "Usuário não cadastrado!\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        
    }
}
