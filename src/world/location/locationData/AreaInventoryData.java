package world.location.locationData;

import mechanics.inventory.AreaInventory;
import world.item.consumables.Key;
import world.location.Area;
import world.location.Floor;

public final class AreaInventoryData {
    static{

        Floor floorPtr = FloorData.getFloor(0);
        Area areaPtr = floorPtr.getFloorArea(1);

        areaPtr.addInventory(new AreaInventory("Metal Box 1"));
        areaPtr.addInventory(new AreaInventory("Metal box 2"));

        areaPtr.getAreaInventories().get(0).add(new Key("First Key",
         "Key from ground floor to get to second floor",
         "zeroth_to_first_FloorKey", "cutscene_unlockingFloor00"));

        floorPtr = FloorData.getFloor(0);
        areaPtr = floorPtr.getFloorArea(1);
        areaPtr.addInventory(new AreaInventory("Chest"));                   // 0
        areaPtr.addInventory(new AreaInventory("Skeleton Corpse"));         // 1


    }
}
