/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Drug.Drug;
import Business.Enterprise.DistributingEnterprise;

/**
 *
 * @author uppal
 */
public class SalesWorkRequest extends WorkRequest{
       
         private int cartSize;
         private Drug requestedDrug;
     private String testResult;
private DistributingEnterprise requestedEnterprise;
    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

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

    public DistributingEnterprise getRequestedEnterprise() {
        return requestedEnterprise;
    }

    public void setRequestedEnterprise(DistributingEnterprise requestedEnterprise) {
        this.requestedEnterprise = requestedEnterprise;
    }
   
    
}
