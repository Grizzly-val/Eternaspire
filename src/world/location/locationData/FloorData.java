package world.location.locationData;
import java.util.TreeMap;

import world.location.Floor;

public final class FloorData {
    
    private static final TreeMap<Integer, Floor> floors = new TreeMap<>();

    static{
        int n = 0;
        addFloor(n++, "The Beginning of No End", "Eternaspire's Entry Point", "nolock");
        addFloor(n++, "The Platform of Nadir", "A still platform at the spiral's starting end, heavy with the weight of descent.", "FloorLock_ThePlatformOfNadir");
    }

    private FloorData(){};      // Prevents instantiation

    private static void addFloor(int n, String name, String description, String lockID){
        Floor newFloor = new Floor(n, name, description, lockID);
        floors.put(n, newFloor);
    }

    public static Floor getFloor(int key) {return floors.get(key);}

    

}
