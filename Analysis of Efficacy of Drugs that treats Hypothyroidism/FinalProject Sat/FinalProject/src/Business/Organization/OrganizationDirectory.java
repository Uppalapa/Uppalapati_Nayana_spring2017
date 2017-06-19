/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author uppal
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;
       public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Organization.Type type){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Lab.getValue())){
            organization = new LabOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Patient.getValue())){
            organization = new PatientOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Sales.getValue())){
            organization = new SalesOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Distributor.getValue())){
            organization = new DistributingOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Schedule.getValue())){
            organization = new SchedulerOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    public Organization searchOrganization(String name)
    {
        for(Organization organization:organizationList)
        {
        if (name.equalsIgnoreCase(organization.getName())){
            return organization;
            
        }
        }
        return null;
        
    }
}
