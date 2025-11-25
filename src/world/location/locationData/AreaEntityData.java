package world.location.locationData;

import entity.tower_entity.remnants.Cenkrath;
import entity.tower_entity.remnants.Drowner;
import entity.tower_entity.remnants.ElementalBlob;
import entity.tower_entity.remnants.Gnawer;
import entity.tower_entity.remnants.Scorthrax;
import entity.tower_entity.remnants.Shardling;
import entity.tower_entity.remnants.Skinless;
import entity.tower_entity.remnants.Spinefiend;
import mechanics.battleMechanics.skill.active_skills.challenger.RendingCut;
import mechanics.battleMechanics.skill.active_skills.tower_entity.NomadsWisdom;
import entity.tower_entity.Echo;
import entity.tower_entity.Remnant;
import entity.tower_entity.echoes.LostVanguard;
import entity.tower_entity.echoes.Nihil;
import entity.tower_entity.echoes.Osarion;
import entity.tower_entity.echoes.TheAngler;
import entity.tower_entity.echoes.UnmovingNomad;
import entity.tower_entity.echoes.Vorthos;
import world.item.consumables.Food;
import world.item.consumables.FoodEffect;
import world.item.consumables.Key;
import world.item.consumables.SkillScroll;
import world.item.wpn.BladeOfEntropy;
import world.item.wpn.SanctifierHammer;
import world.item.wpn.TheCuratorsNeedle;
import world.location.Floor;

public final class AreaEntityData {
    
    public static void init(FloorData floorData){

        Floor floorPtr = floorData.getFloor(0);
        AreaEntities areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant((Remnant)new ElementalBlob(4).addDrops(new Key("The Whetstone Clavis", 
                                                        "A key that sharpens the hand that holds it. No grand undertaking begins without the necessary edge.", 
                                                                    "FloorLock_ThePlatformOfNadir", 
                                                                "cutscene_UseKey_TheWhetstoneClavis"),

                                                                new Food("Dark-browned Drumstick", 
                                                                    "Chewy but digestible", 
                                                                                17, 
                                                                            "nocutscene",
                                                                            FoodEffect.HP)
                                                                                )
                                        );

        // Floor 1 Area 1
        floorPtr = floorData.getFloor(1);
        areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant((Remnant)new ElementalBlob(7));
            areaEntitiesPtr.addRemnant((Remnant)new Gnawer(6));
            areaEntitiesPtr.addRemnant((Remnant)new ElementalBlob(6));
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


        // Floor 2 Area 1
        floorPtr = floorData.getFloor(2);
        areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Gnawer(12));
            areaEntitiesPtr.addRemnant((Remnant)new ElementalBlob(11).addDrops(new Food("Herbal Liquid",
                                                                    "A bitter tonic brewed from potent herbs, known to invigorate the drinker and restore a small amount of vitality.", 
                                                                                10, 
                                                                            "nocutscene", 
                                                                            FoodEffect.HP)));
        
        // Floor 2 Area 2
        floorPtr = floorData.getFloor(2);
        areaEntitiesPtr = floorPtr.getFloorArea(2).getAreaEntities();
            areaEntitiesPtr.addRemnant(new ElementalBlob(12));
            areaEntitiesPtr.addRemnant(new ElementalBlob(12));
            areaEntitiesPtr.addRemnant(new Gnawer(13));
            areaEntitiesPtr.setEcho((Echo)new UnmovingNomad().addDrops(new Key("The Nomads Ring", "An old scuffed ring that somehow exudes freedom, it seems to thank you. It shows the way for your next adventure.", 
                                                                    "FloorLock_TheRuinedKingdomOfNeferis",
                                                                    "cutscene_UseKey_TheNomadsRing"),
                                                                    new SkillScroll("cutscene_Learn_NomadsWisdom", new NomadsWisdom(), "The Scroll of the Wandering Sage")));
    
        //Floor 3 Area 1
        floorPtr = floorData.getFloor(3);
        areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Scorthrax(12));
            areaEntitiesPtr.addRemnant((Remnant)new Cenkrath(13).addDrops(new Food("Coconut Water", 
                                                                    "A refreshing drink from the desert palm, it replenishes a moderate amount of vitality and quenches thirst effectively.", 
                                                                    15, 
                                                                    "nocutscene", 
                                                                    FoodEffect.HP)));
        
        //Floor 3 Area 2
        floorPtr = floorData.getFloor(3);
        areaEntitiesPtr = floorPtr.getFloorArea(2).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Scorthrax(14));
            areaEntitiesPtr.addRemnant(new Cenkrath(14));
            areaEntitiesPtr.addRemnant(new Scorthrax(15));

        //Floor 3 Area 3
        floorPtr = floorData.getFloor(3);
        areaEntitiesPtr = floorPtr.getFloorArea(3).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Cenkrath(16));
            areaEntitiesPtr.addRemnant((Remnant)new Scorthrax(16).addDrops(new SanctifierHammer()));

        //Floor 4 Area 1
        floorPtr = floorData.getFloor(4);
        areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Cenkrath(16));
            areaEntitiesPtr.addRemnant(new Cenkrath(14));
            areaEntitiesPtr.addRemnant((Remnant)(new Spinefiend(17).addDrops(new Key("The Golden Ankh", 
                                                                        "An ancient symbol of eternal life and protection, it is said to grant access to the Pharaoh's Chamber.", 
                                                                        "AreaLock_ThePharaohsChamber", 
                                                                        "cutscene_UseKey_TheGoldenAnkh"))));

        //Floor 4 Area 2
        floorPtr = floorData.getFloor(4);
        areaEntitiesPtr = floorPtr.getFloorArea(2).getAreaEntities();
            areaEntitiesPtr.setEcho((Echo)new Osarion().addDrops(new Key("Heart of the Avalanche", "Compressed ice pulses with the suspended fury of a mountain storm.", "FloorLock_TheGlacialGates", "cutscene_UseKey_HeartOfTheAvalanche")));

        // Floor 5 Area 1
        floorPtr = floorData.getFloor(5);
        areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Shardling(18));
            areaEntitiesPtr.addRemnant((Remnant)new Skinless(19).addDrops(new Food("Crispy Skin", "Cruchy and crispy skin", 100, "cutscene_EatFood_CrispySkin_asMercenary", FoodEffect.XP)));

        // Floor 5 Area 2
        floorPtr = floorData.getFloor(5);
        areaEntitiesPtr = floorPtr.getFloorArea(2).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Skinless(20));
            areaEntitiesPtr.setEcho((Echo)new Vorthos(25).addDrops(new TheCuratorsNeedle()));

        // Floor 6 Area 1
        floorPtr = floorData.getFloor(6);
        areaEntitiesPtr = floorPtr.getFloorArea(1).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Skinless(22));
            areaEntitiesPtr.setEcho((Echo)new TheAngler(23));

        // Floor 6 Area 2
        floorPtr = floorData.getFloor(6);
        areaEntitiesPtr = floorPtr.getFloorArea(2).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Drowner(22));
            areaEntitiesPtr.addRemnant(new Drowner(23));
            areaEntitiesPtr.addRemnant(new Shardling(18));
            

        // Floor 6 Area 3
        floorPtr = floorData.getFloor(6);
        areaEntitiesPtr = floorPtr.getFloorArea(3).getAreaEntities();
            areaEntitiesPtr.addRemnant(new Skinless(22));
            areaEntitiesPtr.setEcho((Echo)new Nihil(25).addDrops(new BladeOfEntropy()));

    }
}
