package world.location.locationData;

import entity.tower_entity.remnants.Cenkrath;
import entity.tower_entity.remnants.CorruptedDrowner;
import entity.tower_entity.remnants.CorruptedGnawer;
import entity.tower_entity.remnants.CorruptedSpinefiend;
import entity.tower_entity.remnants.Drowner;
import entity.tower_entity.remnants.ElementalBlob;
import entity.tower_entity.remnants.EntropyGolem;
import entity.tower_entity.remnants.FalseReflection;
import entity.tower_entity.remnants.FractalHorror;
import entity.tower_entity.remnants.Gnawer;
import entity.tower_entity.remnants.Scorthrax;
import entity.tower_entity.remnants.Shardling;
import entity.tower_entity.remnants.Skinless;
import entity.tower_entity.remnants.Spinefiend;
import mechanics.battleMechanics.skill.active_skills.NomadsWisdom;
import mechanics.battleMechanics.skill.active_skills.dropped.RendingCut;
import mechanics.battleMechanics.skill.passive_skills.dropped.HiredBladesSiphon;
import entity.tower_entity.Echo;
import entity.tower_entity.Remnant;
import entity.tower_entity.echoes.BanishedKnight;
import entity.tower_entity.echoes.Epochra;
import entity.tower_entity.echoes.FallenPaladin;
import entity.tower_entity.echoes.LostVanguard;
import entity.tower_entity.echoes.Malphas;
import entity.tower_entity.echoes.Nihil;
import entity.tower_entity.echoes.Osarion;
import entity.tower_entity.echoes.TheAngler;
import entity.tower_entity.echoes.UnmovingNomad;
import entity.tower_entity.echoes.VoidboundAeliana;
import entity.tower_entity.echoes.Vorthos;
import world.item.consumables.Food;
import world.item.consumables.FoodEffect;
import world.item.consumables.Key;
import world.item.consumables.SkillScroll;
import world.item.wpn.BladeOfEntropy;
import world.item.wpn.CorruptedRedeemer;
import world.item.wpn.IronDagger;
import world.item.wpn.SanctifierHammer;
import world.item.wpn.TheCuratorsNeedle;
import world.item.wpn.VanguardsBastion;
import world.location.Floor;

public final class AreaEntityData {
    
    public static void init(FloorData floorData){

        Floor floorPtr = floorData.getFloor(0);
        AreaEntities areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant((Remnant)new ElementalBlob(5).addDrops(new Key("The Whetstone Clavis", 
                                                        "A key that sharpens the hand that holds it. No grand undertaking begins without the necessary edge.", 
                                                                    "FloorLock_ThePlatformOfNadir", 
                                                                "cutscene_UseKey_TheWhetstoneClavis"),

                                                                new Food("Dark-browned Drumstick", 
                                                                    "Chewy but digestible", 
                                                                                17, 
                                                                            "nocutscene",
                                                                            FoodEffect.HP)
                                                                                ));

        // Floor 1 Area 1
        floorPtr = floorData.getFloor(1);
        areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant((Remnant)new ElementalBlob(6));
            areaEntitiesPtr.addRemnant((Remnant)new Gnawer(8));
            areaEntitiesPtr.addRemnant((Remnant)new ElementalBlob(8));
            areaEntitiesPtr.addRemnant((Remnant)new Gnawer(8).addDrops(new Key("The Disfragmenter", 
                                                                            "Reverses structural decay, instantly reassembling shattered areas into a safer, navigable area.", 
                                                                                "AreaLock_TheShatteredSpan", 
                                                                                        "cutscene_UseKey_TheDisfragmenter")));

        // Floor 1 Area 2
        floorPtr = floorData.getFloor(1);
        areaEntitiesPtr = floorPtr.getFloorArea(2).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Gnawer(10));
            areaEntitiesPtr.addRemnant(new Gnawer(9));
            areaEntitiesPtr.addRemnant(new ElementalBlob(11));
            areaEntitiesPtr.setEcho((Echo)new LostVanguard(11).addDrops(new Key("The Ascendant's Token", 
                                                                "A mark of crossing the threshold, it grants clearance to continue the arduous climb into the spire's upper reaches.", 
                                                                "FloorLock_TheLowerAscent", 
                                                                "cutscene_UseKey_TheAscendantsToken"),
                                                                new SkillScroll("cutscene_Learn_RendingCut", new RendingCut(), "A Blade's Manual")));


