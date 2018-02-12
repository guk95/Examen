/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.View;

import java.awt.Color;
import java.awt.Rectangle;
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

/**
 *
 * @author Mario
 */
public class MainFrame extends JFrame {

    public Layout layout;
    public Layout Principal;
    public JPanel GenericPanel = new JPanel();
    public JPanel Menu = new JPanel();
    public JLabel Clock = new JLabel();
    public JPanel ClockPanel = new JPanel();
    public JButton ChatBox = new JButton();
    public JButton verTablas = new JButton();
    JButton crearTablas = new JButton();

    public MainFrame() {

        this.layout = new Layout(800, 600, 4);

        Object[][] obj1
                = {
                    {Menu, 160, 600, 4},
                    {GenericPanel, 640, 600, 4}
                };
        layout.setRow(obj1);

        setTitle("Examen");
        setLayout(layout.getLayOut());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(layout.setComponentDimension());
        setResizable(false);
        initComponents();
    }

    private void initComponents() {

        Layout nsPanel = new Layout(160, 600, 4);

        Menu.setLayout(nsPanel.getLayOut());
        Menu.setSize(nsPanel.setComponentDimension());
        Menu.setBackground(new Color(48, 44, 43));
        Clock.setBounds(nsPanel.getRectangle(140, 30));

        verTablas.setText("Ver Tablas");
        verTablas.setBounds(nsPanel.getRectangle(140, 30));
        ChatBox.setText("ChatBox");
        ChatBox.setBounds(nsPanel.getRectangle(140, 30));
        crearTablas.setText("Crear Tablas");
        crearTablas.setBounds(nsPanel.getRectangle(140, 30));
        Menu.add(verTablas);
        Menu.add(ChatBox);
        Menu.add(crearTablas);
        GenericPanel.add(Clock);
        add(Menu);
        pack();
        setVisible(true);
        add(GenericPanel);
        pack();
        setVisible(true);
//            Object[][] obj1
//                = {
//                    {Menu, 160, 600,4},
//                    {GenericPanel, 400, 600,4}
//                };
//       nsPanel.setRow(obj1);

    }

}
