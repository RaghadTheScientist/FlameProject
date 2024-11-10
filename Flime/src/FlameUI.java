import java.sql.*;
public class FlameUI extends javax.swing.JFrame {
public static final String  DB_URL = "jdbc:mysql://localhost:3306/sys";
public static final String  USER = "root";
public static final String  PASS = "2n4@060";
public static int ID ;
public static String EmployeeType;
    public FlameUI() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        MyInfoDialog = new javax.swing.JDialog();
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
        ViewInvoicesDialog = new javax.swing.JDialog();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        NewItemDialog = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        PaymentTypeDiaglog = new javax.swing.JDialog();
        jLabel12 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        BaseLayout = new javax.swing.JPanel();
        Page1Panel = new javax.swing.JPanel();
        P1Button = new javax.swing.JButton();
        P1Label1 = new javax.swing.JLabel();
        P1Label2 = new javax.swing.JLabel();
        P1Label3 = new javax.swing.JLabel();
        P1ComboBox = new javax.swing.JComboBox<>();
        P1TextField = new javax.swing.JTextField();
        Page2Panel = new javax.swing.JPanel();
        P2Panel1 = new javax.swing.JPanel();
        P2P1Button1 = new javax.swing.JButton();
        P2P1Button2 = new javax.swing.JButton();
        P2P1Button3 = new javax.swing.JButton();
        P2Panel2 = new javax.swing.JPanel();
        P2P2Panel1 = new javax.swing.JPanel();
        P2P2Panel2 = new javax.swing.JPanel();
        P2P2P2Button1 = new javax.swing.JButton();
        P2P2P2Button2 = new javax.swing.JButton();
        P2Panel3 = new javax.swing.JPanel();
        P2P3Label = new javax.swing.JLabel();
        P2P3Button1 = new javax.swing.JButton();
        P2P3Button2 = new javax.swing.JButton();
        P2P3Button3 = new javax.swing.JButton();
        P2Panel4 = new javax.swing.JPanel();
        P2P4Panel1 = new javax.swing.JPanel();
        P2P4P1Label = new javax.swing.JLabel();
        P2P4Panel2 = new javax.swing.JPanel();
        P2P4P2Label = new javax.swing.JLabel();
        P2P4Panel3 = new javax.swing.JPanel();
        P2P4P3Label = new javax.swing.JLabel();
        Page3Panel = new javax.swing.JPanel();
        P3Panel1 = new javax.swing.JPanel();
        P3P1Button1 = new javax.swing.JButton();
        P3P1Button2 = new javax.swing.JButton();
        P3P1Button3 = new javax.swing.JButton();
        P2P1Button4 = new javax.swing.JButton();
        P3Panel2 = new javax.swing.JPanel();
        P3P2Panel1 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        P3P2Panel2 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        P3P2Panel3 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        P3P2Panel4 = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        P3Panel3 = new javax.swing.JPanel();
        P3P3ScrollPane = new javax.swing.JScrollPane();
        P3P3Table = new javax.swing.JTable();
        P3P3Label1 = new javax.swing.JLabel();

        jLabel1.setText("First Name");

        jLabel3.setText("ID");

        jLabel2.setText("Phone Number");

        jLabel4.setText("Last Name");

        jLabel5.setText("Salary");

        jTextField1.setText("jTextField1");
        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setText("jTextField1");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setText("jTextField1");

        jTextField4.setText("jTextField1");

        jTextField5.setText("jTextField1");

        jButton2.setText("Save");

