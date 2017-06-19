/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author uppal
 */
public class EnterpriseDirectory {
     private ArrayList<Enterprise> enterpriseList;
    
    public EnterpriseDirectory(){
        enterpriseList=new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    //creating an enterprise and adding it to the list
    public Enterprise creatAndAddEnterprise(String name,Enterprise.EnterpriseType type){
        Enterprise enterprise=null;
        if(type==Enterprise.EnterpriseType.Hospital)
        {
            enterprise=new HospitalEnterprise(name);
            enterpriseList.add(enterprise);
        }        
        if(type==Enterprise.EnterpriseType.Manufacture)
        {
            enterprise=new ManufactureEnterprise(name);
            enterpriseList.add(enterprise);
        }
        if(type==Enterprise.EnterpriseType.Distributor)
        {
            enterprise=new DistributingEnterprise(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
    public HospitalEnterprise searchHospitalEnterprise(String enterpriseName){
        for(Enterprise enterprise:enterpriseList)
        {
            if(enterprise.getName().equals(enterpriseName)&&enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Hospital))
            {
                return (HospitalEnterprise)enterprise;
            }
        }
        return null;
    } 
    public ManufactureEnterprise searchManufacturingEnterprise(String enterpriseName){
        for(Enterprise enterprise:enterpriseList)
        {
            if(enterprise.getName().equals(enterpriseName)&&enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Manufacture))
            {
                return (ManufactureEnterprise)enterprise;
            }
        }
        return null;
    }
    public DistributingEnterprise searchDistributingEnterprise(String enterpriseName){
        for(Enterprise enterprise:enterpriseList)
        {
            if(enterprise.getName().equals(enterpriseName)&&enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Distributor))
            {
                return (DistributingEnterprise)enterprise;
            }
        }
        return null;
    }
    
}
