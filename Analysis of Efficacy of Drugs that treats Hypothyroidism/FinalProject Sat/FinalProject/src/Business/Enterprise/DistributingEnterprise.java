/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Drug.Drug;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author chand
 */
public class DistributingEnterprise extends Enterprise {
    private ArrayList<Drug> drugList;
    private int drugsInWarehouse;
    private HashMap<String,Integer> hashDrugs;
    public DistributingEnterprise(String name) {
        super(name,Enterprise.EnterpriseType.Distributor);
        drugList=new ArrayList<Drug>();
        
    }
    @Override
    public ArrayList<Role> getSupportedRole(){
        return null;
    }

    public ArrayList<Drug> getDrugList() {
        return drugList;
    }

    public void setDrugList(ArrayList<Drug> drugList) {
        this.drugList = drugList;
    }
    public Drug searchForDrugInList(String DrugName)
    {
        for(Drug drug:drugList)
        {
            if(drug.getName().equalsIgnoreCase(DrugName))
            {
                return drug;
            }
        }
        return null;
    }

    public int getDrugsInWarehouse() {
        return drugsInWarehouse;
    }

    public void setDrugsInWarehouse(int drugsInWarehouse) {
        this.drugsInWarehouse = drugsInWarehouse;
    }

    public HashMap<String, Integer> getHashDrugs() {
        return hashDrugs;
    }

    public void setHashDrugs(HashMap<String, Integer> hashDrugs) {
        this.hashDrugs = hashDrugs;
    }
    
    
    
}
    

