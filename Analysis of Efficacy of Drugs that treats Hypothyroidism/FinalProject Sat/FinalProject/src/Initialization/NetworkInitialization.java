/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Initialization;

import Business.EcoSystem.EcoSystem;
import Business.Network.Network;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author chand
 */
public class NetworkInitialization {

    private static ArrayList<Network> existingNetworks;

    public static ArrayList<Network> initializeNetwork(EcoSystem system) {
        existingNetworks = system.getNetworkList();
        Network newNetwork;
        newNetwork=new Network();
        newNetwork.setName("INDIA");
        newNetwork.setFlagIcon("C:\\Users\\chand\\Desktop\\FinalProject Sat\\FinalProject\\networkIcons\\download.jpg");
        existingNetworks.add(newNetwork);
        System.out.println("Network: "+newNetwork.getName());
        newNetwork.setEnterpriseDirectory(Initialization.EnterpriseInitialization.initializeNetworkEnterprises(newNetwork));
        
        newNetwork=new Network();
        newNetwork.setName("USA");
        newNetwork.setFlagIcon("C:/Users/chand/Desktop/FinalProject Sat/FinalProject/networkIcons/download.jpg");
         newNetwork.setFlagIcon("C:\\Users\\chand\\Desktop\\FinalProject Sat\\FinalProject\\networkIcons\\download.jpg");
        existingNetworks.add(newNetwork);
        System.out.println("Network: "+newNetwork.getName());
        newNetwork.setEnterpriseDirectory(Initialization.EnterpriseInitialization.initializeNetworkEnterprises(newNetwork));
        //System.out.println("Network: "+newNetwork.getName());
        newNetwork=new Network();
        newNetwork.setName("BELGIUM");
        existingNetworks.add(newNetwork);
        newNetwork.setFlagIcon("C:/Users/chand/Desktop/FinalProject Sat/FinalProject/networkIcons/download.jpg");
         newNetwork.setFlagIcon("C:\\Users\\chand\\Desktop\\FinalProject Sat\\FinalProject\\networkIcons\\download.jpg");
        newNetwork.setEnterpriseDirectory(Initialization.EnterpriseInitialization.initializeNetworkEnterprises(newNetwork));
        System.out.println("Network: "+newNetwork.getName());
        newNetwork=new Network();
        newNetwork.setName("ARGENTINA");
        existingNetworks.add(newNetwork);
        newNetwork.setFlagIcon("C:/Users/chand/Desktop/FinalProject Sat/FinalProject/networkIcons/download.jpg");
         newNetwork.setFlagIcon("C:\\Users\\chand\\Desktop\\FinalProject Sat\\FinalProject\\networkIcons\\download.jpg");
        newNetwork.setEnterpriseDirectory(Initialization.EnterpriseInitialization.initializeNetworkEnterprises(newNetwork));
        System.out.println("Network: "+newNetwork.getName());
        newNetwork=new Network();
        newNetwork.setName("HAITI");
        existingNetworks.add(newNetwork);
        newNetwork.setFlagIcon("C:/Users/chand/Desktop/FinalProject Sat/FinalProject/networkIcons/download.jpg");
         newNetwork.setFlagIcon("C:\\Users\\chand\\Desktop\\FinalProject Sat\\FinalProject\\networkIcons\\download.jpg");
        newNetwork.setEnterpriseDirectory(Initialization.EnterpriseInitialization.initializeNetworkEnterprises(newNetwork));
        System.out.println("Network: "+newNetwork.getName());
        newNetwork=new Network();
        newNetwork.setName("ANGOLA");
        existingNetworks.add(newNetwork);
        newNetwork.setFlagIcon("C:/Users/chand/Desktop/FinalProject Sat/FinalProject/networkIcons/download.jpg");
         newNetwork.setFlagIcon("C:\\Users\\chand\\Desktop\\FinalProject Sat\\FinalProject\\networkIcons\\download.jpg");
        newNetwork.setEnterpriseDirectory(Initialization.EnterpriseInitialization.initializeNetworkEnterprises(newNetwork));
        System.out.println("Network: "+newNetwork.getName());
        newNetwork=new Network();
        newNetwork.setName("JAMAICA");
        newNetwork.setFlagIcon("C:/Users/chand/Desktop/FinalProject Sat/FinalProject/networkIcons/download.jpg");
         newNetwork.setFlagIcon("C:\\Users\\chand\\Desktop\\FinalProject Sat\\FinalProject\\networkIcons\\download.jpg");
        existingNetworks.add(newNetwork);
        
        newNetwork.setEnterpriseDirectory(Initialization.EnterpriseInitialization.initializeNetworkEnterprises(newNetwork));
        System.out.println("Network: "+newNetwork.getName());
        newNetwork=new Network();
        newNetwork.setName("ECUADOR");
        newNetwork.setFlagIcon("C:/Users/chand/Desktop/FinalProject Sat/FinalProject/networkIcons/download.jpg");
         newNetwork.setFlagIcon("C:\\Users\\chand\\Desktop\\FinalProject Sat\\FinalProject\\networkIcons\\download.jpg");
        existingNetworks.add(newNetwork);
        
        newNetwork.setEnterpriseDirectory(Initialization.EnterpriseInitialization.initializeNetworkEnterprises(newNetwork));
        System.out.println("Network: "+newNetwork.getName());
        newNetwork=new Network();
        newNetwork.setFlagIcon("C:/Users/chand/Desktop/FinalProject Sat/FinalProject/networkIcons/download.jpg");
         newNetwork.setFlagIcon("C:\\Users\\chand\\Desktop\\FinalProject Sat\\FinalProject\\networkIcons\\download.jpg");
        newNetwork.setName("LIBYA");
        existingNetworks.add(newNetwork);
        newNetwork.setEnterpriseDirectory(Initialization.EnterpriseInitialization.initializeNetworkEnterprises(newNetwork));
        System.out.println("Network: "+newNetwork.getName());
        newNetwork=new Network();
        newNetwork.setName("CAMEROON");
        newNetwork.setFlagIcon("C:/Users/chand/Desktop/FinalProject Sat/FinalProject/networkIcons/download.jpg");
         newNetwork.setFlagIcon("C:\\Users\\chand\\Desktop\\FinalProject Sat\\FinalProject\\networkIcons\\download.jpg");
        existingNetworks.add(newNetwork);
        newNetwork.setEnterpriseDirectory(Initialization.EnterpriseInitialization.initializeNetworkEnterprises(newNetwork));
        System.out.println("Network: "+newNetwork.getName());
    
            
            

        return existingNetworks;
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static Boolean searchForNetwork(String networkName) {
        for (Network network : existingNetworks) {
            if (network.getName().equalsIgnoreCase(networkName)) {
                return true;
            }
        }
        return false;
    }

}
