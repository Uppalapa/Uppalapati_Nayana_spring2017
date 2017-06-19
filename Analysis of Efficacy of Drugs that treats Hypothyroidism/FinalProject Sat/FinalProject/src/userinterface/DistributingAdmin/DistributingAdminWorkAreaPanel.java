/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DistributingAdmin;

import Business.Drug.Drug;
import Business.Employee.Employee;
import Business.Enterprise.DistributingEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ManufactureEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chand
 */
public class DistributingAdminWorkAreaPanel extends javax.swing.JPanel {

    /**
     * Creates new form DistributingAdminWorkAreaPanel
     */
    JPanel userprocessContainer;
    DistributingEnterprise enterprise;
    Network network;
    public DistributingAdminWorkAreaPanel(JPanel userProcessContainer,Network network,DistributingEnterprise enterprise) {
        initComponents();
        this.userprocessContainer=userProcessContainer;
        this.enterprise=enterprise;
        this.network=network;
        
        enterpriseTypeLabel.setText(enterprise.getEnterpriseType().getValue());
        enterpriseNameTxtField.setText(enterprise.getName());
    
        //manage organization combo box and table are generated
        populateTable();
        populateCombo();
        //manage employees - combo boxes are generated 
        populateOrganizationComboBox();
        populateOrganizationEmpComboBox();
        
        //manage useraccounts - combo box and table
        popOrganizationComboBox();
        popData();
        
        //manage drugs
        populateDrugTable();
    }
    //manage drugs table generation
    private void populateDrugTable(){
        DefaultTableModel model=(DefaultTableModel)drugTable.getModel();
        
        model.setRowCount(0);
        
        for(Drug drug:enterprise.getDrugList())
        {
            Object[] row=new Object[1];
            row[0]=drug;
            //row[1]=drug.getManufactureEnterprise().getName();
            model.addRow(row);
            System.out.println("Drug:"+drug.getName());
        }
        
    }
    //manage organization -combo box
     private void populateCombo(){
        organizationJComboBox1.removeAllItems();
        for (Organization.Type type : Organization.Type.values()){
            if (type.getValue().equals(Organization.Type.Distributor.getValue()))
                organizationJComboBox1.addItem(type);
        }
    }
     //manage organization -table
    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        
        model.setRowCount(0);
        
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            Object[] row = new Object[2];
            row[0] = organization.getOrganizationID();
            row[1] = organization.getName();
            
