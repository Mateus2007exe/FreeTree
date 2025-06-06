/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import com.mycompany.ft.Conexao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author psfel
 */
public class Admin {
    
    
    public Admin(){
    
JTextField campoNome = new JTextField();
        campoNome.setBounds(30, 380, 220, 30);


        JLabel labelNome = new JLabel("Bem vindo Admin!");
        labelNome.setBounds(160, 50, 300, 30);


        JFrame tela = new JFrame();

        JButton cad = new JButton("Verificar Historico");
        cad.setBounds(120, 200, 300, 30);
        cad.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                try(Connection con = Conexao.faz_conexao()) {
                        String sql = "select *from Denuncia where nome=? and senha=? ";     
                        }catch(SQLException ex){
                            System.out.println("Erro com o banco de dados");
                    }

                } 
                
        });
        tela.add(cad);
        tela.add(labelNome);
        

        tela.setLayout(null);

        tela.setBounds(500, 100, 600, 500);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);
    }
}
