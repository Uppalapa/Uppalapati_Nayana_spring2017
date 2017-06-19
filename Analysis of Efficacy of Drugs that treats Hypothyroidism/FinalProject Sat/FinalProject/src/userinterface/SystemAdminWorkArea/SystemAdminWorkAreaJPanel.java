/*
 * AdminWorkAreaJPanel.java
 *
 * Created on October 10, 2008, 8:50 AM
 */
package UserInterface.SystemAdminWorkArea;

import Business.Appointment.Appointment;
import Business.Drug.Drug;
import Business.EcoSystem.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.ManufactureEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Patient.Patient;
import Business.VitalSigns.VitalSign;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import userinterface.SystemAdminWorkArea.DrugActiveCompoundAnalysisPanel;
import userinterface.SystemAdminWorkArea.ReportPanel;
import userinterface.SystemAdminWorkArea.PatientsPanel;
import userinterface.SystemAdminWorkArea.BestDrugPanel;
import userinterface.SystemAdminWorkArea.DisplayPanel;
/**
 *
 * @author chand
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    EcoSystem system;

    /**
     * Creates new form AdminWorkAreaJPanel
     */
    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;

        populateTree();
    }

    public void populateTree() {
        
        DefaultTreeModel model = (DefaultTreeModel) JTree.getModel();

        ArrayList<Network> networkList = system.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;
        Network network;
        Enterprise enterprise;
        Organization organization;

        DefaultMutableTreeNode networks = new DefaultMutableTreeNode("Networks");
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();
        root.insert(networks, 0);

        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
        for (int i = 0; i < networkList.size(); i++) {
            network = networkList.get(i);
            networkNode = new DefaultMutableTreeNode(network);
            networks.insert(networkNode, i);

            enterpriseList = network.getEnterpriseDirectory().getEnterpriseList();

            for (int j = 0; j < enterpriseList.size(); j++) {
                enterprise = enterpriseList.get(j);
                enterpriseNode = new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);

                organizationList = enterprise.getOrganizationDirectory().getOrganizationList();
                for (int k = 0; k < organizationList.size(); k++) {
                    organization = organizationList.get(k);
                    organizationNode = new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);
                }
            }
        }

        
        model.reload();
    }
    public ChartPanel pushChartPanel(HashMap<String,Integer> tMap,String heading){
//        int s1=Integer.parseInt(text1.getText());
//        int s2=Integer.parseInt(text2.getText());
//        int s3=Integer.parseInt(text3.getText());
//        int s4=Integer.parseInt(text4.getText());

       DefaultCategoryDataset dataset=new DefaultCategoryDataset();
//        dataset.setValue(50,"","Section1");
//        dataset.setValue(60,"","Section2");
//        dataset.setValue(70,"","Section3");
//        dataset.setValue(80,"","Section4");
        ArrayList<String> drugs=new ArrayList<String>();
        ArrayList<Integer> ints=new ArrayList<Integer>();

            Set<Map.Entry<String, Integer>> grabset = tMap.entrySet();
      Iterator<Map.Entry<String,Integer>> i = grabset.iterator();
       while (i.hasNext()){
          Map.Entry<String,Integer> me = (Map.Entry<String,Integer>)i.next();
//          dataset.setValue(me.getValue(), "",(String)me.getKey());
        drugs.add(me.getKey());
        ints.add(me.getValue());
         
       }
       for(int j=0;j<drugs.size();j++)
        {
            dataset.setValue(ints.get(j)," ",drugs.get(j)+""+j);
            
            
        }
         

        org.jfree.chart.JFreeChart chart=ChartFactory.createBarChart(heading, "","", dataset,PlotOrientation.VERTICAL,true,true,true);
        CategoryPlot catPlot=chart.getCategoryPlot();
        catPlot.setRangeGridlinePaint(Color.MAGENTA);

        ChartPanel chartPanel=new ChartPanel(chart);
//        panel.removeAll();
//        panel.add(chartPanel,BorderLayout.CENTER);
        return chartPanel;
    }
    private  PieDataset createDataset()
    {
        DefaultPieDataset result=new DefaultPieDataset();
        result.setValue("Windows",65);
        result.setValue("Mac",15);
        result.setValue("Linux",20);
        return result;
    }
    
    public Network searchForNetwork(String objName)
    {
        Network nt=new Network();
        
        for(Network network:system.getNetworkList()){
            if(network.getName().equalsIgnoreCase(objName))
            {
                return network;
            }
        }
        
        return nt;
    }
    private DefaultCategoryDataset generateActiveDataset()
    {
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        for(Network network:system.getNetworkList())
        {
            ManufactureEnterprise mEnterprise;
            for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
            {
                if(enterprise.getEnterpriseType().getValue().equalsIgnoreCase(Enterprise.EnterpriseType.Manufacture.getValue()))
                {
                mEnterprise=(ManufactureEnterprise)enterprise;
                for(Drug drug:mEnterprise.getDrugList())
                {
                   
                    dataset.setValue(drug.getActiveCompound().getPercentageInDrug(),"",drug.getName());
                    
                }
                }
            }
        }
        return dataset;
    }
    public static  HashMap<String,Integer> checkMap(String testString,int testInt,HashMap<String,Integer> testmap)
    {
        Set<Map.Entry<String, Integer>> grabset = testmap.entrySet();
      Iterator<Map.Entry<String,Integer>> i = grabset.iterator();
      int newValue=testInt;
      
      if(testmap.containsKey(testString))
      {
          
          int tst=testmap.get(testString);
          int existingValue=0;
          while (i.hasNext()){
          Map.Entry<String,Integer> me = (Map.Entry<String,Integer>)i.next();
          if(((String)me.getKey()).equalsIgnoreCase(testString))
          {
              existingValue=(Integer)me.getValue();
          }
          System.out.println ("Check:"+(String)me.getKey()+"  "+me.getValue());
            }
          newValue=newValue+existingValue;
          
          
          
          
          
      }
      else
      {
          //testmap.put(testString,newValue);
      }
      testmap.put(testString,newValue);
      return testmap;
    }
    
    
    private void printMap(HashMap<String,Integer> testmap)
    {
         Set<Map.Entry<String, Integer>> grabset = testmap.entrySet();
      Iterator<Map.Entry<String,Integer>> i = grabset.iterator();
       while (i.hasNext()){
          Map.Entry<String,Integer> me = (Map.Entry<String,Integer>)i.next();
          
          System.out.println ((String)me.getKey()+"  "+me.getValue());
            }
         
    }

    public HashMap<String,Integer> checkForBestDrug()
    {
        
        HashMap<String,Integer> hmap = new HashMap<String,Integer>();
        PatientOrganization pOrganization;
        for(Network network:system.getNetworkList())
        {
            for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
            {
                if(enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Hospital))
                {
                    enterprise=(HospitalEnterprise)enterprise;
                    for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList())
                    {
                        if(organization.getName().equalsIgnoreCase(Organization.Type.Patient.getValue()))
                        {
                            pOrganization=(PatientOrganization)organization;
                            for(Patient patient:pOrganization.getPatientDiretcory().getPatientList())
                            {
                                int improvementCount=0;
                                int currentElement=0;
                                
                                for(VitalSign vitalSign:patient.getVitalSignHistory().getVitalSignList())
                                {
                                    if(currentElement>0){
                                    
                                    if(vitalSign.getTsh()<5.50&&vitalSign.getTsh()>0.35)
                                    {
                                        
                                        VitalSign vsBefore=patient.getVitalSignHistory().getVitalSignList().get(currentElement-1);
                                        if(vsBefore.getTsh()>vitalSign.getTsh())
                                        {
                                        improvementCount++;
                                        Appointment app=patient.searchForAppointment(vsBefore.getReportId());
                                        Drug drug=app.getPrescribedDrug();
                                        System.out.println("drug now: "+drug.getName());
                                        hmap=checkMap(drug.getName(),1, hmap);
                                        System.out.println("I'm here");
                                        }
                                    }
                                    }
                                    currentElement++;
                                    
                                }
                                int threshold=(patient.getVitalSignHistory().getVitalSignList().size())/2;
                                if(improvementCount>threshold)
                                {
                                    
                                }
                            }
                            
                        }
                    }
                }
            }
        }
        return hmap;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        userPP = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        bestDrugBtn = new javax.swing.JButton();
        patientsSufferingBtn = new javax.swing.JButton();
        chemicalCompoundsAnalysisBtn = new javax.swing.JButton();
        percentOfPatientsinhEntrpriseBtn = new javax.swing.JButton();
        manageAdminJButton = new javax.swing.JButton();
        manageEnterpriseJButton = new javax.swing.JButton();
        manageNetworkJButton = new javax.swing.JButton();
        selectedNodeJLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTree = new javax.swing.JTree();

        jSplitPane1.setDividerLocation(150);

        userPP.setLayout(new java.awt.CardLayout());

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));

        bestDrugBtn.setText("Which is the best drug");
        bestDrugBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bestDrugBtnActionPerformed(evt);
            }
        });

        patientsSufferingBtn.setText("Number of patients suffering from");
        patientsSufferingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientsSufferingBtnActionPerformed(evt);
            }
        });

        chemicalCompoundsAnalysisBtn.setText("Analyse chemical compounds of each drug");
        chemicalCompoundsAnalysisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chemicalCompoundsAnalysisBtnActionPerformed(evt);
            }
        });

        percentOfPatientsinhEntrpriseBtn.setText("Percentage of patients going to each hospital enterprise in the network");
        percentOfPatientsinhEntrpriseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                percentOfPatientsinhEntrpriseBtnActionPerformed(evt);
            }
        });

        manageAdminJButton.setText("Manage Enterprise Admin");
        manageAdminJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAdminJButtonActionPerformed(evt);
            }
        });

        manageEnterpriseJButton.setText("Manage Enterprise");
        manageEnterpriseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEnterpriseJButtonActionPerformed(evt);
            }
        });

        manageNetworkJButton.setText("Manage Network");
        manageNetworkJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageNetworkJButtonActionPerformed(evt);
            }
        });

        selectedNodeJLabel.setText("<view_selected_node>");

        jLabel1.setText("Selected Node:");

        jButton1.setText("Get chemical compounds of each drug");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectedNodeJLabel)
                .addGap(79, 79, 79))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(manageAdminJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(manageEnterpriseJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageNetworkJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(313, 313, 313))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(patientsSufferingBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bestDrugBtn)
                            .addComponent(percentOfPatientsinhEntrpriseBtn)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addComponent(chemicalCompoundsAnalysisBtn)))
                        .addGap(115, 340, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectedNodeJLabel)
                    .addComponent(jLabel1))
                .addGap(52, 52, 52)
                .addComponent(bestDrugBtn)
                .addGap(22, 22, 22)
                .addComponent(chemicalCompoundsAnalysisBtn)
                .addGap(28, 28, 28)
                .addComponent(patientsSufferingBtn)
                .addGap(53, 53, 53)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(percentOfPatientsinhEntrpriseBtn)
                .addGap(62, 62, 62)
                .addComponent(manageAdminJButton)
                .addGap(18, 18, 18)
                .addComponent(manageEnterpriseJButton)
                .addGap(18, 18, 18)
                .addComponent(manageNetworkJButton)
                .addGap(91, 91, 91))
        );

        userPP.add(jPanel3, "card2");

        jSplitPane1.setRightComponent(userPP);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("System");
        JTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        JTree.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTree.setMaximumSize(new java.awt.Dimension(100, 20));
        JTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                valueChangedAction(evt);
            }
        });
        jScrollPane1.setViewportView(JTree);

        jPanel2.add(jScrollPane1);

        jSplitPane1.setLeftComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageEnterpriseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEnterpriseJButtonActionPerformed

        ManageEnterpriseJPanel manageEnterpriseJPanel = new ManageEnterpriseJPanel(userProcessContainer, system);
        userProcessContainer.add("manageEnterpriseJPanel", manageEnterpriseJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEnterpriseJButtonActionPerformed

    private void manageAdminJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAdminJButtonActionPerformed
        // TODO add your handling code here:
        ManageEnterpriseAdminJPanel manageEnterpriseAdminJPanel = new ManageEnterpriseAdminJPanel(userProcessContainer, system);
        userProcessContainer.add("manageEnterpriseAdminJPanel", manageEnterpriseAdminJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageAdminJButtonActionPerformed

    private void manageNetworkJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageNetworkJButtonActionPerformed
        ManageNetworkJPanel manageNetworkJPanel = new ManageNetworkJPanel(userProcessContainer, system);
        userProcessContainer.add("manageNetworkJPanel", manageNetworkJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageNetworkJButtonActionPerformed

    private void valueChangedAction(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_valueChangedAction
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) JTree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            selectedNodeJLabel.setText(selectedNode.toString());
        }

    }//GEN-LAST:event_valueChangedAction

    private void bestDrugBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bestDrugBtnActionPerformed
        // TODO add your handling code here:
       HashMap<String,Integer> hmap=checkForBestDrug();
        printMap(hmap);
        ChartPanel chPanel=pushChartPanel(hmap,"Evaluation Of Best Drug");
        BestDrugPanel panel=new BestDrugPanel(userProcessContainer,chPanel);
        userProcessContainer.add("Best drug", panel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

        
        
        
        
    }//GEN-LAST:event_bestDrugBtnActionPerformed

    private void patientsSufferingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientsSufferingBtnActionPerformed
        // TODO add your handling code here:
        HashMap<String,Integer> hmap=new HashMap<String,Integer>();
        PatientOrganization pOrganization;
        for(Network network:system.getNetworkList())
        {
            
            int numOfPatients=0;
           for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
            {
                if(enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Hospital))
                {
                    enterprise=(HospitalEnterprise)enterprise;
                    for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList())
                    {
                        if(organization.getName().equalsIgnoreCase(Organization.Type.Patient.getValue()))
                        {
                            pOrganization=(PatientOrganization)organization;
                            for(Patient patient:pOrganization.getPatientDiretcory().getPatientList())
                            {
                                numOfPatients++;
                            }
                        }
                    }
                }
                 hmap.put(network.getName(),numOfPatients);
                
            }
           
            
        }
        printMap(hmap);
        ChartPanel chPanel=pushChartPanel(hmap,"PAtients suffering from Hypo ");
        PatientsPanel panel=new PatientsPanel(userProcessContainer,chPanel);
        userProcessContainer.add("PatientsPanel",panel);
     CardLayout layout = (CardLayout) userProcessContainer.getLayout();
     System.out.println("I'm here");
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_patientsSufferingBtnActionPerformed

    private JPanel getInfoPanel(Network network)
    {
        JPanel panel=new JPanel();
        JLabel label = new JLabel();
        
        
        ImageIcon icon=new ImageIcon(network.getFlagIcon());
        icon.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
        label.setIcon(icon);
      

       
        panel.add(label);


        
        
        
        
        return panel;
    }
    
    private void percentOfPatientsinhEntrpriseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_percentOfPatientsinhEntrpriseBtnActionPerformed
        // TODO add your handling code here:
           ReportPanel panel=new ReportPanel(userProcessContainer,system);
            userProcessContainer.add("ReportPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
            
        
    }//GEN-LAST:event_percentOfPatientsinhEntrpriseBtnActionPerformed

    private void chemicalCompoundsAnalysisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chemicalCompoundsAnalysisBtnActionPerformed
        // TODO add your handling code here:
        DrugActiveCompoundAnalysisPanel panel=new DrugActiveCompoundAnalysisPanel(userProcessContainer,generateActiveDataset());
         userProcessContainer.add("manageNetworkJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_chemicalCompoundsAnalysisBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PieDataset dataset=createDataset();
        //JFreeChart chart=createChart(dataset,chartTitle);
       
        JFreeChart chart=ChartFactory.createPieChart3D("Pie chart", dataset, true, true, false);
       PiePlot3D plot=(PiePlot3D) chart.getPlot();
       plot.setStartAngle(0);
       plot.setDirection(Rotation.CLOCKWISE);
       plot.setForegroundAlpha(0.5f);
        ChartPanel chartPanel=new ChartPanel(chart);
        DisplayPanel dPanel=new DisplayPanel(userProcessContainer,chartPanel);
         userProcessContainer.add("manageNetworkJPanel", dPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree JTree;
    private javax.swing.JButton bestDrugBtn;
    private javax.swing.JButton chemicalCompoundsAnalysisBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton manageAdminJButton;
    private javax.swing.JButton manageEnterpriseJButton;
    private javax.swing.JButton manageNetworkJButton;
    private javax.swing.JButton patientsSufferingBtn;
    private javax.swing.JButton percentOfPatientsinhEntrpriseBtn;
    private javax.swing.JLabel selectedNodeJLabel;
    private javax.swing.JPanel userPP;
    // End of variables declaration//GEN-END:variables
}
