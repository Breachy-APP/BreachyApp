package org.example;

import java.sql.*;

public class DBActions {
    private String username;
    private String password;
    private String Email;
    private String accountStatus;
    public DBActions(){

    }
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
    public void setAccountStatus(String accountStatus){
        this.accountStatus = accountStatus;
    }
    public String getAccountStatus(){
        return this.accountStatus;
    }

    public void insertAccount(){
        //todo
        try {
            Connection dbConnection = DBConnection.getInstance().getConnection();
            PreparedStatement insertStmt = dbConnection.prepareStatement("Insert into accounts(username, upassword, Email, accountStatus) Values (?, ?, ?, ?);");
            insertStmt.setString(1, this.username);
            insertStmt.setString(2,this.password);
            insertStmt.setString(3,this.Email);
            insertStmt.setString(4,"InActive");
            int rows = insertStmt.executeUpdate();

            System.out.println("Rows Inserted: " + rows);
            System.out.println("New Account is Inserted Successfully");
        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }
    public void retrieveAccountInfo(String username, String password) {
        String email;
        String status;

        try{

            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement stmt = dbConnection.createStatement();
            String query = "Select * from accounts;";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                if (rs.getString("username").equals(username) && rs.getString("upassword").equals(password)){

                    email = rs.getString("email");
                    status = rs.getString("accountStatus");
                    //todo


                }

            }



        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public boolean authorizeAccountAccess(String username, String password){
        boolean isAuth = false;
        //todo
        try{

            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement stmt = dbConnection.createStatement();
            String query = "select username, upassword from accounts;";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                if(rs.getString("username").equals(username) && rs.getString("upassword").equals(password)){
                    System.out.println("Login Successfully");
                    setAccountStatus("Active");

                    isAuth = true;

                    // todo app accessed page
                }
                else{
                    System.out.println("No match, searching...");

                }
            }


        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return isAuth;
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


    public String searchForBreach(String searchFor){
        String req = searchFor;
        String result = null;
        SearchTool st = new SearchTool();

        try {
            Connection dbConnection = DBConnection.getInstance().getConnection();
             Statement Stmt = dbConnection.createStatement();
            String query = "Select * from breaches;";
            ResultSet rs = Stmt.executeQuery(query);
            while(rs.next()){
                if (rs.getString("breachSystem").equalsIgnoreCase(req)){
                    result = rs.getString("breachDescription");


                }
                else{
                    result = "No Matches";

                }

            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public void updateAccount(){
        //todo

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
}


