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
public class DrugOrderWorkQueue extends WorkQueue{
    private ArrayList<DrugOrderWorkRequest> DrugOrderWorkRequestList;

    public DrugOrderWorkQueue() {
        DrugOrderWorkRequestList = new ArrayList<DrugOrderWorkRequest>();
    }

    public ArrayList<DrugOrderWorkRequest> getDrugOrderWorkRequestList() {
        return DrugOrderWorkRequestList;
    }

    
    
   
    
}
