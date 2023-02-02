package org.breachy;

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
        String res = searching.searchForBreach(breachID);
        return res;
    }
    public  String searchBySystem(String breachSystem){
        String res = searching.searchForBreach(breachSystem);
        return res;
        //todo

    }
    public String searchByVersion(String breachSysVersion){
        String res = searching.searchForBreach(breachSysVersion);
        return res;

    }
    public String searchByDescription(String breachDescription){
        String res = searching.searchForBreach(breachDescription);
        return res;
    }


}
