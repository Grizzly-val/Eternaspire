package world.location.locationData;

import mechanics.battleMechanics.skill.active_skills.challenger.ChallengersWill;
import mechanics.battleMechanics.skill.passive_skills.challenger.FleetingAid;
import mechanics.inventory.AreaInventory;
import world.item.consumables.FoodEffect;
import world.item.consumables.Food;
import world.item.consumables.Key;
import world.item.consumables.SkillScroll;
import world.item.wpn.ChallengersSword;
import world.location.Area;
import world.location.Floor;

public final class AreaInventoryData {
    
    public static void init(FloorData floorData){
        AreaInventory tempInventory;
        // Floor 0 Area 1
        Floor floorPtr = floorData.getFloor(0);
        Area areaPtr = floorPtr.getFloorArea(1);
            areaPtr.addInventory(new AreaInventory("Garbage rubble"));
                areaPtr.getAreaInventories().get(0).addItem(new ChallengersSword());
                areaPtr.getAreaInventories().get(1).addItem(new SkillScroll("cutscene_Learn_ChallengersWill", new ChallengersWill(), "The Charter of Resolve"));
                areaPtr.getAreaInventories().get(1).addItem(new Key("The Latch Breaker", "A blunt key that does not turn locks, but rather shatters the binding force holding the Suspension Gate shut.", "AreaLock_TheSuspensionGate", "cutscene_UseKey_TheLatchBreaker"));
        
        // Floor 1 Area 1
        floorPtr = floorData.getFloor(1);
        areaPtr = floorPtr.getFloorArea(1);
            tempInventory = new AreaInventory("Water Pocket");
                tempInventory.addItem(new SkillScroll("cutscene_Learn_FleetingAid", new FleetingAid(), "Transcription of Asclepius"));



        // Floor 1 Area 2
        floorPtr = floorData.getFloor(1);
        areaPtr = floorPtr.getFloorArea(2);
            tempInventory = new AreaInventory("Chest box");
                tempInventory.addItem(new Food("Jar of Pottage", "A hot, thick stew of grains and vegetables, offering essential warmth and hearty sustenance.", 40, "cutscene_EatFood_JarOfPottage", FoodEffect.HP));
                    areaPtr.addInventory(tempInventory);

            tempInventory = new AreaInventory("Gnawer's Den");
                tempInventory.addItem(null);
                        
    }
}
