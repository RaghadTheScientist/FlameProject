import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conn {
    public static final String  DB_URL = "jdbc:mysql://localhost:3306/flame";
    public static final String  USER = "root";
    public static final String  PASS = "1234";
    
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery("SELECT I.Invoice_ID, I.Inv_Time, I.Inv_Date FROM INVOICE I");
            while(rs.next()){
                System.out.println("ID :" + rs.getInt("I.Invoice_ID"));
                
        }
        } catch (SQLException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    }
