/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import Business.Patient.Patient;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author chand
 */
public class AppointmentDirectory {
    
    private ArrayList<Appointment> appointmentHistory;
    
    public AppointmentDirectory(){
        
        appointmentHistory=new ArrayList<Appointment>();
        
    }
    

    public ArrayList<Appointment> getAppointmentHistory() {
        return appointmentHistory;
    }

    public void setAppointmentHistory(ArrayList<Appointment> appointmentHistory) {
        this.appointmentHistory = appointmentHistory;
    }
    
    public Appointment addAppointment(Patient patient,String doctorName,Date appointmentdate){
        Appointment appointment=new Appointment(patient,doctorName,appointmentdate);
        appointmentHistory.add(appointment);
        return appointment;
    }
    
    
}
