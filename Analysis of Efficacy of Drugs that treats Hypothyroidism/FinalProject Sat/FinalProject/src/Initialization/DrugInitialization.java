/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Initialization;

import Business.Drug.ChemicalCompound;
import Business.Drug.Drug;
import Business.Enterprise.DistributingEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.ManufactureEnterprise;
import Business.Network.Network;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author chand
 */
public class DrugInitialization {
    
    public static ArrayList<Drug> existingDrugs=new ArrayList<Drug>();
    public static ArrayList<Drug> drugsList;
    public static int[] dosages=new int[]{25,50,75,100};
    public static String[] drugNames={"ArmorThyroid","Levothroid","Cytomel","Levoxyl","LevoT","Westhroid","Unithroid","Thyrolar","Thryogen","Eltroxin","Roxin","Synox","Thyronorm","Proloid","Pregnavit","Fertibre","NPThyroid","Synthroid","WPThyroid","TrioStat","Tirosynt"};
    public static ArrayList<Drug> initializeDrugs(ManufactureEnterprise mEnterprise)
    {
        
        drugsList=new ArrayList<Drug>();
        Drug tempDrug;
        int randomDrugIndex=0;
        int randomDosageIndex;
        int randomDosage;
        int i=0;
        String drugName="";
        int firstDrugAdded=0;
       
       while(firstDrugAdded==0)
       {
               randomDrugIndex=randInt(0,(drugNames.length-1)); 
               if(drugNames[randomDrugIndex]=="")
                {

                }
                else{
                   
                   drugName=drugNames[randomDrugIndex];
                   // randomDosageIndex=randInt(0,(dosages.length-1));
                   if(existsInList(drugName,drugsList))
                   {
                       
                   }
                   else
                   {
                    tempDrug=new Drug(drugNames[randomDrugIndex],25);
//                    if(checkIfDrugExists(drugsList, tempDrug))
//                    {
//
//                    }
//                    else{
//                        drugName=drugNames[randomDrugIndex];
                        tempDrug.setName(drugName);
                        tempDrug.setChemicalCompounds(generateCompoundsList());
                        tempDrug.setActiveCompound(tempDrug.getChemicalCompounds().get(0));
                        tempDrug.setManufactureEnterprise(mEnterprise);
                        drugsList.add(tempDrug);
                     //   existingDrugs.add(tempDrug);
                        
//                        break;
//                    }
//                }
//       }     
//            
//        while(drugsList.size()<4&&drugsList.size()>0)
//        {
//         
//           System.out.println("I'm here");
//           
                
            
//                    randomDosageIndex=randInt(0,(dosages.length-1));
                    tempDrug=new Drug(drugName,50);
                    tempDrug.setName(drugName);
                    tempDrug.setChemicalCompounds(generateCompoundsList());
                    tempDrug.setActiveCompound(tempDrug.getChemicalCompounds().get(0));
                    tempDrug.setManufactureEnterprise(mEnterprise);
                  //  existingDrugs.add(tempDrug);
                    drugsList.add(tempDrug);
                    tempDrug=new Drug(drugName,75);
                    tempDrug.setName(drugName);
                    tempDrug.setChemicalCompounds(generateCompoundsList());
                    tempDrug.setActiveCompound(tempDrug.getChemicalCompounds().get(0));
                    tempDrug.setManufactureEnterprise(mEnterprise);
                   // existingDrugs.add(tempDrug);
                    drugsList.add(tempDrug);
//                  
                    tempDrug=new Drug(drugName,100);
                    tempDrug.setName(drugName);
                    tempDrug.setChemicalCompounds(generateCompoundsList());
                    tempDrug.setActiveCompound(tempDrug.getChemicalCompounds().get(0));
                    tempDrug.setManufactureEnterprise(mEnterprise);
                  //  existingDrugs.add(tempDrug);
                    drugsList.add(tempDrug);
                    firstDrugAdded++;
//                  
//                    if(checkIfDrugExists(drugsList, tempDrug))
//                    {
//                        System.out.println("drug already exists");
//                    }
//                    else{
//                        
//                        tempDrug.setManufactureEnterprise(mEnterprise);
                   }
                    }
                
            
       }
        
        drugNames[randomDrugIndex]="";
        for(Drug drug:drugsList)
        {
            existingDrugs.add(drug);
        }
        System.out.println("Drugs : "+drugsList.size());
        return drugsList;
    }
    private static Boolean existsInList(String drugName,ArrayList<Drug> drugList)
    {
        Boolean exists=false;
        
        
        for(Drug drug:existingDrugs)
        {
            if(drug.getName().equalsIgnoreCase(drugName))
                
            {
               return true;
                
            }
        }
        
        
        return exists;
    }
    private static int randInt(int min, int max) {
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    
    private static ArrayList<ChemicalCompound> generateCompoundsList()
    {
        ArrayList<ChemicalCompound> ccList=new ArrayList<ChemicalCompound>();
        
        ArrayList<Double> pList=generatePercentages();
        ChemicalCompound activeCompound=new ChemicalCompound();
        activeCompound.setCompoundName("LevoThyroxine Sodium");
        activeCompound.setPercentageInDrug(pList.get(0));
        
        ccList.add(activeCompound);
        
        ChemicalCompound cc1=new ChemicalCompound();
        cc1.setCompoundName("Lactose");
        ccList.add(cc1);
        
        ChemicalCompound cc2=new ChemicalCompound();
        cc2.setCompoundName("Magnesium stearate");
        ccList.add(cc2);
        ChemicalCompound cc3=new ChemicalCompound();
        cc3.setCompoundName("Maize Starch");
        ccList.add(cc3);
        
        ChemicalCompound cc4=new ChemicalCompound();
        cc4.setCompoundName("Stearic acid");
        ccList.add(cc4);
        
        ChemicalCompound cc5=new ChemicalCompound();
        cc5.setCompoundName("Pregelanitized maize starch");
        ccList.add(cc5);
        
        ChemicalCompound cc6=new ChemicalCompound();
        cc6.setCompoundName("sodium");
        ccList.add(cc6);
        
        
        for(int i=1;i<7;i++)
        {
            ccList.get(i).setPercentageInDrug(pList.get(i));
        }
        
        
        
        
        
        return ccList;
    }
    private static ArrayList<Double> generatePercentages()
    {
        ArrayList<Double> percentageList=new ArrayList<Double>();
        
        Double activePercentage=generateRandomDouble(45.0,70.0);
        
        Double remainedPercentage=100.00-activePercentage;
        Double lastCompoundPercentage=generateRandomDouble(0.0,12.0);
        remainedPercentage=remainedPercentage-lastCompoundPercentage;
        Double sum=0.0;
        
        int numOfCompounds=0;
        while(numOfCompounds<6)
        {
        
        
             Double ccPercentage=generateRandomDouble(0.0,remainedPercentage);
             remainedPercentage=remainedPercentage-ccPercentage;
             sum=sum+ccPercentage;
             percentageList.add(ccPercentage);
             numOfCompounds++;
        
        
        }
        percentageList.add(lastCompoundPercentage);
        
        
        return percentageList;
    }
    private static Double generateRandomDouble(double rangeMin,double rangeMax)
    {
        Random r = new Random();
        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();


        return randomValue;
    }
    private static Boolean checkIfDrugExists(ArrayList<Drug> drugList,Drug drug)
    {
        Boolean exists=false;
        while(drugList.size()>0)
        {
        for(Drug everyDrug:drugList)
        {
            if(everyDrug.getName().equalsIgnoreCase(drug.getName())&&everyDrug.getSelectedDosage()==drug.getSelectedDosage())
            {
                return true;
            }
        }
        
        
        
        }
        return false;
    }
    public static ArrayList<Drug> initializeHospitalDrugList(ArrayList<DistributingEnterprise> distriList,HospitalEnterprise hEnterprise){
        ArrayList<Drug> hDrugList=new ArrayList<Drug>();
//        ArrayList<DistributingEnterprise> dEnterprises=new ArrayList<DistributingEnterprise>();
//        for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
//        {
//            if(enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Distributor))
//            {
//                dEnterprises.add((DistributingEnterprise)enterprise);
//            }
//        }
//        if(dEnterprises.size()>0)
//        {
         while(hDrugList.size()<=3)
            {
            for(DistributingEnterprise dEnterprise:distriList)
            {
                Drug tempDrug=dEnterprise.getDrugList().get(randInt(0,(dEnterprise.getDrugList().size()-1)));
                if(!hDrugList.contains(tempDrug))
                {
                hDrugList.add(tempDrug);
                }
            }
            }
        
        return hDrugList;
        
    }
    public static ArrayList<Drug> initializeDristributorDrugList(ArrayList<ManufactureEnterprise> manuList,DistributingEnterprise dEnterprise){
           ArrayList<Drug> dDrugList=new ArrayList<Drug>();
//        ArrayList<ManufactureEnterprise> mEnterprises=new ArrayList<ManufactureEnterprise>();
//        for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
//        {
//            if(enterprise.getEnterpriseType().toString().equalsIgnoreCase(Enterprise.EnterpriseType.Manufacture.getValue()))
//            {
//                mEnterprises.add((ManufactureEnterprise)enterprise);
//            }
//        }
//        if(mEnterprises.size()>0)
        {
            for(ManufactureEnterprise mEnterprise:manuList)
            {
               int NumOfdrugs=0;
               while(NumOfdrugs<=2)
               {
                    Drug tempDrug=mEnterprise.getDrugList().get(randInt(0,3));
                    if(!dDrugList.contains(tempDrug))
                    {

                       dDrugList.add(tempDrug);
                       NumOfdrugs++;
                    }
               }
            }
        
        }
        return dDrugList;
        
    }
    
}
