package org.breachy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.net.URIBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class mainPageFrame extends JFrame implements ActionListener {
    static ImageIcon breachyLogo = new ImageIcon(mainPageFrame.class.getClassLoader().getResource("breachyLogo.jpg"));
    private final static String API_Report = "https://www.virustotal.com/vtapi/v2/file/report?";
    private final static String API_Scan = "https://www.virustotal.com/vtapi/v2/file/scan";
    public static File file;
    public static Scanner input = new Scanner(System.in);

    Container mainPageContainer = getContentPane();
    JLabel searchLabel = new JLabel("Search");
    static JTextField searchField = new JTextField();
    JButton searchButton = new JButton("Search");
    JCheckBoxMenuItem searchByID = new JCheckBoxMenuItem("Search By ID");
    JCheckBoxMenuItem searchBySystem = new JCheckBoxMenuItem("Search by System");
    JCheckBoxMenuItem searchByVersion = new JCheckBoxMenuItem("Search By Version");
    JCheckBoxMenuItem searchByKeyWord = new JCheckBoxMenuItem("General Search");
    JButton logOutButton = new JButton("LOGOUT");
    //tips page button
    JButton tipsButton = new JButton("TIPS");
    JButton accountSittings = new JButton("Account Settings");
    JToggleButton ChangeColor = new JToggleButton("Dark Mode");
    JButton virusButton = new JButton("Virus File Scan");
    JButton hashCheckButton = new JButton("Hash/ID Check");

    JButton softwareListsButton = new JButton("OS Types");

    String allAccountData;
//    String accountUsername;
//    String accountPassword;
//    String accountEmail;
//    String accountStatus;
    static String hashID;


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


        if (allAccountData != null) {
            logOutButton.setBounds(200, 400, 100, 30);
        } else {
            logOutButton.setBounds(125, 400, 100, 30);
            logOutButton.setText("Return");
        }


        accountSittings.setBounds(30, 400, 150, 30);
        tipsButton.setBounds(10, 49, 100, 30);
        virusButton.setBounds(100, 310, 150, 30);
        hashCheckButton.setBounds(100, 350, 150, 30);
        softwareListsButton.setBounds(100, 270, 150, 30);
        ChangeColor.setBounds(220, 49, 105, 30);

    }

    public void openMainPage(mainPageFrame mainFrame, boolean c) {

        mainFrame.setTitle("main page");
        mainFrame.setVisible(c);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setBounds(600, 150, 350, 500);
        mainFrame.setResizable(false);
        mainFrame.setIconImage(breachyLogo.getImage());

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


        if (allAccountData != null) {
            mainPageContainer.add(accountSittings);
        }

        mainPageContainer.add(tipsButton);
        mainPageContainer.setBackground(InitialPage.color);
        mainPageContainer.add(ChangeColor);
        mainPageContainer.add(virusButton);
        mainPageContainer.add(hashCheckButton);
        mainPageContainer.add(softwareListsButton);

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
        virusButton.addActionListener(this);
        hashCheckButton.addActionListener(this);
        softwareListsButton.addActionListener(this);
    }

    public void setLayoutManager() {
        mainPageContainer.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        SearchTool searchForBreach = new SearchTool();

        if (e.getSource() == searchButton) {
            if (searchField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Field is empty!");
            } else {
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

                String[] allDataArr = allAccountData.split(" : ");
                for (int i = 0; i < allDataArr.length; i++) {
                    System.out.println(allDataArr[i]);
                }

                accountSittings sittings = new accountSittings();
                sittings.setUsername(allDataArr[0]);
                sittings.setPassword(allDataArr[1]);
                sittings.setEmail(allDataArr[2]);
                sittings.setStatus(allDataArr[3]);

                sittings.openSittingsPage(sittings, true);

            }
            if (ChangeColor.isSelected()) {
                InitialPage.color = new Color(40, 40, 40);
                mainPageContainer.setBackground(InitialPage.color);
                searchByID.setBackground(InitialPage.color);
                searchBySystem.setBackground(InitialPage.color);
                searchByVersion.setBackground(InitialPage.color);
                searchByKeyWord.setBackground(InitialPage.color);
                ChangeColor.setText("Light Mode");
            } else {
                InitialPage.color = new Color(93, 93, 112);
                mainPageContainer.setBackground(InitialPage.color);
                searchByID.setBackground(InitialPage.color);
                searchBySystem.setBackground(InitialPage.color);
                searchByVersion.setBackground(InitialPage.color);
                searchByKeyWord.setBackground(InitialPage.color);
                ChangeColor.setText("Dark Mode");
            }

            if (e.getSource() == virusButton) {
                try {
                    VirusScan();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

            }
            if (e.getSource() == hashCheckButton) {
                VirusReport();
            }

            if (e.getSource() == softwareListsButton) {
                this.toFront();
                setVisible(false);
                SoftwareListsFrame softPage = new SoftwareListsFrame();


            }
        }

    public static void VirusScan() throws IOException, InterruptedException {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(".")); //sets current directory

        int r = fileChooser.showOpenDialog(null); //select file to open
        if (r == JFileChooser.APPROVE_OPTION) {
            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
        } else if (r == JFileChooser.CANCEL_OPTION)
            return;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_Scan))
                .header("accept", "text/plain")
                .header("content-type", "application/x-www-form-urlencoded")
                .method("POST", HttpRequest.BodyPublishers.ofString("apikey=781dc33df7ae27f765cf69c4f0f6c87cc159a5260fdf2c132a5eada8dc229fac&file=" + file))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        if (response != null) {
            //System.out.println(response.body());
            ScanInfo sInfo = parseVirusScanResponse(response.body(), ScanInfo.class);
            JOptionPane.showMessageDialog(null, sInfo);
        }

    }

    public static ScanInfo parseVirusScanResponse(String responseString, Class<?> elementClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode ScanInfoNode = objectMapper.readTree(responseString);
            ScanInfo sInfo = new ScanInfo();
            String verbose_msg = ScanInfoNode.get("verbose_msg").toString();
            String permalink = ScanInfoNode.get("permalink").toString();
            String scan_id = ScanInfoNode.get("scan_id").toString();

            sInfo.setScan_id(scan_id);
            sInfo.setVerbose_msg(verbose_msg);
            sInfo.setPermalink(permalink);

            return sInfo;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e);
            return null;
        }

    }

    public static void VirusReport() {
        URIBuilder uriBuilder = null;
        hashID = searchField.getText();
        try {
            uriBuilder = new URIBuilder(API_Report);
            uriBuilder.addParameter("apikey", System.getenv("API_KEY"));
            uriBuilder.addParameter("resource", hashID);
            uriBuilder.addParameter("allinfo", "false");
            URI uri = uriBuilder.build();
            HttpResponse<String> response = httpAPI.sendGet(uri);
            if (response != null) {

                VirusInfo vInfo = parseVirusResponse(response.body(), VirusInfo.class);
                JOptionPane.showMessageDialog(null, vInfo);
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter SCAN ID OR FILE HASH !");
        }

    }

    public static VirusInfo parseVirusResponse(String responseString, Class<?> elementClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode VirusInfoNode = objectMapper.readTree(responseString);
            VirusInfo vInfo = new VirusInfo();
            String detected = VirusInfoNode.get("scans").get("McAfee").get("detected").toString();
            String result = VirusInfoNode.get("scans").get("McAfee").get("result").toString();

            vInfo.setDetected(detected);
            vInfo.setResult(result);

            return vInfo;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
