/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Patient.PatientDirectory;
import Business.Role.PatientRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author uppal
 */
public class PatientOrganization extends Organization{
    
    private PatientDirectory patientDiretcory;

    public PatientOrganization() {
        super(Type.Patient.getValue());
        patientDiretcory=new PatientDirectory();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new PatientRole());
        return roles;
    }

    public PatientDirectory getPatientDiretcory() {
        return patientDiretcory;
    }

    public void setPatientDiretcory(PatientDirectory patientDiretcory) {
        this.patientDiretcory = patientDiretcory;
    }
      
    
}
