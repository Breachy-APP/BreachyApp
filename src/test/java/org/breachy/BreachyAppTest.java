package org.breachy;

import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BreachyAppTest {

    private final InitialPage initialPage = new InitialPage();
    private final LoginFrame loginFrame = new LoginFrame();
    private final SignUpFrame signUpFrame = new SignUpFrame();
    private final mainPageFrame mainPage = new mainPageFrame();
    private final tipsPageFrame tipsPageFrame = new tipsPageFrame();
    private final DBActions dbActions = new DBActions();
    private final DBActions dbActions2 = new DBActions("Test","Test", "Test@.com");
    private final DBActions dbActions3 = new DBActions("Test","Test");

    private final Main main = new Main();

    @Test
    void MainTest(){

        initialPage.openIntialPage(initialPage,true);

    }

    @Test
    void MainPageTest() throws IOException, InterruptedException {

        mainPage.openMainPage(mainPage, true);
        mainPage.setLayoutManager();
        mainPage.setLocationAndSize();
        mainPage.addComponentsToContainer();
        mainPage.addActionEvent();
        mainPage.actionPerformed(new ActionEvent(mainPage, 3,"test"));
        mainPage.VirusScan();
        //mainPage.parseVirusScanResponse("Test", ScanInfo.class);
        mainPage.VirusReport();
        //mainPage.parseVirusResponse("Test", VirusInfo.class);


    }

    @Test
    void initialPageTest(){

        initialPage.openIntialPage(initialPage, true);
        initialPage.openLogInForm(true);
        initialPage.openSignInForm(true);
        initialPage.setLayoutManager();
        initialPage.setInitPageLocation();
        initialPage.addComponentsToContainer();
        initialPage.addActionEvent();
        initialPage.actionPerformed(new ActionEvent(initialPage, 4,"test"));

    }

    @Test
    void TipPageTest() {

        tipsPageFrame.openTipsPage(tipsPageFrame, true);
        tipsPageFrame.setLayoutManager();
        tipsPageFrame.setLocation();
        tipsPageFrame.addComponentsToContainer();
        tipsPageFrame.addActionEvent();
        tipsPageFrame.actionPerformed(new ActionEvent(tipsPageFrame, 2,"test"));

    }
    @Test
    void loginPageTest() {

        initialPage.openLogInForm(true);
        loginFrame.setLayoutManager();
        loginFrame.setLocationAndSize();
        loginFrame.addComponentsToContainer();
        loginFrame.addActionEvent();
        loginFrame.actionPerformed(new ActionEvent(loginFrame, 2,"test"));


    }
    @Test
    void signUpPageTest(){

        initialPage.openSignInForm(true);
        signUpFrame.setLayoutManager();
        signUpFrame.setLocation();
        signUpFrame.addComponentsToContainer();
        signUpFrame.addActionEvent();
        signUpFrame.actionPerformed(new ActionEvent(signUpFrame, 2,"test"));

        signUpFrame.agreement.setSelected(true);
        assertEquals(true, signUpFrame.isComplete("D","d@.com","d","d"));
        assertEquals(false, signUpFrame.isComplete("","","",""));
        assertEquals(false, signUpFrame.isComplete("Test","","Test",""));
        signUpFrame.agreement.setSelected(false);
        assertEquals(false, signUpFrame.isComplete("","","",""));


    }

    @Test
    void DBActionsTest(){


        dbActions.setUsername("Test");
        dbActions.getUsername();
        dbActions.setPassword("Test");
        dbActions.getPassword();
        dbActions.setEmail("Test@g.com");
        dbActions.getEmail();
        dbActions.setAccountStatus("Test");
        dbActions.getAccountStatus();

        assertEquals(true,  dbActions.authorizeAccountAccess("h", "h"));
        assertEquals(false, dbActions.authorizeAccountAccess("Test","test"));

        dbActions.insertAccount();
        dbActions.retrieveAccountInfo("test","test");
        assertEquals("hhh@.comActive", dbActions.retrieveAccountInfo("h","h"));

        assertEquals(true, dbActions.alreadyExists("h","h"));
        assertEquals(false,dbActions.alreadyExists("Test","test"));

        assertEquals(null, dbActions.searchForBreach("ff"));

        dbActions.updateAccount("h h h@.com UnActive");
        dbActions.deleteAccount("Test");


    }


}
