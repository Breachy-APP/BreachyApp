package org.breachy;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.sql.*;
import java.util.Base64;

public class DBActions {
    private String username;
    private String password;
    private String Email;
    public static String accountStatus;

    public DBActions(){

        String username = null;
        String password = null;
        String Email = null;
        String accountStatus = null;

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


//            //make the salt and the hash
//            byte[] salt = Base64.getDecoder().decode(saltString);
//            // Use the salt to generate a secret key
//            SecretKeySpec secretKey = new SecretKeySpec(salt, "AES");
//            Cipher cipher = Cipher.getInstance("AES");
//            cipher.init(Cipher.DECRYPT_MODE, secretKey);
//            byte[] decryptedPassword = cipher.doFinal(Base64.getDecoder().decode(storedPassword));


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
            String query = "select username, email from accounts;";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                if(rs.getString("username").equals(this.username) && rs.getString("email").equals(this.Email)){
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

            int rows = updateStmt.executeUpdate();

            System.out.println("Rows Updates: " + rows);
            if (rows > 0){
                System.out.println("Account is Updates Successfully");
            }
            else{
                System.out.println("Nothing is Updated");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
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
                System.out.println("No Accounts were found");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static boolean checkPassword(String username, String enteredPassword) {
        try {
            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT upassword, salt FROM accounts WHERE username = '" + username + "';");
            while (rs.next()) {
                String storedPassword = rs.getString("upassword");
                String saltString = rs.getString("salt");
                byte[] salt = Base64.getDecoder().decode(saltString);
                // Use the salt to generate a secret key
                SecretKeySpec secretKey = new SecretKeySpec(salt, "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                byte[] decryptedPassword = cipher.doFinal(Base64.getDecoder().decode(storedPassword));
                if (enteredPassword.equals(new String(decryptedPassword))) {
                    System.out.println("true");
                    return true;
                } else {
                    System.out.println("false");
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
        System.out.println("false");
        return false;
    }
}


