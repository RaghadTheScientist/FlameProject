
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO {
    private Connection connection;

    public InvoiceDAO(Connection connection) {
        this.connection = connection;
    }

  
    public void addInvoice(Invoice invoice) throws SQLException {
        String sql = "INSERT INTO invoice (invoice_id, cashier_id, preparer_id, invoice_date, invoice_time, completion_state, total_price, order_type, payment_Type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
        String sql = "SELECT * FROM invoice WHERE completion_state = false LIMIT ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, limit);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int invoiceId = resultSet.getInt("invoice_id");
            int cashierId = resultSet.getInt("cashier_id");
            int preparerId = resultSet.getInt("preparer_id");
            String invoiceDate = resultSet.getString("invoice_date");
            String invoiceTime = resultSet.getString("invoice_time");
            boolean completionState = resultSet.getBoolean("completion_state");
            double totalPrice = resultSet.getDouble("total_price");
            String orderType = resultSet.getString("order_type");
            String paymentType = resultSet.getString("payment_type");

            Invoice invoice = new Invoice(invoiceId, cashierId, preparerId, invoiceDate, invoiceTime, completionState, totalPrice, orderType, paymentType);
            pendingInvoices.add(invoice);
        }

        return pendingInvoices;
    }

   
    public boolean getCompletionState(int invoiceId) throws SQLException {
        String sql = "SELECT completion_state FROM invoice WHERE invoice_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, invoiceId);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getBoolean("completion_state");
        }
        return false; 
    }

    
    public void markInvoiceAsCompleted(int invoiceId) throws SQLException {
        String sql = "UPDATE invoice SET completion_state = true WHERE invoice_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, invoiceId);
        statement.executeUpdate();
    }

    
}
