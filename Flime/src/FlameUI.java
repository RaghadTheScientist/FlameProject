import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.List;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.time.*;
import javax.swing.table.DefaultTableModel;
public class FlameUI extends javax.swing.JFrame {//test
public static final String  DB_URL = "jdbc:mysql://localhost/flame";
public static final String  USER = "root";
public static final String  PASS = "1234";

public static int ID ;
public static String EmployeeType;
public Queue<String> InvoiceItemList;
public String InvT1,InvT2;

//NADA========================================================================================
 //private JButton btnMyInformation, btnViewInvoices, btnCreateNewItem;
 private JButton[] btnCompleteInvoice = new JButton[4];
 private JTextPane[] textPaneInvoiceDetails= new JTextPane[4];
 private JPanel[] invoicePanels = new JPanel[4];
 //private DefaultTableModel model;
 //private JPanel centerPanel;
InvoiceManager invoiceManager;
DefaultTableModel tableModel;
 //NADA========================================================================================
 
 //JLabel P3Panel3 = new JLabel();
//JLabel waitingListLabel = new JLabel("Invoice Waiting List");
//JPanel waitingListPanel = new JPanel(new BorderLayout());
//JTable tableRemainingInvoice = new JTable();
 
DefaultTableModel waitingListModel ;


    public FlameUI() {
        initComponents();
        
        waitingListModel = new DefaultTableModel(new Object[]{"Invoice_ID", "Completion"}, 0); 
        tableRemainingInvoice.setModel(waitingListModel); 
        tableModel = new DefaultTableModel(new Object[]{"Item_ID", "Item_Name", "Category", "Quantity"}, 0); 
        currentInvoice.setModel(tableModel); 
       
    }

