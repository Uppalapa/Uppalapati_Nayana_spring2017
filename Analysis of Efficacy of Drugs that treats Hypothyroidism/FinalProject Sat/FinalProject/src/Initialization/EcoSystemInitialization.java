/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Initialization;

import Business.EcoSystem.EcoSystem;
import Business.Network.Network;
import java.util.ArrayList;

/**
 *
 * @author chand
 */
public class EcoSystemInitialization {
    
    private static EcoSystem ecoSystem;
    
    private static ArrayList<Network> networkList;
    public static EcoSystem initializeEcoSystem(EcoSystem system){
        
        networkList=system.getNetworkList();
        
    int numberOfNetworks=networkList.size();
    if(numberOfNetworks==0)
    {
        System.out.println("Number of Networks in the List:"+numberOfNetworks);
    }
    else{
    System.out.println("Not Zero: Number of Networks in the List:"+numberOfNetworks);
    }
    system.setNetworkList(Initialization.NetworkInitialization.initializeNetwork(system));
    return system;
    }
    
}
