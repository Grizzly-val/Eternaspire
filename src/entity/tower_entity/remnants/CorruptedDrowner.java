package entity.tower_entity.remnants;

import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.skill.active_skills.HydroJet;
import mechanics.battleMechanics.skill.passive_skills.VoidBody;

public class CorruptedDrowner extends Remnant {

    private final static int BASE_HP = 90; // Buffed HP
    private final static int BASE_ATK = 28; // Buffed ATK
    
    public CorruptedDrowner(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "Corrupted Drowner",
        "The reflection is no longer just bloated; it is missing its face. It swims through the floor like it is deep space.",
        "The Drowner implodes, leaving a small singularity that vanishes.",
        new HydroJet(), // Keeping active, changed passive
        new VoidBody());
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| " + this.getName() + " grasps with hands made of static.");
        dmgAttack(opponent, atk);
    }
}