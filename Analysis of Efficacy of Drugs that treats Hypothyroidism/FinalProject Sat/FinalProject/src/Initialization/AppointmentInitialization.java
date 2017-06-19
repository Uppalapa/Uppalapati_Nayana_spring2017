/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Initialization;

import Business.Appointment.Appointment;
import Business.Employee.Employee;
import Business.Enterprise.HospitalEnterprise;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.Role.DoctorRole;
import Business.UserAccount.PatientUserAccount;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AppointmentWorkRequest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import Business.UserAccount.EmployeeUserAccount;

/**
 *
 * @author chand
 */
public class AppointmentInitialization {
  
    private static ArrayList<Appointment> appointmentList;
    public static ArrayList<Appointment> initializeAppointmentHistory(PatientUserAccount pua,Patient patient,HospitalEnterprise hEnterprise){
        
        appointmentList=new ArrayList<Appointment>();
        //Generate a date for Jan. 9, 2013, 10:11:12 AM
        Calendar cal = Calendar.getInstance();
        cal.set(2013, Calendar.JANUARY, 9); //Year, month and day of month
        Date date = cal.getTime();
        
        while(appointmentList.size()<=2)
        {
            AppointmentWorkRequest request=new AppointmentWorkRequest();
           request.setSender(pua);
           
           UserAccount ua=searchForDoctorAccount(hEnterprise);
           System.out.println("Useraccount random: "+ua.getUsername());
           request.setReceiver(ua);
         Employee employee=searchForDoctorUA(hEnterprise, ua);
        System.out.println("Date selected is: "+date.toString());
        cal.add(Calendar.MONTH, 3);
        date=cal.getTime();
        Appointment appointment=new Appointment(patient, ua.getUsername(), date);
        
        patient.getAppointmentHist().add(appointment);
        hEnterprise.getAppointmentDirectory().getAppointmentHistory().add(appointment);
        
        appointment.setScheduledBy(searchForScheduler(hEnterprise));
        
        
        
        
        appointmentList.add(appointment);
        
        
        
        }
        
        
        
        return appointmentList;
        
        
    } 
    private static Employee searchForDoctor(HospitalEnterprise hEnterprise)
    {
        Employee employee=new Employee();
        
        ArrayList<Employee> doctorList=new ArrayList<Employee>();
        for(Employee everyEmployee:hEnterprise.getEmployeeDirectory().getEmployeeList())
        {
            doctorList.add(everyEmployee);
        }
        if(doctorList.size()>0)
        {
        employee=doctorList.get(randInt(0,(doctorList.size())));
        }
        
        
        
        
        
        return employee;
    }
    
    private static Employee searchForDoctorUA(HospitalEnterprise enterprise,UserAccount ua)

    {




        Employee employee=new Employee();

           EmployeeUserAccount uacc=new EmployeeUserAccount();
        
        
        for(UserAccount eua:enterprise.getUserAccountDirectory().getUserAccountList())
        {
            if(eua.getRole().equals(new DoctorRole())&&ua.getUsername().equalsIgnoreCase(eua.getUsername()))
            {
                System.out.println("Before: "+eua.getUsername());
                uacc=(EmployeeUserAccount)eua;
                System.out.println("After: "+uacc.getUsername());
                return uacc.getEmployee();
                
            }
            
        }
        


            

            return employee;

    }
private static int randInt(int min, int max) {
        Random rand = new Random();
        
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min)) + min;

        return randomNum;
    }
    private static UserAccount searchForDoctorAccount(HospitalEnterprise enterprise){
        UserAccount uacc=new UserAccount();
        
        for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList())
        {
            if(organization.getName().equalsIgnoreCase(Organization.Type.Doctor.getValue()))
            {
                int randomized=randInt(0, (organization.getUserAccountDirectory().getUserAccountList().size()-1));
                int i=0;
             for(UserAccount eua:organization.getUserAccountDirectory().getUserAccountList())
            {
                if(i==randomized)
                {
                return eua;
                }
                i++;
            }
            
        }
            }
        
        
        
        return uacc;
    }
     private static Employee searchForScheduler(HospitalEnterprise hEnterprise)
    {
        for(Organization organization:hEnterprise.getOrganizationDirectory().getOrganizationList())
        {
            if(organization.getName().equalsIgnoreCase(Organization.Type.Schedule.getValue()))
            {
                int i=randInt(0, (organization.getEmployeeDirectory().getEmployeeList().size()-1));
                Employee employee=organization.getEmployeeDirectory().getEmployeeList().get(i);
            }
        }
        return null;
    }
}