        javax.swing.GroupLayout MyInfoDialogLayout = new javax.swing.GroupLayout(MyInfoDialog.getContentPane());
        MyInfoDialog.getContentPane().setLayout(MyInfoDialogLayout);
        MyInfoDialogLayout.setHorizontalGroup(
            MyInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyInfoDialogLayout.createSequentialGroup()
                .addGroup(MyInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MyInfoDialogLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(MyInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MyInfoDialogLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MyInfoDialogLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MyInfoDialogLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MyInfoDialogLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MyInfoDialogLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(MyInfoDialogLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jButton2)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        MyInfoDialogLayout.setVerticalGroup(
            MyInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyInfoDialogLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(MyInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MyInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(MyInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MyInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MyInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable1);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Invoices");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Filter :");

        jCheckBox1.setText("Only completed Invoices");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jButton3.setText("Apply");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ViewInvoicesDialogLayout = new javax.swing.GroupLayout(ViewInvoicesDialog.getContentPane());
        ViewInvoicesDialog.getContentPane().setLayout(ViewInvoicesDialogLayout);
        ViewInvoicesDialogLayout.setHorizontalGroup(
            ViewInvoicesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewInvoicesDialogLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(ViewInvoicesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewInvoicesDialogLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ViewInvoicesDialogLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(26, 26, 26)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(51, 51, 51))))
            .addGroup(ViewInvoicesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewInvoicesDialogLayout.createSequentialGroup()
                    .addContainerGap(48, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(48, Short.MAX_VALUE)))
        );
        ViewInvoicesDialogLayout.setVerticalGroup(
            ViewInvoicesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewInvoicesDialogLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(ViewInvoicesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jCheckBox1)
                    .addComponent(jButton3))
                .addContainerGap(268, Short.MAX_VALUE))
            .addGroup(ViewInvoicesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewInvoicesDialogLayout.createSequentialGroup()
                    .addContainerGap(106, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE)))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Create New Item");

        jLabel8.setText("Item Name");

        jLabel9.setText("Price");

        jTextField6.setText("jTextField1");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.setText("jTextField1");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jButton1.setText("Add");

        jLabel11.setText("Category");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Hot Drinks", "Cold Drinks", "Sweets" }));

