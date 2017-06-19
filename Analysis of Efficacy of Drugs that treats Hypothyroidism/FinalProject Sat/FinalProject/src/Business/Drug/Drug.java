/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Drug;

import Business.Enterprise.ManufactureEnterprise;
import java.util.ArrayList;

/**
 *
 * @author chand
 */
public class Drug {
    
    private String name;
    private ArrayList<ChemicalCompound> chemicalCompounds;
    private int dosage[]=new int[4];
    
    private ChemicalCompound activeCompound;
    
    private int selectedDosage;
    private ManufactureEnterprise manufactureEnterprise;
    public Drug(String drugname,int selectedDosage){
        this.name=drugname;
        chemicalCompounds=new ArrayList<ChemicalCompound>();
        this.selectedDosage=selectedDosage;
        activeCompound=new ChemicalCompound();
    }

    public ArrayList<ChemicalCompound> getChemicalCompounds() {
        return chemicalCompounds;
    }
    
    public void addChemicalCompound(ChemicalCompound newCompound){
        chemicalCompounds.add(newCompound);
        
    }
    public void removeChemicalCompound(ChemicalCompound chemicalCompound)
    {
        chemicalCompounds.remove(chemicalCompound);
    }

  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ManufactureEnterprise getManufactureEnterprise() {
        return manufactureEnterprise;
    }

    public void setManufactureEnterprise(ManufactureEnterprise manufactureEnterprise) {
        this.manufactureEnterprise = manufactureEnterprise;
    }

    public int getSelectedDosage() {
        return selectedDosage;
    }

    public void setSelectedDosage(int selectedDosage) {
        this.selectedDosage = selectedDosage;
    }

    public ChemicalCompound getActiveCompound() {
        return activeCompound;
    }

    public void setActiveCompound(ChemicalCompound activeCompound) {
        this.activeCompound = activeCompound;
    }

    public void setChemicalCompounds(ArrayList<ChemicalCompound> chemicalCompounds) {
        this.chemicalCompounds = chemicalCompounds;
    }
    
    
    @Override
    public String toString(){
        return this.name;
    }
}
