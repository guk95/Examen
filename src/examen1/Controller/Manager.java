/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Controller;

import examen1.Model.ChatBox;
import examen1.Model.Tablas;
import examen1.View.ChatBoxView;

import java.awt.event.ActionListener;
import examen1.Model.User;
import examen1.View.Login;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.AncestorListener;
import examen1.View.MainFrame;
<<<<<<< HEAD
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class Manager implements ActionListener {

    Login login;
    Tablas tablas;
    MainFrame mainFrame;
    User user = new User();

    public Manager() {
    }

    public Manager(Login login, Tablas tablas) {
        this.login = login;
        this.tablas = tablas;
        this.login.Loguear.addActionListener(this);
        this.login.Registrar.addActionListener(this);

    }

    public void actionPerformed(ActionEvent evento) {
//        if (boxView.send_Message == evento.getSource()) {
//            ControllersendMessage();
//        }
        if (login.Loguear == evento.getSource()) {
            if (ControllerLogIn()) {
                ControllerForMainFrame cfmf = new ControllerForMainFrame();
                cfmf.StartMainFrame();
                login.dispose();
            } else {

                JOptionPane.showMessageDialog(null, "Usuario incorrecto");
            }

        }
        if (login.Registrar == evento.getSource()) {
            ControllerRegister();

        }

    }

    public boolean ControllerLogIn() {
        if (tablas.Login(login.Nombre.getText(), login.Password.getText())) {

            return true;
        } else {

            return false;
        }

    }

    public void ControllerRegister() {

        boolean result = tablas.CreateUser(login.Username.getText(), login.Displayname.getText(), login.Passwordnew.getText());
        if (result) {
            JOptionPane.showMessageDialog(null, "Usuario Creado");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
=======

/**
 *
 * @author Mario
 */
public class Manager implements ActionListener {

    ChatBox chatBox;
    ChatBoxView boxView;
    MainFrame mainFrame;
    Login login;
    Tablas tablas;
    User user = new User();

    public Manager() {
    }

    public Manager(Login login, Tablas tablas) {
        this.login= login;
       this.tablas=tablas;
//        this.boxView.send_Message.addActionListener((ActionListener) this);
//        ControllerreadDB();
//        Controllerclock();

    }

    public void actionPerformed(ActionEvent evento) {
        if (boxView.send_Message == evento.getSource()) {
            ControllersendMessage();
        }

    }

    public void ControllersendMessage() {

        chatBox.sendtoDB(user.getDisplayname(), boxView.send_Message.getText());
        boxView.send_Message.setText("");
    }

    public void ControllerreadDB() {
        Thread t = new Thread(
                new Runnable() {
            public void run() {
                while (boxView.isVisible()) {

                    ResultSet rs1 = chatBox.readDB();

                    try {
                        String text = "";
                        while (rs1.next()) {
                            text = text + rs1.getObject("Displayname").toString() + "   "
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
    
    public void Controllerclock(){
        
         Thread clock = new Thread(
                new Runnable() {
            public void run() {
             while(mainFrame.isVisible()){             
             mainFrame.Clock.setText(chatBox.getTime());
             }

            }
        });

        clock.start();
    
        
    
>>>>>>> origin/master
    }

}
