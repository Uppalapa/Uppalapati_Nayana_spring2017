/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Employee.Employee;
import Business.UserAccount.PatientUserAccount;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author chand
 */
public class AppointmentWorkRequest extends WorkRequest {
   private PatientUserAccount sender;
    private Date appointmentReqDate;
    private Employee doctor;
   
    private String testResult; 

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public Date getAppointmentReqDate() {
        return appointmentReqDate;
    }

    public void setAppointmentReqDate(Date appointmentReqDate) {
        this.appointmentReqDate = appointmentReqDate;
    }

    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }
    
    @Override
    public void setSender(UserAccount userAccount)
    {
        this.sender=(PatientUserAccount)userAccount;
    }

   @Override
    public PatientUserAccount getSender() {
        return sender;
    }
    
    
    
}
