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
    JMenuBar menuBar = new JMenuBar(); //todo
    JMenuItem x= new JMenuItem("X"); // todo
    //tips page button
    JButton tipsButton = new JButton("TIPS !!");
    JLabel dt = new JLabel("press for The Daily Tips");

    JButton accountSittings = new JButton("Account Settings");

    String accountUsername;
    String accountPassword;

    mainPageFrame(){
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }


    public void setLocationAndSize(){

        searchLabel.setBounds(13, 15, 100, 30);
        searchLabel.setForeground(Color.white);
        searchField.setBounds(12,15,300,25);

        searchButton.setBounds(120,49,100,30);

        searchByID.setBounds(105, 100, 150, 30);
        searchByID.setForeground(Color.white);
        searchByID.setBackground(new Color(44,60,120));

        searchBySystem.setBounds(105, 130, 150,30);
        searchBySystem.setForeground(Color.white);
        searchBySystem.setBackground(new Color(44,60,120));

        searchByVersion.setBounds(105,160, 150, 30);
        searchByVersion.setForeground(Color.white);
        searchByVersion.setBackground(new Color(44,60,120));

        searchByKeyWord.setBounds(105, 190, 150,30);
        searchByKeyWord.setForeground(Color.white);
        searchByKeyWord.setBackground(new Color(44,60,120));

        logOutButton.setBounds(200, 400, 100,30 );
        accountSittings.setBounds(30,400,150,30);

        menuBar.setBounds(500,500,300,30);

        dt.setBounds(100,270,200,30);
        dt.setForeground(Color.WHITE);
        tipsButton.setBounds(120,300,100,90);

    }
    public void openMainPage(mainPageFrame mainFrame, boolean c){

        mainFrame.setTitle("main page");
        mainFrame.setVisible(c);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        mainPageContainer.add(accountSittings);
        mainPageContainer.add(menuBar);//todo
        mainPageContainer.add(tipsButton);
        mainPageContainer.add(dt);
        mainPageContainer.setBackground(new Color(44, 60, 120));

    }

    public void addActionEvent(){

        searchButton.addActionListener(this);
        logOutButton.addActionListener(this);
        accountSittings.addActionListener(this);
        searchByID.addActionListener(this);
        searchBySystem.addActionListener(this);
        searchByVersion.addActionListener(this);
        searchByKeyWord.addActionListener(this);
        tipsButton.addActionListener(this);

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

            JOptionPane.showMessageDialog(this,"Thank You For using Out Application");
            this.toBack();
            setVisible(false);
            InitialPage initFrame = new InitialPage();
            initFrame.openIntialPage(initFrame, true);

        }
        if (e.getSource() == tipsButton){
            this.toFront();
            setVisible(false);
            tipsPageFrame tipsPage = new tipsPageFrame();
            tipsPage.openTipsPage(tipsPage,true);

        }
        if (e.getSource() == accountSittings){

            this.toFront();
            setVisible(false);
            accountSittings sittings = new accountSittings();//todo sittings
            sittings.username = this.accountUsername;
            sittings.password = this.accountPassword;
            sittings.openSittingsPage(sittings,true);

        }
    }
}
