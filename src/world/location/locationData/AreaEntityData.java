package world.location.locationData;

import entity.tower_entity.echoes.LostVanguard;
import entity.tower_entity.remnants.ElementalBlob;
import world.location.Area;
import world.location.Floor;

public final class AreaEntityData {
    static{
        

        Floor floorPtr = FloorData.getFloor(0);
        Area areaPtr = floorPtr.getFloorArea(1);
            areaPtr.getAreaEntities().addRemnant(new ElementalBlob(10));
            areaPtr.getAreaEntities().addRemnant(new ElementalBlob(6));
            areaPtr.getAreaEntities().addRemnant(new ElementalBlob(6));
            areaPtr.getAreaEntities().setEcho(new LostVanguard());

        floorPtr = FloorData.getFloor(1);
        areaPtr = floorPtr.getFloorArea(1);
            areaPtr.getAreaEntities().addRemnant(new ElementalBlob(1));
            areaPtr.getAreaEntities().addRemnant(new ElementalBlob(2));
            areaPtr.getAreaEntities().addRemnant(new ElementalBlob(3));
            areaPtr.getAreaEntities().setEcho(new LostVanguard());

    }
}
