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
import userinterface.ManufacturerAdminRole.AdminWorkAreaJPanel;

/**
 *
 * @author chand
 */
public class ManufactureAdminRole extends Role{
    
    public ManufactureAdminRole(){
        
        super(RoleType.ManufactureAdmin);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,Network network, EcoSystem business) {
        return new AdminWorkAreaJPanel(userProcessContainer, network,enterprise);
    }
    
}
