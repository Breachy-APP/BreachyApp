package org.breachy;

import java.sql.*;

public class DBActions {
    private String username;
    private String password;
    private String Email;
    private String accountStatus;

    public DBActions(){

        String username = this.username;
        String password = this.password;

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
    public String retrieveAccountInfo(String AUsername, String APassword) {

        String AEmail,AStatus;
        AEmail = getEmail();
        AStatus = getAccountStatus();
        String accountData = "";
        accountSittings editData = new accountSittings();
        try{

            Connection dbConnection = DBConnection.getInstance().getConnection();

            Statement stmt = dbConnection.createStatement();
            String query = "select * from accounts;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                if (rs.getString("username").equals(AUsername) && rs.getString("upassword").equals(APassword)){
                    System.out.println(AUsername +" "+ APassword +" "+ AEmail +" "+ AStatus);
                    accountData = AUsername +" : "+ APassword +" : "+ AEmail +" : "+ AStatus;

                    accountSittings sittings = new accountSittings();
                    sittings.openSittingsPage(sittings,false);
                    sittings.setAccountData(accountData);
                }

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return accountData;
    }
    public boolean authorizeAccountAccess(String username, String password){
        boolean isAuth = false;
        String u,p,em,st;

        //todo
        try{

            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement stmt = dbConnection.createStatement();
            String query = "select * from accounts;";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                if(rs.getString("username").equals(username) && rs.getString("upassword").equals(password)){
                    System.out.println("Login Successfully");

                    setEmail(rs.getString("email"));

                    setAccountStatus("Active");


                    setUsername(this.username);
                    u= getUsername();
                    setPassword(this.password);
                    p = getPassword();
                    setEmail(this.Email);
                    em = getPassword();
                    setAccountStatus(this.accountStatus);
                    st = getAccountStatus();
                    System.out.println(u + "Checking " + p + " ");

                    System.out.println("siuuuuuuuuuuuuuuu " + retrieveAccountInfo(u,p));

                    isAuth = true;

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

    public void updateAccount(String data){

        try{

        System.out.println(data);
        String[] sData = new String[4];

        for (int i = 0; i < sData.length; i++) {
            if(sData[i] == null){
                data = retrieveAccountInfo(this.username, this.password);

            }
            else{
                sData = data.split(" : ");
            }
        }
            accountSittings u = new accountSittings();
            String uu = u.UB.getText();
            System.out.println(data);
            System.out.println(uu);
            Connection dbConnection = DBConnection.getInstance().getConnection();
            PreparedStatement updateStmt = dbConnection.prepareStatement("update accounts set username = ? where username = ?;");
            updateStmt.setString(1, sData[0]);
            updateStmt.setString(2,this.username);
            //updateStmt.setString(2,sData[1]);
            //updateStmt.setString(3,sData[2]);
            //updateStmt.setString(4,sData[3]);
            int rows = updateStmt.executeUpdate();

            System.out.println("Rows Updates: " + rows);
            System.out.println("Account is Updates Successfully");

        }catch (SQLException e){
            e.printStackTrace();
        }


        //todo

    }
    public void deleteAccount(String dUsername){

        try {
            Connection dbConnection = DBConnection.getInstance().getConnection();
            PreparedStatement deleteStmt = dbConnection.prepareStatement("Delete from accounts where username = ?;");
            deleteStmt.setString(1, dUsername);
            int rows = deleteStmt.executeUpdate();

            System.out.println("Rows Deleted: " + rows);
            if (rows >= 0 ) {

                InitialPage newProcess = new InitialPage();
                newProcess.openIntialPage(newProcess, true);
                System.out.println("Account is Deleted Successfully");

            }
            else{
                System.out.println("No Accoounts were found");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}