       /* waitingListModel = new DefaultTableModel();
        tableRemainingInvoice = new JTable(waitingListModel);
        waitingListModel.setColumnIdentifiers(new String[] {"Invoice ID", "Completion"});

        tableModel = new DefaultTableModel();
        currentInvoice = new JTable(tableModel);
        tableModel.setColumnIdentifiers(new String[] {"Item ID", "Item Name", "Category", "Quantity"});

        completeButton = new JButton("Complete");
        
        // Populate the tables
        populateTable();
        populateWaitingList();

        // Layout setup
         centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(invoiceLabe, BorderLayout.NORTH);
        centerPanel.add(new JScrollPane(currentInvoice), BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

         P3Panel3 = new JPanel(new BorderLayout());
        P3Panel3.add(P3P3Label1, BorderLayout.NORTH);
        P3Panel3.add(new JScrollPane(tableRemainingInvoice), BorderLayout.CENTER);
        add(P3Panel3, BorderLayout.SOUTH);

        add(completeButton, BorderLayout.SOUTH); // Add the "Complete" button

        // Handle the "Complete" button click
        jButton1.addActionListener(e -> {
            int selectedRow = currentInvoice.getSelectedRow();
            if (selectedRow != -1) {
                int invoiceId = (int) currentInvoice.getValueAt(selectedRow, 0);
                String sql = "UPDATE INVOICE SET Completion = true WHERE Invoice_ID = ?";
                try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, invoiceId);
                    stmt.executeUpdate();
                    // Refresh the tables
                    tableModel.setRowCount(0);
                    waitingListModel.setRowCount(0);
                    invoiceLabe.setText("");
                    populateTable();
                    populateWaitingList();
                } catch (SQLException ex) {
                    // Handle the exception
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }*/
     private void populateTable() {
        String sql = "SELECT i.Invoice_ID, t.Item_ID, t.Item_Name, t.Category, c.Quantity "
                   + "FROM INVOICE i "
                   + "JOIN CONSIST_OF c ON i.Invoice_ID = c.Inv_ID "
                   + "JOIN ITEM t ON c.I_ID = t.Item_ID "
                   + "WHERE i.Completion = false "
                   + "ORDER BY i.Invoice_ID ASC "
                   + "LIMIT 1";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            tableModel.setRowCount(0);
            if (rs.next()) {
                int invoiceId = rs.getInt("Invoice_ID");
                invoiceLabe.setText("Invoice #" + invoiceId);

                do {
                tableModel.addRow(new Object[]{
                    rs.getInt("Item_ID"),
                    rs.getString("Item_Name"),
                    rs.getString("Category"),
                    rs.getInt("Quantity")
                });
            } while (rs.next());
        } else {
            invoiceLabe.setText("No current invoice available.");
        }
        } catch (SQLException e) {
                    e.printStackTrace();
          JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
          // Handle the exception
        }
    }
   private void populateWaitingList() {
        String sql = "SELECT Invoice_ID, Completion FROM INVOICE WHERE Completion = false ";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            
            while (rs.next()) {
                waitingListModel.addRow(new Object[] {
                    rs.getInt("Invoice_ID"),
                    rs.getBoolean("Completion")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
            JOptionPane.showMessageDialog(this, " noo " + e.getMessage()); // Handle the exception
        }
    }
   
   private void completeInvoice() {
        int selectedRow = currentInvoice.getSelectedRow();
        if (selectedRow != -1) {
            int invoiceId = (int) currentInvoice.getValueAt(selectedRow, 0);
            String sql = "UPDATE INVOICE SET Completion = true WHERE Invoice_ID = ?";
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, invoiceId);
                stmt.executeUpdate();
                // Refresh the tables
                tableModel.setRowCount(0);
                waitingListModel.setRowCount(0);
                invoiceLabe.setText("");
                populateWaitingList();
                populateTable();
                
            } catch (SQLException ex) {
                ex.printStackTrace(); // Handle the exception
                 JOptionPane.showMessageDialog(this, "not complete" + ex.getMessage());
            }
        }
    }


       /* waitingListModel = new DefaultTableModel();
        tableRemainingInvoice = new JTable(waitingListModel);
        waitingListModel.setColumnIdentifiers(new String[] {"Invoice ID", "Completion"});
        
        
        
        // Populate the main table
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[] {"Item_ID", "Item_Name", "Category", "Quantity"});
        currentInvoice.setModel(tableModel);


                // Retrieve the next incomplete invoice
        String sql = "SELECT i.Invoice_ID, t.Item_ID, t.Item_Name, t.Category, c.Quantity "
                   + "FROM INVOICE i "
                   + "JOIN CONSISTS_OF c ON i.Invoice_ID = c.Inv_ID "
                   + "JOIN ITEM t ON c.LID = t.Item_ID "
                   //+ "WHERE i.Completion = false "
                   + "ORDER BY i.Invoice_ID ASC "
                   + "LIMIT 1";

       
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sys","root","2n4@060");
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                int invoiceId = rs.getInt("Invoice_ID");
                invoiceLabe.setText("Invoice #" + invoiceId);

                // Populate the main table
                do {
                    tableModel.addRow(new Object[] {
                        rs.getInt("Item_ID"),
                        rs.getString("Item_Name"),
                        rs.getString("Category"),
                        rs.getInt("Quantity")
                    });
                } while (rs.next());
            }
        } catch (SQLException e) {
            // Handle the exception
        }
        
                // Populate the waiting list table
        sql = "SELECT i.Invoice_ID, i.Order_Type, i.Completion "
            + "FROM INVOICE i ";
            //+ "WHERE i.Completion = false";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sys","root","2n4@060");
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                waitingListModel.addRow(new Object[] {
                    rs.getInt("Invoice_ID"),
                    rs.getString("Order_Type"),
                    rs.getBoolean("Completion")
                });
            }
        } catch (SQLException e) {
            // Handle the exception
        }//2
        
       /*         // Add the components to the GUI
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(invoiceLabel, BorderLayout.NORTH);
        tablePanel.add(new JScrollPane(jTable1), BorderLayout.CENTER);
        add(tablePanel, BorderLayout.CENTER);

        waitingListPanel.add(waitingListLabel, BorderLayout.NORTH);
        waitingListPanel.add(new JScrollPane(waitingListTable), BorderLayout.CENTER);
        add(waitingListPanel, BorderLayout.SOUTH);
        JButton completeButton = new JButton("Complete");
        
        add(completeButton, BorderLayout.SOUTH);*/

      /*  
        completeButton.addActionListener(e -> {
    int selectedRow = currentInvoice.getSelectedRow();
    if (selectedRow != -1) {
        int invoiceId = (int) currentInvoice.getValueAt(selectedRow, 0);
        String sqll = "UPDATE INVOICE SET Completion = true WHERE Invoice_ID = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sys","root","2n4@060");
             PreparedStatement stmt = conn.prepareStatement(sqll)) {
            stmt.setInt(1, invoiceId);
            stmt.executeUpdate();
            // Refresh the table with the next incomplete invoice
            tableModel.setRowCount(0);
            waitingListModel.setRowCount(0);
            invoiceLabe.setText("");
            populateTable();
            populateWaitingList();
        } catch (SQLException ex) {
            // Handle the exception
        }
    }
});
        
  pack();
  setLocationRelativeTo(null);   }  */ 
        
        
        
        

   
   //NADA========================================================================================    
   //this for Food Preparer Page NADA
      /*  
        btnMyInformation = new JButton("My Information");
        btnViewInvoices = new JButton("View Invoices");
        btnCreateNewItem = new JButton("Create New Item");
        
        btnCompleteInvoice[0]=new JButton();
        btnCompleteInvoice[1]=new JButton();
        btnCompleteInvoice[2]=new JButton();
        btnCompleteInvoice[3]=new JButton();
        
        textPaneInvoiceDetails[0] = new JTextPane();
        textPaneInvoiceDetails[1] = new JTextPane();
        textPaneInvoiceDetails[2] = new JTextPane();
        textPaneInvoiceDetails[3] = new JTextPane();
        
        invoicePanels[0]= new JPanel();
        invoicePanels[1]= new JPanel();
        invoicePanels[2]= new JPanel();
        invoicePanels[3]= new JPanel();
       
        invoiceManager = new InvoiceManager();
        //NADA========================================================================================
        
        //NADA========================================================================================
        // top
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(btnMyInformation);
        topPanel.add(btnViewInvoices);
        topPanel.add(btnCreateNewItem);
        getContentPane().add(topPanel, BorderLayout.NORTH);

        
         //middle
        centerPanel = new JPanel(new GridLayout(2, 2, 10, 10)); 
        for (int i = 0; i < 4; i++) {
            invoicePanels[i] = new JPanel(new BorderLayout()); 
            
           
            btnCompleteInvoice[i] = new JButton("Complete");
            
           
            textPaneInvoiceDetails[i] = new JTextPane();
            textPaneInvoiceDetails[i].setText("Invoice Details #" + (i + 1)); 
            textPaneInvoiceDetails[i].setEditable(false); 
            JScrollPane scrollPane = new JScrollPane(textPaneInvoiceDetails[i]);

           
            invoicePanels[i].add(scrollPane, BorderLayout.CENTER);
            invoicePanels[i].add(btnCompleteInvoice[i], BorderLayout.SOUTH);
            
            centerPanel.add(invoicePanels[i]);
        }
        getContentPane().add(centerPanel, BorderLayout.CENTER); */
        
        
        //bottom
        //DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        //tableRemainingInvoices = new JTable(model);
        //JScrollPane scrollPaneTable = new JScrollPane(tableRemainingInvoices);
        //getContentPane().add(scrollPaneTable, BorderLayout.SOUTH);

        
        // model = (DefaultTableModel)tableRemainingInvoice.getModel();
        //tableRemainingInvoice.setModel(model); 
        
        // String query = "SELECT * FROM invoice WHERE Completion = false";
        /*
         try (//Connection conn = DatabaseConnection.getConnection();
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost/sys","root","2n4@060");
           // PreparedStatement stmt = myCon.prepareStatement(query)) {//=================================================================
            Statement st= myCon.createStatement();
                 
            ResultSet rs = st.executeQuery(query);
            
            /* while(rs.next()){
               
                 String Invoice_ID=String.valueOf( rs.getInt("Invoice_ID"));
                    
                   //String Completion= rs.getBoolean("Completion");
                   
                 String Order_Type= rs.getString("Order_Type");
                
                   String tbData[] = {Invoice_ID, Order_Type};
              model = (DefaultTableModel)tableRemainingInvoice.getModel();
             
            }
        } catch (SQLException ex) {
        Logger.getLogger(FlameUI.class.getName()).log(Level.SEVERE, null, ex);
    }*/
     //NADA========================================================================================       

            
      //NADA========================================================================================  
       /* btnMyInformation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMyInformation();
            }
        });
        
         btnViewInvoices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllInvoices();
            }
        });

        btnCreateNewItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewItem();
            }
        });

        for (int i = 0; i < 4; i++) {
            final int index = i;
            btnCompleteInvoice[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    completeInvoice(index);
                }
            });
        }
        loadPendingInvoices();
    }*/
    //NADA========================================================================================

    //NADA========================================================================================
   /* private void displayMyInformation() {
        JOptionPane.showMessageDialog(this, "Display My Information - Fetch from DB");
    }

    private void displayAllInvoices() {
        JOptionPane.showMessageDialog(this, "Display All Invoices - Fetch from DB");
    }

    private void createNewItem() {
        JOptionPane.showMessageDialog(this, "Create New Item - Add to DB");
    }

    private void completeInvoice(int invoiceIndex) {
        try {
            int invoiceId = Integer.parseInt(textPaneInvoiceDetails[invoiceIndex].getName());
            invoiceManager.completeInvoice(invoiceId);
            JOptionPane.showMessageDialog(this, "Invoice #" + invoiceId + " completed.");
            loadPendingInvoices(); 
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error completing invoice.");
        }
    }

    private void loadPendingInvoices() {
        try {
            List<Invoice> pendingInvoices = invoiceManager.getPendingInvoices();
            for (int i = 0; i < 4; i++) {
                if (i < pendingInvoices.size()) {
                    Invoice invoice = pendingInvoices.get(i);
                    textPaneInvoiceDetails[i].setText("Invoice ID: " + invoice.getInvoiceId() +
                            "\nTotal Price: " + invoice.getTotalPrice() +
                            "\nDate: " + invoice.getInvoiceDate());
                    textPaneInvoiceDetails[i].setName(String.valueOf(invoice.getInvoiceId()));
                    btnCompleteInvoice[i].setEnabled(true);
                } else {
                    textPaneInvoiceDetails[i].setText("No Invoice");
                    textPaneInvoiceDetails[i].setName(null);
                    btnCompleteInvoice[i].setEnabled(false);
                }
            }
            updateRemainingInvoicesTable(pendingInvoices.subList(Math.min(4, pendingInvoices.size()), pendingInvoices.size()));
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading pending invoices.");
        }
    }

    private void updateRemainingInvoicesTable(List<Invoice> remainingInvoices) {
        DefaultTableModel model = (DefaultTableModel) tableRemainingInvoice.getModel();
        model.setRowCount(0); 
        for (Invoice invoice : remainingInvoices) {
            model.addRow(new Object[]{invoice.getInvoiceId(), "Pending", invoice.getTotalPrice()});
        }
    }*/
    //NADA========================================================================================
    
    /*
    private void populateTable() {
        String sql = "SELECT i.Invoice_ID, t.Item_ID, t.Item_Name, t.Category, c.Quantity "
                   + "FROM INVOICE i "
                   + "JOIN CONSISTS_OF c ON i.Invoice_ID = c.Inv_ID "
                   + "JOIN ITEM t ON c.LID = t.Item_ID "
                   //+ "WHERE i.Completion = false "
                   + "ORDER BY i.Invoice_ID ASC "
                   + "LIMIT 1";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                int invoiceId = rs.getInt("Invoice_ID");
                invoiceLabe.setText("Invoice #" + invoiceId);

                do {
                    tableModel.addRow(new Object[] {
                        rs.getInt("Item_ID"),
                        rs.getString("Item_Name"),
                        rs.getString("Category"),
                        rs.getInt("Quantity")
                    });
                } while (rs.next());
            }
        } catch (SQLException e) {
            // Handle the exception
        }
    }
   private void populateWaitingList() {
        String sql = "SELECT Invoice_ID, Completion FROM INVOICE WHERE Completion = false";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                waitingListModel.addRow(new Object[] {
                    rs.getInt("Invoice_ID"),
                    rs.getBoolean("Completion")
                });
            }
        } catch (SQLException e) {
            // Handle the exception
        }
    }*/
    
    
    
    
    
    
    public void GenerateItems(){
            P2P4Panel1.removeAll();
            P2P4Panel1.repaint();
            P2P4Panel1.revalidate();
       
            P2P4Panel2.removeAll();
            P2P4Panel2.repaint();
            P2P4Panel2.revalidate();
        
            P2P4Panel3.removeAll();
            P2P4Panel3.repaint();
            P2P4Panel3.revalidate();    
    List<Item> list = null;
    try {
        list = ItemDAO.getAllItems();
    } catch (SQLException ex) {
        Logger.getLogger(FlameUI.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    for (Item list1 : list) {
        AddItemToMenu(list1.getName(),(int)list1.getPrice(),list1.getItemId(),list1.getCategory());
    }
        
    }
    public void AddItemToMenu(String IName,int IPrice,int IId,String CTGRY){
        javax.swing.JPanel jPanelItem = new javax.swing.JPanel();
        jPanelItem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanelItem.setLayout(new java.awt.BorderLayout(10, 10));
        jPanelItem.setSize(new Dimension(100,100));
        
        javax.swing.JLabel ItemName = new javax.swing.JLabel();
        ItemName.setText(IName);
        
        javax.swing.JLabel ItemPrice = new javax.swing.JLabel();
        ItemPrice.setText(Integer.toString(IPrice));
        
        javax.swing.JButton ItemButton = new javax.swing.JButton();
        ItemButton.setText("ADD");
        ItemButton.putClientProperty("ID", IId);
        ItemButton.putClientProperty("Name", IName);
        ItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddItemToMenu(((int)ItemButton.getClientProperty("ID")),((String)ItemButton.getClientProperty("Name")),IPrice);
            }});
        jPanelItem.add(ItemName, java.awt.BorderLayout.PAGE_START);
        jPanelItem.add(ItemPrice, java.awt.BorderLayout.CENTER);
        jPanelItem.add(ItemButton, java.awt.BorderLayout.PAGE_END);
        if(CTGRY.equalsIgnoreCase("Hot Drinks")){
            P2P4Panel1.add(jPanelItem);
            P2P4Panel1.repaint();
            P2P4Panel1.revalidate();
        }else if(CTGRY.equalsIgnoreCase("Cold Drinks")){
            P2P4Panel2.add(jPanelItem);
            P2P4Panel2.repaint();
            P2P4Panel2.revalidate();
        }else{
            P2P4Panel3.add(jPanelItem);
            P2P4Panel3.repaint();
            P2P4Panel3.revalidate();
        } 
    }
    public void updatePrice(){
        DefaultTableModel model1 = (DefaultTableModel) InvItemsListT.getModel();
        int price = 0;
        for (int i = 0; i < model1.getRowCount(); i++) {
            price += ((int) model1.getValueAt(i, 3));
        }
        TP2.setText(Integer.toString((price)));
        TPT2.setText(Double.toString(((double)price)*1.15));
    }
    public void AddItemToMenu(int Id, String Name,int price) {
    DefaultTableModel model1 = (DefaultTableModel) InvItemsListT.getModel();
    boolean itemFound = false; // Flag to check if the item is found

    if (model1.getRowCount() <= 0) {
        model1.addRow(new Object[]{Id, 1, Name,price});
        TP2.setText(Integer.toString(price));
        TPT2.setText(Double.toString(((double)price)*1.15));
    } else {
        for (int i = 0; i < model1.getRowCount(); i++) {
            if ( model1.getValueAt(i, 0).equals(Id)) { // Check if Id matches
                int currentQuantity = (int) model1.getValueAt(i, 1);
                int currentPrice = (int) model1.getValueAt(i, 3);
                model1.setValueAt((currentQuantity + 1), i, 1);// Update quantity
                model1.setValueAt(price+currentPrice, i, 3);
                itemFound = true;
                updatePrice();
                break; 
            }
        }
        if (!itemFound) {
            model1.addRow(new Object[]{Id, 1, Name,price});
            updatePrice();
        }
    }
}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        MyInfoDialog = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        PaymentTypeDiaglog = new javax.swing.JDialog();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        itemN = new javax.swing.JTextField();
        itemP = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        BaseLayout = new javax.swing.JPanel();
        Page1Panel = new javax.swing.JPanel();
        signbtt = new javax.swing.JButton();
        P1Label1 = new javax.swing.JLabel();
        P1Label2 = new javax.swing.JLabel();
        P1Label3 = new javax.swing.JLabel();
        P1ComboBox = new javax.swing.JComboBox<>();
        IDtextf = new javax.swing.JTextField();
        resetbtt = new javax.swing.JButton();
        Page2Panel = new javax.swing.JPanel();
        P2Panel1 = new javax.swing.JPanel();
        P2P1Button1 = new javax.swing.JButton();
        P2P1Button2 = new javax.swing.JButton();
        P2P1Button3 = new javax.swing.JButton();
        P2Panel2 = new javax.swing.JPanel();
        P2P2Panel1 = new javax.swing.JPanel();
        InvItemsList = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        InvItemsListT = new javax.swing.JTable();
        P2P2Panel2 = new javax.swing.JPanel();
        P2P2P2Button1 = new javax.swing.JButton();
        P2P2P2Button2 = new javax.swing.JButton();
        TP1 = new javax.swing.JLabel();
        TPT1 = new javax.swing.JLabel();
        TP2 = new javax.swing.JLabel();
        TPT2 = new javax.swing.JLabel();
        P2Panel3 = new javax.swing.JPanel();
        P2P3Label = new javax.swing.JLabel();
        P2P3Button1 = new javax.swing.JButton();
        P2P3Button2 = new javax.swing.JButton();
        P2P3Button3 = new javax.swing.JButton();
        P2Panel4 = new javax.swing.JPanel();
        P2P4Panel1 = new javax.swing.JPanel();
        P2P4Panel2 = new javax.swing.JPanel();
        P2P4Panel3 = new javax.swing.JPanel();
        Page3Panel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        btnMyInformation = new javax.swing.JButton();
        btnViewInvoices = new javax.swing.JButton();
        btnCreateNewItem = new javax.swing.JButton();
        P2P1Button4 = new javax.swing.JButton();
        centerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        currentInvoice = new javax.swing.JTable();
        jScrollBar1 = new javax.swing.JScrollBar();
        completeButton = new javax.swing.JButton();
        invoiceLabe = new javax.swing.JLabel();
        P3Panel3 = new javax.swing.JPanel();
        P3P3ScrollPane = new javax.swing.JScrollPane();
        tableRemainingInvoice = new javax.swing.JTable();
        P3P3Label1 = new javax.swing.JLabel();

        MyInfoDialog.setResizable(false);

        jLabel1.setText("First Name");

        jLabel3.setText("ID");

        jLabel2.setText("Phone Number");

        jLabel4.setText("Last Name");

        jLabel5.setText("Salary");

        jTextField1.setEditable(false);
        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setText("jTextField1");

        jTextField3.setText("jTextField1");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setText("jTextField1");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setEditable(false);
        jTextField5.setText("jTextField1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(jTextField2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(84, 84, 84))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(33, 33, 33)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(jTextField4)
                            .addComponent(jTextField3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MyInfoDialog.getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        MyInfoDialog.getContentPane().add(jButton2, java.awt.BorderLayout.PAGE_END);

        PaymentTypeDiaglog.setMinimumSize(new java.awt.Dimension(448, 192));
        PaymentTypeDiaglog.setModal(true);
        PaymentTypeDiaglog.setResizable(false);

        jButton4.setText("Place Invoice");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        PaymentTypeDiaglog.getContentPane().add(jButton4, java.awt.BorderLayout.PAGE_END);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Choose the Invoice Type:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Card" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dine-In", "Takeout" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Choose the Payment Type:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        PaymentTypeDiaglog.getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setText("Create New Item");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("Item Name:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setText("Price:");

        itemN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNActionPerformed(evt);
            }
        });

        itemP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPActionPerformed(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(226, 226, 226));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Hot Drinks", "Cold Drinks", "Sweets" }));

        jButton1.setBackground(new java.awt.Color(226, 226, 226));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(226, 226, 226));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel14.setText("Category:");

        jButton6.setBackground(new java.awt.Color(226, 226, 226));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton6.setText("Exit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(itemP, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(48, 48, 48)
                            .addComponent(itemN, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(246, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(jButton6)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemN, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jLabel11.setText("Category");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(792, Short.MAX_VALUE))
            .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(305, Short.MAX_VALUE))
            .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        BaseLayout.setLayout(new java.awt.CardLayout());

        signbtt.setBackground(new java.awt.Color(226, 226, 226));
        signbtt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        signbtt.setText("Sign in ");
        signbtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signbttActionPerformed(evt);
            }
        });

        P1Label1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        P1Label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        P1Label1.setText("Welcome to Flame System");
        P1Label1.setAlignmentY(0.0F);

        P1Label2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        P1Label2.setText("Employee type");

        P1Label3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        P1Label3.setText("ID number");

        P1ComboBox.setBackground(new java.awt.Color(226, 226, 226));
        P1ComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        P1ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Cashier", "Food Preparer" }));
        P1ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P1ComboBoxActionPerformed(evt);
            }
        });

        IDtextf.setText("please enter your id");
        IDtextf.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        IDtextf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDtextfActionPerformed(evt);
            }
        });

        resetbtt.setBackground(new java.awt.Color(226, 226, 226));
        resetbtt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        resetbtt.setText("Reset");
        resetbtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbttActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Page1PanelLayout = new javax.swing.GroupLayout(Page1Panel);
        Page1Panel.setLayout(Page1PanelLayout);
        Page1PanelLayout.setHorizontalGroup(
            Page1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Page1PanelLayout.createSequentialGroup()
                .addGap(0, 224, Short.MAX_VALUE)
                .addComponent(P1Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
            .addGroup(Page1PanelLayout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addGroup(Page1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(Page1PanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(signbtt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resetbtt, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Page1PanelLayout.createSequentialGroup()
                        .addGroup(Page1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(P1Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(P1Label3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Page1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(P1ComboBox, 0, 200, Short.MAX_VALUE)
                            .addComponent(IDtextf))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Page1PanelLayout.setVerticalGroup(
            Page1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Page1PanelLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(P1Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(Page1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(P1Label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(P1ComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Page1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P1Label3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDtextf, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(Page1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signbtt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetbtt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
        );

        BaseLayout.add(Page1Panel, "Page1");

        P2Panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        P2P1Button1.setBackground(new java.awt.Color(226, 226, 226));
        P2P1Button1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        P2P1Button1.setText("My Information");
        P2P1Button1.setPreferredSize(new java.awt.Dimension(75, 40));
        P2P1Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P2P1Button1ActionPerformed(evt);
            }
        });

        P2P1Button2.setBackground(new java.awt.Color(226, 226, 226));
        P2P1Button2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        P2P1Button2.setText("View invoices");
        P2P1Button2.setPreferredSize(new java.awt.Dimension(75, 40));
        P2P1Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P2P1Button2ActionPerformed(evt);
            }
        });

        P2P1Button3.setBackground(new java.awt.Color(226, 226, 226));
        P2P1Button3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        P2P1Button3.setText("Exit");
        P2P1Button3.setPreferredSize(new java.awt.Dimension(75, 40));
        P2P1Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P2P1Button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout P2Panel1Layout = new javax.swing.GroupLayout(P2Panel1);
        P2Panel1.setLayout(P2Panel1Layout);
        P2Panel1Layout.setHorizontalGroup(
            P2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P2P1Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(P2P1Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(P2P1Button3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        P2Panel1Layout.setVerticalGroup(
            P2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P2P1Button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(P2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(P2P1Button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(P2P1Button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        P2Panel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        P2P2Panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        InvItemsList.setPreferredSize(new java.awt.Dimension(260, 310));

        InvItemsListT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Quantity", "Item", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        InvItemsListT.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane7.setViewportView(InvItemsListT);
        if (InvItemsListT.getColumnModel().getColumnCount() > 0) {
            InvItemsListT.getColumnModel().getColumn(0).setMinWidth(50);
            InvItemsListT.getColumnModel().getColumn(0).setMaxWidth(50);
            InvItemsListT.getColumnModel().getColumn(1).setMinWidth(60);
            InvItemsListT.getColumnModel().getColumn(1).setMaxWidth(60);
            InvItemsListT.getColumnModel().getColumn(3).setMinWidth(40);
            InvItemsListT.getColumnModel().getColumn(3).setPreferredWidth(40);
            InvItemsListT.getColumnModel().getColumn(3).setMaxWidth(40);
        }

        javax.swing.GroupLayout InvItemsListLayout = new javax.swing.GroupLayout(InvItemsList);
        InvItemsList.setLayout(InvItemsListLayout);
        InvItemsListLayout.setHorizontalGroup(
            InvItemsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InvItemsListLayout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        InvItemsListLayout.setVerticalGroup(
            InvItemsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout P2P2Panel1Layout = new javax.swing.GroupLayout(P2P2Panel1);
        P2P2Panel1.setLayout(P2P2Panel1Layout);
        P2P2Panel1Layout.setHorizontalGroup(
            P2P2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2P2Panel1Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(InvItemsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        P2P2Panel1Layout.setVerticalGroup(
            P2P2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2P2Panel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(InvItemsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        P2P2Panel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        P2P2Panel2.setPreferredSize(new java.awt.Dimension(80, 80));

        P2P2P2Button1.setBackground(new java.awt.Color(226, 226, 226));
        P2P2P2Button1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        P2P2P2Button1.setText("Place Invoice");
        P2P2P2Button1.setPreferredSize(new java.awt.Dimension(75, 40));
        P2P2P2Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P2P2P2Button1ActionPerformed(evt);
            }
        });

        P2P2P2Button2.setBackground(new java.awt.Color(226, 226, 226));
        P2P2P2Button2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        P2P2P2Button2.setText("Trash");
        P2P2P2Button2.setPreferredSize(new java.awt.Dimension(75, 40));
        P2P2P2Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P2P2P2Button2ActionPerformed(evt);
            }
        });

        TP1.setText("Total Price :");

        TPT1.setText("Total Price With Tax. :");

        TP2.setText("  ");

        TPT2.setText("  ");

        javax.swing.GroupLayout P2P2Panel2Layout = new javax.swing.GroupLayout(P2P2Panel2);
        P2P2Panel2.setLayout(P2P2Panel2Layout);
        P2P2Panel2Layout.setHorizontalGroup(
            P2P2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2P2Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P2P2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P2P2Panel2Layout.createSequentialGroup()
                        .addComponent(P2P2P2Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(P2P2P2Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addGroup(P2P2Panel2Layout.createSequentialGroup()
                        .addComponent(TP1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TP2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(P2P2Panel2Layout.createSequentialGroup()
                        .addComponent(TPT1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TPT2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        P2P2Panel2Layout.setVerticalGroup(
            P2P2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P2P2Panel2Layout.createSequentialGroup()
                .addGroup(P2P2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TP1)
                    .addComponent(TP2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(P2P2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TPT1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TPT2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(P2P2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P2P2P2Button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2P2P2Button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout P2Panel2Layout = new javax.swing.GroupLayout(P2Panel2);
        P2Panel2.setLayout(P2Panel2Layout);
        P2Panel2Layout.setHorizontalGroup(
            P2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P2P2Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(P2P2Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
        );
        P2Panel2Layout.setVerticalGroup(
            P2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2Panel2Layout.createSequentialGroup()
                .addComponent(P2P2Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(P2P2Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
        );

        P2Panel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        P2P3Label.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        P2P3Label.setText("Category");

        P2P3Button1.setBackground(new java.awt.Color(226, 226, 226));
        P2P3Button1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        P2P3Button1.setText("Hot Drinks");
        buttonGroup1.add(P2P3Button1);
        P2P3Button1.setPreferredSize(new java.awt.Dimension(75, 40));
        P2P3Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P2P3Button1ActionPerformed(evt);
            }
        });

        P2P3Button2.setBackground(new java.awt.Color(226, 226, 226));
        P2P3Button2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        P2P3Button2.setText("Cold Drinks");
        buttonGroup1.add(P2P3Button2);
        P2P3Button2.setPreferredSize(new java.awt.Dimension(75, 40));
        P2P3Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P2P3Button2ActionPerformed(evt);
            }
        });

        P2P3Button3.setBackground(new java.awt.Color(226, 226, 226));
        P2P3Button3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        P2P3Button3.setText("Sweet");
        buttonGroup1.add(P2P3Button3);
        P2P3Button3.setPreferredSize(new java.awt.Dimension(75, 40));
        P2P3Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P2P3Button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout P2Panel3Layout = new javax.swing.GroupLayout(P2Panel3);
        P2Panel3.setLayout(P2Panel3Layout);
        P2Panel3Layout.setHorizontalGroup(
            P2Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2Panel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(P2Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P2P3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(P2Panel3Layout.createSequentialGroup()
                        .addComponent(P2P3Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(P2P3Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(P2P3Button3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        P2Panel3Layout.setVerticalGroup(
            P2Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2Panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P2P3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(P2Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P2P3Button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(P2P3Button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(P2P3Button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        P2Panel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        P2Panel4.setLayout(new java.awt.CardLayout());
        P2Panel4.add(P2P4Panel1, "HotDrinks");
        P2Panel4.add(P2P4Panel2, "ColdDrinks");
        P2Panel4.add(P2P4Panel3, "Sweet");

        javax.swing.GroupLayout Page2PanelLayout = new javax.swing.GroupLayout(Page2Panel);
        Page2Panel.setLayout(Page2PanelLayout);
        Page2PanelLayout.setHorizontalGroup(
            Page2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P2Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Page2PanelLayout.createSequentialGroup()
                .addComponent(P2Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Page2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P2Panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(P2Panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        Page2PanelLayout.setVerticalGroup(
            Page2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Page2PanelLayout.createSequentialGroup()
                .addComponent(P2Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Page2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(P2Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Page2PanelLayout.createSequentialGroup()
                        .addComponent(P2Panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(P2Panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        BaseLayout.add(Page2Panel, "Page2");

        topPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        topPanel.setPreferredSize(new java.awt.Dimension(446, 54));

        btnMyInformation.setBackground(new java.awt.Color(226, 226, 226));
        btnMyInformation.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnMyInformation.setText("My Information");
        btnMyInformation.setName("btnMyInformation"); // NOI18N
        btnMyInformation.setPreferredSize(new java.awt.Dimension(75, 40));
        btnMyInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyInformationActionPerformed(evt);
            }
        });

        btnViewInvoices.setBackground(new java.awt.Color(226, 226, 226));
        btnViewInvoices.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnViewInvoices.setText("View invoices");
        btnViewInvoices.setActionCommand("View Invoices");
        btnViewInvoices.setPreferredSize(new java.awt.Dimension(75, 40));
        btnViewInvoices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewInvoicesActionPerformed(evt);
            }
        });

        btnCreateNewItem.setBackground(new java.awt.Color(226, 226, 226));
        btnCreateNewItem.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnCreateNewItem.setText("Create new Item");
        btnCreateNewItem.setActionCommand("Create New Item");
        btnCreateNewItem.setPreferredSize(new java.awt.Dimension(75, 40));
        btnCreateNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewItemActionPerformed(evt);
            }
        });

        P2P1Button4.setBackground(new java.awt.Color(226, 226, 226));
        P2P1Button4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        P2P1Button4.setText("Exit");
        P2P1Button4.setPreferredSize(new java.awt.Dimension(75, 40));
        P2P1Button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P2P1Button4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMyInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnViewInvoices, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCreateNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(P2P1Button4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMyInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewInvoices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreateNewItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(P2P1Button4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        centerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        centerPanel.setPreferredSize(new java.awt.Dimension(910, 300));

        currentInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item_ID", "Item_Name", "Category", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(currentInvoice);

        completeButton.setText("Complete");
        completeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeButtonActionPerformed(evt);
            }
        });

        invoiceLabe.setText("Invoice #");

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(completeButton)
                .addGap(393, 393, 393))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centerPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(invoiceLabe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centerPanelLayout.createSequentialGroup()
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(centerPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(centerPanelLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(invoiceLabe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(completeButton)
                .addGap(219, 219, 219))
        );

        P3Panel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        tableRemainingInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Invoice_ID", "Order_Type", "Completion"
            }
        ));
        tableRemainingInvoice.setGridColor(new java.awt.Color(153, 153, 153));
        P3P3ScrollPane.setViewportView(tableRemainingInvoice);

        P3P3Label1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        P3P3Label1.setText("Invoice Waitlist");

        javax.swing.GroupLayout P3Panel3Layout = new javax.swing.GroupLayout(P3Panel3);
        P3Panel3.setLayout(P3Panel3Layout);
        P3Panel3Layout.setHorizontalGroup(
            P3Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P3Panel3Layout.createSequentialGroup()
                .addComponent(P3P3ScrollPane)
                .addContainerGap())
            .addGroup(P3Panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P3P3Label1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        P3Panel3Layout.setVerticalGroup(
            P3Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P3Panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P3P3Label1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(P3P3ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout Page3PanelLayout = new javax.swing.GroupLayout(Page3Panel);
        Page3Panel.setLayout(Page3PanelLayout);
        Page3PanelLayout.setHorizontalGroup(
            Page3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
            .addComponent(centerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(P3Panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Page3PanelLayout.setVerticalGroup(
            Page3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Page3PanelLayout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(centerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(P3Panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BaseLayout.add(Page3Panel, "Page3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BaseLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BaseLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signbttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signbttActionPerformed
     
        try{
            
            Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
            //mydb is database name مااعر int id = (int)IDtextf.getText();ف 
           int id;
           try {
               id = Integer.parseInt(IDtextf.getText());
           } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(null, "Please enter a valid numerical ID.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
               return;
           }
        
          
         
          if(P1ComboBox.getSelectedItem().toString().equals("Cashier")){
                String sql = "SELECT * FROM cashier WHERE Cashier_ID = " + id;
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if(rs.next()){
                    ID = id;
                    EmployeeType = "Cashier";
                    GenerateItems();//added by Raghad
                    BaseLayout.removeAll();
                    BaseLayout.add(Page2Panel);
                    BaseLayout.repaint();
                    BaseLayout.validate();
                    
                }else{
                    JOptionPane.showMessageDialog(this,"ID is incorrect");
                    IDtextf.setText("");
                    //reset comobox
                }}
          else if(P1ComboBox.getSelectedItem().toString().equals("Food Preparer")){
                String sq = "SELECT * FROM food_preparer WHERE preparer_ID = " + id;
                Statement stm = con.createStatement();
                ResultSet r = stm .executeQuery(sq);
                if(r.next()){
                    ID = id;
                    EmployeeType = "Food Preparer";
                    BaseLayout.removeAll();
                    BaseLayout.add(Page3Panel);
                    BaseLayout.repaint();
                    BaseLayout.validate();
                }else{
                    JOptionPane.showMessageDialog(this,"ID is incorrect");
                    IDtextf.setText("");
                    P1ComboBox.setSelectedIndex(0);
          }}
         
          con.close();
        }catch(Exception e)//close try
        {System.out.println(e.getMessage());
        
        }//close
        
        
    }//GEN-LAST:event_signbttActionPerformed

    private void P2P1Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2P1Button1ActionPerformed
    try {
        MyInfoDialog.setLocationRelativeTo(this); // Center relative to the main frame
        MyInfoDialog.pack();
        MyInfoDialog.setVisible(true);
        Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
        String sql = "SELECT * FROM cashier WHERE Cashier_ID = " + ID;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            jTextField1.setText(Integer.toString(rs.getInt(1)));
            jTextField2.setText(rs.getString(2));
            jTextField3.setText(rs.getString(3));
            jTextField4.setText(rs.getString(4));
            jTextField5.setText(rs.getString(5));
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(FlameUI.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
    }//GEN-LAST:event_P2P1Button1ActionPerformed

    private void P2P3Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2P3Button2ActionPerformed
       P2Panel4.removeAll();
       P2Panel4.add(P2P4Panel2);
       P2Panel4.repaint();
       P2Panel4.validate();
    }//GEN-LAST:event_P2P3Button2ActionPerformed

    private void P2P2P2Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2P2P2Button2ActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) InvItemsListT.getModel();
        if(InvItemsListT.getSelectedRow()!=-1){
            model1.removeRow(InvItemsListT.getSelectedRow());
        }else{
            for (int i = model1.getRowCount() - 1; i >= 0; i--) {
            model1.removeRow(i);
            }
        }
    }//GEN-LAST:event_P2P2P2Button2ActionPerformed

    private void P2P2P2Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2P2P2Button1ActionPerformed
        if(((DefaultTableModel) InvItemsListT.getModel()).getRowCount()==0){
        JOptionPane.showMessageDialog(this,"Add items first");
        }else{
        PaymentTypeDiaglog.setLocationRelativeTo(this); // Center relative to the main frame
        PaymentTypeDiaglog.pack();
        PaymentTypeDiaglog.setVisible(true);}
    }//GEN-LAST:event_P2P2P2Button1ActionPerformed

    private void btnMyInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyInformationActionPerformed
        try {
        MyInfoDialog.setLocationRelativeTo(this); // Center relative to the main frame
        MyInfoDialog.pack();
        MyInfoDialog.setVisible(true);
        Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
        String sql = "SELECT * FROM food_preparer WHERE Preparer_ID = " + ID;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            jTextField1.setText(Integer.toString(rs.getInt(1)));
            jTextField2.setText(rs.getString(2));
            jTextField3.setText(rs.getString(3));
            jTextField4.setText(rs.getString(4));
            jTextField5.setText(rs.getString(5));
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(FlameUI.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnMyInformationActionPerformed

    private void btnViewInvoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewInvoicesActionPerformed
        ViewInvoicesDialog d = new ViewInvoicesDialog();
        d.setLocationRelativeTo(this); // Center relative to the main frame
        d.pack();
        d.setVisible(true);
    }//GEN-LAST:event_btnViewInvoicesActionPerformed

    private void btnCreateNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewItemActionPerformed
      BaseLayout.removeAll();

    // Add the desired panel (jPanel1) to BaseLayout
    BaseLayout.add(jPanel1);

    // Refresh the BaseLayout to reflect changes
    BaseLayout.revalidate(); // Preferred over validate for modern Swing
    BaseLayout.repaint();
     
   
    
    }//GEN-LAST:event_btnCreateNewItemActionPerformed

    private void itemNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemNActionPerformed

    private void itemPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemPActionPerformed

    private void P2P3Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2P3Button1ActionPerformed
       P2Panel4.removeAll();
       P2Panel4.add(P2P4Panel1);
       P2Panel4.repaint();
       P2Panel4.validate();
    }//GEN-LAST:event_P2P3Button1ActionPerformed

    private void P2P3Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2P3Button3ActionPerformed
       P2Panel4.removeAll();
       P2Panel4.add(P2P4Panel3);
       P2Panel4.repaint();
       P2Panel4.validate();
    }//GEN-LAST:event_P2P3Button3ActionPerformed

    private void P2P1Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2P1Button3ActionPerformed
        BaseLayout.removeAll();
        BaseLayout.add(Page1Panel);
        BaseLayout.repaint();
        BaseLayout.validate();
    }//GEN-LAST:event_P2P1Button3ActionPerformed

    private void P2P1Button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2P1Button4ActionPerformed
        BaseLayout.removeAll();
        BaseLayout.add(Page1Panel);
        BaseLayout.validate();
    }//GEN-LAST:event_P2P1Button4ActionPerformed

    private void resetbttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbttActionPerformed
        // TODO add your handling code here:
        IDtextf.setText("");
        P1ComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_resetbttActionPerformed

    private void P1ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P1ComboBoxActionPerformed
     // TODO add your handling code here:
    }//GEN-LAST:event_P1ComboBoxActionPerformed

    private void IDtextfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDtextfActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_IDtextfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
          Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
         String slc = "INSERT INTO item (Item_Name, Item_Price, Category) VALUES (?, ?, ?)";
         PreparedStatement statement = con.prepareStatement(slc);
          int price ;
           try {
              price = Integer.parseInt(itemP.getText());
           } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(null, "Please enter a valid numerical price.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
               return;
           }
         statement.setString(1,itemN.getText()) ;
         statement.setInt(2, price);
         String selected;
            selected = jComboBox1.getSelectedItem().toString() ;
         statement.setString(3, selected);
         statement.executeUpdate();
         JOptionPane.showMessageDialog(null, "insertion successful.");
         con.close();
        }//close try
        catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        }//close catch
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        itemN.setText("");
        itemP.setText("");
        jComboBox1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void P2P1Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2P1Button2ActionPerformed
        ViewInvoicesDialog d = new ViewInvoicesDialog();
        d.setLocationRelativeTo(this); // Center relative to the main frame
        d.pack();
        d.setVisible(true);
    }//GEN-LAST:event_P2P1Button2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        BaseLayout.removeAll();
        BaseLayout.add(Page3Panel);
        BaseLayout.repaint();
        BaseLayout.validate();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void completeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeButtonActionPerformed
        // TODO add your handling code here:
         completeInvoice();
    }//GEN-LAST:event_completeButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    String phoneNumber = jTextField4.getText();
    if (phoneNumber.length() != 9) 
    JOptionPane.showMessageDialog(null, "The Phone Number Must Be 9 digits.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
    else   
    try{
        if(EmployeeType.equals("Cashier")){
    Connection con =DriverManager.getConnection("jdbc:mysql://localhost/flame","root","1234" );
    String query="UPDATE cashier SET Fname=?,Lname=?,Cphone_Num=? WHERE cashier_id=?";
    PreparedStatement ps=con.prepareStatement(query);
    ps.setString(1,jTextField2.getText());
    ps.setString(2,jTextField3.getText());
    ps.setString(3,jTextField4.getText());
    ps.setInt(4,ID );
    ps.executeUpdate();
    con.close();
    }else{
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost/flame","root","1234" );
    String query="UPDATE food_preparer SET Fname=?,Lname=?,Fphone_Num=? WHERE Preparer_ID=?";
    PreparedStatement ps=con.prepareStatement(query);
    ps.setString(1,jTextField2.getText());
    ps.setString(2,jTextField3.getText());
    ps.setString(3,jTextField4.getText());
    ps.setInt(4,ID );
    ps.executeUpdate();
    con.close();
        }
    }
catch(SQLException ex){
           
        Logger.getLogger(FlameUI.class.getName()).log(Level.SEVERE, null, ex);
}
    MyInfoDialog.dispose();
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int InvID = 0;
        InvT1 = (String)jComboBox2.getSelectedItem();
        InvT2 = (String)jComboBox3.getSelectedItem();
        PaymentTypeDiaglog.dispose();
        String insertQuery = "INSERT INTO INVOICE (Inv_Time,Inv_Date ,Total_Price ,Completion ,Order_Type ,Payment_Type ,C_ID,FP_ID  ) VALUES (?,?,?,?,?,?,?,?)";
        //insert invoice
        try (Connection conn = DriverManager.getConnection(DB_URL,USER,PASS );
            PreparedStatement pstmt = conn.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
            LocalTime currentTime = LocalTime.now();
            LocalDate currentDate = LocalDate.now();
            pstmt.setTime(1, java.sql.Time.valueOf(currentTime));
            pstmt.setDate(2, java.sql.Date.valueOf(currentDate));
            pstmt.setInt(3,Integer.parseInt(TP2.getText()));
            pstmt.setBoolean(4, false);
            pstmt.setString(5,InvT2);
            pstmt.setString(6,InvT1);
            pstmt.setInt(7,ID);
            pstmt.setNull(8,java.sql.Types.INTEGER);
            pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    InvID = generatedKeys.getInt(1);

                }
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //insert items to invoice
        DefaultTableModel model1 = (DefaultTableModel) InvItemsListT.getModel();
        for (int i = 0; i < model1.getRowCount(); i++) {
            int currentQuantity = (int) model1.getValueAt(i, 1);
            int currentID = (int) model1.getValueAt(i, 0);
            insertQuery = "INSERT INTO Consist_Of (Inv_ID, I_ID, Quantity) VALUES (?,?,?)";
            //insert invoice
            try (Connection conn = DriverManager.getConnection(DB_URL,USER,PASS );
                PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
                LocalTime currentTime = LocalTime.now();
                LocalDate currentDate = LocalDate.now();
                pstmt.setInt(1, InvID);
                pstmt.setInt(2, currentID);
                pstmt.setInt(3,currentQuantity);

                pstmt.execute();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(null, "Invoice has been added successfully!");
        for (int i = model1.getRowCount() - 1; i >= 0; i--) {
            model1.removeRow(i);
        }
        TP2.setText(" ");
        TPT2.setText(" ");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      /* SwingUtilities.invokeLater(() -> new FlameUI().setVisible(true));
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlameUI().setVisible(true);
                
            }
        });  */
            

         
          SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
             FlameUI ui = new FlameUI();
            ui.setVisible(true); 

            
            ui.populateTable();       
            ui.populateWaitingList(); 
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel BaseLayout;
    private javax.swing.JTextField IDtextf;
    private javax.swing.JPanel InvItemsList;
    public javax.swing.JTable InvItemsListT;
    private javax.swing.JDialog MyInfoDialog;
    private javax.swing.JComboBox<String> P1ComboBox;
    private javax.swing.JLabel P1Label1;
    private javax.swing.JLabel P1Label2;
    private javax.swing.JLabel P1Label3;
    private javax.swing.JButton P2P1Button1;
    private javax.swing.JButton P2P1Button2;
    private javax.swing.JButton P2P1Button3;
    private javax.swing.JButton P2P1Button4;
    private javax.swing.JButton P2P2P2Button1;
    private javax.swing.JButton P2P2P2Button2;
    private javax.swing.JPanel P2P2Panel1;
    private javax.swing.JPanel P2P2Panel2;
    private javax.swing.JButton P2P3Button1;
    private javax.swing.JButton P2P3Button2;
    private javax.swing.JButton P2P3Button3;
    private javax.swing.JLabel P2P3Label;
    private javax.swing.JPanel P2P4Panel1;
    private javax.swing.JPanel P2P4Panel2;
    private javax.swing.JPanel P2P4Panel3;
    private javax.swing.JPanel P2Panel1;
    private javax.swing.JPanel P2Panel2;
    private javax.swing.JPanel P2Panel3;
    public javax.swing.JPanel P2Panel4;
    private javax.swing.JLabel P3P3Label1;
    private javax.swing.JScrollPane P3P3ScrollPane;
    private javax.swing.JPanel P3Panel3;
    private javax.swing.JPanel Page1Panel;
    private javax.swing.JPanel Page2Panel;
    private javax.swing.JPanel Page3Panel;
    private javax.swing.JDialog PaymentTypeDiaglog;
    private javax.swing.JLabel TP1;
    private javax.swing.JLabel TP2;
    private javax.swing.JLabel TPT1;
    private javax.swing.JLabel TPT2;
    private javax.swing.JButton btnCreateNewItem;
    private javax.swing.JButton btnMyInformation;
    private javax.swing.JButton btnViewInvoices;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JButton completeButton;
    private javax.swing.JTable currentInvoice;
    private javax.swing.JLabel invoiceLabe;
    private javax.swing.JTextField itemN;
    private javax.swing.JTextField itemP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    public javax.swing.JComboBox<String> jComboBox2;
    public javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton resetbtt;
    private javax.swing.JButton signbtt;
    private javax.swing.JTable tableRemainingInvoice;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables

}
