/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Controller;

import examen1.Model.ChatBox;
import examen1.Model.User;
import examen1.View.ChatBoxView;
import examen1.View.MainFrame;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class ManagerForMainFrame {

    MainFrame mainFrame;
    ChatBox chatBox;
    User user = new User();
    ChatBoxView boxView;

    public ManagerForMainFrame() {

    }

    public ManagerForMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
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

    public void Controllerclock() {

        Thread clock = new Thread(
                new Runnable() {
            public void run() {
                while (mainFrame.isVisible()) {
                    mainFrame.Clock.setText(chatBox.getTime());
                }

            }
        });

        clock.start();

    }

}
