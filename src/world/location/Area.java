package world.location;

import java.util.ArrayList;

import mechanics.inventory.AreaInventory;
import world.location.locationData.AreaEntities;

public class Area extends Location{

    AreaEntities areaEntities = new AreaEntities();

    ArrayList<AreaInventory> areaInventories = new ArrayList<>();
    
    public AreaEntities getAreaEntities(){return areaEntities;}
    public ArrayList<AreaInventory> getAreaInventories(){return areaInventories;}

    public Area(String name, String description, String lockID){
        super(name, description, lockID);
        addInventory(new AreaInventory("Item Drops"));
    }


    public void addArea(Floor floor){
        floor.addArea(this);
    }

    public void addInventory(AreaInventory newInventory){
        areaInventories.add(newInventory);
    }

}