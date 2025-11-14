package world.location;

import java.util.HashMap;

public class Floor extends Location{
    
    private int number;

    private HashMap<Integer, Area> areas = new HashMap<>();
    private int areaChoice = 1;

    public Floor(int number, String name, String description, String lockID){
        super(name, description, lockID);
        this.number = number;
    }

    public HashMap<Integer, Area> getAreas(){return areas;}
    public int getNumber(){return number;}

    public void addArea(Area newArea){
        areas.put(areaChoice++, newArea);
    }

    public Area getFloorArea(int key){return areas.get(key);}


}
