package world.location.locationData;

import entity.tower_entity.echoes.LostVanguard;
import entity.tower_entity.remnants.ElementalBlob;
import entity.tower_entity.Remnant;
import world.item.consumables.Food;
import world.location.Floor;

public final class AreaEntityData {
    static{

        Floor floorPtr = FloorData.getFloor(0);
        AreaEntities areaPtr = floorPtr.getFloorArea(1).getAreaEntities();

        areaPtr.addRemnant((Remnant)new ElementalBlob(2));


        /* 
        floorPtr = FloorData.getFloor(1);
        areaPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaPtr.addRemnant(new ElementalBlob(1));
            areaPtr.addRemnant(new ElementalBlob(2));
            areaPtr.addRemnant(new ElementalBlob(3));
            areaPtr.setEcho(new LostVanguard());
        */
    }
}
