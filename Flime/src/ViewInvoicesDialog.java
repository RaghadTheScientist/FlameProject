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
    private final JTextField filterTextField;
    private final JCheckBox completedOnlyCheckBox;
    private final JButton applyButton;
    private final DefaultTableModel tableModel;
    private final TableRowSorter<DefaultTableModel> sorter;

    public ViewInvoicesDialog() {
        super((Dialog)null, "Invoices", true);
        setSize(600, 400);
        setLayout(new BorderLayout());

        
        tableModel = new DefaultTableModel(new String[]{"Invoice_ID", "Inv_Date", "Total_Price", "Order_Type"}, 0);
        invoiceTable = new JTable(tableModel);
        sorter = new TableRowSorter<>(tableModel);
        invoiceTable.setRowSorter(sorter);

        
        filterTextField = new JTextField(15);
        completedOnlyCheckBox = new JCheckBox("Only completed invoices");
        applyButton = new JButton("Apply");

        JPanel filterPanel = new JPanel();
        filterPanel.add(new JLabel("Filter:"));
        filterPanel.add(filterTextField);
        filterPanel.add(completedOnlyCheckBox);
        filterPanel.add(applyButton);

        add(filterPanel, BorderLayout.NORTH);
        add(new JScrollPane(invoiceTable), BorderLayout.CENTER);

        loadInvoices();

        applyButton.addActionListener(e -> applyFilter());
    }

    private void loadInvoices() {
        try {
            String url = "jdbc:mysql://localhost:3306/flame";
            String user = "root";
            String password = "1234";
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                String query = "SELECT * FROM INVOICE";
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {
    int invoiceId = rs.getInt("Invoice_ID");
    java.sql.Date invDate = rs.getDate("Inv_Date"); 
    int totalPrice = rs.getInt("Total_Price"); 
    String orderType = rs.getString("Order_Type"); 

    tableModel.addRow(new Object[]{invoiceId, invDate, totalPrice, orderType});
}

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading invoices: " + ex.getMessage());
        }
    }

    private void applyFilter() {
        String text = filterTextField.getText();
        boolean completedOnly = completedOnlyCheckBox.isSelected();

        
        RowFilter<DefaultTableModel, Object> rf = null;
        try {
            if (completedOnly && text.trim().length() > 0) {
                rf = RowFilter.regexFilter(text, 1);
                rf = RowFilter.andFilter(java.util.List.of(rf, RowFilter.regexFilter("Completed", 4)));
            } else if (completedOnly) {
                rf = RowFilter.regexFilter("Completed", 4);
            } else if (text.trim().length() > 0) {
                rf = RowFilter.regexFilter(text, 1);
            }

            sorter.setRowFilter(rf);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid filter: " + ex.getMessage());
        }
    }
}