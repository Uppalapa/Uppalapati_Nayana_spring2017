/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import Business.Drug.Drug;
import Business.Employee.Employee;
import Business.Patient.Patient;
import java.util.Date;

/**
 *
 * @author chand
 */
public class Appointment {
    private Patient patient;
    private Employee doctor;
    private String appointmentId;
    private Date appointmentDate;
    public static int counter;
    private Drug prescribedDrug;
    private Employee reportTestedBy;
    private Employee scheduledBy;
    
    public Appointment(Patient patient,String doctorName,Date appointmentDate){
        
        appointmentId=patient.getPatientID()+doctorName+patient.getAppointmentHist().size();
        this.appointmentDate=appointmentDate;
        this.patient=patient;
       
        counter++;
        
        
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Appointment.counter = counter;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }

    public Drug getPrescribedDrug() {
        return prescribedDrug;
    }

    public void setPrescribedDrug(Drug prescribedDrug) {
        this.prescribedDrug = prescribedDrug;
    }

    public Employee getReportTestedBy() {
        return reportTestedBy;
    }

    public void setReportTestedBy(Employee reportTestedBy) {
        this.reportTestedBy = reportTestedBy;
    }

    public Employee getScheduledBy() {
        return scheduledBy;
    }

    public void setScheduledBy(Employee scheduledBy) {
        this.scheduledBy = scheduledBy;
    }
    
    
    @Override
    public String toString(){
        return this.appointmentId;
    }
    
}
