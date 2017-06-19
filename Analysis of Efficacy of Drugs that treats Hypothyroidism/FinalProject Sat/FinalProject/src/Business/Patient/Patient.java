/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Appointment.Appointment;
import Business.VitalSigns.VitalSign;
import Business.VitalSigns.VitalSignHistory;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author uppal
 */
public class Patient extends Person{
   private boolean isSmoker;
   private boolean isDiabetic;
   private boolean isAlcoholic;
   private double weight;
   private double height;
   private Appointment appointment;
   private ArrayList<Appointment> appointmentHist;
   private VitalSignHistory vitalSignHistory;
   private VitalSign vitalSign;
   private String patientID;
   private static int count=100;
   private String familyHistory;
   private String workOutStatus;
   
   
   public Patient(String enterpriseName,String firstName,int patientNumber){
       appointmentHist=new ArrayList<Appointment>();
       count++;
       patientID="PAT"+firstName+enterpriseName+patientNumber;
       vitalSignHistory=new VitalSignHistory();
   }
    public boolean isIsSmoker() {
        return isSmoker;
    }

    public void setIsSmoker(boolean isSmoker) {
        this.isSmoker = isSmoker;
    }

    public boolean isIsDiabetic() {
        return isDiabetic;
    }

    public void setIsDiabetic(boolean isDiabetic) {
        this.isDiabetic = isDiabetic;
    }

    public boolean isIsAlcoholic() {
        return isAlcoholic;
    }

    public void setIsAlcoholic(boolean isAlcoholic) {
        this.isAlcoholic = isAlcoholic;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public ArrayList<Appointment> getAppointmentHist() {
        return appointmentHist;
    }

    public void setAppointmentHist(ArrayList<Appointment> appointmentHist) {
        this.appointmentHist = appointmentHist;
    }

    
    
    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public VitalSignHistory getVitalSignHistory() {
        return vitalSignHistory;
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

    public String getWorkOutStatus() {
        return workOutStatus;
    }

    public void setWorkOutStatus(String workOutStatus) {
        this.workOutStatus = workOutStatus;
    }

    public void setVitalSignHistory(VitalSignHistory vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }
    
    public Appointment searchForAppointment(String appointmentId)
    {
        Appointment app=null;
        
        for(Appointment appointment:appointmentHist)
        {
            if(appointment.getAppointmentId().equalsIgnoreCase(appointmentId))
            {
                return appointment;
            }
        }
        
        
        return app;
    }
  
    
   @Override
   public String toString(){
       return this.getPatientID();
   }
    
}
