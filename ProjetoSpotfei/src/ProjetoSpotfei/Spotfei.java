/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoSpotfei;

import DAO.ConexaoBD;
import View.FrameLogin;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * TESTE GERA JAVADOC
 * @author Daniel Barroso de Oliveira | Email: unfidoliveira@fei.edu.br
 */
public class Spotfei {
    public static void main(String[] args) {
        try (Connection conexao = new ConexaoBD().getConnection()) {
            System.out.println("Conexao estabelecida com sucesso!");
            FrameLogin janela_login = new FrameLogin();
            janela_login.setVisible(true);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados :v");
            e.printStackTrace();
        }
    }
}
