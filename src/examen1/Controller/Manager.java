/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Controller;

import examen1.Model.ChatBox;
import examen1.View.ChatBoxView;

import java.awt.event.ActionListener;
import examen1.Model.User;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.AncestorListener;

/**
 *
 * @author Mario
 */
public class Manager implements ActionListener {

    ChatBox chatBox;
    ChatBoxView boxView;
    User user= new User() ;

    public Manager() {
    }

    public Manager(ChatBox chatBox, ChatBoxView boxView) {
        this.chatBox = chatBox;
        this.boxView = boxView;
        this.boxView.send_Message.addActionListener((ActionListener) this);
        ControllerreadDB();

    }

    public void actionPerformed(ActionEvent evento) {
        if (boxView.send_Message == evento.getSource()) {
            ControllersendMessage();
        }

    }

    public void ControllersendMessage() {
        
        chatBox.sendtoDB(user.getDisplayname(), boxView.send_Message.getText());
    }

    public void ControllerreadDB() {
        Thread t = new Thread(
                new Runnable() {
            public void run() {
                while (boxView.isVisible()) {
                    boxView.chatArea.setText("");
                    ResultSet rs1 = chatBox.readDB();
                
                    try {
                            String text="";
                        while (rs1.next()) {
                             text=text+rs1.getObject("Displayname").toString() + "   "
                                    + "  " + rs1.getObject("Message").toString() + "                                             " + rs1.getObject("Date").toString() + "\n" + "\n";

                        }
                        boxView.chatArea.setText(text);

                    } catch (Exception e) {
                        System.out.println("Error :" + e);
                    }
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });

        t.start();
    }

}
