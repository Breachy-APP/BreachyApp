package org.breachy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


    public class tipsPageFrame extends JFrame implements ActionListener {

        Container tipsPageContainer = getContentPane();

        JLabel tipsLabel = new JLabel("Tips:");
        JLabel firewallTip = new JLabel("1. Use a firewall.");
        JLabel antiVirusTip = new JLabel("2. Install antivirus software.");
        JLabel complexPassTip = new JLabel("3. Use complex passwords.");
        JLabel upToDateTip = new JLabel("4. Keep your OS, apps and browser up-to-date.");
        JLabel ignoreSpamTip = new JLabel("5. Ignore spam.");
        JLabel backUpTip = new JLabel("6. Back up your computer.");
        JLabel secureNetworkTip = new JLabel("7. Secure your network.");
        JLabel awayPirateTip = new JLabel("8. Stay away from pirated material.");

        JLabel unsecuredWifiTip = new JLabel("9. Don’t use unsecured public Wi-Fi.");
        JButton returnButton = new JButton("Return");

        tipsPageFrame() {
            setLayoutManager();
            setLocation();
            addComponentsToContainer();
            addActionEvent();
        }

        public void openTipsPage(tipsPageFrame tipsFrame, boolean flag) {
            tipsFrame.setTitle("Tips Page");
            tipsFrame.setVisible(flag);
            tipsFrame.setBounds(600, 150, 350, 500);
            tipsFrame.setResizable(false);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == returnButton) {
                this.toBack();
                setVisible(false);
                mainPageFrame mainPage = new mainPageFrame();
                mainPage.openMainPage(mainPage, true);
            }
        }

        public void addActionEvent() {
            //Button that return to main page\
            returnButton.addActionListener(this);
        }

        public void addComponentsToContainer() {
            tipsLabel.setForeground(Color.white);
            firewallTip.setForeground(Color.white);
            antiVirusTip.setForeground(Color.white);
            complexPassTip.setForeground(Color.white);
            upToDateTip.setForeground(Color.white);
            ignoreSpamTip.setForeground(Color.white);
            backUpTip.setForeground(Color.white);
            secureNetworkTip.setForeground(Color.white);
            awayPirateTip.setForeground(Color.white);
            unsecuredWifiTip.setForeground(Color.white);

            tipsPageContainer.add(tipsLabel);
            tipsPageContainer.add(firewallTip);
            tipsPageContainer.add(antiVirusTip);
            tipsPageContainer.add(complexPassTip);
            tipsPageContainer.add(upToDateTip);
            tipsPageContainer.add(ignoreSpamTip);
            tipsPageContainer.add(backUpTip);
            tipsPageContainer.add(secureNetworkTip);
            tipsPageContainer.add(awayPirateTip);
            tipsPageContainer.add(unsecuredWifiTip);
            tipsPageContainer.add(returnButton);
            tipsPageContainer.setBackground(InitialPage.color);


        }

        public void setLocation() {

            tipsLabel.setBounds(12, 15, 300, 30);
            tipsLabel.setFont(new Font("Calibre", Font.BOLD, 20));
            firewallTip.setSize(300, 150);
            antiVirusTip.setSize(300, 200);
            complexPassTip.setSize(300, 250);
            upToDateTip.setSize(300, 300);
            ignoreSpamTip.setSize(300, 350);
            backUpTip.setSize(300, 400);
            secureNetworkTip.setSize(300, 450);
            awayPirateTip.setSize(300, 500);
            unsecuredWifiTip.setSize(300, 550);
            returnButton.setBounds(120, 400, 100, 30);


        }

        public void setLayoutManager() {
            tipsPageContainer.setLayout(null);
        }
    }
