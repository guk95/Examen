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

    public MainFrame() {

        this.layout = new Layout(800, 600, 4);

        Object[][] obj1
                = {
                    {Menu, 160, 600, 4},
                    {GenericPanel, 640, 600, 4}
                };
        layout.setRow(obj1);

        setTitle("Dashboard Module");
        setLayout(layout.getLayOut());
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
    Clock.setLocation(400,400);
        JButton btn_usuarios = new JButton();
        btn_usuarios.setText("Usuarios");
        btn_usuarios.setBounds(nsPanel.getRectangle(140, 30));

        JButton btn_update = new JButton();
        btn_update.setText("Update User");
        btn_update.setBounds(nsPanel.getRectangle(140, 30));

        JButton btn_Empleados = new JButton();
        btn_Empleados.setText("Revisar empleado");
        btn_Empleados.setBounds(nsPanel.getRectangle(140, 30));

        Menu.add(btn_usuarios);
        Menu.add(btn_update);
        Menu.add(btn_Empleados);
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
