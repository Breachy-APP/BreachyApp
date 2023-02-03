package org.breachy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class accountSittings extends JFrame implements ActionListener {
    //todo sittings
    private String username;
    private String password;
    private String email;
    private String status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    Container sittingsContainer = getContentPane();
    JLabel usernameLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel emailLabel = new JLabel("EMAIL");
    JLabel statusLabel = new JLabel("Account Status");


    Icon editIcon = new ImageIcon("Edit_Icon3.jpg");

    JButton UB = new JButton(editIcon);
    JButton PB = new JButton(editIcon);
    JButton EB = new JButton(editIcon);
    JButton SB = new JButton(editIcon);

    JTextField usernameCField = new JTextField(getUsername());
    JTextField passwordCField = new JTextField(getPassword());
    JTextField emailCField = new JTextField(getEmail());
    JTextField statusCField = new JTextField(getStatus());


    JButton returnB = new JButton("Return");

    DBActions editUserData = new DBActions();


    accountSittings() {

        setLayoutManager();
        setEditPageLocation();
        addComponentsToContainer();
        addActionEvent();

    }

    public void openSittingsPage(accountSittings sittingsFrame, boolean c){

        sittingsFrame.setTitle("Account Sittings");
        sittingsFrame.setVisible(c);
        sittingsFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        sittingsFrame.setBounds(600, 150, 350, 500);
        sittingsFrame.setResizable(false);

    }
    public void setLayoutManager(){
        sittingsContainer.setLayout(null);
    }
    public void setEditPageLocation() {

        usernameLabel.setBounds(20,30,100,30);
        usernameLabel.setForeground(Color.white);
        passwordLabel.setBounds(20,60,100,30);
        passwordLabel.setForeground(Color.white);
        emailLabel.setBounds(20,90,100,30);
        emailLabel.setForeground(Color.white);
        statusLabel.setBounds(20,120,100,30);
        statusLabel.setForeground(Color.white);

        UB.setBounds(270,30,30,20);
        PB.setBounds(270,60,30,20);
        EB.setBounds(270,90,30,20);
        SB.setBounds(270,120,30,20);

        returnB.setBounds(120,400,100,30);

        usernameCField.setBounds(120,30,120,20);
        passwordCField.setBounds(120,60,120,20);
        emailCField.setBounds(120,90,120,20);
        statusCField.setBounds(120,120,120,20);


    }
    public void addComponentsToContainer(){

        sittingsContainer.add(usernameLabel);
        sittingsContainer.add(passwordLabel);
        sittingsContainer.add(emailLabel);
        sittingsContainer.add(statusLabel);

        sittingsContainer.add(UB);
        sittingsContainer.add(PB);
        sittingsContainer.add(EB);
        sittingsContainer.add(SB);

        sittingsContainer.add(returnB);

        sittingsContainer.setBackground(InitialPage.color);

        sittingsContainer.add(usernameCField);
        sittingsContainer.add(passwordCField);
        sittingsContainer.add(emailCField);
        sittingsContainer.add(statusCField);

    }

    public void addActionEvent(){

        UB.addActionListener(this);
        PB.addActionListener(this);
        EB.addActionListener(this);
        SB.addActionListener(this);

        returnB.addActionListener(this);

    }
    public void getAccountData(String accountSittingsData) {

        String [] DBAD = new String[4];
        DBAD = accountSittingsData.split(" : ");
        System.out.println("sheeeeees "+accountSittingsData);

        setUsername(DBAD[0]);
        setPassword(DBAD[1]);
        setEmail(DBAD[2]);
        setStatus(DBAD[3]);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == returnB){

            this.toBack();
            setVisible(false);
            mainPageFrame mainPage = new mainPageFrame();
            mainPage.openMainPage(mainPage, true);

        }
        if (e.getSource() == UB){
            JOptionPane.showInputDialog("Username",getUsername());
        }
        if (e.getSource() == PB){
            JOptionPane.showInputDialog("Enter new Password",getPassword());
        }
        if (e.getSource() == EB){
            JOptionPane.showInputDialog("Enter new Email", getEmail());
        }
        if (e.getSource() == EB){
            JOptionPane.showInputDialog("Enter new Email", getStatus());
        }
    }
}
