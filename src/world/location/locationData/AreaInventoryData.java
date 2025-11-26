package world.location.locationData;

import mechanics.battleMechanics.skill.challenger.active_skills.AvalancheStrike;
import mechanics.battleMechanics.skill.challenger.active_skills.ChallengersWill;
import mechanics.battleMechanics.skill.challenger.active_skills.Oblivion;
import mechanics.battleMechanics.skill.challenger.active_skills.ThermalSiphon;
import mechanics.battleMechanics.skill.challenger.passive_skills.FleetingAid;
import mechanics.battleMechanics.skill.challenger.passive_skills.Photosynthesis;
import mechanics.inventory.AreaInventory;
import world.item.consumables.FoodEffect;
import world.item.consumables.Food;
import world.item.consumables.Key;
import world.item.consumables.SkillScroll;
import world.item.wpn.BroadSword;
import world.item.wpn.ChallengersSword;
import world.item.wpn.GalacticSeverance;
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
                tempInventory.addItem(new Key("Illusionary Compass", "A mystical compass that guides those who are lost in illusions towards clarity.", "AreaLock_TheLabyrinth", "cutscene_UseKey_IllusionaryCompass"));
                tempInventory.addItem(new Food("Dried Meat Strips", "Tough, salty strips of preserved meat that provide a quick boost of energy and protein.", 20, "cutscene_EatFood_DriedMeatStrips", FoodEffect.HP));
    
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
                tempInventory.addItem(new Key("The Pharoah's Sigil", "An ornate sigil that once belonged to Osarion himself, it radiates authority and power, granting access to the deepest chambers of the pyramid.", "FloorLock_ThePyramidOfOsarion", "cutscene_UseKey_ThePharaohsSigil"));
                    areaPtr.addInventory(tempInventory);
            tempInventory = new AreaInventory("Broken Vase");
                tempInventory.addItem(new Key("Dilapidated Lantern", "An old, corroded lantern that seems to hum faintly with latent energy. It seems to faintly glow when close to the climbs of echoes.", "AreaLock_TheClimbOfEchoes", "cutscene_UseKey_DilapidatedLantern"));
                    areaPtr.addInventory(tempInventory);
        








        //Floor 3 Area 1
        floorPtr = floorData.getFloor(3);
        areaPtr = floorPtr.getFloorArea(1);
            tempInventory = new AreaInventory("Collapsed Wall");
                tempInventory.addItem(new Food("Stamina Elixir Soup", "A revitalizing drink that restores a moderate amount of stamina, helping to recover from fatigue.", 2, "cutscene_EatFood_StaminaElixirSoup", FoodEffect.SP));
                tempInventory.addItem(new ObeliskCleaver());
        
        //Floor 3 Area 2 (empty area)


                







        //Floor 4 Area 1
        floorPtr = floorData.getFloor(4);
        areaPtr = floorPtr.getFloorArea(1);
            tempInventory = new AreaInventory("Deserted Caravan");
                tempInventory.addItem(new SoldiersScimitar());
                tempInventory.addItem(new Food("Canteen of Water", "A canteen filled with water, essential for survival in the harsh desert environment.", 10, "cutscene_DrinkWater_CanteenOfWater", FoodEffect.HP));
                    areaPtr.addInventory(tempInventory);
        
        //Floor 4 Area 2
        floorPtr = floorData.getFloor(4);
        areaPtr = floorPtr.getFloorArea(2);
            tempInventory = new AreaInventory("Mirage Pool");
                tempInventory.addItem(new Food("Oasis Fruit", "A juicy fruit found near oasises, known to refresh and hydrate the body effectively.", 50, "nocutscene", FoodEffect.HP));
                
                    areaPtr.addInventory(tempInventory);
            tempInventory = new AreaInventory("A Pile of Sand");
                tempInventory.addItem(new SkillScroll("cutscene_Learn_Photosynthesis", new Photosynthesis(), "The Sunlit Codex"));
                    areaPtr.addInventory(tempInventory);

        //Floor 4 Area 3
        floorPtr = floorData.getFloor(4);
        areaPtr = floorPtr.getFloorArea(3);
            tempInventory = new AreaInventory("Broken Vase");
                tempInventory.addItem(new Food("Dried Meat Strips", "Tough, salty strips of preserved meat that provide a quick boost of energy and protein.", 20, "cutscene_EatFood_DriedMeatStrips", FoodEffect.HP));
            tempInventory = new AreaInventory("Ancient Statue");
                areaPtr.addInventory(tempInventory);










        // --- FLOOR 5 (The Ice Theme) ---

        floorPtr = floorData.getFloor(5);
        
        // Floor 5 Area 1: The Crystalline Vestibule
        areaPtr = floorPtr.getFloorArea(1);
            tempInventory = new AreaInventory("Refracting Pillar");
                // Key for Area 2
                tempInventory.addItem(new Key("The Ring-Finger Key", "A finger frozen solid, snapping off a statue. The bone protrudes in a shape that fits a lock.", "AreaLock_TheIceboundHall", "cutscene_UseKey_RingFinger"));
                tempInventory.addItem(new Food("Frozen Marrow", "The inside of a bone, preserved perfectly by the cold.", 50, "nocutscene", FoodEffect.HP)); 
                areaPtr.addInventory(tempInventory);
            
        // Floor 5 Area 2: The Weeping Chasm
        areaPtr = floorPtr.getFloorArea(2);
            tempInventory = new AreaInventory("Dripping Icicle");
                tempInventory.addItem(new SkillScroll("cutscene_Learn_ThermalSiphon", new ThermalSiphon(), "Scroll: Thermal Siphon"));
                tempInventory.addItem(new Key("The Cryo Sigil", 
                        "A jagged rune of unmelting blue ice. It feels impossibly heavy, weighted down by the sorrow it contains.", 
                        "FloorLock_TheSanctumOfSorrow", 
                        "cutscene_UseKey_TheCryoSigil"));
                areaPtr.addInventory(tempInventory);















        // --- FLOOR 6 (The Absolute Zero) ---

        floorPtr = floorData.getFloor(6);

        // Floor 6 Area 1: The Mirror of Regret
        areaPtr = floorPtr.getFloorArea(1);
            tempInventory = new AreaInventory("Black Mirror Frame");
                // Key for Lore/Side Unlock
                tempInventory.addItem(new Key("The Black Ice Prism", "A geometric shape that doesn't melt. Looking through it reveals things invisible to the naked eye.", "AreaLock_TheHeartfrostSpire", "cutscene_UseKey_BlackIcePrism"));
                areaPtr.addInventory(tempInventory);
            
            tempInventory = new AreaInventory("Frozen Puddle");
                tempInventory.addItem(new Food("Bioluminescent Jelly", "Glowing flesh harvested from deep beneath the ice. It tastes like battery acid.", 1, "nocutscene", FoodEffect.SP)); 
                areaPtr.addInventory(tempInventory);

        // Floor 6 Area 2: The Heartfrost Spire
        areaPtr = floorPtr.getFloorArea(2);
            tempInventory = new AreaInventory("Pulsing Core Fragment");
                // Key for Area 3
                tempInventory.addItem(new Key("The Heartbeat Sensor", "A mechanical device that only unlocks if it detects a slowing pulse.", "AreaLock_TheThroneOfEternalStillness", "cutscene_UseKey_HeartbeatSensor"));
                tempInventory.addItem(new SkillScroll("cutscene_Learn_AvalancheStrike", new AvalancheStrike(), "Scroll: Avalanche Strike"));
                areaPtr.addInventory(tempInventory);
            
            tempInventory = new AreaInventory("Frozen Petitioner");
                tempInventory.addItem(new Food("Preserved Ration", "A military ration from the castle's original guard, flash-frozen. It is rock hard.", 25, "nocutscene", FoodEffect.HP));
                areaPtr.addInventory(tempInventory);

        // Floor 6 Area 3: The Throne of Eternal Stillness
        areaPtr = floorPtr.getFloorArea(3);
            tempInventory = new AreaInventory("Static Void");
                // Void Salt grants SP
                tempInventory.addItem(new Food("Void Salt", "Residue from the air. Tastes like static on your tongue.", 10, "nocutscene", FoodEffect.SP)); 
                areaPtr.addInventory(tempInventory);








        // --- FLOOR 7: The Fragmented Threshold ---

        floorPtr = floorData.getFloor(7);

        // Floor 7 Area 1: The Splintered Hall
        areaPtr = floorPtr.getFloorArea(1);
            tempInventory = new AreaInventory("Rotting Crate");
                // Key to open Area 2 (The Festering Core)
                tempInventory.addItem(new Key("The Festering Key", "A key covered in living rust. It feels warm and sickly to the touch.", "AreaLock_TheFesteringCore", "cutscene_UseKey_FesteringKey"));
                tempInventory.addItem(new Food("Corrupted Fruit", "A fruit that looks rotted, but smells incredibly sweet. It pulses in your hand.", 80, "nocutscene", FoodEffect.HP));
                areaPtr.addInventory(tempInventory);

        // Floor 7 Area 2: The Festering Core
        areaPtr = floorPtr.getFloorArea(2);
            tempInventory = new AreaInventory("Pulsating Vein");
                // Key to open Floor 8
                tempInventory.addItem(new Key("The Void Sigil", "A symbol that hurts to look at. It grants passage to the collapsed reality of the 8th floor.", "FloorLock_TheCollapsingVoid", "cutscene_UseKey_VoidSigil"));
                areaPtr.addInventory(tempInventory);












        // --- FLOOR 8: The Collapsing Void ---

        floorPtr = floorData.getFloor(8);
        // Floor 8 Area 1: The Screaming Void
        areaPtr = floorPtr.getFloorArea(1);
            tempInventory = new AreaInventory("Floating Debris");
                // Key to open Area 2 (The Final Nexus)
                tempInventory.addItem(new Food("Abyssal Nectar", "Thick black liquid found pooling in the void. It restores mental fortitude.", 5, "nocutscene", FoodEffect.SP));
                tempInventory.addItem(new Key("The Triarch's Eye", "A gem plucked from Malphas's forehead. It sees through the chaos of the collapsing reality, revealing the path to the Nexus.", "AreaLock_TheFinalNexus", "cutscene_UseKey_TriarchsEye"));
                areaPtr.addInventory(tempInventory);    

        // Floor 8 Area 2: The Final Nexus
        areaPtr = floorPtr.getFloorArea(2);
            tempInventory = new AreaInventory("Core Fragment");
                tempInventory.addItem(new Food("Corrupted Fruit", "A fruit that looks rotted, but smells incredibly sweet. It pulses in your hand.", 99998, "nocutscene", FoodEffect.HP));
                areaPtr.addInventory(tempInventory);






        //Floor 9 Area 1 : The Chasm of Echoes
        floorPtr = floorData.getFloor(9);
        areaPtr = floorPtr.getFloorArea(1);
            tempInventory = new AreaInventory("Luminous Bridge Fragment");
                tempInventory.addItem(new Food("Nebula Nectar", "A swirling, colorful drink that seems to contain tiny stars within it. It revitalizes the drinker.", 100, "nocutscene", FoodEffect.HP));
                tempInventory.addItem(new Key("NULL Shard", "A fragment of space itself, unlocks the final resting place of heavenly bodies.", "AreaLock_TheStellarGraveyard", "cutscene_UseKey_NULLShard"));
                    areaPtr.addInventory(tempInventory);

        //Floor 9 Area 2 : The Stellar Graveyard
        floorPtr = floorData.getFloor(9);
        areaPtr = floorPtr.getFloorArea(2);
            tempInventory = new AreaInventory("Stone Plate");
                tempInventory.addItem(new GalacticSeverance());
                tempInventory.addItem(new Key("Dimensional Rift Key", "A key that seems to warp reality around it, allowing passage through fractured dimensions.", "AreaLock_TheFusedDimensions", "cutscene_UseKey_DimensionalRiftKey"));
                    areaPtr.addInventory(tempInventory);

        //Floor 9 Area 3 : The Fused Dimensions
        floorPtr = floorData.getFloor(9);
        areaPtr = floorPtr.getFloorArea(3);
            tempInventory = new AreaInventory("Reality Fracture");
                tempInventory.addItem(new Food("Quantum Foam", "A bizarre substance that seems to exist in multiple states at once, consuming it imparts a strange sense of clarity.", 15, "nocutscene", FoodEffect.SP));
                tempInventory.addItem(new SkillScroll("cutscene_Learn_Oblivion", new Oblivion(), "The Codex of Nihility"));
                    areaPtr.addInventory(tempInventory);
    }
}
