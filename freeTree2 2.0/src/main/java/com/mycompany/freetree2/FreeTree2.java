
package com.mycompany.freetree2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class FreeTree2 {
    
    public static void main(String[] args) throws SQLException{
            
        new Gui();
        
        Connection conexao = null;           
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/freeTree", "root", "123321");
            ResultSet rsUsuarios = conexao.createStatement().executeQuery("select *FROM DENUNCIAS");
            while(rsUsuarios.next()) {
                System.out.println("Nome:"+rsUsuarios.getString("nome"));
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não localizado.");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: "+ex.getMessage());
        } finally {
            if (conexao != null) {
                conexao.close();
            }
        }
    }
    
     public static void criarTela(){
    

}   
    
    
    
    
}       

