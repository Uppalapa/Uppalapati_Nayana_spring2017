/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EcoSystem;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author chand
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private EcoSystem()
    {
        super(null);
        networkList=new ArrayList<Network>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public static EcoSystem getInstance(){
        
        if(business==null)
        {
            business=new EcoSystem();
            
        }
        return business;
    }
  
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
        
    }
    public Network createAndAddNetwork(){
        
        Network network=new Network();
        networkList.add(network);
        return network;
        
    }
    public boolean checkIfUserNameIsUnique(String userName)
    {
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName))
        {
            return false;
        }
        for(Network network:networkList)
        {
            return false;
        }
        return true;
    }
    public Boolean searchNetwork(String networkName)
    {
        for(Network network:networkList)
        {
            if(network.getName().equalsIgnoreCase(networkName))
            {
                return true;
                
            }
        }
        return false;
    }
    
    
}
