package org.breachy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchTool {
    String breachID;
    String breachSystem;
    String breachSysVersion;
    String breachDescription;
    DBActions searching = new DBActions();
    public SearchTool(){

    }
    public SearchTool(String breachID, String breachSystem, String breachSysVersion, String breachDescription){

        this.breachID = breachID;
        this.breachSystem = breachSystem;
        this.breachSysVersion = breachSysVersion;
        this.breachDescription = breachDescription;

    }

    public String searchByID(String breachID){

        String result = null;

        try {

            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement Stmt = dbConnection.createStatement();
            String query = "Select * from breaches;";
            ResultSet rs = Stmt.executeQuery(query);

            while (rs.next()) {
                if (rs.getString("breachid").equalsIgnoreCase(breachID)) {
                    result = rs.getString("breachid");


                } else {
                    result = "No Matches";

                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    public  String searchBySystem(String breachSystem){
        String result = null;

        try {

            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement Stmt = dbConnection.createStatement();
            String query = "Select * from breaches;";
            ResultSet rs = Stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("breachsystem").equalsIgnoreCase(breachSystem)) {
                    result = rs.getString("breachsystem");


                } else {
                    result = "No Matches";

                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;

    }
    public String searchByVersion(String breachSysVersion){
        String result = null;

        try {

            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement Stmt = dbConnection.createStatement();
            String query = "Select * from breaches;";
            ResultSet rs = Stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("breachSysVersion").equalsIgnoreCase(breachSysVersion)) {
                    result = rs.getString("breachSysVersion");


                } else {
                    result = "No Matches";

                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;

    }
    public String searchByDescription(String breachDescription){
        String result = null;

        try {

            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement Stmt = dbConnection.createStatement();
            String query = "Select * from breaches;";
            ResultSet rs = Stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("breachDescription").equalsIgnoreCase(breachDescription)) {
                    result = rs.getString("breachDescription");


                } else {
                    result = "No Matches";

                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }


    public void search(String req) {

    }
}