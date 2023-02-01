package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class accountSittings extends JFrame implements ActionListener {
    //todo sittings
    String username;
    String password;
    String email;
    String status;
    Container sittingsContainer = getContentPane();
    JLabel usernameLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel emailLabel = new JLabel("EMAIL");
    JLabel statusLabel = new JLabel("Account Status");

    JLabel usernameText = new JLabel();
    JLabel passwordText = new JLabel();
    JLabel emailText = new JLabel();
    JLabel statusText = new JLabel();

    Icon editIcon = new ImageIcon("Edit_Icon3.jpg");

    JButton UB = new JButton(editIcon);
    JButton PB = new JButton(editIcon);
    JButton EB = new JButton(editIcon);
    JButton SB = new JButton(editIcon);

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

        usernameText.setBounds(110,30,100,20);
        passwordText.setBounds(110,60,100,20);
        emailText.setBounds(110,90,100,20);
        statusText.setBounds(110,120,100,20);

        UB.setBounds(270,30,30,20);
        PB.setBounds(270,60,30,20);
        EB.setBounds(270,90,30,20);
        SB.setBounds(270,120,30,20);

        returnB.setBounds(120,400,100,30);

        // todo fix problem
        /*
        usernameText.setText(editUserData.getUsername());
        passwordText.setText(editUserData.getPassword());
        emailText.setText(editUserData.getEmail());
        statusText.setText(editUserData.getAccountStatus());
*/

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

        sittingsContainer.add(usernameText);
        sittingsContainer.add(passwordText);
        sittingsContainer.add(emailText);
        sittingsContainer.add(statusText);

        sittingsContainer.add(returnB);

        sittingsContainer.setBackground(new Color(44,60,120));

    }

    public void addActionEvent(){

        UB.addActionListener(this);
        PB.addActionListener(this);
        EB.addActionListener(this);
        SB.addActionListener(this);

        returnB.addActionListener(this);

    }
    public void getAccountData(String Susername, String Spassword) {

        String [] accountData = new String[4];

        DBActions auth = new DBActions(Susername, Spassword);

        System.out.println(Susername +"SSSSSS"+ Spassword);

            accountData = auth.retrieveAccountInfo(Susername, Spassword);
            usernameText.setText(Susername);
            passwordText.setText(Spassword);
            emailText.setText(accountData[2]);
            statusText.setText(accountData[3]);


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
            JOptionPane.showInputDialog("Enter new Username", usernameText.getText());
        }
        if (e.getSource() == PB){
            JOptionPane.showInputDialog("Enter new Password", passwordText.getText());
        }
        if (e.getSource() == EB){
            JOptionPane.showInputDialog("Enter new Email", emailText.getText());
        }
        if (e.getSource() == SB){
            JOptionPane.showConfirmDialog(this,"Change Account Status to Active ?");
        }
    }
}
