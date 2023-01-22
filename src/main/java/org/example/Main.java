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
        initFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame.setResizable(false);

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con= DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe","system","IVIeeZo_2015");

        Statement stmt=con.createStatement();

        ResultSet rs=stmt.executeQuery("select * from breachyAppTest");
        while(rs.next()){

            System.out.println(rs.getString("username")+rs.getString("password"));
        }
        con.close();
    }
}
