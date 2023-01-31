package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainPageFrame extends JFrame implements ActionListener {

    Container mainPageContainer = getContentPane();
    JLabel searchLabel = new JLabel("Search");
    JTextField searchField = new JTextField();
    JButton searchButton = new JButton("Search");
    JCheckBoxMenuItem searchByID = new JCheckBoxMenuItem("Search By ID");
    JCheckBoxMenuItem searchBySystem = new JCheckBoxMenuItem("Search by System");
    JCheckBoxMenuItem searchByVersion = new JCheckBoxMenuItem("Search By Version");
    JCheckBoxMenuItem searchByKeyWord = new JCheckBoxMenuItem("General Search");
    JButton logOutButton = new JButton("LOGOUT");
    JMenuBar menuBar = new JMenuBar();
    JMenuItem x= new JMenuItem("X");

    String accountUsername;
    String accountPassword;
    mainPageFrame(){
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void userAccount(String username, String password){

        accountUsername = username;
        accountPassword = password;

    }
    public void setLocationAndSize(){

        searchField.setBounds(12,15,300,30);
        searchLabel.setBounds(13, 15, 100, 30);
        searchButton.setBounds(120,49,100,30);
        searchByID.setBounds(105, 100, 150, 30);
        searchBySystem.setBounds(105, 130, 150,30);
        searchByVersion.setBounds(105,160, 150, 30);
        searchByKeyWord.setBounds(105, 190, 150,30);
        logOutButton.setBounds(120, 400, 100,30 );
        menuBar.setBounds(500,500,300,30);

    }
    public void openMainPage(mainPageFrame mainFrame, boolean c){

        mainFrame.setTitle("main page");
        mainFrame.setVisible(c);
        mainFrame.setBounds(600, 150, 350, 500);
        mainFrame.setResizable(false);


    }

    public void addComponentsToContainer(){

        mainPageContainer.add(searchLabel);
        mainPageContainer.add(searchField);
        mainPageContainer.add(searchButton);
        mainPageContainer.add(searchByID);
        mainPageContainer.add(searchBySystem);
        mainPageContainer.add(searchByVersion);
        mainPageContainer.add(searchByKeyWord);
        mainPageContainer.add(logOutButton);
        mainPageContainer.add(menuBar);
        mainPageContainer.setBackground(new Color(44, 60, 120));

    }

    public void addActionEvent(){

        searchButton.addActionListener(this);
        logOutButton.addActionListener(this);
        searchByID.addActionListener(this);
        searchBySystem.addActionListener(this);
        searchByVersion.addActionListener(this);
        searchByKeyWord.addActionListener(this);

    }


    public void setLayoutManager() {
        mainPageContainer.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == searchButton){

            String searchText = searchField.getText();
            DBActions searchForBreach = new DBActions();
            String theBreach = searchForBreach.searchForBreach(searchText);
            System.out.println(theBreach);
        }
        if(e.getSource() == logOutButton){

            InitialPage initFrame = new InitialPage();
            initFrame.openIntialPage(initFrame, true);

        }
    }


    //todo

}
