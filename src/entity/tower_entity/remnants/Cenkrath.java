package entity.tower_entity.remnants;

import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.skill.active_skills.tower_entity.DeathWrap;

public class Cenkrath extends Remnant {

    private final static int BASE_HP = 30;
    private final static int BASE_ATK = 8;
    
    public Cenkrath(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "Cenkrath",
        "A pale crawler that glides just beneath the surface, scraping the skin of anything above with razor legs.",
        "Cenkrath curls in on itself and sinks beneath the surface.",
        new DeathWrap(),
        null);
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| " + this.getName() + " shoots a blast of molten venom.");
        dmgAttack(opponent, atk);
    }
  
}