/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

    public static boolean sendMessage(Socket connection, String message){
        try {
            ObjectOutputStream output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            output.writeObject(message);
            return true;
        } catch (IOException ex) {
            System.out.println("ERRO SendMessage");
        }
        
        return false;
    }
    
    public static String receiveMessage(Socket connection){
        String response = null;
        try{
            ObjectInputStream input = new ObjectInputStream(connection.getInputStream());
            response = (String) input.readObject();
        }catch(IOException ex){
            System.out.println("ERRO ReceiveMessage");
        }catch(ClassNotFoundException ex){
            System.out.println("ERRO ReceiveMessage");
        }
        return response;
    }

}
