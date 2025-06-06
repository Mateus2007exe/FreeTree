/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

public class chat extends JFrame {

    private JLabel jl_title;
    private JEditorPane messages;
    private JTextField jt_message;
    private JButton jb_message;
    private JPanel panel;
    private JScrollPane scroll;

    String connection_info;
    ArrayList<String> message_list;

    public chat(String connection_info, String title) {
        super("Chat " + title);
        this.connection_info = connection_info;
        initComponents();
        configComponents();
        insertComponents();
        insertActions();
        start();
    }

    public void initComponents() {
        message_list = new ArrayList<String>();
        jl_title = new JLabel(connection_info.split(":")[0], SwingConstants.CENTER);
        messages = new JEditorPane();
        scroll = new JScrollPane(messages);
        jt_message = new JTextField();
        jb_message = new JButton("Enviar");
        panel = new JPanel(new BorderLayout());
    }

    public void configComponents() {
        this.setMinimumSize(new Dimension(480, 720));
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        messages.setContentType("text/html");
        messages.setEditable(false);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jb_message.setSize(100, 40);
        this.setVisible(true);
    }

    public void insertComponents() {
        this.add(jl_title, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
        this.add(panel, BorderLayout.SOUTH);
        panel.add(jt_message, BorderLayout.CENTER);
        panel.add(jb_message, BorderLayout.EAST);
    }

    private void insertActions() {
        jb_message.addActionListener(event -> send());
        jt_message.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    send();
                }
            }

            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void append_message(String recieved) {
        message_list.add(recieved);
        String message = "";
        for (String str : message_list) {
            message += str;
        }
        messages.setText(message);
    }

    public void send() {
        if (jt_message.getText().length() > 0) {
            DateFormat df = new SimpleDateFormat("hh:mm:ss");
            append_message("<b>[" + df.format(new Date()) + "] Eu: </b><i>" + jt_message.getText() + "</i><br>");
        }
    }

    public void start() {
        this.pack();
        this.setVisible(true);
    }

}
