/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author chand
 */
public class AppointmentWorkQueue extends WorkQueue{
    private ArrayList<AppointmentWorkRequest> appointmentWorkList;

    public AppointmentWorkQueue(){
        appointmentWorkList=new ArrayList<AppointmentWorkRequest>();
    }
    public ArrayList<AppointmentWorkRequest> getAppointmentWorkList() {
        return appointmentWorkList;
    }

    public void setAppointmentWorkList(ArrayList<AppointmentWorkRequest> appointmentWorkList) {
        this.appointmentWorkList = appointmentWorkList;
    }
    
    
}
