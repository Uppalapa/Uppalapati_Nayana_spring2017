/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.SalesPersonRole;
import Business.WorkQueue.SalesWorkQueue;
import java.util.ArrayList;

/**
 *
 * @author uppal
 */
public class SalesOrganization extends Organization{

    private SalesWorkQueue salesWorkQueue;
    public SalesOrganization() {
        super(Type.Sales.getValue());
        salesWorkQueue=new SalesWorkQueue();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SalesPersonRole());
        return roles;
    }

    public SalesWorkQueue getSalesWorkQueue() {
        return salesWorkQueue;
    }

    public void setSalesWorkQueue(SalesWorkQueue salesWorkQueue) {
        this.salesWorkQueue = salesWorkQueue;
    }
      
    
}
