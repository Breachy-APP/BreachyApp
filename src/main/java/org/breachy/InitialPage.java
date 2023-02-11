package org.breachy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.breachy.mainPageFrame.breachyLogo;

public class InitialPage extends JFrame implements ActionListener {

    Container initPageContainer = getContentPane();
    JLabel welcomeLabel = new JLabel("Welcome to the application");
    JButton signUPButton = new JButton("SIGN UP");
    JButton logInButton = new JButton("LOG IN");
    JCheckBox rememberMe = new JCheckBox("REMEMBER ME");

    JToggleButton ChangeColor = new JToggleButton("Light Theme");
    public static Color color=new Color(40,40,40);
    JToggleButton ChangeColor = new JToggleButton("Dark Mode");
    public static Color color=new Color(93, 93, 112);
    
    JButton Guest = new JButton("Continue without Login");

    InitialPage(){
        setLayoutManager();
        setInitPageLocation();
        addComponentsToContainer();
        addActionEvent();
    }
    public void openIntialPage(InitialPage initFrame, boolean c){

        initFrame.setTitle("Initial Form");
        initFrame.setVisible(c);
        initFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initFrame.setBounds(600, 150, 350, 500);
        initFrame.setResizable(false);
        initFrame.setIconImage(breachyLogo.getImage());
    }
    public void openLogInForm(boolean c) {

        LoginFrame logInFrame = new LoginFrame();
        logInFrame.setTitle("Login Form");
        logInFrame.setVisible(c);
        logInFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        logInFrame.setBounds(600, 150, 350, 500);
        logInFrame.setResizable(false);
        logInFrame.setIconImage(breachyLogo.getImage());

    }
    public static void openSignInForm(boolean c) {

        SignUpFrame signUpFrame = new SignUpFrame();
        signUpFrame.setTitle("Sign Up Form");
        signUpFrame.setVisible(c);
        signUpFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        signUpFrame.setBounds(600, 150, 350, 500);
        signUpFrame.setResizable(false);
        signUpFrame.setIconImage(breachyLogo.getImage());

    }
    public void setLayoutManager(){
        initPageContainer.setLayout(null);
    }
    public void setInitPageLocation(){
        welcomeLabel.setBounds(70,30,250,45);
        welcomeLabel.setFont(new Font("Calibre", Font.BOLD, 16));
        welcomeLabel.setForeground(Color.white);
        signUPButton.setBounds(120,100,100,30);
        logInButton.setBounds(120,150,100,30);
        rememberMe.setBounds(110,190,150,30);
        rememberMe.setFont(new Font("Calibre", Font.ITALIC, 12));
        rememberMe.setForeground(Color.white);
        ChangeColor.setBounds(107,300,130,30);
        Guest.setBounds(82,230,180,30);
    }
    public void addComponentsToContainer(){

        initPageContainer.add(welcomeLabel);
        initPageContainer.add(signUPButton);
        initPageContainer.add(logInButton);
        initPageContainer.add(rememberMe);
        rememberMe.setBackground(color);
        initPageContainer.setBackground(color);
        initPageContainer.add(ChangeColor);
        initPageContainer.add(Guest);

    }
    public void addActionEvent(){

        signUPButton.addActionListener(this);
        logInButton.addActionListener(this);
        rememberMe.addActionListener(this);
        ChangeColor.addActionListener(this);
        Guest.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == signUPButton){
            this.toFront();
            setVisible(false);
            openSignInForm(true);

        }
        if(e.getSource() == logInButton){
            this.toFront();
            setVisible(false);
            openLogInForm(true);
        }

        if(ChangeColor.isSelected()){
            color = new Color(93, 93, 112);
            initPageContainer.setBackground(color);
            rememberMe.setBackground(color);

            ChangeColor.setText("Dark Theme");
            ChangeColor.setText("Light Mode");

        }else{
            color = new Color(40,40,40);
            initPageContainer.setBackground(color);
            rememberMe.setBackground(color);
            ChangeColor.setText("Light theme");
            ChangeColor.setText("Dark Mode");

        }

        if(e.getSource() == Guest){
            this.toFront();
            setVisible(false);
            mainPageFrame mainFrame = new mainPageFrame();
            mainFrame.openMainPage(mainFrame,true);

        }
    }
}

