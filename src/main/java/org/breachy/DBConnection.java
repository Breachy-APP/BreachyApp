
package org.breachy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
    public class DBConnection {
        private final String url;
        private final int port;
        private final String DBName;
        private Connection connection;
        private static org.breachy.DBConnection instance;

        // SECRET TODO
        private final String DBUsername = System.getenv("DB_Username");
        private final String DBPassword = System.getenv("DB_Password");

        private DBConnection() throws SQLException {

            this.DBName = "BreachyAppDB";
            this.port = 5432;
            this.url = "jdbc:postgresql://localhost:" + Integer.toString(this.port) + "/" + this.DBName;

            Properties props = new Properties();
            props.setProperty("user", DBUsername);
            props.setProperty("password", DBPassword);
            props.setProperty("ssl", "false");

            this.connection = DriverManager.getConnection(url, props);

        }
        public Connection getConnection(){
            return this.connection;
        }
        public static DBConnection getInstance() throws SQLException{
            if (instance == null){
                instance = new DBConnection();
            }
            else if(instance.getConnection().isClosed()){
                instance = new DBConnection();
            }
            return instance;
        }
    }