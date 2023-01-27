package org.example;
import java.sql.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Init page to open either sign Up or Login page
        InitialPage initFrame = new InitialPage();
        initFrame.setTitle("Initial Form");
        initFrame.setVisible(true);
        initFrame.setBounds(600, 150, 350, 500);
        initFrame.setResizable(false);






    }
}
