/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import java.util.ArrayList;
import Business.Role.LabAssistantRole;
import Business.WorkQueue.LabTestWorkQueue;

/**
 *
 * @author uppal
 */
public class LabOrganization extends Organization{

    private LabTestWorkQueue labTestWorkQueue;
    
    public LabOrganization() {
        super(Organization.Type.Lab.getValue());
        labTestWorkQueue=new LabTestWorkQueue();
    }

    public LabTestWorkQueue getLabTestWorkQueue() {
        return labTestWorkQueue;
    }

    public void setLabTestWorkQueue(LabTestWorkQueue labTestWorkQueue) {
        this.labTestWorkQueue = labTestWorkQueue;
    }
    
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new LabAssistantRole());
        return roles;
    }
     
   
      
    
}
