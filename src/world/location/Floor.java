package world.location;
import java.util.HashMap;

import world.location.locationData.FloorData;

public class Floor extends Location{
    
    private int number;

    private HashMap<Integer, Area> areas = new HashMap<>();
    private int areaChoice = 1;

    public Floor(int number, String name, String description, String lockID){
        super(name, description, lockID);
        this.number = number;
    }

    public Floor getNextFloor(){return FloorData.getFloor(number + 1);}
    public Floor getPrevFloor(){return FloorData.getFloor(number - 1);}

    public HashMap<Integer, Area> getAreas(){return areas;}
    public int getNumber(){return number;}

    public void addArea(Area newArea){
        areas.put(areaChoice++, newArea);
    }

    public Area getFloorArea(int key){return areas.get(key);}


}
