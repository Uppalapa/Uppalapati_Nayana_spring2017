/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author chand
 */
public class NewJInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame
     */
    EcoSystem system;
    JPanel userProcessContainer;
    Component[] panels;
    public NewJInternalFrame(JPanel userProcessContainer,EcoSystem system) {
        initComponents();
        this.system=system;
        createMenuBar(system);
        this.userProcessContainer=userProcessContainer;
        generatePanels();
         addInternalFrameListener(new InternalFrameAdapter(){
            public void internalFrameClosing(InternalFrameEvent e) {
                // do something  
               //  userProcessContainer.remove(this);
     CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
   
            }
        });

    }

    private void generatePanels(){
        Point origin=new Point(10,20);
        int offset=35;
    
        int i=0;
        JPanel panel;
        for(Network selectedNetwork:system.getNetworkList())
        {
            
            panel=new JPanel();
        System.out.println("action is performed and network selected "+selectedNetwork.getName());
                ChartPanel chartPanel=pushChartPanel(createDataset(selectedNetwork),selectedNetwork.getName());
                panel.add(chartPanel);
                panel.setName(selectedNetwork.getName());
                panel.setBounds(origin.x, origin.y,200, 200);
                panel.setOpaque(true);
                panel.setVisible(false);
                panel.setBackground(Color.red);
                jLayeredPane1.add(panel,new Integer(i));
                origin.x+=offset;
                origin.y+=offset;
                i++;
        }
       panels=jLayeredPane1.getComponents();
        for(Component component:panels)
        {
            System.out.println("Panel"+component.getName());
        }
        
    }
    private void createMenuBar(EcoSystem system) {

        JMenuBar menubar = new JMenuBar();
       // ImageIcon icon = new ImageIcon("c:/Users/chand/Pictures/who-logo.jpg");

        JMenu file = new JMenu("Select a Network");
        
      //  file.setMnemonic(KeyEvent.VK_F);
      JMenuItem item;
        for(Network network:system.getNetworkList())
        {
            ImageIcon icon = new ImageIcon(network.getFlagIcon());
            item=new JMenuItem(network.getName(),icon);
            item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Network selectedNetwork=actionPerformedOn((JMenuItem)e.getSource());
                //JPanel panel1=(JPanel)selectedNetwork.getName();
                for(Component component:panels)
                {
                    if(selectedNetwork.getName().equalsIgnoreCase(component.getName()))
                    {
                        component.setVisible(true);
                    }
                }
                
            }
            });
            file.add(item);
            
        }
      
        JMenuItem eMenuItem = new JMenuItem("Exit");
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        file.add(eMenuItem);

        menubar.add(file);

        setJMenuBar(menubar);
    }
    public Network actionPerformedOn(JMenuItem item)
    {
        Network network;
        
        network=searchForNetwork(item.getText());
        
        
        return network;
        
    }
    public DefaultCategoryDataset createDataset(Network network)
    {
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        HospitalEnterprise hEnterprise;
        for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
        {
            if(enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Hospital))
            {
                hEnterprise=(HospitalEnterprise)enterprise;
                PatientOrganization pOrganization=null;
                for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList())
                {
                 
                    System.out.println("checking for patients");
                    if(enterprise.getOrganizationDirectory().searchOrganization(Organization.Type.Patient.getValue()).getName().equals(organization.getName()))
                    {
                    pOrganization=(PatientOrganization)organization;
                    dataset.setValue(pOrganization.getPatientDiretcory().getPatientList().size(),"",enterprise.getName());
                    }
                }
            }
        }
        
        
        
        return dataset;
    }
    public ChartPanel pushChartPanel(DefaultCategoryDataset dataset,String heading){

        org.jfree.chart.JFreeChart chart=ChartFactory.createBarChart(heading, "","", dataset,PlotOrientation.VERTICAL,true,true,true);
        CategoryPlot catPlot=chart.getCategoryPlot();
        catPlot.setRangeGridlinePaint(Color.MAGENTA);

        ChartPanel chartPanel=new ChartPanel(chart);
                 return chartPanel;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalPanel = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("New Internal frame");

        internalPanel.setOpaque(false);
        internalPanel.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                internalPanelVetoableChange(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 594, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 393, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout internalPanelLayout = new javax.swing.GroupLayout(internalPanel);
        internalPanel.setLayout(internalPanelLayout);
        internalPanelLayout.setHorizontalGroup(
            internalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, internalPanelLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        internalPanelLayout.setVerticalGroup(
            internalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, internalPanelLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(internalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(internalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void internalPanelVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_internalPanelVetoableChange
        // TODO add your handling code here:
         if (evt.getPropertyName().equals(IS_CLOSED_PROPERTY)) {
         boolean changed = ((Boolean) evt.getNewValue()).booleanValue();
         if (changed) {
             System.out.println("Value changed: "+changed);
             //this.getParent().setVisible(false);
             Component[] componentArray =userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
//        PatientWorkAreaJPanel panel=new PatientWorkAreaJPanel(userProcessContainer, userAccount, organization, enterprise);
//        panel.populateReportTable();
    userProcessContainer.remove(this);
     CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
             
             
         }
         }
        
         
    }//GEN-LAST:event_internalPanelVetoableChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel internalPanel;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables

    private Network searchForNetwork(String networkName) {
        
        Network nt=null;
        
        
        for(Network network:system.getNetworkList())
        {
            if(network.getName().equalsIgnoreCase(networkName))
            {
                return network;
            }
        }
        return nt;
        
    }
}
