/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Patient.Patient;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author chand
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public UserAccount createEmployeeUserAccount(String username, String password, Employee employee, Role role){
        EmployeeUserAccount userAccount = new EmployeeUserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
     public UserAccount createPatientUserAccount(String username, String password, Patient patient, Role role){
        PatientUserAccount userAccount = new PatientUserAccount();
        userAccount.setUsername(username);
        System.out.println("username is:"+userAccount.getUsername());
        userAccount.setPassword(password);
        userAccount.setPatient(patient);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
     
     public Patient searchPatient(String username){
         Patient patient=null;
         PatientUserAccount ua=null;
         System.out.println("Search for : "+username);
         for(UserAccount userAccount:userAccountList)
         {
             if(userAccount.getUsername().equalsIgnoreCase(username))
             {
                 System.out.print("USername : "+ userAccount.getUsername());
                 ua=(PatientUserAccount)userAccount;
                 return ua.getPatient();
             }
         }
         
         
         return patient;
     }
     public Employee searchEmployee(String username){
         Employee employee=null;
         EmployeeUserAccount ua=null;
         System.out.println("Search for : "+username);
         for(UserAccount userAccount:userAccountList)
         {
             if(userAccount.getUsername().equalsIgnoreCase(username))
             {
                 System.out.print("USername : "+ userAccount.getUsername());
                 ua=(EmployeeUserAccount)userAccount;
                 return ua.getEmployee();
             }
         }
         
         
         return employee;
     }
   
}
