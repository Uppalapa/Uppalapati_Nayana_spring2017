/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Drug.Drug;
import Business.Enterprise.HospitalEnterprise;

/**
 *
 * @author uppal
 */
public class DrugOrderWorkRequest extends WorkRequest{
        private HospitalEnterprise requestedEnterprise;
         private String testResult;
         private int cartSize;
         private Drug requestedDrug;

    public int getCartSize() {
        return cartSize;
    }

    public void setCartSize(int cartSize) {
        this.cartSize = cartSize;
    }

    public Drug getRequestedDrug() {
        return requestedDrug;
    }

    public void setRequestedDrug(Drug requestedDrug) {
        this.requestedDrug = requestedDrug;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public HospitalEnterprise getRequestedEnterprise() {
        return requestedEnterprise;
    }

    public void setRequestedEnterprise(HospitalEnterprise requestedEnterprise) {
        this.requestedEnterprise = requestedEnterprise;
    }
   
    
        
        
    
}
