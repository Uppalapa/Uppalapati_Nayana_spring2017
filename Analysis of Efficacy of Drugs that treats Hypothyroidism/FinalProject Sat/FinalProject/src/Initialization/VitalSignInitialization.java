/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Initialization;

import Business.Appointment.Appointment;
import Business.Employee.Employee;
import Business.Enterprise.HospitalEnterprise;
import Business.Organization.Organization;
import Business.VitalSigns.VitalSign;
import Business.VitalSigns.VitalSignHistory;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author chand
 */
public class VitalSignInitialization {
    
    private static VitalSignHistory vitalSignHistory;
    public static VitalSignHistory initializeVitalSignHistory(ArrayList<Appointment> appointmentList,HospitalEnterprise hEnterprise){
        
        System.out.println("Drug list size: "+hEnterprise.getDrugList().size());
        vitalSignHistory=new VitalSignHistory();
        ArrayList<VitalSign> vsList=new ArrayList<VitalSign>();
        int position=0;
        VitalSign vitalSign;
        for(Appointment appointment:appointmentList)
        {
            vitalSign=generateVitalSign();
            vitalSign.setReportId(appointment.getAppointmentId());
            Employee labAssistant=searchForLAbAsst(hEnterprise);
            vitalSign.setTestedBy(labAssistant);
            if(appointment.getAppointmentId().equalsIgnoreCase(appointmentList.get(0).getAppointmentId())||position==0)
            {
            appointment.
             setPrescribedDrug(hEnterprise.getDrugList().get(randInt(0,(hEnterprise.getDrugList().size())-1)));
           
            }
            else{
                if(vitalSign.getStatus().equalsIgnoreCase("normal"))
                {
                    appointment.setPrescribedDrug(appointmentList.get(position-1).getPrescribedDrug());
                }
                else{
                    appointment.setPrescribedDrug(hEnterprise.getDrugList().get(randInt(0,(hEnterprise.getDrugList().size())-1)));
                }
            }
            searchForAppointment(hEnterprise, appointment,labAssistant);
            
            
            
             vsList.add(vitalSign);
           // position++;
        
            
        }
        
        
        vitalSignHistory.setVitalSignList(vsList);
        return vitalSignHistory;
    }
    private static void searchForAppointment(HospitalEnterprise hEnterprise,Appointment appointment,Employee employee)
    {
        for(Appointment appoint:hEnterprise.getAppointmentDirectory().getAppointmentHistory())
        {
            if(appointment.getAppointmentId().equalsIgnoreCase(appoint.getAppointmentId()))
            {
                appointment.setReportTestedBy(employee);
            }
        }
    }
    private static VitalSign generateVitalSign()
    {
        VitalSign vs=new VitalSign();
        
        
            //normal values are 
            //T3:0.60 to 1.81
            //T4:4.50 to 10.90
            //TSH:0.35 to 5.50
            //BloodSugar:80 to 140
            //Haemoglobin 12.50 to 14.50
            //WBC Count: 4000 to 11000
            
            double normalT3Lower=0.60;
            double normalT3Higher=1.81;
            double normalT4Lower=4.50;
            double normalT4Higher=10.90;
            double normalTSHLower=0.35;
            double normalTSHHigher=5.50;
            double normalBloodSugarLower=80;
            double normalBloodSugarHigher=140;
            double normalHaemoglobinLower=12.50;
            double normalHaemoglobinHigher=14.50;
            double normalWBCCountLower=4000;
            double normalWBCCountHigher=11000;
            
            vs.setT3(generateRandomDouble(0.40,1.81));
            vs.setT4(generateRandomDouble(4.50,10.90));
            vs.setTsh(generateRandomDouble(0.0,15.50));
            vs.setBloodSugar(randInt(70,160));
            vs.setHaemoglobin(generateRandomDouble(11.50,14.50));
            vs.setWbcCount(randInt(2000,11000));
            
            if(vs.getTsh()<5.50&&vs.getTsh()>0.35)
            {
                vs.setStatus("Normal");
            }
            else{
                vs.setStatus("Abnormal");
            }
            
        
        
        
        
        
        
        return vs;
        
    }
    private static Double generateRandomDouble(double rangeMin,double rangeMax)
    {
        Random r = new Random();
        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();


        return randomValue;
    }
    private static int randInt(int min, int max) {
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    private static Employee searchForLAbAsst(HospitalEnterprise hEnterprise)
    {
        for(Organization organization:hEnterprise.getOrganizationDirectory().getOrganizationList())
        {
            if(organization.getName().equalsIgnoreCase(Organization.Type.Lab.getValue()))
            {
                int i=randInt(0, (organization.getEmployeeDirectory().getEmployeeList().size()-1));
                Employee employee=organization.getEmployeeDirectory().getEmployeeList().get(i);
                return employee;
            }
        }
        return null;
    }
    
}
