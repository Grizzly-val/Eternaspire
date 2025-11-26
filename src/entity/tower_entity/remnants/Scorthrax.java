
package entity.tower_entity.remnants;

import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.skill.tower_entity.active_skills.InfernalStinger;

public class Scorthrax extends Remnant {

    private final static int BASE_HP = 10;
    private final static int BASE_ATK = 20;
    
    public Scorthrax(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "Scorthrax",
        "A fiery remnant that scorches everything in its path.",
        "Scorthrax lets out a final roar before collapsing into smoldering ashes.",
        new InfernalStinger(),
        null);
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| " + this.getName() + "shoots a blast of molten venom.");
        dmgAttack(opponent, atk);
    }
  
}