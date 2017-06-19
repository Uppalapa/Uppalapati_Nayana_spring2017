/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem.EcoSystem;
import Business.Enterprise.DistributingEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.DistributingAdmin.DistributingAdminWorkAreaPanel;

/**
 *
 * @author chand
 */
public class DistributorAdminRole extends Role{

    public DistributorAdminRole(){
        
        super(RoleType.Distributor);
    }
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,Network network, EcoSystem business) {
        return new DistributingAdminWorkAreaPanel(userProcessContainer,network, (DistributingEnterprise)enterprise);
    }
    
}
