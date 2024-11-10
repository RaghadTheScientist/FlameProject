import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceManager {

    // all completionState = false
    public List<Invoice> getPendingInvoices() throws SQLException {
        List<Invoice> invoices = new ArrayList<>();
        String query = "SELECT * FROM invoice WHERE completionState = false";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Invoice invoice = new Invoice(
                    rs.getInt("invoice_id"),
                    rs.getInt("cashier_id"),
                    rs.getInt("preparer_id"),
                    rs.getString("invoice_date"),
                    rs.getString("invoice_time"),
                    rs.getBoolean("completionState"),
                    rs.getDouble("total_price"),
                    rs.getString("order_type"),
                    rs.getString("payment_type")
                );
                invoices.add(invoice);
            }
        }
        return invoices;
    }

    // update completionState to true 
    public void completeInvoice(int invoiceId) throws SQLException {
        String query = "UPDATE invoice SET completionState = true WHERE invoice_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, invoiceId);
            stmt.executeUpdate();
        }
    }
}
