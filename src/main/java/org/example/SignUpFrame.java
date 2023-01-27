package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpFrame extends JFrame implements ActionListener {

    Container singUpContainer = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel eMailLabel = new JLabel("EMAIL");
    JLabel createPasswordLabel = new JLabel("Create Password");
    JLabel confirmPasswordLabel = new JLabel("Confirm Password");
    JTextField userTextField = new JTextField();
    JTextField emailField = new JTextField();
    JPasswordField createPasswordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();
    JButton signUpButton = new JButton("Sign UP");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    JCheckBox agreement = new JCheckBox("Agree to Our Term");

    SignUpFrame() {
        setLayoutManager();
        setLocation();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        singUpContainer.setLayout(null);
    }

    public void setLocation() {
        // Label's Locations
        userLabel.setBounds(50, 50, 100, 30);
        eMailLabel.setBounds(50, 100, 100, 30);
        createPasswordLabel.setBounds(50, 150, 100, 30);
        confirmPasswordLabel.setBounds(50, 200, 100, 30);
        // Field's Locations
        userTextField.setBounds(160, 50, 150, 30);
        emailField.setBounds(160, 100, 150, 30);
        createPasswordField.setBounds(160, 150, 150, 30);
        confirmPasswordField.setBounds(160, 200, 150, 30);
        // Button's location
        showPassword.setBounds(160, 250, 150, 30);
        agreement.setBounds(160, 300, 150, 30);
        signUpButton.setBounds(50, 350, 100, 30);
        resetButton.setBounds(200, 350, 100, 30);

    }

    public void addComponentsToContainer() {
        //Labels
        singUpContainer.add(userLabel);
        singUpContainer.add(eMailLabel);
        singUpContainer.add(createPasswordLabel);
        singUpContainer.add(confirmPasswordLabel);
        //Fields
        singUpContainer.add(createPasswordField);
        singUpContainer.add(confirmPasswordField);
        singUpContainer.add(userTextField);
        singUpContainer.add(emailField);
        // checks
        singUpContainer.add(showPassword);
        singUpContainer.add(agreement);
        //buttons
        singUpContainer.add(signUpButton);
        singUpContainer.add(resetButton);
        //bg
        singUpContainer.setBackground(new Color(78, 178, 178));
    }

    public void addActionEvent() {
        signUpButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // RESET button case
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            emailField.setText("");
            createPasswordField.setText("");
            confirmPasswordField.setText("");
        }
        // show password check case
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                confirmPasswordField.setEchoChar((char) 0);
                createPasswordField.setEchoChar((char) 0);
            } else {
                createPasswordField.setEchoChar('*');
                confirmPasswordField.setEchoChar('*');
            }
        }

        boolean complete;
        // Sign Up button case
        if (e.getSource() == signUpButton) {
            String userNameText;
            String emailText;
            String passwordText;
            String conPasswordText;

            userNameText = userTextField.getText();
            emailText = emailField.getText();
            // password info
            passwordText = createPasswordField.getText();
            conPasswordText = confirmPasswordField.getText();

            // username and email info


                // Check if already exists then Insert to DB
                if (isComplete(userNameText, emailText, passwordText, conPasswordText)) {

                    DBActions newAccount = new DBActions(userNameText, passwordText, emailText);
                    if (newAccount.alreadyExists(userNameText, passwordText)) {
                        JOptionPane.showMessageDialog(this, "Account Already Exists try to log in");
                    } else {
                        newAccount.insertAccount();
                        System.out.println("Insert successfully");
                    }
                    JOptionPane.showMessageDialog(this, "Welcome to our amazing app");
                    // todo open app page
                }
        }
    }
    public boolean isComplete(String userNameText, String emailText, String passwordText, String conPasswordText){


        if(userTextField != null && emailField != null && createPasswordField != null &&
                confirmPasswordField != null && agreement.isSelected() && (emailText.endsWith(".com")||emailText.endsWith(".sa"))
                && emailText.contains("@") && passwordText.equals(conPasswordText)){

            return true;

        }
        else {

            if (userTextField == null || emailField == null || createPasswordField == null || confirmPasswordField == null) {
                JOptionPane.showMessageDialog(this, "please complete the information");
            }else if (! emailText.contains("@")){
                JOptionPane.showMessageDialog(this, "Invalid Email it should contain a host");
            } else if (passwordText.equals("") || !passwordText.equals(conPasswordText)) {
                createPasswordField.setText("");
                confirmPasswordField.setText("");
                JOptionPane.showMessageDialog(this, "Password is wrong!");
            }else if ( ! agreement.isSelected()) {
                JOptionPane.showMessageDialog(this, "please agree to out terms to be able to sign up");
            }
            return false;

        }
    }
}

