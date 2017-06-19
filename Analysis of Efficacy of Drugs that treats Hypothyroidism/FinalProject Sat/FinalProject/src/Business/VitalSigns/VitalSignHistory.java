/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.VitalSigns;

import java.util.ArrayList;

/**
 *
 * @author uppal
 */
public class VitalSignHistory {
    
    
     private ArrayList<VitalSign> vitalSignsList;

    public VitalSignHistory(){
        this.vitalSignsList = new ArrayList<>();
    }

    /* Setter & Getter for VitalSignList */
    public ArrayList<VitalSign> getVitalSignList() {
        return vitalSignsList;
    }

    public void setVitalSignList(ArrayList<VitalSign> vitalSignsList) {
        this.vitalSignsList = vitalSignsList;
    }

    public VitalSign addVitalSign(VitalSign vitalSign) {

        
        this.vitalSignsList.add(vitalSign);
        return vitalSign;

    }

                                                
    public void removeVitalSign(VitalSign vitalSigns) {
        this.vitalSignsList.remove(vitalSigns);
    }
    }

    

