/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Appointment.Appointment;
import Business.Appointment.AppointmentDirectory;
import Business.Drug.Drug;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author uppal
 */

    public class HospitalEnterprise extends Enterprise {
    
    private AppointmentDirectory appointmentDirectory;
    private ArrayList<Drug> drugList;
    private int drugsInPharmacy;
    private HashMap<String,Integer> hashDrugs;
    public HospitalEnterprise(String name) {
        super(name,Enterprise.EnterpriseType.Hospital);
        appointmentDirectory=new AppointmentDirectory();
        drugList=new ArrayList<Drug>();
    }

    public AppointmentDirectory getAppointmentDirectory() {
        return appointmentDirectory;
    }

    public void setAppointmentDirectory(AppointmentDirectory appointmentDirectory) {
        this.appointmentDirectory = appointmentDirectory;
    }

    public ArrayList<Drug> getDrugList() {
        return drugList;
    }

    public void setDrugList(ArrayList<Drug> drugList) {
        this.drugList = drugList;
    }
    
    
    
    @Override
    public ArrayList<Role> getSupportedRole(){
        return null;
    }

    public int getDrugsInPharmacy() {
        return drugsInPharmacy;
    }

    public void setDrugsInPharmacy(int drugsInPharmacy) {
        this.drugsInPharmacy = drugsInPharmacy;
    }

    public HashMap<String, Integer> getHashDrugs() {
        return hashDrugs;
    }

    public void setHashDrugs(HashMap<String, Integer> hashDrugs) {
        this.hashDrugs = hashDrugs;
    }
    public Appointment searchForAppointment(String appId)
    {
        Appointment app;
        
        for(Appointment appointment:appointmentDirectory.getAppointmentHistory())
        {
            if(appointment.getAppointmentId().equalsIgnoreCase(appId))
            {
                return appointment;
            }
        }
        
        
        
        
        return null;
    }
    
    
}

