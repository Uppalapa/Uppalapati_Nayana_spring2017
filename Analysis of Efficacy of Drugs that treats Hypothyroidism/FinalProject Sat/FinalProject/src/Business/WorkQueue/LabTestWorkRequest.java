/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Appointment.Appointment;
import Business.Patient.Patient;

/**
 *
 * @author uppal
 */
public class LabTestWorkRequest extends WorkRequest{
     private String testResult;
     private Patient patient;
     private Appointment patientAppointment;

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Appointment getPatientAppointment() {
        return patientAppointment;
    }

    public void setPatientAppointment(Appointment patientAppointment) {
        this.patientAppointment = patientAppointment;
    }

    
    
}
