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
import Business.Organization.PatientOrganization;
import Business.UserAccount.PatientUserAccount;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.PatientRole.PatientWorkAreaJPanel;

/**
 *
 * @author uppal
 */
public class PatientRole extends Role {

    public PatientRole(){
        
        super(RoleType.Patient);
    }
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,Network network, EcoSystem business) {
        return new PatientWorkAreaJPanel(userProcessContainer, (PatientUserAccount)account, (PatientOrganization)organization, enterprise);
    }
    
    
}
