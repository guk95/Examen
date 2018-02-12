/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.View;

import examen1.Model.funciones;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.JTextArea;

public class ChatBoxView extends JFrame {

    public Layout Principal;
    public JPanel GenericPanel = new JPanel();
    public JTextField send_Message = new JTextField();
    public JTextArea chatArea = new JTextArea();
    public JTextArea chatArea1 = new JTextArea(10, 3);
    public JButton send = new JButton();
    public JButton regresar = new JButton();

    public ChatBoxView() {
        this.Principal = new Layout(1000, 1000, 4);
        setTitle("ChatBox");
        setLayout(Principal.getLayOut());
        setPreferredSize(Principal.setComponentDimension());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        Layout nsPanel = new Layout(1000, 1000, 4);
        chatArea.setBounds(nsPanel.getRectangle(500, 500));
        send_Message.setBounds(nsPanel.getRectangle(500, 200));
        send.setBounds(nsPanel.getRectangle(140, 140));
        regresar.setBounds(nsPanel.getRectangle(140,140));
        GenericPanel.setLayout(nsPanel.getLayOut());
        GenericPanel.setSize(nsPanel.setComponentDimension());
        GenericPanel.add(chatArea);
        GenericPanel.add(send_Message);
        GenericPanel.add(send);
         GenericPanel.add(regresar);
        setVisible(true);
        add(GenericPanel);
        pack();
        setVisible(true);
    }

}
