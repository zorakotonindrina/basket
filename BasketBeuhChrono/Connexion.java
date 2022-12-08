package connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Connexion{
    Connection con;
   
    public Connexion() throws Exception{
       
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/basket","postgres","001836");

            // Class.forName("oracle.jdbc.driver.OracleDriver");
            // con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","itu","1836");
            //System.out.println(getCon());
            //con.close();
    }
    public Connection getCon() {
        return con;
    }
    public void setCon(Connection con) {
        this.con = con;
    }
   
    
}