        // Floor 2 Area 1
        floorPtr = floorData.getFloor(2);
        areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant((Remnant)new Gnawer(12).addDrops(new IronDagger()));
            areaEntitiesPtr.addRemnant((Remnant)new ElementalBlob(13).addDrops(new Food("Herbal Liquid",
                                                                    "A bitter tonic brewed from potent herbs, known to invigorate the drinker and restore a small amount of vitality.", 
                                                                                10, 
                                                                            "nocutscene", 
                                                                            FoodEffect.HP)));
        
        // Floor 2 Area 2
        floorPtr = floorData.getFloor(2);
        areaEntitiesPtr = floorPtr.getFloorArea(2).getAreaEntities();
            areaEntitiesPtr.addRemnant(new ElementalBlob(12));
            areaEntitiesPtr.addRemnant(new ElementalBlob(14));
            areaEntitiesPtr.addRemnant(new Gnawer(14));
            areaEntitiesPtr.setEcho((Echo)new UnmovingNomad(17).addDrops(new Key("The Nomads Ring", "An old scuffed ring that somehow exudes freedom, it seems to thank you. It shows the way for your next adventure.", 
                                                                    "FloorLock_TheRuinedKingdomOfNeferis",
                                                                    "cutscene_UseKey_TheNomadsRing"),
                                                                    new SkillScroll("cutscene_Learn_NomadsWisdom", new NomadsWisdom(), "The Scroll of the Wandering Sage"),
                                                                    new SkillScroll("cutscene_Learn_HiredBladesSiphon", new HiredBladesSiphon(), "Daunting Contract")));
    



        