            model.addRow(row);
        }
    }
    
    //manage employees-organization combo
    public void populateOrganizationComboBox(){
        organizationJComboBox2.removeAllItems();
        
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            organizationJComboBox2.addItem(organization);
        }
    }
    //manage employees - organization employee combo
    public void populateOrganizationEmpComboBox(){
        organizationEmpJComboBox.removeAllItems();
        
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            organizationEmpJComboBox.addItem(organization);
        }
    }

    private void populateTable(Organization organization){
        DefaultTableModel model = (DefaultTableModel) organizationJTable1.getModel();
        
        model.setRowCount(0);
        
        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()){
            Object[] row = new Object[2];
            row[0] = employee.getId();
            row[1] = employee.getName();
            model.addRow(row);
        }
    }
    
    //generate organization combo box - manage useraccounts
    
        public void popOrganizationComboBox() {
        organizationJComboBox.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            organizationJComboBox.addItem(organization);
        }
    }
    
    public void populateEmployeeComboBox(Organization organization){
        employeeJComboBox.removeAllItems();
        
        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()){
            employeeJComboBox.addItem(employee);
        }
    }
    
    private void populateRoleComboBox(Organization organization){
        roleJComboBox.removeAllItems();
        for (Role role : organization.getSupportedRole()){
            roleJComboBox.addItem(role);
        }
    }
    // manage useraccounts - usertable generation
    public void popData() {

        DefaultTableModel model = (DefaultTableModel) userJTable.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                Object row[] = new Object[2];
                row[0] = ua;
                row[1] = ua.getRole();
                ((DefaultTableModel) userJTable.getModel()).addRow(row);
            }
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        enterpriseTypeLabel = new javax.swing.JLabel();
        enterpriseNameTxtField = new javax.swing.JTextField();
        welcomeLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        organizationJComboBox1 = new javax.swing.JComboBox();
        addOrganizationJButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userJTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        employeeJComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        roleJComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passwordJTextField = new javax.swing.JTextField();
        createUserJButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        organizationJComboBox2 = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        organizationJTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        organizationEmpJComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        nameJTextField1 = new javax.swing.JTextField();
        addEmployeeBtn = new javax.swing.JButton();
        DrugsDistributedPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        drugTable = new javax.swing.JTable();
        viewDrugDetailsBtn = new javax.swing.JButton();
        viewDrugDetailsInnerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        drugnameTxtFld = new javax.swing.JTextField();
        drugManufactureTxtFld = new javax.swing.JTextField();
        addNewDrugBtn = new javax.swing.JButton();
        dosageLabel = new javax.swing.JLabel();
        dosageTxtFld = new javax.swing.JTextField();
        addANewDrugBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        enterpriseTypeLabel.setText("Enterprise Type:");

        enterpriseNameTxtField.setEnabled(false);

        welcomeLabel.setText("Welcome Admin!!!!!!!!!!!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(enterpriseTypeLabel)
                .addGap(18, 18, 18)
                .addComponent(enterpriseNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(welcomeLabel)
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterpriseTypeLabel)
                    .addComponent(enterpriseNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(welcomeLabel))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jSplitPane1.setTopComponent(jPanel1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 926, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("My Profile", jPanel3);

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(organizationJTable);

        jLabel7.setText("Organization Type ");

        organizationJComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBox1ActionPerformed(evt);
            }
        });

        addOrganizationJButton.setText("Add Organization");
        addOrganizationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrganizationJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jLabel7)
                                .addGap(39, 39, 39)
                                .addComponent(organizationJComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(addOrganizationJButton)))
                .addContainerGap(335, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(organizationJComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(addOrganizationJButton)
                .addContainerGap(259, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Organization", jPanel4);

        userJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userJTable);

        jLabel5.setText("Organization");

        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Employee");

        employeeJComboBox.setBackground(new java.awt.Color(255, 255, 204));
        employeeJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeJComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setText("Role");

        jLabel2.setText("User Name");

        jLabel3.setText("Password");

        createUserJButton.setText("Create");
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(104, 104, 104)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(employeeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roleJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addComponent(createUserJButton)))
                .addContainerGap(335, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roleJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(createUserJButton)
                .addGap(27, 27, 27))
        );

        jTabbedPane1.addTab("Manage UserAccounts", jPanel5);

        jLabel8.setText("Organization");

        organizationJComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBox2ActionPerformed(evt);
            }
        });

        organizationJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(organizationJTable1);

        jLabel10.setText("Organization");

        jLabel9.setText("Name");

        addEmployeeBtn.setText("Create Employee");
        addEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel8)
                        .addGap(32, 32, 32)
                        .addComponent(organizationJComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGap(0, 418, Short.MAX_VALUE)
                                .addComponent(addEmployeeBtn))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(organizationEmpJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(268, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(organizationJComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(organizationEmpJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(nameJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addEmployeeBtn)
                .addContainerGap(231, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Employees", jPanel6);

        drugTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Drug name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(drugTable);

        viewDrugDetailsBtn.setText("viewDetails of Drug");

        viewDrugDetailsInnerPanel.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setText("Drug name:");

        jLabel11.setText("Manufacturing company:");

        addNewDrugBtn.setText("Add");
        addNewDrugBtn.setEnabled(false);
        addNewDrugBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewDrugBtnActionPerformed(evt);
            }
        });

        dosageLabel.setText("Dosage:");

        javax.swing.GroupLayout viewDrugDetailsInnerPanelLayout = new javax.swing.GroupLayout(viewDrugDetailsInnerPanel);
        viewDrugDetailsInnerPanel.setLayout(viewDrugDetailsInnerPanelLayout);
        viewDrugDetailsInnerPanelLayout.setHorizontalGroup(
            viewDrugDetailsInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewDrugDetailsInnerPanelLayout.createSequentialGroup()
                .addGroup(viewDrugDetailsInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewDrugDetailsInnerPanelLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(viewDrugDetailsInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11))
                        .addGap(25, 25, 25)
                        .addGroup(viewDrugDetailsInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(drugnameTxtFld)
                            .addComponent(drugManufactureTxtFld, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addComponent(dosageLabel)
                        .addGap(34, 34, 34)
                        .addComponent(dosageTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewDrugDetailsInnerPanelLayout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(addNewDrugBtn)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        viewDrugDetailsInnerPanelLayout.setVerticalGroup(
            viewDrugDetailsInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewDrugDetailsInnerPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(viewDrugDetailsInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(viewDrugDetailsInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(drugnameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dosageLabel)
                        .addComponent(dosageTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(viewDrugDetailsInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(drugManufactureTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(addNewDrugBtn)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        addANewDrugBtn.setText("Add a drug");
        addANewDrugBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addANewDrugBtnActionPerformed(evt);
            }
        });

        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DrugsDistributedPanelLayout = new javax.swing.GroupLayout(DrugsDistributedPanel);
        DrugsDistributedPanel.setLayout(DrugsDistributedPanelLayout);
        DrugsDistributedPanelLayout.setHorizontalGroup(
            DrugsDistributedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DrugsDistributedPanelLayout.createSequentialGroup()
                .addGroup(DrugsDistributedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DrugsDistributedPanelLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(viewDrugDetailsInnerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DrugsDistributedPanelLayout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DrugsDistributedPanelLayout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(viewDrugDetailsBtn)
                        .addGap(46, 46, 46)
                        .addComponent(refreshBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addANewDrugBtn)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        DrugsDistributedPanelLayout.setVerticalGroup(
            DrugsDistributedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DrugsDistributedPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(DrugsDistributedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewDrugDetailsBtn)
                    .addComponent(addANewDrugBtn)
                    .addComponent(refreshBtn))
                .addGap(29, 29, 29)
                .addComponent(viewDrugDetailsInnerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Drugs distributed by this company", DrugsDistributedPanel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void organizationJComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_organizationJComboBox1ActionPerformed

    private void addOrganizationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrganizationJButtonActionPerformed

        Type type = (Type) organizationJComboBox1.getSelectedItem();
        enterprise.getOrganizationDirectory().createOrganization(type);
        populateTable();
        popOrganizationComboBox();
    }//GEN-LAST:event_addOrganizationJButtonActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null){
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void employeeJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeJComboBoxActionPerformed

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed
  boolean isValid = true;
        String userName = nameJTextField.getText();
        String password = passwordJTextField.getText();

        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        Employee employee = (Employee) employeeJComboBox.getSelectedItem();
        Role role = (Role) roleJComboBox.getSelectedItem();

        if (userName.isEmpty()) {
            int messageType = JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(null, "Name cannot be empty", "Error", messageType);
            nameJTextField.setBackground(Color.red);
            isValid = false;
        } else {
            nameJTextField.setBackground(Color.white);
        }

        String pswd = passwordJTextField.getText();
        String passwordRegEx = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        if (pswd.isEmpty()) {
            int messageType = JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(null, "Password cannot be empty", "Error", messageType);
            passwordJTextField.setBackground(Color.red);
            isValid = false;
        } else if (!pswd.isEmpty() && !pswd.matches(passwordRegEx)) {
            int messageType = JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(null, "Password not valid (Rules for password start-of-string\n" + "a digit must occur at least once\n"
                    + "a lower case letter must occur at least once\n"
                    + "an upper case letter must occur at least once\n"
                    + "a special character must occur at least once\n"
                    + "no whitespace allowed in the entire string\n"
                    + "anything, at least eight places though\n"
                    + "end-of-string", "Error", messageType);
            passwordJTextField.setBackground(Color.red);
            isValid = false;
        } else {
            passwordJTextField.setBackground(Color.white);
        }

        if (isValid) {
            organization.getUserAccountDirectory().createEmployeeUserAccount(userName, password, employee, role);

            popData();
            nameJTextField.setText("");
            passwordJTextField.setText("");
        }    }//GEN-LAST:event_createUserJButtonActionPerformed

    private void organizationJComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBox2ActionPerformed
        Organization organization = (Organization) organizationJComboBox2.getSelectedItem();
        if (organization != null){
            populateTable(organization);
        }
    }//GEN-LAST:event_organizationJComboBox2ActionPerformed

    private void addEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeBtnActionPerformed

          boolean isValid = true;
        Organization organization = (Organization) organizationEmpJComboBox.getSelectedItem();
        String name = nameJTextField.getText();
        if (name.isEmpty()) {
            int messageType = JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(null, "Name cannot be empty", "Error", messageType);
            nameJTextField.setBackground(Color.red);
            isValid = false;
        } else {
            nameJTextField.setBackground(Color.white);
        }

        if (isValid) {

            organization.getEmployeeDirectory().createEmployee(name);
            System.out.println("An employee named " + name + " created in" + organization.getName());
            populateTable();
            nameJTextField.setText("");
        }

    }//GEN-LAST:event_addEmployeeBtnActionPerformed

    private void addANewDrugBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addANewDrugBtnActionPerformed
        // TODO add your handling code here:
        
       
       
            addNewDrugBtn.setEnabled(true);
            
            //if you want to use the comboboxes instead of textfields call 
            //populating combobox functions here
        
        
            
        
        
    }//GEN-LAST:event_addANewDrugBtnActionPerformed

    private void addNewDrugBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewDrugBtnActionPerformed
        // TODO add your handling code here:
         String drugName=drugnameTxtFld.getText();
        String drugManufacturer=drugManufactureTxtFld.getText();
        Boolean drugExistsWithManufacturer=false;
        Boolean drugExistsInList=false;
        for(Drug drug: enterprise.getDrugList())
        {
            if(drug.getName().equalsIgnoreCase(drugName))
            {
                drugExistsInList=true;
                JOptionPane.showMessageDialog(null,"This drug already exists in your list");

                break;
            }
        }
        
                 ArrayList<ManufactureEnterprise>mEnterpriseList=new ArrayList<ManufactureEnterprise>();
        for(Enterprise everyEnterprise:network.getEnterpriseDirectory().getEnterpriseList())
        {
            if(everyEnterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Manufacture))
            {
                
                mEnterpriseList.add((ManufactureEnterprise) everyEnterprise);
            
            }
            
        }
        Drug newDrugtoBeAdded=new Drug("drugname",0);
        if(drugExistsInList==false){
        for(ManufactureEnterprise mEnterprise:mEnterpriseList)
        {
                
                if(mEnterprise.getName().equalsIgnoreCase(drugManufacturer))
                {
                    for(Drug drug:mEnterprise.getDrugList())
                    {
                        if(drug.getName().equalsIgnoreCase(drugName))
                        {
                            drugExistsWithManufacturer=true;
                            newDrugtoBeAdded=drug;
                            break;
                        }
                    }
                }
        }
        }
        if(drugExistsInList==false&&drugExistsWithManufacturer==true)
        {
                enterprise.getDrugList().add(newDrugtoBeAdded);
        }
    }//GEN-LAST:event_addNewDrugBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
        populateDrugTable();
    }//GEN-LAST:event_refreshBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DrugsDistributedPanel;
    private javax.swing.JButton addANewDrugBtn;
    private javax.swing.JButton addEmployeeBtn;
    private javax.swing.JButton addNewDrugBtn;
    private javax.swing.JButton addOrganizationJButton;
    private javax.swing.JButton createUserJButton;
    private javax.swing.JLabel dosageLabel;
    private javax.swing.JTextField dosageTxtFld;
    private javax.swing.JTextField drugManufactureTxtFld;
    private javax.swing.JTable drugTable;
    private javax.swing.JTextField drugnameTxtFld;
    private javax.swing.JComboBox employeeJComboBox;
    private javax.swing.JTextField enterpriseNameTxtField;
    private javax.swing.JLabel enterpriseTypeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTextField nameJTextField1;
    private javax.swing.JComboBox organizationEmpJComboBox;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JComboBox organizationJComboBox1;
    private javax.swing.JComboBox organizationJComboBox2;
    private javax.swing.JTable organizationJTable;
    private javax.swing.JTable organizationJTable1;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JTable userJTable;
    private javax.swing.JButton viewDrugDetailsBtn;
    private javax.swing.JPanel viewDrugDetailsInnerPanel;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
