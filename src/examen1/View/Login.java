/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mario
 */
public class Login extends JFrame {

    public Layout Principal;
    public JPanel GenericPanel = new JPanel();
    public JTextField Nombre = new JTextField();
    public JTextField Password = new JTextField();
    public JButton Loguear = new JButton();
    public JLabel Registra = new JLabel();
    public JButton Registrar = new JButton();
    public JTextField Username = new JTextField();
    public JTextField Passwordnew = new JTextField();
    public JTextField Displayname = new JTextField();

    public Login() {
        this.Principal = new Layout(400, 450, 4);
        setTitle("ChatBox");
        setLayout(Principal.getLayOut());
        setPreferredSize(Principal.setComponentDimension());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();

    }

    private void initComponents() {

        Layout nsPanel = new Layout(300, 300, 4);
        Nombre.setBounds(nsPanel.getRectangle(140, 30));
        Nombre.setText("Username");
        Password.setText("Password");
        Password.setBounds(nsPanel.getRectangle(140, 30));
        Loguear.setBounds(nsPanel.getRectangle(140, 30));
        Loguear.setText("LogIn");
        Registra.setBounds(nsPanel.getRectangle(140, 30));
        Registra.setText("!!!!!REGISTRATE!!!!!!");
        Username.setBounds(nsPanel.getRectangle(140, 30));
        Username.setText("Username");
        Displayname.setBounds(nsPanel.getRectangle(140, 30));
        Displayname.setText("DisplayName");
        Passwordnew.setBounds(nsPanel.getRectangle(140, 30));
        Passwordnew.setText("Password");
        Registrar.setBounds(nsPanel.getRectangle(140, 30));
        Registrar.setText("Registrar");
        GenericPanel.setLayout(nsPanel.getLayOut());
        GenericPanel.setSize(nsPanel.setComponentDimension());
        GenericPanel.add(Nombre);
        GenericPanel.add(Password);
        GenericPanel.add(Loguear);

        GenericPanel.add(Registra);
        GenericPanel.add(Username);
        GenericPanel.add(Displayname);
        GenericPanel.add(Passwordnew);
        GenericPanel.add(Registrar);
        setVisible(true);
        add(GenericPanel);
        pack();
        setVisible(true);
    }

}
