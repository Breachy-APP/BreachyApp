package org.breachy;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Key;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Base64;

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
    JButton returnButton = new JButton("Return");

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

        //label colors
        userLabel.setForeground(Color.white);
        eMailLabel.setForeground(Color.white);
        createPasswordLabel.setForeground(Color.white);
        confirmPasswordLabel.setForeground(Color.white);

        // Field's Locations
        userTextField.setBounds(160, 50, 150, 30);
        emailField.setBounds(160, 100, 150, 30);
        createPasswordField.setBounds(160, 150, 150, 30);
        confirmPasswordField.setBounds(160, 200, 150, 30);

        // Button's location
        showPassword.setBounds(160, 250, 150, 30);
        showPassword.setForeground(Color.white);
        agreement.setBounds(160, 300, 150, 30);
        agreement.setForeground(Color.white);
        signUpButton.setBounds(50, 350, 100, 30);
        resetButton.setBounds(200, 350, 100, 30);
        returnButton.setBounds(120, 400, 100, 30);

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
        singUpContainer.add(returnButton);

        //bg
        agreement.setBackground(InitialPage.color);
        showPassword.setBackground(InitialPage.color);
        singUpContainer.setBackground(InitialPage.color);
    }

    public void addActionEvent() {

        signUpButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        returnButton.addActionListener(this);
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

            // Username info
            userNameText = userTextField.getText();
            emailText = emailField.getText();
            // password info
            passwordText = createPasswordField.getText();
            conPasswordText = confirmPasswordField.getText();

            // Check if already exists then Insert to DB
            if (isComplete(userNameText, emailText, passwordText, conPasswordText)) {

                DBActions newAccount = new DBActions(userNameText, passwordText, emailText);
                if (newAccount.alreadyExists(userNameText, emailText)) {
                    JOptionPane.showMessageDialog(this, "Account Already Exists try to log in");
                } else {
                    System.out.println("Inserting... !");
                    encryptPassword(userNameText, passwordText,emailText);
                }

                JOptionPane.showMessageDialog(this, "Welcome to our amazing app");

                this.toFront();
                setVisible(false);
                String accData = newAccount.retrieveAccountInfo(userNameText, passwordText);
                mainPageFrame mainFrame = new mainPageFrame();
                mainFrame.allAccountData = newAccount.retrieveAccountInfo(userNameText, passwordText);
                mainFrame.openMainPage(mainFrame, true);
                System.out.println("Retrieve info");
            }
        }
        if (e.getSource() == returnButton) {

            this.toBack();
            setVisible(false);
            InitialPage initpage = new InitialPage();
            initpage.openIntialPage(initpage, true);

        }
    }

    public boolean isComplete(String userNameText, String emailText, String passwordText, String conPasswordText) {


        if (userTextField != null && emailField != null && createPasswordField != null &&
                confirmPasswordField != null && agreement.isSelected() && (emailText.endsWith(".com") || emailText.endsWith(".sa"))
                && emailText.contains("@") && passwordText.equals(conPasswordText)) {

            return true;

        } else {

            if (userNameText == null) {
                JOptionPane.showMessageDialog(this, "please complete the information");
            } else if (emailText == null) {
                JOptionPane.showMessageDialog(this, "please complete the information");
            } else if (passwordText == null) {
                JOptionPane.showMessageDialog(this, "please complete the information");
            } else if (conPasswordText == null) {
                JOptionPane.showMessageDialog(this, "please complete the information");
            } else if (!emailText.contains("@")) {
                JOptionPane.showMessageDialog(this, "Invalid Email it should contain a host");
            } else if (!emailText.endsWith(".com") || (!emailText.endsWith(".sa"))) {
                JOptionPane.showMessageDialog(this, "Invalid Email it should contain a domain");
            } else if (passwordText.equals("") || !passwordText.equals(conPasswordText)) {
                createPasswordField.setText("");
                confirmPasswordField.setText("");
                JOptionPane.showMessageDialog(this, "Password is wrong!");
            } else if (!agreement.isSelected()) {
                JOptionPane.showMessageDialog(this, "please agree to out terms to be able to sign up");
            }
            return false;

        }
    }

    public static void encryptPassword(String username, String password, String emailText) {
        try {
            // Generate a random encryption key
            Key encryptionKey = generateEncryptionKey();
            //Encrypt the password
            byte[] encryptedPassword = encrypt(password, encryptionKey);
            // Encode the encrypted password and encryption key into base64 strings
            String encryptedPasswordBase64 = Base64.getEncoder().encodeToString(encryptedPassword);
            String encryptionKeyBase64 = Base64.getEncoder().encodeToString(encryptionKey.getEncoded());
            // Store the encrypted password and encryption key in the database
            Connection dbConnection = DBConnection.getInstance().getConnection();
            PreparedStatement pstmt = dbConnection.prepareStatement("INSERT INTO accounts (username, upassword, email, accountstatus, salt) VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, username);
            pstmt.setString(2, encryptedPasswordBase64);
            pstmt.setString(3, emailText);
            pstmt.setString(4,("Active"));
            pstmt.setString(5,encryptionKeyBase64);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Key generateEncryptionKey() throws Exception {
        SecureRandom random = new SecureRandom();
        byte[] keyBytes = new byte[16];
        random.nextBytes(keyBytes);
        return new SecretKeySpec(keyBytes, "AES");
    }

    private static byte[] encrypt(String data, Key encryptionKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, encryptionKey);
        return cipher.doFinal(data.getBytes());
    }
}

