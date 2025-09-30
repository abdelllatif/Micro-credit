package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private final String url = "jdbc:mysql://localhost:3306/Micro_Credit";
    private final String user = "root";
    private final String password = "";
    private  Connection conn=null;
    public Connection getConnection() {
        try {
            if(this.conn==null) {
              this.conn=  DriverManager.getConnection(url, user, password);
                System.out.println("good conn");
            }
            return conn;
        } catch (SQLException e) {
            System.out.println(" Erreur de connexion : " + e.getMessage());
            return null;
        }
    }
}
