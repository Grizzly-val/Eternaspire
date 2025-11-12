package world.location.locationData;

import mechanics.battleMechanics.skill.active_skills.challenger.ChallengersWill;
import mechanics.battleMechanics.skill.active_skills.challenger.RendingCut;
import mechanics.inventory.AreaInventory;
import world.item.consumables.Key;
import world.item.consumables.SkillScroll;
import world.item.wpn.ChallengersSword;
import world.item.wpn.IronDagger;
import world.location.Area;
import world.location.Floor;

public final class AreaInventoryData {
    static{

        Floor floorPtr = FloorData.getFloor(0);
        Area areaPtr = floorPtr.getFloorArea(1);
            areaPtr.addInventory(new AreaInventory("Garbage rubble"));
                areaPtr.getAreaInventories().get(0).addItem(new ChallengersSword());
                areaPtr.getAreaInventories().get(1).addItem(new SkillScroll("cutscene_Learn_ChallengersWill", new ChallengersWill(), "The Charter of Resolve"));
                
    }
}
