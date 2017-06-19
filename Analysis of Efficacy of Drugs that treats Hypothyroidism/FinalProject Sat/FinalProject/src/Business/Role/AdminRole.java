/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.HospitalAdministrativeRole.HospitalAdminWorkAreaJPanel;

/**
 *
 * @author uppal
 */
public class AdminRole extends Role{
    
    public AdminRole(){
        
        super(RoleType.Admin);
    }
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network,EcoSystem business) {
        
        return new HospitalAdminWorkAreaJPanel(userProcessContainer, network,enterprise);
    }


    
}
