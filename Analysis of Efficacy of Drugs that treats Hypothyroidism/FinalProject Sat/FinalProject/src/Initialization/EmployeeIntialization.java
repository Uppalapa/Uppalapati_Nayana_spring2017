/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Initialization;

import Business.Appointment.Appointment;
import Business.Appointment.AppointmentDirectory;
import Business.Employee.Employee;
import Business.Employee.EmployeeDirectory;
import Business.Enterprise.HospitalEnterprise;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Patient.Patient;
import Business.Patient.PatientDirectory;
import Business.Role.PatientRole;
import Business.Role.Role;
import Business.UserAccount.EmployeeUserAccount;
import Business.UserAccount.PatientUserAccount;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author chand
 */
public class EmployeeIntialization {

    public static EmployeeDirectory masterEmployeeDirectory = new EmployeeDirectory();
    public static EmployeeDirectory employeeDirectory;
    public static PatientDirectory patientDirectory;
    public static ArrayList<String> existingUserNames;
    public static ArrayList<String> existingPatientNames;
    public static ArrayList<String> existingEmployeeNames;

    public static EmployeeDirectory initializeEmployeesInOrganization() {
        
        employeeDirectory = new EmployeeDirectory();
        existingEmployeeNames = new ArrayList<String>();
        existingUserNames = new ArrayList<String>();
        while (employeeDirectory.getEmployeeList().size() <= 3) {
            Employee employee = new Employee();
            
            String empName = generateRandomName();
            if (!(existingEmployeeNames.contains(empName))) {
                employee.setName(empName);
                //create username and password for each employee
                EmployeeUserAccount euAccount = new EmployeeUserAccount();
                //euAccount.setEmployee(employee);
                String userName = generateRandomName();
                if (!(existingUserNames.contains(userName))) {
//                    euAccount.setUsername(userName);
//                    euAccount.setPassword(generateRandomName());
                   // System.out.println("Username: "+userName+"Password:"+euAccount.getPassword());
                }
                
                employeeDirectory.getEmployeeList().add(employee);
            }
        }
        return employeeDirectory;
        
    }

    public static PatientDirectory initializePatientInOrganization(HospitalEnterprise hEnterprise) {
        patientDirectory = new PatientDirectory();
        existingPatientNames = new ArrayList<String>();
        existingUserNames = new ArrayList<String>();
        String[] workOutStatus={"Active","lazy","inactive"};
        int counter = 01;
        System.out.println("Hospital name: "+hEnterprise.getName());
        while (patientDirectory.getPatientList().size() <= 3) {
            
            int patientNumber;
            String firstName = generateRandomName();  
            String lastname=generateRandomName();
            int age=randInt(10,70);
            Patient patient = new Patient(hEnterprise.getName(), firstName, counter);
            
            if (!(existingPatientNames.contains(firstName))) {
                patient.setFirstName(firstName);
                patient.setLastName(lastname);
                
                patient.setAge(age);
                
                if (!(existingUserNames.contains(firstName))) {
                    counter++;
                }
                //Adding appointments to the patient
               //patient.setAppointmentHist(Initialization.AppointmentInitialization.initializeAppointmentHistory(patient,hEnterprise));
              
                
                patientDirectory.getPatientList().add(patient);
            }
        }
        return patientDirectory;
        
    }
    
    private static String generateRandomName() {
        // TODO code application logic here
        final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        final java.util.Random rand = new java.util.Random();

        // consider using a Map<String,Boolean> to say whether the identifier is being used or not 
        final Set<String> identifiers = new HashSet<String>();
        
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        //System.out.println("Names:"  + builder.toString());
        return builder.toString();
        
    }
    private static int randInt(int min, int max) {
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    public static UserAccountDirectory initializeEmployeeUSerAccountDirectory(Organization organization){
        System.out.println("-------------------------------------------------Printing Employees for: "+organization.getName()+"------------------------------------");
        UserAccountDirectory userAccountDirectory=new UserAccountDirectory();
        Role role=organization.getSupportedRole().get(0);
        System.out.println("Role of organization: "+organization.getSupportedRole().get(0));
        for(Employee employee:organization.getEmployeeDirectory().getEmployeeList())
        {
            
            
            EmployeeUserAccount eua=new EmployeeUserAccount();
            eua.setUsername(employee.getName());
            eua.setPassword("Employ&1");
            eua.setEmployee(employee);
            eua.setRole(role);
            System.out.println("Username: "+eua.getUsername()+"Password:"+eua.getPassword());
            organization.getUserAccountDirectory().createEmployeeUserAccount(eua.getUsername(), eua.getPassword(), employee,role);
            
            userAccountDirectory.getUserAccountList().add(eua);
            
        }
        
        return userAccountDirectory;
    }
    
    public static UserAccountDirectory initializePatientUSerAccountDirectory(PatientOrganization organization,HospitalEnterprise hEnterprise){
        System.out.println("-------------------------------------------------Printing patients for: "+organization.getName()+"------------------------------------");
        UserAccountDirectory userAccountDirectory=new UserAccountDirectory();
        
        for(Patient patient:organization.getPatientDiretcory().getPatientList())
        {
            PatientUserAccount pua=new PatientUserAccount();
            pua.setUsername(patient.getFirstName());
            pua.setPassword("Patien&1");
            pua.setPatient(patient);
            
            
            pua.setRole(new PatientRole());
            System.out.println("Username: "+pua.getUsername()+"Password:"+pua.getPassword());
            organization.getUserAccountDirectory().createPatientUserAccount(pua.getUsername(), pua.getPassword(),patient,new PatientRole());
            userAccountDirectory.getUserAccountList().add(pua);
            
        }
       // generateAppointments(hEnterprise);
        //generateVitalSigns(hEnterprise);
        return userAccountDirectory;
    }
    
    public static AppointmentDirectory  generateAppointments(HospitalEnterprise enterprise){
        AppointmentDirectory appDir=new AppointmentDirectory();
        PatientOrganization pOrganization;
        for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList())
        {
            if(organization.getName().equalsIgnoreCase(Organization.Type.Patient.getValue()))
            {
                pOrganization=(PatientOrganization)organization;
                for(UserAccount ua:pOrganization.getUserAccountDirectory().getUserAccountList())
                {
                    PatientUserAccount pua=(PatientUserAccount)ua;
                    
                 pua.getPatient().setAppointmentHist(Initialization.AppointmentInitialization.initializeAppointmentHistory(pua,pua.getPatient(),enterprise));   
                
                 for(Appointment appointment:pua.getPatient().getAppointmentHist())
                 {
                 appDir.getAppointmentHistory().add(appointment);
                 }
                }
            }
            
        }
        
        return appDir;
        
        
    }
    public static void generateVitalSigns(HospitalEnterprise enterprise)
    {
        PatientOrganization pOrganization;
        for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList())
        {
            if(organization.getName().equalsIgnoreCase(Organization.Type.Patient.getValue()))
            {
                pOrganization=(PatientOrganization)organization;
                for(UserAccount ua:pOrganization.getUserAccountDirectory().getUserAccountList())
                {
                    PatientUserAccount pua=(PatientUserAccount)ua;
                    
                    Patient patient=pua.getPatient();
                pua.getPatient().setVitalSignHistory(Initialization.VitalSignInitialization.initializeVitalSignHistory(patient.getAppointmentHist(),enterprise));
                System.out.println("Number of reports generated are: "+pua.getPatient().getVitalSignHistory().getVitalSignList().size());
                }
            }
        }
    }
}
