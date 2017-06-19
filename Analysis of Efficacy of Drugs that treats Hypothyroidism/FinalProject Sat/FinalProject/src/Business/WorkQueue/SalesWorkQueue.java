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
public class SalesWorkQueue extends WorkQueue{
    
    private ArrayList<SalesWorkRequest> SalesWorkRequestList;

    public SalesWorkQueue() {
        SalesWorkRequestList = new ArrayList<SalesWorkRequest>();
    }

    public ArrayList<SalesWorkRequest> getSalesWorkRequestList() {
        return SalesWorkRequestList;
    }
}
