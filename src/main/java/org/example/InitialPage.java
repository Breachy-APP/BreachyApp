package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialPage extends JFrame implements ActionListener {

    Container initPageContainer = getContentPane();
    JLabel welcomeLabel = new JLabel("Welcome to the application");
    JButton signUPButton = new JButton("SIGN IN");
    JButton logInButton = new JButton("LOG IN");
    JCheckBox rememberMe = new JCheckBox("REMEMBER ME");

    InitialPage(){
        setLayoutManager();
        setInitPageLocation();
        addComponentsToContainer();
        addActionEvent();
    }
    public void openLogInForm(boolean c) {

        LoginFrame logInFrame = new LoginFrame();
        logInFrame.setTitle("Login Form");
        logInFrame.setVisible(c);
        logInFrame.setBounds(600, 150, 350, 500);
        logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInFrame.setResizable(false);


    }
    public static void openSignInForm(boolean c) {

        SignUpFrame signUpFrame = new SignUpFrame();
        signUpFrame.setTitle("Sign Up Form");
        signUpFrame.setVisible(c);
        signUpFrame.setBounds(600, 150, 350, 500);
        signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signUpFrame.setResizable(false);

    }
    public void setLayoutManager(){
        initPageContainer.setLayout(null);
    }
    public void setInitPageLocation(){
        welcomeLabel.setBounds(80,30,155,30);
        signUPButton.setBounds(120,100,100,30);
        logInButton.setBounds(120,150,100,30);
        rememberMe.setBounds(100,190,150,30);
    }
    public void addComponentsToContainer(){


        initPageContainer.add(welcomeLabel);
        initPageContainer.add(signUPButton);
        initPageContainer.add(logInButton);
        initPageContainer.add(rememberMe);


    }
    public void addActionEvent(){

        signUPButton.addActionListener(this);
        logInButton.addActionListener(this);
        rememberMe.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == signUPButton){
            openSignInForm(true);
        }
        if(e.getSource() == logInButton){
            openLogInForm(true);
        }


    }
}
