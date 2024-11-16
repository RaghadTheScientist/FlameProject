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
    
        
      try {
            if(USER.equals("cashier")){
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery("SELECT C.cashier_id, C.phone_number, C.first_name,C.last_name,C.salary FROM cashier C WHERE cashier_id=ID");
           while(rs.next()){
                 jTextField1.setText(rs.getString("cashier_id")) ;
                 jTextField2.setText(rs.getString("first_name")) ;
                 jTextField3.setText(rs.getString("last_name")) ;
                 jTextField4.setText(rs.getString("phone_number")) ;
                 jTextField5.setText(rs.getString("salary")) ;
           }}
           
            else{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement ss = conn.createStatement();
            ResultSet rs = ss.executeQuery("SELECT P.preparer_id, P.phone_number, P.first_name,P.last_name,P.salary FROM food_preparer P WHERE preparer_id=ID");
           while(rs.next()){
                 jTextField1.setText(rs.getString("preparer_id")) ;
                 jTextField2.setText(rs.getString("first_name")) ;
                 jTextField3.setText(rs.getString("last_name")) ;
                 jTextField4.setText(rs.getString("phone_number")) ;
                 jTextField5.setText(rs.getString("salary")) ;
            }}
        } catch (SQLException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    

      
        
    }

    }
