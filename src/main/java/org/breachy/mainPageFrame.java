package org.breachy;

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
    JMenuItem x = new JMenuItem("X"); // todo
    //tips page button
    JButton tipsButton = new JButton("TIPS");

    JButton accountSittings = new JButton("Account Settings");

    JToggleButton ChangeColor = new JToggleButton("Dark Theme");


    String accountUsername;
    String accountPassword;

    mainPageFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }


    public void setLocationAndSize() {

        searchLabel.setBounds(13, 15, 100, 30);
        searchLabel.setForeground(Color.white);
        searchField.setBounds(12, 15, 300, 25);

        searchButton.setBounds(115, 49, 100, 30);

        searchByID.setBounds(105, 100, 150, 30);
        searchByID.setForeground(Color.white);
        searchByID.setBackground(InitialPage.color);

        searchBySystem.setBounds(105, 130, 150, 30);
        searchBySystem.setForeground(Color.white);
        searchBySystem.setBackground(InitialPage.color);

        searchByVersion.setBounds(105, 160, 150, 30);
        searchByVersion.setForeground(Color.white);
        searchByVersion.setBackground(InitialPage.color);

        searchByKeyWord.setBounds(105, 190, 150, 30);
        searchByKeyWord.setForeground(Color.white);
        searchByKeyWord.setBackground(InitialPage.color);

        logOutButton.setBounds(200, 400, 100, 30);
        accountSittings.setBounds(30, 400, 150, 30);

        menuBar.setBounds(500, 500, 300, 30);


        tipsButton.setBounds(10, 49, 100, 30);

        ChangeColor.setBounds(220, 49, 105, 30);

    }

    public void openMainPage(mainPageFrame mainFrame, boolean c) {

        mainFrame.setTitle("main page");
        mainFrame.setVisible(c);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setBounds(600, 150, 350, 500);
        mainFrame.setResizable(false);

    }

    public void addComponentsToContainer() {

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
        mainPageContainer.setBackground(InitialPage.color);
        mainPageContainer.add(ChangeColor);

    }

    public void addActionEvent() {

        searchButton.addActionListener(this);
        logOutButton.addActionListener(this);
        accountSittings.addActionListener(this);
        searchByID.addActionListener(this);
        searchBySystem.addActionListener(this);
        searchByVersion.addActionListener(this);
        searchByKeyWord.addActionListener(this);
        tipsButton.addActionListener(this);
        ChangeColor.addActionListener(this);
    }

    public void setLayoutManager() {
        mainPageContainer.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        SearchTool searchForBreach = new SearchTool();

        if (e.getSource() == searchButton) {

            String searchID, searchSys, searchVersion, searchGen;
            String theBreach = "";

            if (searchByID.isSelected()) {

                searchID = searchField.getText();
                theBreach = searchForBreach.searchByID(searchID);

            }
            if (searchBySystem.isSelected()) {

                searchSys = searchField.getText();
                theBreach = searchForBreach.searchBySystem(searchSys);


            }
            if (searchByVersion.isSelected()) {

                searchVersion = searchField.getText();
                theBreach = searchForBreach.searchByVersion(searchVersion);

            }
            if (searchByKeyWord.isSelected()) {

                searchGen = searchField.getText();
                theBreach = searchForBreach.searchByDescription(searchGen);

            }
            if ((!searchByID.isSelected()) && (!searchBySystem.isSelected()) && (!searchByVersion.isSelected()) && (!searchByKeyWord.isSelected())) {
                searchGen = searchField.getText();
                theBreach = searchForBreach.search(searchGen);

            }
            if (!theBreach.equalsIgnoreCase(" ")) {
                System.out.println("final result " + theBreach);
                JOptionPane.showMessageDialog(this, theBreach);
            }


        }
        if (e.getSource() == logOutButton) {

            JOptionPane.showMessageDialog(this, "Thank You For using Out Application");
            this.toBack();
            setVisible(false);
            InitialPage initFrame = new InitialPage();
            initFrame.openIntialPage(initFrame, true);

        }
        if (e.getSource() == tipsButton) {
            this.toFront();
            setVisible(false);
            tipsPageFrame tipsPage = new tipsPageFrame();
            tipsPage.openTipsPage(tipsPage, true);

        }
        if (e.getSource() == accountSittings) {

            this.toFront();
            setVisible(false);
            accountSittings sittings = new accountSittings();
            sittings.openSittingsPage(sittings, true);

        }
        if (ChangeColor.isSelected()) {
            InitialPage.color = new Color(40, 40, 40);
            mainPageContainer.setBackground(InitialPage.color);
            searchByID.setBackground(InitialPage.color);
            searchBySystem.setBackground(InitialPage.color);
            searchByVersion.setBackground(InitialPage.color);
            searchByKeyWord.setBackground(InitialPage.color);
            ChangeColor.setText("Light Theme");
        } else {
            InitialPage.color = new Color(160, 160, 170);
            mainPageContainer.setBackground(InitialPage.color);
            searchByID.setBackground(InitialPage.color);
            searchBySystem.setBackground(InitialPage.color);
            searchByVersion.setBackground(InitialPage.color);
            searchByKeyWord.setBackground(InitialPage.color);
            ChangeColor.setText("Dark Theme");
        }
    }
}
