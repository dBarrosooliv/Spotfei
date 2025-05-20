/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Usuario;
import View.FramePerfilUsuario;

/**
 *
 * @author Daniel Barroso de Oliveira | Email: unfidoliveira@fei.edu.br 
 */
public class ControllerPerfil {
        
    private final FramePerfilUsuario view;
    private final Usuario user;
    
    public ControllerPerfil(FramePerfilUsuario view, Usuario user){
        this.view = view;
        this.user = user;
    }

    public Usuario getUser() {
        return user;
    }
    
    
}
