/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Initialization;

import Business.Appointment.Appointment;
import Business.Drug.Drug;
import Business.Employee.Employee;
import Business.Enterprise.DistributingEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.ManufactureEnterprise;
import Business.Network.Network;
import Business.Role.AdminRole;
import Business.Role.DistributorAdminRole;
import Business.Role.ManufactureAdminRole;
import static Initialization.EmployeeIntialization.generateVitalSigns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author chand
 */
public class EnterpriseInitialization {

    public static EnterpriseDirectory enterpriseDirectory;
    private static ArrayList<HospitalEnterprise> hospitalList = new ArrayList<HospitalEnterprise>();
    private static ArrayList<ManufactureEnterprise> manufacturerList = new ArrayList<ManufactureEnterprise>();
    private static ArrayList<DistributingEnterprise> distributorList = new ArrayList<DistributingEnterprise>();
    private static ArrayList<HospitalEnterprise> hospList;
    private static ArrayList<ManufactureEnterprise> manuList;
    private static ArrayList<DistributingEnterprise> distriList;

    public static EnterpriseDirectory initializeNetworkEnterprises(Network network) {

        enterpriseDirectory = new EnterpriseDirectory();
        String[] hospitalEnterprises = {"Mayo Clinic", "Cleveland Clinic", "Massachusetts General Hospital", "Johns Hoplins Hospital", "UCLA Medical Center", "Hospital Britanico De Buenor", "Hospital De Urgenicas", "Hospital Espanol", "Hospital Aleman", "Clinic Bessoue", "CHU Brugmann", "Hospital Erasme", "IRIS Hospital Network", "CHR de Namur", "CHU Tivoli", "Fortis Healthcare", "Apollo Hospitals", "Columbia Asia Referral Hospital", "Nova Speciality Hospital", "BGS Global Hospitals", "Cemedia Lda", "Clinic Henda", "Clinica Luvarsa", "Mediter", "Clinica Boa Vida", "Shisong Hospital", "Wum District Hospital", "Christ Medical Center", "Banso Baptist Hospital", "Bameda Regional Hospital", "Hospital Alcivar", "Hospital Metropoletano De Ecuador", "Hospital Mt.Sinai", "Kennedy Hospital", "Hospital De Ninos", "Canape vert Ecuador Hospital", "Adventist Hospital", "General Hospital", "Hospital Espior", " Hospital Camijo", "May Pen Hospital", "Linstead Hospital", "Port Maria Hospital", "Spanish Town Hospital", "Black River Hospital", "Tripoli Hospital", "Al Jala Hospital", "Bir Usta Milad Hospital", "Sbea Hospital", "Metiga Milotary Hospital"};
        String[] manufactureEnterprises = {"Forest Pharmaceuticals", "Bio-Tech Pharmaceuticals", "King Pharmaceuticals", "Mova Pharmaceuticals", "Western research labs",
                                           "Fox Pharmaceuticals", "Genzy Me", "Galxo Pharmaceuticals", "Cadila Pharmaceuticals", "Neon Laboratories",
            "Abbott India LTD", "Piramal Healthcare", "Pfizer Limited", "Bestochern FDormulations", "Forbes labs",
            "Reddy Labs", "Medi Globe Pharmaceuticals", "True health Pharmaceuticals", "Smilin Pharmaceuticals", "Conna Pharmaceuticals"};
        String[] distributorEnterprises = {"Rochester Drug Cooperative", "Smith Drug", "Anda Distribution", "North Carolina Whole Sale Drug", "Mc Kesson Coorporation",
            "DFE pharma", "bulani", "Ehor Pharma", "Omaera", "Prina Farma", "Laborex",
            "Aphad", "CCP", "Novartis Pharma Services", "SAPP", "Matish HealthCare", "Fracture Pharma Company",
            "Streamline Pharma Private Limited", "Rezicure pharmaceuticals", "Elegant International", "Medichin", "Indis", "Life Pharma",
            "Multi Pharma", "Multi Pharma", "Patch Pharma", "Unica Santa Ana", "Landerlan", "Solfit",
            "TopMedic S.A", "Eskegroup", "Angrand S.A", "Interchimie S.A", "Pharma Solhaitr", "A.F Hauser",
            "Javied", "Cari Med", "Medimpex", "RDL", "MJD pharmaceutical", "Maner",
            "MS Diagnostico", "Kims SRL", "Histo", "Donner", "Alfa Health Care", "Pharmalys",
            "Alqubar", "Alafia", "Kuma Medical Company Services"};

        hospList = new ArrayList<HospitalEnterprise>();
        manuList = new ArrayList<ManufactureEnterprise>();
        distriList = new ArrayList<DistributingEnterprise>();
        HospitalEnterprise hospiEnterprise;
        ManufactureEnterprise manuEnterprise;
        DistributingEnterprise distriEnterprise;
        
        while (manuList.size() < 2) {
            int pickOne = randInt(0, 19);
            if (!searchForEnterprise(manufactureEnterprises[pickOne], Enterprise.EnterpriseType.Manufacture) && !searchForEnterpriseinSystem(manufactureEnterprises[pickOne], EnterpriseType.Manufacture)) {
                manuEnterprise = new ManufactureEnterprise(manufactureEnterprises[pickOne]);
                Employee employee=new Employee();
                String empName=generateRandomName();
                employee.setName(empName);
                String username=manuEnterprise.getName()+empName;
                manuEnterprise.setOrganizationDirectory(Initialization.OrganizationInitialization.initializeOrganizations(EnterpriseType.Manufacture,manuEnterprise));
                manuEnterprise.getUserAccountDirectory().createEmployeeUserAccount(username,"Employ&1", employee,new ManufactureAdminRole());
                manuEnterprise.setDrugList(Initialization.DrugInitialization.initializeDrugs(manuEnterprise));
                manuEnterprise.setHashDrugs(generateHashDrugs(manuEnterprise.getDrugList()));
                manuEnterprise.setDrugInWarehouse(numOfDrugs(manuEnterprise.getHashDrugs()));
                System.out.println("Employee username:"+ username);
               manuEnterprise.setOrganizationDirectory(Initialization.OrganizationInitialization.initializeOrganizations(EnterpriseType.Manufacture,manuEnterprise));
               System.out.println("Drugs manufactured by me : "+manuEnterprise.getDrugList().size());
               
               manuList.add(manuEnterprise);
                manufacturerList.add(manuEnterprise);
                enterpriseDirectory.getEnterpriseList().add(manuEnterprise);
            }

        }
        while (distriList.size() < 3) {
            int pickOne = randInt(0, 49);
            if (!searchForEnterprise(distributorEnterprises[pickOne], Enterprise.EnterpriseType.Distributor) && !searchForEnterpriseinSystem(distributorEnterprises[pickOne], EnterpriseType.Distributor)) {
                distriEnterprise = new DistributingEnterprise(distributorEnterprises[pickOne]);
                Employee employee=new Employee();
                String empName=generateRandomName();
                employee.setName(empName);
                String username=distriEnterprise.getName()+empName;
                distriEnterprise.setOrganizationDirectory(Initialization.OrganizationInitialization.initializeOrganizations(EnterpriseType.Distributor, distriEnterprise));
                distriEnterprise.getUserAccountDirectory().createEmployeeUserAccount(username,"Employ&1", employee,new DistributorAdminRole());
                System.out.println("Employee username:"+ username);
                distriEnterprise.setDrugList(Initialization.DrugInitialization.initializeDristributorDrugList(manuList, distriEnterprise));
                distriEnterprise.setHashDrugs(generateHashDrugs(distriEnterprise.getDrugList()));
                
                System.out.println("Drugs distributesd by me : "+distriEnterprise.getDrugList().size() );
                distriEnterprise.setDrugsInWarehouse(numOfDrugs(distriEnterprise.getHashDrugs()));
                distriList.add(distriEnterprise);
                distributorList.add(distriEnterprise);
                enterpriseDirectory.getEnterpriseList().add(distriEnterprise);
            }

        }
        while (hospList.size() <3) {
            int pickOne = randInt(0, 49);
            if (!searchForEnterprise(hospitalEnterprises[pickOne], Enterprise.EnterpriseType.Hospital) && !searchForEnterpriseinSystem(hospitalEnterprises[pickOne], EnterpriseType.Hospital)) {
                hospiEnterprise = new HospitalEnterprise(hospitalEnterprises[pickOne]);
                Employee employee=new Employee();
                 hospiEnterprise.setDrugList(Initialization.DrugInitialization.initializeHospitalDrugList(distriList, hospiEnterprise));
                 hospiEnterprise.setOrganizationDirectory(Initialization.OrganizationInitialization.initializeOrganizations(EnterpriseType.Hospital,hospiEnterprise));
               
                hospiEnterprise.setHashDrugs(generateHashDrugs(hospiEnterprise.getDrugList()));
                hospiEnterprise.setDrugsInPharmacy(numOfDrugs(hospiEnterprise.getHashDrugs()));
                System.out.println("Drugs in this hospital are: "+hospiEnterprise.getDrugList().size());
                String empName=generateRandomName();
                employee.setName(empName);
                String username=hospiEnterprise.getName()+empName;
                hospiEnterprise.getUserAccountDirectory().createEmployeeUserAccount(username,"Employ&1", employee,new AdminRole());
                System.out.println("Employee username:"+ username);
                
                hospiEnterprise.setAppointmentDirectory(Initialization.EmployeeIntialization.generateAppointments(hospiEnterprise));
                generateVitalSigns(hospiEnterprise);
                for(Appointment appointment:hospiEnterprise.getAppointmentDirectory().getAppointmentHistory())
                {
                    System.out.println("Appointment id: "+appointment.getAppointmentId() );
                }
                hospList.add(hospiEnterprise);
                hospitalList.add(hospiEnterprise);
                enterpriseDirectory.getEnterpriseList().add(hospiEnterprise);

            }

        }
        

        return enterpriseDirectory;
    }

