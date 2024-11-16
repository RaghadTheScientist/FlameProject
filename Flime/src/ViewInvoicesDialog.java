import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;

public class ViewInvoicesDialog extends JDialog {

    private final JTable invoiceTable;
    private final JCheckBox completedOnlyCheckBox;
    private final JButton applyButton;
    private final DefaultTableModel tableModel;


    public ViewInvoicesDialog() {
        super((Dialog)null, "Invoices", true);
        setSize(600, 400);
        setLayout(new BorderLayout());

        
        tableModel = new DefaultTableModel(new String[]{"Invoice_ID", "Inv_Date", "Total_Price", "Order_Type","Completion"}, 0);
        invoiceTable = new JTable(tableModel);

        

        completedOnlyCheckBox = new JCheckBox("Only completed invoices");
        applyButton = new JButton("Apply");

        JPanel filterPanel = new JPanel();
        filterPanel.add(new JLabel("Filter:"));

        filterPanel.add(completedOnlyCheckBox);
        filterPanel.add(applyButton);

        add(filterPanel, BorderLayout.NORTH);
        add(new JScrollPane(invoiceTable), BorderLayout.CENTER);

        loadInvoices();

        applyButton.addActionListener(e -> applyFilter());
    }

    private void loadInvoices() {
        try {
            String url = FlameUI.DB_URL;
            String user = FlameUI.USER;
            String password = FlameUI.PASS;
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                String query = "SELECT * FROM INVOICE";
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {
                    int invoiceId = rs.getInt("Invoice_ID");
                    java.sql.Date invDate = rs.getDate("Inv_Date"); 
                    int totalPrice = rs.getInt("Total_Price"); 
                    String orderType = rs.getString("Order_Type"); 
                    String completion = Boolean.toString(rs.getBoolean("Completion"));
                    tableModel.addRow(new Object[]{invoiceId, invDate, totalPrice, orderType,completion});
                    }
                conn.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading invoices: " + ex.getMessage());
        }
    }

    private void applyFilter() {
        while(tableModel.getRowCount() > 0)
        {
            tableModel.removeRow(0);
        }
        boolean completedOnly = completedOnlyCheckBox.isSelected();
            if (completedOnly) {
               try {
            String url = FlameUI.DB_URL;
            String user = FlameUI.USER;
            String password = FlameUI.PASS;
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                String query = "SELECT * FROM INVOICE  WHERE Completion=true";
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {
                    int invoiceId = rs.getInt("Invoice_ID");
                    java.sql.Date invDate = rs.getDate("Inv_Date"); 
                    int totalPrice = rs.getInt("Total_Price"); 
                    String orderType = rs.getString("Order_Type"); 
                    String completion = Boolean.toString(rs.getBoolean("Completion"));
                    tableModel.addRow(new Object[]{invoiceId, invDate, totalPrice, orderType,completion});                   
                }
                conn.close();

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading invoices: " + ex.getMessage());
        }
            } else {
                try {
            String url = FlameUI.DB_URL;
            String user = FlameUI.USER;
            String password = FlameUI.PASS;
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                String query = "SELECT * FROM INVOICE";
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {
                    int invoiceId = rs.getInt("Invoice_ID");
                    java.sql.Date invDate = rs.getDate("Inv_Date"); 
                    int totalPrice = rs.getInt("Total_Price"); 
                    String orderType = rs.getString("Order_Type"); 
                    String completion = Boolean.toString(rs.getBoolean("Completion"));
                    tableModel.addRow(new Object[]{invoiceId, invDate, totalPrice, orderType,completion});
                    }
                conn.close();

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading invoices: " + ex.getMessage());
        }
            }

            
        
    }
}