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
import UserInterface.LabAssistantRole.LabAssistantWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author uppal
 */
public class LabAssistantRole extends Role {
    
    public LabAssistantRole(){
        
        super(RoleType.LabAssistant);
    }
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network,EcoSystem business) {
        return new LabAssistantWorkAreaJPanel(userProcessContainer, account, organization,enterprise,network, business);
    }

    
    
}
