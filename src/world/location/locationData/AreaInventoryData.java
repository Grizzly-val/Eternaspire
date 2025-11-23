package world.location.locationData;

import mechanics.battleMechanics.skill.active_skills.challenger.ChallengersWill;
import mechanics.battleMechanics.skill.passive_skills.challenger.FleetingAid;
import mechanics.battleMechanics.skill.passive_skills.challenger.Photosynthesis;
import mechanics.inventory.AreaInventory;
import world.item.consumables.FoodEffect;
import world.item.consumables.Food;
import world.item.consumables.Key;
import world.item.consumables.SkillScroll;
import world.item.wpn.BroadSword;
import world.item.wpn.ChallengersSword;
import world.item.wpn.ObeliskCleaver;
import world.item.wpn.SoldiersScimitar;
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

        //Floor 2 Area 1
        floorPtr = floorData.getFloor(2);
        areaPtr = floorPtr.getFloorArea(1);
            tempInventory = new AreaInventory("Chest Box");
                tempInventory.addItem(new Food("Dried Meat Strips", "Tough, salty strips of preserved meat that provide a quick boost of energy and protein.", 20, "cutscene_EatFood_DriedMeatStrips", FoodEffect.HP));
                tempInventory.addItem(new Food("Stamina Elixir Soup", "A revitalizing drink that restores a moderate amount of stamina, helping to recover from fatigue.", 2, "cutscene_EatFood_StaminaElixir", FoodEffect.SP));
                    areaPtr.addInventory(tempInventory);
            tempInventory = new AreaInventory("Rubble Pile");
                tempInventory.addItem(new BroadSword());
                tempInventory.addItem(new Key("Gate Key", "A sturdy key that unlocks the gates to the kingdom beyond.", "AreaLock_EntranceToNeferis", "cutscene_UseKey_GateKey"));
                    areaPtr.addInventory(tempInventory);

        //Floor 2 Area 2
        floorPtr = floorData.getFloor(2);
        areaPtr = floorPtr.getFloorArea(2);
            tempInventory = new AreaInventory("Chest Box");
                tempInventory.addItem(new Food("Echo Berry Tart", "A sweet tart made from echo berries, known to slightly enhance one's resonance abilities upon consumption.", 15, "cutscene_EatFood_EchoBerryTart", FoodEffect.SP));
                    areaPtr.addInventory(tempInventory);  
            tempInventory = new AreaInventory("Broken Vase");
                tempInventory.addItem(new Key("Dilapidated Lantern", "An old, corroded lantern that seems to hum faintly with latent energy. It seems to faintly glow when close to the climbs of echoes.", "AreaLock_TheClimbOfEchoes", "cutscene_UseKey_DilapidatedLantern"));
                    areaPtr.addInventory(tempInventory);
        
        //Floor 3 Area 1
        floorPtr = floorData.getFloor(3);
        areaPtr = floorPtr.getFloorArea(1);
            tempInventory = new AreaInventory("Deserted Caravan");
                tempInventory.addItem(new SoldiersScimitar());
                tempInventory.addItem(new Food("Canteen of Water", "A canteen filled with water, essential for survival in the harsh desert environment.", 10, "cutscene_DrinkWater_CanteenOfWater", FoodEffect.HP));
                    areaPtr.addInventory(tempInventory);
        
        //Floor 3 Area 2
        floorPtr = floorData.getFloor(3);
        areaPtr = floorPtr.getFloorArea(2);
            tempInventory = new AreaInventory("Mirage Pool");
                tempInventory.addItem(new Food("Oasis Fruit", "A juicy fruit found near oasises, known to refresh and hydrate the body effectively.", 50, "nocutscene", FoodEffect.HP));
                tempInventory.addItem(new Key("Illusionary Compass", "A mystical compass that guides those who are lost in illusions towards clarity.", "AreaLock_TheLabyrinth", "cutscene_UseKey_IllusionaryCompass"));
                    areaPtr.addInventory(tempInventory);
            tempInventory = new AreaInventory("A Pile of Sand");
                tempInventory.addItem(new SkillScroll("cutscene_Learn_Photosynthesis", new Photosynthesis(), "The Sunlit Codex"));
                    areaPtr.addInventory(tempInventory);

        //Floor 3 Area 3
        floorPtr = floorData.getFloor(3);
        areaPtr = floorPtr.getFloorArea(3);
            tempInventory = new AreaInventory("Broken Vase");
                tempInventory.addItem(new Food("Dried Meat Strips", "Tough, salty strips of preserved meat that provide a quick boost of energy and protein.", 20, "cutscene_EatFood_DriedMeatStrips", FoodEffect.HP));
            tempInventory = new AreaInventory("Ancient Statue");
                tempInventory.addItem(new Key("The Pharoah's Sigil", "An ornate sigil that once belonged to Osarion himself, it radiates authority and power, granting access to the deepest chambers of the pyramid.", "FloorLock_ThePyramidOfOsarion", "cutscene_UseKey_ThePharaohsSigil"));
                areaPtr.addInventory(tempInventory);

        //Floor 4 Area 1
        floorPtr = floorData.getFloor(4);
        areaPtr = floorPtr.getFloorArea(1);
            tempInventory = new AreaInventory("Collapsed Wall");
                tempInventory.addItem(new Food("Stamina Elixir Soup", "A revitalizing drink that restores a moderate amount of stamina, helping to recover from fatigue.", 2, "cutscene_EatFood_StaminaElixirSoup", FoodEffect.SP));
                tempInventory.addItem(new ObeliskCleaver());
        
        //Floor 4 Area 2 (empty area)
                        
    }
}
