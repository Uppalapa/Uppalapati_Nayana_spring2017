/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Patient.Patient;

/**
 *
 * @author chand
 */
public class PatientUserAccount extends UserAccount{
    
    private Patient patient;
    
    public PatientUserAccount(){
        //patient=new Patient();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    @Override
    public String toString(){
        return patient.getFirstName();
    }
    
    
}
