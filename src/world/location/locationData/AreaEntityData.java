package world.location.locationData;

import entity.tower_entity.remnants.ElementalBlob;
import entity.tower_entity.Remnant;
import world.item.consumables.Key;
import world.location.Floor;

public final class AreaEntityData {
    static{

        Floor floorPtr = FloorData.getFloor(0);
        AreaEntities areaPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaPtr.addRemnant((Remnant)new ElementalBlob(4).addDrops(new Key("The Whetstone Clavis", 
                                                        "A key that sharpens the hand that holds it. No grand undertaking begins without the necessary edge.", 
                                                                    "FloorLock_ThePlatformOfNadir", 
                                                                "cutscene_UseKey_TheWhetstoneClavis")));


    }
}
