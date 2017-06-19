/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Initialization;

import Business.Enterprise.Enterprise;
import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Enterprise.HospitalEnterprise;
import Business.Organization.DistributingOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import Business.Organization.PatientOrganization;
import Business.Organization.SalesOrganization;
import Business.Organization.SchedulerOrganization;

/**
 *
 * @author chand
 */
public class OrganizationInitialization {
    
    public static OrganizationDirectory organizationDirectory;
    
    public static OrganizationDirectory initializeOrganizations(EnterpriseType type,Enterprise enterprise){
        
        organizationDirectory=new OrganizationDirectory();
        
        if(type.getValue().equalsIgnoreCase(EnterpriseType.Hospital.getValue()))
        {
        
        DoctorOrganization dOrganization=new DoctorOrganization();
        dOrganization.setEmployeeDirectory(Initialization.EmployeeIntialization.initializeEmployeesInOrganization());
        dOrganization.setName(Type.Doctor.getValue());
        dOrganization.setUserAccountDirectory(Initialization.EmployeeIntialization.initializeEmployeeUSerAccountDirectory(dOrganization));
        System.out.println("Size of useraccountDirectory: "+dOrganization.getUserAccountDirectory().getUserAccountList().size());
        
        LabOrganization lOrganization=new LabOrganization();
        lOrganization.setEmployeeDirectory(Initialization.EmployeeIntialization.initializeEmployeesInOrganization());
        lOrganization.setName(Type.Lab.getValue());
        lOrganization.setUserAccountDirectory(Initialization.EmployeeIntialization.initializeEmployeeUSerAccountDirectory(lOrganization));
        System.out.println("Size of useraccountDirectory: "+lOrganization.getUserAccountDirectory().getUserAccountList().size());
        
        SchedulerOrganization schOrganization=new SchedulerOrganization();
        schOrganization.setEmployeeDirectory(Initialization.EmployeeIntialization.initializeEmployeesInOrganization());
        schOrganization.setName(Type.Schedule.getValue());
        schOrganization.setUserAccountDirectory(Initialization.EmployeeIntialization.initializeEmployeeUSerAccountDirectory(schOrganization));
        System.out.println("Size of useraccountDirectory: "+schOrganization.getUserAccountDirectory().getUserAccountList().size());
        
        
        PatientOrganization pOrganization = new PatientOrganization();
        pOrganization.setPatientDiretcory(Initialization.EmployeeIntialization.initializePatientInOrganization((HospitalEnterprise)enterprise));
        pOrganization.setUserAccountDirectory(Initialization.EmployeeIntialization.initializePatientUSerAccountDirectory(pOrganization,(HospitalEnterprise)enterprise));
        System.out.println("Size of useraccountDirectory: "+pOrganization.getUserAccountDirectory().getUserAccountList().size());
        
        //printing the patients
      /*  for(Patient patient:pOrganization.getPatientDiretcory().getPatientList())
        {
            System.out.println("Patient first name: "+patient.getFirstName()+"  LAst name: "+patient.getLastName());
        }
        pOrganization.setName(Type.Patient.getValue());
        */
        
        organizationDirectory.getOrganizationList().add(dOrganization);
        organizationDirectory.getOrganizationList().add(lOrganization);
        organizationDirectory.getOrganizationList().add(schOrganization);
        organizationDirectory.getOrganizationList().add(pOrganization);
        }
        else if(type.getValue().equalsIgnoreCase(EnterpriseType.Manufacture.getValue()))
        {
             SalesOrganization sOrganization=new SalesOrganization();
             sOrganization.setEmployeeDirectory(Initialization.EmployeeIntialization.initializeEmployeesInOrganization());
             sOrganization.setName(Type.Sales.getValue());
             sOrganization.setUserAccountDirectory(Initialization.EmployeeIntialization.initializeEmployeeUSerAccountDirectory(sOrganization));
            
             System.out.println("Size of useraccountDirectory: "+sOrganization.getUserAccountDirectory().getUserAccountList().size());
        
        organizationDirectory.getOrganizationList().add(sOrganization);
       
        }
        else if(type.getValue().equalsIgnoreCase(EnterpriseType.Distributor.getValue()))
        {
            DistributingOrganization diOrganization=new DistributingOrganization();
            diOrganization.setEmployeeDirectory(Initialization.EmployeeIntialization.initializeEmployeesInOrganization());
            diOrganization.setUserAccountDirectory(Initialization.EmployeeIntialization.initializeEmployeeUSerAccountDirectory(diOrganization));
            diOrganization.setName(Type.Schedule.getValue());
            System.out.println("Size of useraccountDirectory: "+diOrganization.getUserAccountDirectory().getUserAccountList().size());
        
        organizationDirectory.getOrganizationList().add(diOrganization);
        
        }
        
        
        
        return organizationDirectory;
        
    }
    
}
