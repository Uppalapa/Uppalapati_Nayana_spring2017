/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ManufactureEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.SalesPersonRole.SalesPersonWorkAreaJPanel;

/**
 *
 * @author uppal
 */
public class SalesPersonRole extends Role{

    public SalesPersonRole(){
        
        super(RoleType.SalesPerson);
    }
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network,EcoSystem business) {
        return new SalesPersonWorkAreaJPanel(userProcessContainer, account, (ManufactureEnterprise)enterprise,organization,network, business);
    }
      
}
