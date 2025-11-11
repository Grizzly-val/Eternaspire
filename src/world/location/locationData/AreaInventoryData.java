package world.location.locationData;

import mechanics.battleMechanics.skill.active_skills.challenger.RendingCut;
import mechanics.inventory.AreaInventory;
import world.item.consumables.Key;
import world.item.consumables.SkillScroll;
import world.location.Area;
import world.location.Floor;

public final class AreaInventoryData {
    static{

        Floor floorPtr = FloorData.getFloor(0);
        Area areaPtr = floorPtr.getFloorArea(1);

        areaPtr.addInventory(new AreaInventory("Metal box"));
        areaPtr.addInventory(new AreaInventory("Garbage rubble"));

        areaPtr.getAreaInventories().get(0).addItem(new Key("First Key",
         "Key from ground floor to get to second floor",
         "zeroth_to_first_FloorKey", "cutscene_unlockingFloor01"));

        areaPtr.getAreaInventories().get(0).addItem(new SkillScroll("Learn_RendingCut_CUTSCENE", new RendingCut()));

        /* 
        floorPtr = FloorData.getFloor(1);
        areaPtr = floorPtr.getFloorArea(1);
        areaPtr.addInventory(new AreaInventory("Chest"));                   // 1
        areaPtr.addInventory(new AreaInventory("Skeleton Corpse"));         // 2

        areaPtr.getAreaInventories().get(2).addItem(new Key("Second key", "Key for first floor area 2", "FloorOneAreaTwoLOCK", "cutscene_unlockingArea0102"));
        */

        


    }
}
