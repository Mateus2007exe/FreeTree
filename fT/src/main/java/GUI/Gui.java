package GUI;

import com.mycompany.ft.Conexao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Gui {

    public Gui() {

        JTextField campoLogin = new JTextField();
        campoLogin.setBounds(120, 80, 150, 30);

        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setBounds(120, 180, 150, 30);

        JLabel labelLogin = new JLabel("Usuário: ");
        labelLogin.setBounds(120, 50, 100, 30);

        JLabel labelSenha = new JLabel("Senha: ");
        labelSenha.setBounds(120, 150, 100, 30);

        JFrame tela = new JFrame();

        JButton cad = new JButton("Realizar cadastro");
        cad.setBounds(120, 280, 150, 30);
        cad.addActionListener((ActionEvent e) -> {
            new TelaCC();
            tela.setVisible(false);
        });

        JButton botao = new JButton("Login");
        botao.setBounds(120, 230, 150, 30);
        botao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
                if(campoLogin.getText().equals("Polli")&& new String(campoSenha.getPassword()).equals("123321")){
                    
                new Menu();
                tela.setVisible(false);
                }                
                else{ 
                    JOptionPane.showMessageDialog(null,"Este usuario não existe!");
                }
                
                
                
                try {

                    try (Connection con = Conexao.faz_conexao()) {
                        String sql = "select *from usuario where nome=? and senha=? ";
                        
                        try (PreparedStatement stmt = con.prepareStatement(sql)) {
                            stmt.setString(1, campoLogin.getText());
                            stmt.setString(2, new String(campoSenha.getPassword()));
                            
                            ResultSet rs = stmt.executeQuery();
                            
                            if (rs.next()) {
                                
                                Menu menu = new Menu();
                                
                            } else {
                                JOptionPane.showMessageDialog(null, "esse usuario não existe");
                            }
                        }
                    }

                } catch (SQLException ex) {
                }

            }

        });

        tela.add(botao);
        tela.add(labelLogin);
        tela.add(campoLogin);
        tela.add(campoSenha);
        tela.add(labelSenha);
        tela.add(cad);

        tela.setLayout(null);

        tela.setBounds(500, 100, 600, 500);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);

    }

}
