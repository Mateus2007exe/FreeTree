/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ft;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author psfel
 */
public class Usuario {
    
    
    private String nome;
    private String email;
    private String senha;

public void usuario(){
      
}
public String getNome(){
    return nome;
    
}

public String getEmail(){
    return email;
}

public String getSenha(){
    return senha;
} 

public void setNome (String nome) {
    this.nome = nome;
}
public void setEmail (String email){
    this.email = email;
}
public void setSenha (String senha){
    this.senha = senha;
}
}




