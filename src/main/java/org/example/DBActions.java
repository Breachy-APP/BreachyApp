package org.example;

import java.sql.*;

public class DBActions {
    private String username;
    private String password;

    private String Email;

    public DBActions(String username, String password, String Email){
        this.username = username;
        this.password = password;
        this.Email = Email;
    }
    public DBActions(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail(){
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void insertAccount(){
        //todo
        try {
            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement stmt = dbConnection.createStatement();
            PreparedStatement insertStmt = dbConnection.prepareStatement("Insert into accounts(username, upassword, Email) Values (?, ?, ?);");
            insertStmt.setString(1, this.username);
            insertStmt.setString(2,this.password);
            insertStmt.setString(3,this.Email);
            int rows = insertStmt.executeUpdate();

            System.out.println("Rows Inserted: " + rows);
        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }

    public void retrieveAccountInfo(String username, String password){
        //todo
        try{

            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement stmt = dbConnection.createStatement();
            String query = "select username, upassword from accounts;";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                if(rs.getString("username").equals(username) && rs.getString("upassword").equals(password)){
                    System.out.println("Login Successfully");
                    // todo app accessed page
                }
                else{
                    System.out.println("searching...");
                }
            }


        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public boolean alreadyExists(String username, String password){
        boolean exists = false;
        try {
            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement stmt = dbConnection.createStatement();
            String query = "select username, upassword from accounts;";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                if(rs.getString("username").equals(this.username) && rs.getString("upassword").equals(this.password)){
                    exists = true;
                }
                else{
                    exists = false;
                }
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return exists;
    }
    public void deleteAccount(){
        //todo  needs a GUI DELETE Button
        try {
            Connection dbConnection = DBConnection.getInstance().getConnection();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void updateAccount(){
        //todo
    }
}


