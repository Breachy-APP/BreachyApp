package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // Init page to open either sign Up or Login page
        InitialPage initFrame = new InitialPage();
        initFrame.setTitle("Initial Form");
        initFrame.setVisible(true);
        initFrame.setBounds(600, 150, 350, 500);
        initFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame.setResizable(false);

    }
}
