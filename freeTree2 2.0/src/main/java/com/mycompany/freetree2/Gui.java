
package com.mycompany.freetree2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author mateu
 */
public class Gui extends JFrame {
    
    public Gui(){
        
   
      JTextField campoLogin = new JTextField();
      campoLogin.setBounds(120, 80, 150, 30);
        
      JPasswordField campoSenha = new JPasswordField();
      campoSenha.setBounds(120, 180, 150, 30 );
          
        
    JLabel labelLogin = new JLabel("Usuário: ");
    labelLogin.setBounds(120, 50, 100, 30);
    
    JLabel labelSenha = new JLabel("Senha: ");
    labelSenha.setBounds(120, 150, 100, 30);
    
    
    JFrame tela = new JFrame ();
    
    JButton botao = new JButton("Login");
    botao.setBounds(120, 230, 150, 30);
    botao.addActionListener(new ActionListener(){        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String usuario = campoLogin.getText();
            String senha = new String (campoSenha.getPassword());
            
            System.out.printf("Usuario: %s\nSenha: %s", usuario, senha);
        
          if (usuario.equals("admin") && senha.equals("123321")){
              
              JOptionPane.showMessageDialog(null,"Bem vindo Admin!");
              
          }
          
          else {
           JOptionPane.showMessageDialog(null, "Senha ou Usuario incorretos! "); 
        }
        
        }
        
    });

tela.add(botao);
tela.add(labelLogin);
tela.add(campoLogin);
tela.add(campoSenha);
tela.add(labelSenha);

tela.setLayout(null);

tela.setBounds(400, 400, 400, 900);
tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
tela.setVisible(true);

}
          
    
}

