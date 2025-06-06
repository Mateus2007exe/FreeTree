package GUI;

import Chat.chat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author psfel
 */
public class Menu {

    public Menu() {
        

        JLabel labelBem = new JLabel("Bem-Vindo ao Free Tree! ");
        labelBem.setBounds(120, 50, 200, 30);

        JFrame tela = new JFrame();

        JButton cad = new JButton("Logar como Admin");
        cad.setBounds(120, 290, 200, 30);
        cad.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                
            double Senha;
                
            Senha = Double.parseDouble(JOptionPane.showInputDialog("Digite a senha de Admin!"));
                
            
                if(Senha==3550){
                     new Admin();
                    

                }else{
                    JOptionPane.showMessageDialog(null,"Senha Incorreta!");
                }
            }

        });

        JButton chat = new JButton("Iniciar Denuncia com Chat");
        chat.setBounds(120, 130, 200, 30);
        chat.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              chat chat=new chat("Cliente:127.0.0.1:3333", "Atendente");
              tela.setVisible(false);

            }

        });

        JButton call = new JButton("iniciar denuncia com Ligação");
        call.setBounds(120, 210, 200, 30);
        call.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }

        });

        tela.add(cad);
        tela.add(labelBem);
        tela.add(call);
        tela.add(chat);

        tela.setLayout(null);

        tela.setBounds(500, 100, 600, 500);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);

    }
    
    
}