    public static Boolean searchForEnterprise(String enterpriseName, EnterpriseType type) {
        if (type.getValue().equalsIgnoreCase(Enterprise.EnterpriseType.Hospital.getValue())) {
            for (HospitalEnterprise hEnterprise : hospList) {
                if (hEnterprise.getName().equalsIgnoreCase(enterpriseName)) {
                    return true;
                }
            }
        }

            if (type.getValue().equalsIgnoreCase(Enterprise.EnterpriseType.Manufacture.getValue())) {
            for (ManufactureEnterprise mEnterprise : manuList) {
                if (mEnterprise.getName().equalsIgnoreCase(enterpriseName)) {
                    return true;
                }
            }
                    }

            if (type.getValue().equalsIgnoreCase(Enterprise.EnterpriseType.Distributor.getValue())) {
            for (DistributingEnterprise dEnterprise : distriList) {
                if (dEnterprise.getName().equalsIgnoreCase(enterpriseName)) {
                    return true;
                }
            
            }
        }
        return false;

    }

    public static Boolean searchForEnterpriseinSystem(String enterpriseName, EnterpriseType type) {
        if (type.getValue().equalsIgnoreCase(Enterprise.EnterpriseType.Hospital.getValue())) {
            for (HospitalEnterprise hEnterprise : hospitalList) {
                if (hEnterprise.getName().equalsIgnoreCase(enterpriseName)) {
                    return true;
                }
            }
        }

            if (type.getValue().equalsIgnoreCase(Enterprise.EnterpriseType.Manufacture.getValue())) {
            for (ManufactureEnterprise mEnterprise : manufacturerList) {
                if (mEnterprise.getName().equalsIgnoreCase(enterpriseName)) {
                    return true;
                }
            
            }
        }

            if (type.getValue().equalsIgnoreCase(Enterprise.EnterpriseType.Distributor.getValue())) {
            for (DistributingEnterprise dEnterprise : distributorList) {
                if (dEnterprise.getName().equalsIgnoreCase(enterpriseName)) {
                    return true;
                }
            }
            
        }
        return false;

    }
    private static int randInt(int min, int max) {
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    private static String generateRandomName() {
        // TODO code application logic here
        final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        final java.util.Random rand = new java.util.Random();

        // consider using a Map<String,Boolean> to say whether the identifier is being used or not 
        final Set<String> identifiers = new HashSet<String>();
        
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        //System.out.println("Names:"  + builder.toString());
        return builder.toString();
        
    }
    public static HashMap<String,Integer> generateHashDrugs(ArrayList<Drug> drugList)
    {
        HashMap<String,Integer> hashDrugs=new HashMap<String,Integer>();
        for(Drug drug:drugList)
        {
            hashDrugs.put(drug.getName()+drug.getSelectedDosage(),randInt(30,40) );
            
        }
        return hashDrugs;
        
    }
    public static int numOfDrugs(HashMap<String,Integer> hashMap)
    {
        int numOfDrugs=0;
        
          Set<Map.Entry<String, Integer>> grabset = hashMap.entrySet();
      Iterator<Map.Entry<String,Integer>> i = grabset.iterator();
      while (i.hasNext()){
          Map.Entry<String,Integer> me = (Map.Entry<String,Integer>)i.next();
         
          numOfDrugs+=me.getValue();
          
      }
        
        
        
        return numOfDrugs;
    }
}
