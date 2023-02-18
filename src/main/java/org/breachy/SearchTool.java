package org.breachy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.DoubleToIntFunction;

public class SearchTool {
    String breachID;
    String breachSystem;
    String breachSysVersion;
    String breachDescription;
    String errorResult = "Error!";

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
        System.out.println(breachID);
        String result = null;

        try {

            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement Stmt = dbConnection.createStatement();
            String query = "Select * from breaches;";
            ResultSet rs = Stmt.executeQuery(query);

            while (rs.next()) {
                if (rs.getString("breachid").equalsIgnoreCase(breachID) || rs.getString("breachsystem").equalsIgnoreCase(breachID) || rs.getString("breachsysversion").equalsIgnoreCase(breachID) || rs.getString("breachDescription").equalsIgnoreCase(breachID)) {
                    result = rs.getString("breachid") + " : "
                            + rs.getString("breachsystem") + " : "
                            + rs.getString("breachsysversion") + " : "
                            +rs.getString("breachDescription") ;
                    return result;
                } else {
                    result = "No Matches";

                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return errorResult;
    }
    public  String searchBySystem(String breachSystem){
        System.out.println(breachSystem +"???");
        String result = null;

        try {

            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement Stmt = dbConnection.createStatement();
            String query = "Select * from breaches;";
            ResultSet rs = Stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("breachid").equalsIgnoreCase(breachSystem) || rs.getString("breachsystem").equalsIgnoreCase(breachSystem) || rs.getString("breachsysversion").equalsIgnoreCase(breachSystem) || rs.getString("breachDescription").equalsIgnoreCase(breachSystem)) {
                    result = rs.getString("breachid") + " : "
                            + rs.getString("breachsystem") + " : "
                            + rs.getString("breachsysversion") + " : "
                            +rs.getString("breachDescription") ;
                    return result;
                } else {
                    result = "No Matches";

                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return errorResult;
    }
    public String searchByVersion(String breachSysVersion){
        System.out.println(breachSysVersion);
        String result = null;

        try {

            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement Stmt = dbConnection.createStatement();
            String query = "Select * from breaches;";
            ResultSet rs = Stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("breachid").equalsIgnoreCase(breachSysVersion) || rs.getString("breachsystem").equalsIgnoreCase(breachSysVersion) || rs.getString("breachsysversion").equalsIgnoreCase(breachSysVersion) || rs.getString("breachDescription").equalsIgnoreCase(breachSysVersion)) {
                    result = rs.getString("breachid") + " : "
                            + rs.getString("breachsystem") + " : "
                            + rs.getString("breachsysversion") + " : "
                            +rs.getString("breachDescription") ;
                    return result;
                } else {
                    result = "No Matches";

                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return errorResult;

    }
    public String searchByDescription(String breachDescription){
        System.out.println(breachDescription);
        String result = null;

        try {

            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement Stmt = dbConnection.createStatement();
            String query = "Select * from breaches;";
            ResultSet rs = Stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("breachid").equalsIgnoreCase(breachDescription) || rs.getString("breachsystem").equalsIgnoreCase(breachDescription) || rs.getString("breachsysversion").equalsIgnoreCase(breachDescription) || rs.getString("breachDescription").equalsIgnoreCase(breachDescription)) {
                    result = rs.getString("breachid") + " : "
                            + rs.getString("breachsystem") + " : "
                            + rs.getString("breachsysversion") + " : "
                            +rs.getString("breachDescription") ;
                    return result;
                } else {
                    result = "No Matches";

                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return errorResult;
    }

    public String search(String req) {

        String result = null;

        try {

            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement Stmt = dbConnection.createStatement();
            String query = "Select * from breaches;";
            ResultSet rs = Stmt.executeQuery(query);

            while (rs.next()) {
                if (rs.getString("breachid").equalsIgnoreCase(req) || rs.getString("breachsystem").equalsIgnoreCase(req) || rs.getString("breachsysversion").equalsIgnoreCase(req) || rs.getString("breachDescription").equalsIgnoreCase(req)) {

                    result = rs.getString("breachid") + " : "
                            + rs.getString("breachsystem") + " : "
                            + rs.getString("breachsysversion") + " : "
                            +rs.getString("breachDescription") ;
                    return result;

                } else {
                    result = "No Matches";

                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return errorResult;
    }
}