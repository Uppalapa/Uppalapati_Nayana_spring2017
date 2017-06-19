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

/**
 *
 * @author uppal
 */
public abstract class Role {
      public enum RoleType{
        Admin("Admin"),
        Doctor("Doctor"),
        LabAssistant("Lab Assistant"),
        Distributor("Distributor"),
        Scheduler("Scheduler"),
        Patient("Patient"),
        SalesPerson("SalesPerson"),
        ManufactureAdmin("ManufactureAdmin"),
        DistributorAdmin("DistributorAdmin"),
        SystemAdmin("SystemAdmin");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
      private RoleType roleType;

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
      
      public Role(RoleType roleType)
      {
          this.setRoleType(roleType);
      }

    @Override
    public String toString() {
        return this.getRoleType().getValue();
    }
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, Network network,
            EcoSystem business);

    
    
}
