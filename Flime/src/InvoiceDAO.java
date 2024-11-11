
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO {
    private Connection connection;

    public InvoiceDAO(Connection connection) {
        this.connection = connection;
    }

  
    public void addInvoice(Invoice invoice) throws SQLException {
        String sql = "INSERT INTO invoice (Invoice_ID,Inv_Time,Inv_Date, Total_Price, Completion, Order_Type ,Payment_Type ,C_ID , FP_ID ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, invoice.getInvoiceId());
        statement.setInt(2, invoice.getCashierId());
        statement.setInt(3, invoice.getPreparerId());
        statement.setString(4, invoice.getInvoiceDate());
        statement.setString(5, invoice.getInvoiceTime());
        statement.setBoolean(6, invoice.isCompletionState());
        statement.setDouble(7, invoice.getTotalPrice());
        statement.setString(8, invoice.getOrderType());
        statement.setString(9, invoice.getPaymentType());
        statement.executeUpdate();
    }


    public List<Invoice> getPendingInvoices(int limit) throws SQLException {
        List<Invoice> pendingInvoices = new ArrayList<>();
        String sql = "SELECT * FROM INVOICE WHERE completion_state = false LIMIT ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, limit);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int invoiceId = resultSet.getInt("Invoice_ID");
            int cashierId = resultSet.getInt("C_ID");
            int preparerId = resultSet.getInt("FP_ID");
            String invoiceDate = resultSet.getString("Inv_Date");
            String invoiceTime = resultSet.getString("Inv_Time");
            boolean completionState = resultSet.getBoolean("Completion");
            double totalPrice = resultSet.getDouble("Total_Price");
            String orderType = resultSet.getString("Order_Type");
            String paymentType = resultSet.getString("Payment_Type");

            Invoice invoice = new Invoice(invoiceId, cashierId, preparerId, invoiceDate, invoiceTime, completionState, totalPrice, orderType, paymentType);
            pendingInvoices.add(invoice);
        }

        return pendingInvoices;
    }

   
    public boolean getCompletionState(int invoiceId) throws SQLException {
        String sql = "SELECT Completion FROM INVOICE WHERE Invoice_ID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, invoiceId);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getBoolean("Completion");
        }
        return false; 
    }

    
    public void markInvoiceAsCompleted(int invoiceId) throws SQLException {
        String sql = "UPDATE INVOICE SET Completion = true WHERE Invoice_ID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, invoiceId);
        statement.executeUpdate();
    }

    
}
