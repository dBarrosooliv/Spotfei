/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Usuario;
import View.FrameMenu;

/**
 *
 * @author Daniel Barroso de Oliveira | Email: unfidoliveira@fei.edu.br 
 */
public class ControllerMenu {
    
    private final FrameMenu view;
    private final Usuario user;
    
    public ControllerMenu(FrameMenu view, Usuario user){
        this.view = view;
        this.user = user;
    }
}
