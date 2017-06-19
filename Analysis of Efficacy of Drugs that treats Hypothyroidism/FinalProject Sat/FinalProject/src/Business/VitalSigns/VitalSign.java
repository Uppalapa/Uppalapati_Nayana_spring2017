/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.VitalSigns;

import Business.Employee.Employee;

/**
 *
 * @author uppal
 */
public class VitalSign {
    
    private String reportId;
    
    private double t3;
    private double t4;
    private double tsh;
    private double haemoglobin;
    private double wbcCount;
    private double bloodSugar;
    private Employee testedBy;
   
    private String status;
    public VitalSign()
    {
        
    }

    public double getT3() {
        return t3;
    }

    public void setT3(double t3) {
        this.t3 = t3;
    }

    public double getT4() {
        return t4;
    }

    public void setT4(double t4) {
        this.t4 = t4;
    }

    public double getTsh() {
        return tsh;
    }

    public void setTsh(double tsh) {
        this.tsh = tsh;
    }

    public double getHaemoglobin() {
        return haemoglobin;
    }

    public void setHaemoglobin(double haemoglobin) {
        this.haemoglobin = haemoglobin;
    }

    public double getWbcCount() {
        return wbcCount;
    }

    public void setWbcCount(double wbcCount) {
        this.wbcCount = wbcCount;
    }

    public double getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(double bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public Employee getTestedBy() {
        return testedBy;
    }

    public void setTestedBy(Employee testedBy) {
        this.testedBy = testedBy;
    }

    
    @Override
    public String toString(){
        return this.reportId;
    }
    
}
