/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DistributorRole;
import Business.Role.Role;
import Business.WorkQueue.DrugOrderWorkQueue;
import java.util.ArrayList;

/**
 *
 * @author uppal
 */
public class DistributingOrganization extends Organization{

    private DrugOrderWorkQueue drugOrderWorkQueue;
    
    public DistributingOrganization() {
        super(Type.Distributor.getValue());
        drugOrderWorkQueue=new DrugOrderWorkQueue();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DistributorRole());
        return roles;
    }

    public DrugOrderWorkQueue getDrugOrderWorkQueue() {
        return drugOrderWorkQueue;
    }

    public void setDrugOrderWorkQueue(DrugOrderWorkQueue drugOrderWorkQueue) {
        this.drugOrderWorkQueue = drugOrderWorkQueue;
    }

    
    
      
    
}
