package GUI;

import com.mycompany.ft.Cadastro;
import com.mycompany.ft.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaCC {

    public TelaCC() {
        JTextField campoNome = new JTextField();
        campoNome.setBounds(120, 80, 150, 30);

        JTextField campoEmail = new JTextField();
        campoEmail.setBounds(120, 160, 150, 30);

        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setBounds(120, 240, 150, 30);

        JLabel labelNome = new JLabel("Nome: ");
        labelNome.setBounds(120, 50, 100, 30);

        JLabel labelEmail = new JLabel("Email: ");
        labelEmail.setBounds(120, 130, 100, 30);

        JLabel labelSenha = new JLabel("Senha: ");
        labelSenha.setBounds(120, 210, 100, 30);

        JFrame tela = new JFrame();

        JButton cad = new JButton("Realizar cadastro");
        cad.setBounds(120, 320, 150, 30);
        cad.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nome, senha, email;

                nome = campoNome.getText();
                email = campoEmail.getText();
                senha = campoSenha.getText();

                Usuario objUsuario = new Usuario();

                objUsuario.setEmail(email);
                objUsuario.setNome(nome);
                objUsuario.setSenha(senha);

                Cadastro objCad = new Cadastro();

                try {
                    objCad.cadastrarUsu(objUsuario);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "burro, ta errado ai parça");
                }

            }

            private String campoSenha() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

        });

        tela.add(cad);
        tela.add(labelNome);
        tela.add(campoNome);
        tela.add(campoSenha);
        tela.add(labelSenha);
        tela.add(labelEmail);
        tela.add(campoEmail);

        tela.setLayout(null);

        tela.setBounds(500, 100, 600, 500);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);

    }

}
