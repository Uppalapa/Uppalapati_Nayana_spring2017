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
import Business.Organization.SchedulerOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.SchedulerRole.SchedulerWorkArea;

/**
 *
 * @author uppal
 */
public class SchedulerRole extends Role{

    public SchedulerRole(){
        
        super(RoleType.Scheduler);
    }
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network,EcoSystem business) {
        return new SchedulerWorkArea(userProcessContainer, account, (SchedulerOrganization) organization,network, enterprise);
    }
    
    
}
