/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Appointment.AppointmentDirectory;
import Business.Role.Role;
import Business.Role.SchedulerRole;
import Business.WorkQueue.AppointmentWorkQueue;
import java.util.ArrayList;

/**
 *
 * @author uppal
 */
public class SchedulerOrganization extends Organization{
    private AppointmentWorkQueue appointmentWorkQueue;
    private AppointmentDirectory appointmentDirectory;

    public SchedulerOrganization() {
        super(Type.Schedule.getValue());
        appointmentDirectory=new AppointmentDirectory();
        appointmentWorkQueue=new AppointmentWorkQueue();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SchedulerRole());
        return roles;
    }

    public AppointmentDirectory getAppointmentDirectory() {
        return appointmentDirectory;
    }

    public void setAppointmentDirectory(AppointmentDirectory appointmentDirectory) {
        this.appointmentDirectory = appointmentDirectory;
    }

    public AppointmentWorkQueue getAppointmentWorkQueue() {
        return appointmentWorkQueue;
    }

    public void setAppointmentWorkQueue(AppointmentWorkQueue appointmentWorkQueue) {
        this.appointmentWorkQueue = appointmentWorkQueue;
    }
    
    
      
    
}
