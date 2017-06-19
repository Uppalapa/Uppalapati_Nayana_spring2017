/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author chand
 */
public class EmployeeDirectory {
     private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String name){
        Employee employee = new Employee();
        employee.setName(name);
        employeeList.add(employee);
        return employee;
    }
    public Employee searchEmployee(String name)
    {
        for(Employee employee:employeeList)
        {
            if(employee.getName().equalsIgnoreCase(name))
            {
                return employee;
            }
        }
        return null;
    }
}