        javax.swing.GroupLayout NewItemDialogLayout = new javax.swing.GroupLayout(NewItemDialog.getContentPane());
        NewItemDialog.getContentPane().setLayout(NewItemDialogLayout);
        NewItemDialogLayout.setHorizontalGroup(
            NewItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewItemDialogLayout.createSequentialGroup()
                .addGroup(NewItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewItemDialogLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(NewItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(NewItemDialogLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(NewItemDialogLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(NewItemDialogLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7)))
                    .addGroup(NewItemDialogLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jButton1)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        NewItemDialogLayout.setVerticalGroup(
            NewItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewItemDialogLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(NewItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Choose the Invoice Type:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Card" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dine-In", "Takeout" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Choose the Payment Type:");

        jButton4.setText("Place Invoice");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PaymentTypeDiaglogLayout = new javax.swing.GroupLayout(PaymentTypeDiaglog.getContentPane());
        PaymentTypeDiaglog.getContentPane().setLayout(PaymentTypeDiaglogLayout);
        PaymentTypeDiaglogLayout.setHorizontalGroup(
            PaymentTypeDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaymentTypeDiaglogLayout.createSequentialGroup()
                .addGroup(PaymentTypeDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PaymentTypeDiaglogLayout.createSequentialGroup()
                        .addContainerGap(285, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PaymentTypeDiaglogLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
            .addGroup(PaymentTypeDiaglogLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PaymentTypeDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PaymentTypeDiaglogLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(195, Short.MAX_VALUE)))
        );
        PaymentTypeDiaglogLayout.setVerticalGroup(
            PaymentTypeDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaymentTypeDiaglogLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PaymentTypeDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(23, 23, 23))
            .addGroup(PaymentTypeDiaglogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PaymentTypeDiaglogLayout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(128, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusableWindowState(false);
        setResizable(false);

        BaseLayout.setLayout(new java.awt.CardLayout());

        P1Button.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        P1Button.setText("Sign in ");
        P1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P1ButtonActionPerformed(evt);
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

        P1ComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        P1ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Cashier", "Food Preparer" }));

        P1TextField.setText("jTextField1");

        javax.swing.GroupLayout Page1PanelLayout = new javax.swing.GroupLayout(Page1Panel);
        Page1Panel.setLayout(Page1PanelLayout);
        Page1PanelLayout.setHorizontalGroup(
            Page1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Page1PanelLayout.createSequentialGroup()
                .addGroup(Page1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Page1PanelLayout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addGroup(Page1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(P1Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(P1Label3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Page1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(P1ComboBox, 0, 200, Short.MAX_VALUE)
                            .addComponent(P1TextField)))
                    .addGroup(Page1PanelLayout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(P1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(247, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Page1PanelLayout.createSequentialGroup()
                .addGap(0, 224, Short.MAX_VALUE)
                .addComponent(P1Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
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
                    .addComponent(P1TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(P1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        javax.swing.GroupLayout P2P2Panel1Layout = new javax.swing.GroupLayout(P2P2Panel1);
        P2P2Panel1.setLayout(P2P2Panel1Layout);
        P2P2Panel1Layout.setHorizontalGroup(
            P2P2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        P2P2Panel1Layout.setVerticalGroup(
            P2P2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
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
        P2P2P2Button2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        P2P2P2Button2.setText("Trash");
        P2P2P2Button2.setPreferredSize(new java.awt.Dimension(75, 40));
        P2P2P2Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P2P2P2Button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout P2P2Panel2Layout = new javax.swing.GroupLayout(P2P2Panel2);
        P2P2Panel2.setLayout(P2P2Panel2Layout);
        P2P2Panel2Layout.setHorizontalGroup(
            P2P2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2P2Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P2P2P2Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(P2P2P2Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        P2P2Panel2Layout.setVerticalGroup(
            P2P2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2P2Panel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(P2P2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P2P2P2Button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P2P2P2Button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(P2P2Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        P2P4P1Label.setText("hot drinks");

        javax.swing.GroupLayout P2P4Panel1Layout = new javax.swing.GroupLayout(P2P4Panel1);
        P2P4Panel1.setLayout(P2P4Panel1Layout);
        P2P4Panel1Layout.setHorizontalGroup(
            P2P4Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2P4Panel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(P2P4P1Label)
                .addContainerGap(566, Short.MAX_VALUE))
        );
        P2P4Panel1Layout.setVerticalGroup(
            P2P4Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2P4Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P2P4P1Label)
                .addContainerGap(298, Short.MAX_VALUE))
        );

        P2Panel4.add(P2P4Panel1, "HotDrinks");

        P2P4P2Label.setText("cold drinks");

        javax.swing.GroupLayout P2P4Panel2Layout = new javax.swing.GroupLayout(P2P4Panel2);
        P2P4Panel2.setLayout(P2P4Panel2Layout);
        P2P4Panel2Layout.setHorizontalGroup(
            P2P4Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2P4Panel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(P2P4P2Label)
                .addContainerGap(561, Short.MAX_VALUE))
        );
        P2P4Panel2Layout.setVerticalGroup(
            P2P4Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2P4Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P2P4P2Label)
                .addContainerGap(298, Short.MAX_VALUE))
        );

        P2Panel4.add(P2P4Panel2, "ColdDrinks");

        P2P4P3Label.setText("sweet");

        javax.swing.GroupLayout P2P4Panel3Layout = new javax.swing.GroupLayout(P2P4Panel3);
        P2P4Panel3.setLayout(P2P4Panel3Layout);
        P2P4Panel3Layout.setHorizontalGroup(
            P2P4Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2P4Panel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(P2P4P3Label)
                .addContainerGap(589, Short.MAX_VALUE))
        );
        P2P4Panel3Layout.setVerticalGroup(
            P2P4Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P2P4Panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P2P4P3Label)
                .addContainerGap(298, Short.MAX_VALUE))
        );

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

        P3Panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        P3Panel1.setPreferredSize(new java.awt.Dimension(446, 54));

        P3P1Button1.setBackground(new java.awt.Color(226, 226, 226));
        P3P1Button1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        P3P1Button1.setText("My Information");
        P3P1Button1.setPreferredSize(new java.awt.Dimension(75, 40));
        P3P1Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P3P1Button1ActionPerformed(evt);
            }
        });

        P3P1Button2.setBackground(new java.awt.Color(226, 226, 226));
        P3P1Button2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        P3P1Button2.setText("View invoices");
        P3P1Button2.setPreferredSize(new java.awt.Dimension(75, 40));
        P3P1Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P3P1Button2ActionPerformed(evt);
            }
        });

        P3P1Button3.setBackground(new java.awt.Color(226, 226, 226));
        P3P1Button3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        P3P1Button3.setText("Create new Item");
        P3P1Button3.setPreferredSize(new java.awt.Dimension(75, 40));
        P3P1Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P3P1Button3ActionPerformed(evt);
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

        javax.swing.GroupLayout P3Panel1Layout = new javax.swing.GroupLayout(P3Panel1);
        P3Panel1.setLayout(P3Panel1Layout);
        P3Panel1Layout.setHorizontalGroup(
            P3Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P3Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P3P1Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(P3P1Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(P3P1Button3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(P2P1Button4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        P3Panel1Layout.setVerticalGroup(
            P3Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P3Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P3Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P3P1Button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(P3P1Button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(P3P1Button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(P2P1Button4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        P3Panel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        P3Panel2.setPreferredSize(new java.awt.Dimension(910, 300));

        P3P2Panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        P3P2Panel1.setPreferredSize(new java.awt.Dimension(216, 252));
        P3P2Panel1.setVerifyInputWhenFocusTarget(false);

        jButton10.setText("Complate");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(java.awt.SystemColor.controlHighlight);
        jTextPane1.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout P3P2Panel1Layout = new javax.swing.GroupLayout(P3P2Panel1);
        P3P2Panel1.setLayout(P3P2Panel1Layout);
        P3P2Panel1Layout.setHorizontalGroup(
            P3P2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P3P2Panel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(P3P2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(P3P2Panel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        P3P2Panel1Layout.setVerticalGroup(
            P3P2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P3P2Panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(P3P2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(P3P2Panel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(46, Short.MAX_VALUE)))
        );

        P3P2Panel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        P3P2Panel2.setPreferredSize(new java.awt.Dimension(216, 252));
        P3P2Panel2.setVerifyInputWhenFocusTarget(false);

        jButton14.setText("Complate");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jTextPane2.setEditable(false);
        jTextPane2.setBackground(java.awt.SystemColor.controlHighlight);
        jScrollPane2.setViewportView(jTextPane2);

        javax.swing.GroupLayout P3P2Panel2Layout = new javax.swing.GroupLayout(P3P2Panel2);
        P3P2Panel2.setLayout(P3P2Panel2Layout);
        P3P2Panel2Layout.setHorizontalGroup(
            P3P2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P3P2Panel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(P3P2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(P3P2Panel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        P3P2Panel2Layout.setVerticalGroup(
            P3P2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P3P2Panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(P3P2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(P3P2Panel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(46, Short.MAX_VALUE)))
        );

        P3P2Panel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        P3P2Panel3.setPreferredSize(new java.awt.Dimension(216, 252));
        P3P2Panel3.setVerifyInputWhenFocusTarget(false);

        jButton15.setText("Complate");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jTextPane3.setEditable(false);
        jTextPane3.setBackground(java.awt.SystemColor.controlHighlight);
        jScrollPane3.setViewportView(jTextPane3);

        javax.swing.GroupLayout P3P2Panel3Layout = new javax.swing.GroupLayout(P3P2Panel3);
        P3P2Panel3.setLayout(P3P2Panel3Layout);
        P3P2Panel3Layout.setHorizontalGroup(
            P3P2Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P3P2Panel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(P3P2Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(P3P2Panel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        P3P2Panel3Layout.setVerticalGroup(
            P3P2Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P3P2Panel3Layout.createSequentialGroup()
                .addContainerGap(165, Short.MAX_VALUE)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(P3P2Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(P3P2Panel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(46, Short.MAX_VALUE)))
        );

        P3P2Panel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        P3P2Panel4.setPreferredSize(new java.awt.Dimension(216, 252));
        P3P2Panel4.setVerifyInputWhenFocusTarget(false);

        jButton16.setText("Complate");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jTextPane4.setEditable(false);
        jTextPane4.setBackground(java.awt.SystemColor.controlHighlight);
        jScrollPane4.setViewportView(jTextPane4);

        javax.swing.GroupLayout P3P2Panel4Layout = new javax.swing.GroupLayout(P3P2Panel4);
        P3P2Panel4.setLayout(P3P2Panel4Layout);
        P3P2Panel4Layout.setHorizontalGroup(
            P3P2Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P3P2Panel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(P3P2Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(P3P2Panel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        P3P2Panel4Layout.setVerticalGroup(
            P3P2Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P3P2Panel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(P3P2Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(P3P2Panel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(46, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout P3Panel2Layout = new javax.swing.GroupLayout(P3Panel2);
        P3Panel2.setLayout(P3Panel2Layout);
        P3Panel2Layout.setHorizontalGroup(
            P3Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P3Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P3P2Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(P3P2Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(P3P2Panel3, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(P3P2Panel4, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        P3Panel2Layout.setVerticalGroup(
            P3Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P3Panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(P3Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(P3P2Panel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(P3P2Panel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(P3P2Panel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(P3P2Panel4, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                .addGap(312, 312, 312))
        );

        P3Panel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        P3P3Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        P3P3Table.setGridColor(new java.awt.Color(153, 153, 153));
        P3P3ScrollPane.setViewportView(P3P3Table);

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
            .addComponent(P3Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
            .addComponent(P3Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(P3Panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Page3PanelLayout.setVerticalGroup(
            Page3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Page3PanelLayout.createSequentialGroup()
                .addComponent(P3Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(P3Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void P1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P1ButtonActionPerformed
        if(P1ComboBox.getSelectedItem().toString().equals("Cashier")){
        BaseLayout.removeAll();
        BaseLayout.add(Page2Panel);
        BaseLayout.validate();
        }
    }//GEN-LAST:event_P1ButtonActionPerformed

    private void P2P1Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2P1Button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_P2P1Button1ActionPerformed

    private void P2P3Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2P3Button2ActionPerformed
       P2Panel4.removeAll();
       P2Panel4.add(P2P4Panel2);
       P2Panel4.repaint();
       P2Panel4.validate();
    }//GEN-LAST:event_P2P3Button2ActionPerformed

    private void P2P2P2Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2P2P2Button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_P2P2P2Button2ActionPerformed

    private void P2P2P2Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2P2P2Button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_P2P2P2Button1ActionPerformed

    private void P3P1Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P3P1Button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_P3P1Button1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void P3P1Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P3P1Button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_P3P1Button2ActionPerformed

    private void P3P1Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P3P1Button3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_P3P1Button3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

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
        // TODO add your handling code here:
    }//GEN-LAST:event_P2P1Button3ActionPerformed

    private void P2P1Button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P2P1Button4ActionPerformed
        BaseLayout.removeAll();
        BaseLayout.add(Page2Panel);
        BaseLayout.validate();
    }//GEN-LAST:event_P2P1Button4ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
      
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlameUI().setVisible(true);
            }
        });
            

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel BaseLayout;
    private javax.swing.JDialog MyInfoDialog;
    private javax.swing.JDialog NewItemDialog;
    private javax.swing.JButton P1Button;
    private javax.swing.JComboBox<String> P1ComboBox;
    private javax.swing.JLabel P1Label1;
    private javax.swing.JLabel P1Label2;
    private javax.swing.JLabel P1Label3;
    private javax.swing.JTextField P1TextField;
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
    private javax.swing.JLabel P2P4P1Label;
    private javax.swing.JLabel P2P4P2Label;
    private javax.swing.JLabel P2P4P3Label;
    private javax.swing.JPanel P2P4Panel1;
    private javax.swing.JPanel P2P4Panel2;
    private javax.swing.JPanel P2P4Panel3;
    private javax.swing.JPanel P2Panel1;
    private javax.swing.JPanel P2Panel2;
    private javax.swing.JPanel P2Panel3;
    public javax.swing.JPanel P2Panel4;
    private javax.swing.JButton P3P1Button1;
    private javax.swing.JButton P3P1Button2;
    private javax.swing.JButton P3P1Button3;
    private javax.swing.JPanel P3P2Panel1;
    private javax.swing.JPanel P3P2Panel2;
    private javax.swing.JPanel P3P2Panel3;
    private javax.swing.JPanel P3P2Panel4;
    private javax.swing.JLabel P3P3Label1;
    private javax.swing.JScrollPane P3P3ScrollPane;
    private javax.swing.JTable P3P3Table;
    private javax.swing.JPanel P3Panel1;
    private javax.swing.JPanel P3Panel2;
    private javax.swing.JPanel P3Panel3;
    private javax.swing.JPanel Page1Panel;
    private javax.swing.JPanel Page2Panel;
    private javax.swing.JPanel Page3Panel;
    private javax.swing.JDialog PaymentTypeDiaglog;
    private javax.swing.JDialog ViewInvoicesDialog;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    // End of variables declaration//GEN-END:variables
}
