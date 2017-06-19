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
 * @author uppal
 */
public class ManufactureEnterprise extends Enterprise {
    
    private ArrayList<Drug> drugList;
    private int drugInWarehouse;
    private HashMap<String,Integer> hashDrugs;
    
    public ManufactureEnterprise(String name) {
        super(name,Enterprise.EnterpriseType.Manufacture);
        drugList=new ArrayList<Drug>();
    }
    @Override
    public ArrayList<Role> getSupportedRole(){
        return null;
    }

    public ArrayList<Drug> getDrugList() {
        return drugList;
    }
    
    public void addDrug(String drugname,int dosageSelected){
        Drug drug=new Drug(drugname,dosageSelected);
        drugList.add(drug);
        
    }

    public void setDrugList(ArrayList<Drug> drugList) {
        this.drugList = drugList;
    }

    public int getDrugInWarehouse() {
        return drugInWarehouse;
    }

    public void setDrugInWarehouse(int drugInWarehouse) {
        this.drugInWarehouse = drugInWarehouse;
    }

    public HashMap<String, Integer> getHashDrugs() {
        return hashDrugs;
    }

    public void setHashDrugs(HashMap<String, Integer> hashDrugs) {
        this.hashDrugs = hashDrugs;
    }
    
    
    
}
    
