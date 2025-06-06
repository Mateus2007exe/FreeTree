/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chat;

import Servidor.Utils;
import java.net.Socket;

/**
 *
 * @author psfel
 */
public class Atendente implements Runnable{
    
    private boolean running;
    private Socket connection;
    private boolean chatOpen;
    private String connection_info;
    private chat chat;
    
    public Atendente (Socket connection){
        this.chatOpen = false;
        this.running = false;
        this.connection = connection;
        this.connection_info = null;
        this.chat = null;
                
    }
    public boolean isRunning(){
        return running;
    }
    
    public void setRunning(boolean running) {
        this.running = running;
    }
    
    public boolean isChatOpen(){
        return chatOpen;
    }
    
    public void setChatOpen(boolean chatOpen) {
        this.chatOpen = chatOpen;
    }
    
    public chat getChat(){
        return chat;
    }
    
    public void setChat(chat chat){
        this.chat = chat;
    }
    
    public void run(){
        running = true;
        String message;
        while(running){
            message = Utils.receiveMessage(connection);
            if(message == null || message.equals("CHAT_CLOSE")){
                if(chatOpen){
                chat.dispose();}
            }
        }
    }
}
