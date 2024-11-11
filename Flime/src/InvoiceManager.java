import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceManager {//i write it for Food Preparer

    // all completionState = false
    public List<Invoice> getPendingInvoices() throws SQLException {
        List<Invoice> invoices = new ArrayList<>();
        String query = "SELECT * FROM INVOICE WHERE Completion = false";
        
            // ResultSet rs = stmt.executeQuery(query)

           // while (rs.next()) {
               
                //    String Invoice_ID=String.valueOf( rs.getInt("Invoice_ID"));
                    
                  // boolean Completion= rs.getBoolean("Completion");
                   
                  // String Order_Type= rs.getString("Order_Type");
                
                        
                   // String tbData[] = {Invoice_ID, Completion, Order_Type};
              
             
         //   }
       // }
        return invoices;
    }

    // update completionState to true 
    public void completeInvoice(int invoiceId) throws SQLException {
        String query = "UPDATE INVOICE SET Completion = true WHERE Invoice_ID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, invoiceId);
            stmt.executeUpdate();
        }
    }
}
