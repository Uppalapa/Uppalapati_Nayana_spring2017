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
public class LabTestWorkQueue extends WorkQueue{
    
    private ArrayList<LabTestWorkRequest> LabTestWorkRequestList;

    public LabTestWorkQueue() {
        LabTestWorkRequestList = new ArrayList<LabTestWorkRequest>();
    }

    public ArrayList<LabTestWorkRequest> getLabTestWorkRequestList() {
        return LabTestWorkRequestList;
    }
}
