package entity.tower_entity.remnants;

import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.skill.tower_entity.passive_skills.Shrapnels;

public class Spinefiend extends Remnant {

    private final static int BASE_HP = 35;
    private final static int BASE_ATK = 23;
    
    public Spinefiend(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "Spinefiend",
        "A creeping cactus creature whose spines wiggle and lock onto prey like living darts, it has a mustache. It has a FABULOUS mustache…",
        "The Cactus twitches one last time as its spines retract and it topples, mustache still immaculate.",
        null,
        new Shrapnels());
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| " + this.getName() + " poses and shoots its spikes.");
        dmgAttack(opponent, atk);
    }
  
}