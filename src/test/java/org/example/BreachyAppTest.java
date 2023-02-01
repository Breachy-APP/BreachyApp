package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BreachyAppTest {

    private final mainPageFrame mainPage = new mainPageFrame();
    private final InitialPage initialPage = new InitialPage();
    private final tipsPageFrame tipsPageFrame = new tipsPageFrame();


    @Test
    void shouldDisplayMAINpage() {
        mainPage.openMainPage(mainPage, true);

    }

    @Test
    void shouldDisplayINITIALpage() {
        initialPage.openIntialPage(initialPage, true);

    }

    @Test
    void shouldDisplayTIPSpage() {
        tipsPageFrame.openTipsPage(tipsPageFrame, true);
    }


}
