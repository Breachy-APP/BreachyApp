package org.breachy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    JButton returnButton = new JButton("Return");


    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        userLabel.setForeground(Color.white);
        passwordLabel.setBounds(50, 220, 100, 30);
        passwordLabel.setForeground(Color.white);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        showPassword.setBackground(InitialPage.color);
        showPassword.setForeground(Color.white);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
        returnButton.setBounds(120, 400, 100, 30);

    }

    public void addComponentsToContainer() {

        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(returnButton);
        container.setBackground(InitialPage.color);
    }

    public void addActionEvent() {

        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        returnButton.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
            if (e.getSource() == loginButton) {

                String userText;
                String pwdText;
                userText = userTextField.getText();
                pwdText = passwordField.getText();
                System.out.println(userText + " : " + pwdText + " Logged in Successfully");

                DBActions accessAccount = new DBActions(userText, pwdText);

                if (accessAccount.checkPassword(userText, pwdText)) {

                    this.toFront();
                    setVisible(false);
                    String accData = accessAccount.retrieveAccountInfo(userText, pwdText);
                    mainPageFrame mainFrame = new mainPageFrame();
                    mainFrame.allAccountData = accessAccount.retrieveAccountInfo(userText, pwdText);
                    mainFrame.openMainPage(mainFrame, true);
                    System.out.println("Retrieve info");

                } else {
                    JOptionPane.showMessageDialog(this, "Username/password is incorrect, please try again");
                    System.out.println("Wrong account username/password");
                }

            }
            //Coding Part of RESET button
            if (e.getSource() == resetButton) {
                userTextField.setText("");
                passwordField.setText("");
            }
            //Coding Part of showPassword JCheckBox
            if (e.getSource() == showPassword) {
                if (showPassword.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                }
            }
            if (e.getSource() == returnButton) {

                this.toBack();
                setVisible(false);
                InitialPage initpage = new InitialPage();
                initpage.openIntialPage(initpage, true);

            }


    }}