        //Floor 3 Area 1
        floorPtr = floorData.getFloor(3);
        areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Cenkrath(19));
            areaEntitiesPtr.addRemnant(new Cenkrath(15));
            areaEntitiesPtr.addRemnant((Remnant)(new Spinefiend(17).addDrops(new Key("The Golden Ankh", 
                                                                        "An ancient symbol of eternal life and protection, it is said to grant access to the Pharaoh's Chamber.", 
                                                                        "AreaLock_ThePharaohsChamber", 
                                                                        "cutscene_UseKey_TheGoldenAnkh"))));

        //Floor 3 Area 2
        floorPtr = floorData.getFloor(3);
        areaEntitiesPtr = floorPtr.getFloorArea(2).getAreaEntities();
            areaEntitiesPtr.setEcho(new Osarion(27));






        //Floor 4 Area 1
        floorPtr = floorData.getFloor(4);
        areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Scorthrax(20));
            areaEntitiesPtr.addRemnant((Remnant)new Cenkrath(22).addDrops(new Food("Coconut Water", 
                                                                    "A refreshing drink from the desert palm, it replenishes a moderate amount of vitality and quenches thirst effectively.", 
                                                                    15, 
                                                                    "nocutscene", 
                                                                    FoodEffect.HP)));

        //Floor 4 Area 2
        floorPtr = floorData.getFloor(4);
        areaEntitiesPtr = floorPtr.getFloorArea(2).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Scorthrax(23));
            areaEntitiesPtr.addRemnant(new Cenkrath(21));
            areaEntitiesPtr.addRemnant(new Scorthrax(22));

        //Floor 4 Area 3
        floorPtr = floorData.getFloor(4);
        areaEntitiesPtr = floorPtr.getFloorArea(3).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Cenkrath(24));
            areaEntitiesPtr.addRemnant((Remnant)new Scorthrax(19).addDrops(new SanctifierHammer()));


            







        // Floor 5 Area 1
        floorPtr = floorData.getFloor(5);
        areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Shardling(24));
            areaEntitiesPtr.addRemnant((Remnant)new Skinless(22).addDrops(new Food("Crispy Skin", "Cruchy and crispy skin", 100, "cutscene_EatFood_CrispySkin", FoodEffect.XP)));

        // Floor 5 Area 2
        floorPtr = floorData.getFloor(5);
        areaEntitiesPtr = floorPtr.getFloorArea(2).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Skinless(23));
            areaEntitiesPtr.setEcho((Echo)new Vorthos(27).addDrops(new TheCuratorsNeedle()));









        // Floor 6 Area 1
        floorPtr = floorData.getFloor(6);
        areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Skinless(22));
            areaEntitiesPtr.setEcho((Echo)new TheAngler(28));

        // Floor 6 Area 2
        floorPtr = floorData.getFloor(6);
        areaEntitiesPtr = floorPtr.getFloorArea(2).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Drowner(24));
            areaEntitiesPtr.addRemnant(new Drowner(25));
            areaEntitiesPtr.addRemnant(new Shardling(26));
            

        // Floor 6 Area 3
        floorPtr = floorData.getFloor(6);
        areaEntitiesPtr = floorPtr.getFloorArea(3).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Skinless(24));
            areaEntitiesPtr.setEcho((Echo)new Nihil(27).addDrops(new BladeOfEntropy(),
                                                                        new Key("The Fractured Key", 
                                                                        "A key that seems to glitch in and out of existence. It hurts to look at, as if reality is rejecting it.", 
                                                                        "FloorLock_TheFragmentedThreshold", 
                                                                        "cutscene_UseKey_TheFracturedKey")
            ));





        // --- FLOOR 7: The Fragmented Threshold ---
        
        // F7 Area 1: The Splintered Hall
        floorPtr = floorData.getFloor(7);
        areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant(new CorruptedGnawer(27));
            areaEntitiesPtr.addRemnant(new CorruptedSpinefiend(27));

        // F7 Area 2: The Festering Core
        floorPtr = floorData.getFloor(7);
        areaEntitiesPtr = floorPtr.getFloorArea(2).getAreaEntities();
            areaEntitiesPtr.addRemnant(new CorruptedSpinefiend(28));
            areaEntitiesPtr.setEcho((Echo)new VoidboundAeliana(32).addDrops(
                new VanguardsBastion()
            ));








        // --- FLOOR 8: The Collapsing Void ---

        // F8 Area 1: The Screaming Void
        floorPtr = floorData.getFloor(8);
        areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant(new CorruptedDrowner(30));
            areaEntitiesPtr.addRemnant(new CorruptedDrowner(28));
            areaEntitiesPtr.addRemnant(new CorruptedGnawer(29));
        
        floorPtr = floorData.getFloor(8);
        areaEntitiesPtr = floorPtr.getFloorArea(2).getAreaEntities();
            // Echo: Fallen Paladin (Level 33)
            // Drops: Corrupted Redeemer (Weapon) and Key of Absolution (Game End Key)
            areaEntitiesPtr.setEcho((Echo)new FallenPaladin(37).addDrops(
                new CorruptedRedeemer(),
                new Key("Key of Absolution", 
                        "A heavy, cold key that was once warm with holy light. It opens the path to the ultimate wish, heavy with the weight of a failed crusade.", 
                        "FloorLock_TheFinalThreshold", 
                        "cutscene_UseKey_KeyOfAbsolution")
            ));                                                                            











        //Floor 9 Area 1
        floorPtr = floorData.getFloor(9);
        areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant(new FractalHorror(37));
            areaEntitiesPtr.addRemnant(new FalseReflection(38));

        //Floor 9 Area 2
        floorPtr = floorData.getFloor(9);
        areaEntitiesPtr = floorPtr.getFloorArea(2).getAreaEntities();
            areaEntitiesPtr.addRemnant(new FalseReflection(34));
            areaEntitiesPtr.addRemnant(new EntropyGolem(34));
            areaEntitiesPtr.setEcho((Echo)new Malphas(36)); 
        //Floor 9 Area 3
        floorPtr = floorData.getFloor(9);
        areaEntitiesPtr = floorPtr.getFloorArea(3).getAreaEntities();
            areaEntitiesPtr.setEcho((Echo)new BanishedKnight(37).addDrops(new Key("Nugget's Feather", "The feather of your once companion, takes you to the \"final\" floor of the Eternaspire.", "FloorLock_TheZenith", "cutscene_UseKey_NuggetsFeather")));


        //Floor 10 Area 1
        floorPtr = floorData.getFloor(10);
        areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.setEcho((Echo)new Epochra(38).addDrops(new Key("The Eternaspire", "The Tower's Key", "FloorLock_TheEternaspire", "cutscene_UseKey_TheEternaspire")));
    }



}