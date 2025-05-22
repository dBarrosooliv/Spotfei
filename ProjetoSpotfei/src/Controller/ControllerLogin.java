/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConexaoBD;
import DAO.UserDAO;
import Model.Usuario;
import View.FrameLogin;
import View.FrameMenu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Barroso de Oliveira | Email: unfidoliveira@fei.edu.br 
 */
public class ControllerLogin {
        
    private FrameLogin view;

    public ControllerLogin(FrameLogin view) {
        this.view = view;
        
    }    
    
    public void loginUsuario(){
        Usuario user = new Usuario(null,
                                   view.getCampoUsuario().getText(),
                                   view.getCampoSenha().getText());

        if (user.loginUsuario()) {
            JOptionPane.showMessageDialog(view, 
                                          "Login efetuado!", 
                                          "Aviso",
                                          JOptionPane.INFORMATION_MESSAGE);
            FrameMenu janela_menu = new FrameMenu(user);
            janela_menu.setVisible(true);
            view.dispose();
        } else {
            JOptionPane.showMessageDialog(view, 
                                          "Login NÃO efetuado!", 
                                          "Aviso",
                                          JOptionPane.ERROR_MESSAGE);
        }
    }
    
}

