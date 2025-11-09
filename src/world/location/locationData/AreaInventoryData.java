package world.location.locationData;

import mechanics.battleMechanics.skill.active_skills.RendingCut;
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

        areaPtr.getAreaInventories().get(0).add(new Key("First Key",
         "Key from ground floor to get to second floor",
         "zeroth_to_first_FloorKey", "cutscene_unlockingFloor00"));

        floorPtr = FloorData.getFloor(1);
        areaPtr = floorPtr.getFloorArea(1);
        areaPtr.addInventory(new AreaInventory("Chest"));                   // 0
        areaPtr.addInventory(new AreaInventory("Skeleton Corpse"));         // 1

        areaPtr.getAreaInventories().get(1).add(new SkillScroll("Learn_Rending_Cut_CUTSCENE", new RendingCut()));


    }
}
