/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EcoSystem;

import Business.Employee.Employee;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import Business.Role.SystemAdminRole;

/**
 *
 * @author chand
 */

    
    public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        EcoSystem eco=Initialization.EcoSystemInitialization.initializeEcoSystem(system);
         System.out.println("-----------------------Printing names------------------------------");
         for(Network network:eco.getNetworkList())
         {
             System.out.println("Network name:"+network.getName());
         }
         System.out.println("I'm done doing this");

        
        Employee employee = system.getEmployeeDirectory().createEmployee("  ");
        
        UserAccount ua = system.getUserAccountDirectory().createEmployeeUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        return eco;
    }
    

}
