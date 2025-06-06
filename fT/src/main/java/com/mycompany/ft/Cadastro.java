package com.mycompany.ft;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Cadastro {

    Connection conn;
    PreparedStatement pstm;

    public void cadastrarUsu(Usuario objUsuario) throws SQLException {
        String sql = "inset into usuario (nome, email, senha ) Values (?, ?, ?)";
        conn = new Conexao().faz_conexao();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objUsuario.getNome());
            pstm.setString(2, objUsuario.getEmail());
            pstm.setString(3, objUsuario.getSenha());

            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Usuario" + erro);

        }
    }
}
