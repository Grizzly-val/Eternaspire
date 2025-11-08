package world.location.locationData;
import java.util.TreeMap;

import world.location.Floor;

public final class FloorData {
    
    private static final TreeMap<Integer, Floor> floors = new TreeMap<>();

    static{
        int n = 0;
        addFloor(n++, "Ground floor", "The lowest you will ever be after entering Eternaspire.", "nolock");
        addFloor(n++, "Name for Floor 1", "Description for floor 1", "zeroth_to_first_FloorKey");
        addFloor(n++, "Name for Floor 2", "Description for floor 2", "nolock");
        addFloor(n++, "Name for Floor 3", "Description for floor 3", "nolock");
    }

    private FloorData(){};      // Prevents instantiation

    private static void addFloor(int n, String name, String description, String lockID){
        Floor newFloor = new Floor(n, name, description, lockID);
        floors.put(n, newFloor);
    }

    public static Floor getFloor(int key) {return floors.get(key);}

    

}
