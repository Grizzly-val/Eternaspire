package world.location.locationData;

import entity.tower_entity.remnants.ElementalBlob;
import entity.tower_entity.remnants.Gnawer;
import mechanics.battleMechanics.skill.active_skills.challenger.RendingCut;
import entity.tower_entity.Echo;
import entity.tower_entity.Remnant;
import entity.tower_entity.echoes.LostVanguard;
import world.item.consumables.Food;
import world.item.consumables.FoodEffect;
import world.item.consumables.Key;
import world.item.consumables.SkillScroll;
import world.location.Floor;

public final class AreaEntityData {
    
    public static void init(FloorData floorData){

        Floor floorPtr = floorData.getFloor(0);
        AreaEntities areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant((Remnant)new ElementalBlob(4).addDrops(new Key("The Whetstone Clavis", 
                                                        "A key that sharpens the hand that holds it. No grand undertaking begins without the necessary edge.", 
                                                                    "FloorLock_ThePlatformOfNadir", 
                                                                "cutscene_UseKey_TheWhetstoneClavis")));

        // Floor 1 Area 1
        floorPtr = floorData.getFloor(1);
        areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant((Remnant)new ElementalBlob(7));
            areaEntitiesPtr.addRemnant((Remnant)new Gnawer(6));
            areaEntitiesPtr.addRemnant((Remnant)new ElementalBlob(6).addDrops(new Food("Dark-browned Drumstick", 
                                                                    "Chewy but digestible", 
                                                                                17, 
                                                                            "nocutscene",
                                                                            FoodEffect.HP)));
            areaEntitiesPtr.addRemnant((Remnant)new Gnawer(8).addDrops(new Key("The Disfragmenter", 
                                                                            "Reverses structural decay, instantly reassembling shattered areas into a safer, navigable area.", 
                                                                                "AreaLock_TheShatteredSpan", 
                                                                                        "cutscene_UseKey_TheDisfragmenter")));

        // Floor 1 Area 2
        floorPtr = floorData.getFloor(1);
        areaEntitiesPtr = floorPtr.getFloorArea(2).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Gnawer(9));
            areaEntitiesPtr.addRemnant(new Gnawer(9));
            areaEntitiesPtr.addRemnant(new ElementalBlob(11));
            areaEntitiesPtr.setEcho((Echo)new LostVanguard().addDrops(new Key("The Ascendant's Token", 
                                                                "A mark of crossing the threshold, it grants clearance to continue the arduous climb into the spire's upper reaches.", 
                                                                "FloorLock_TheLowerAscent", 
                                                                "cutscene_UseKey_TheAscendantsToken"),
                                                                new SkillScroll("cutscene_Learn_RendingCut", new RendingCut(), "A Blade's Manual")));


    }
}
