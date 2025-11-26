package entity.tower_entity.remnants;

import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.skill.tower_entity.active_skills.FleshSiphon;
import mechanics.battleMechanics.skill.tower_entity.passive_skills.HeatLeach;

public class Skinless extends Remnant {

    private final static int BASE_HP = 55;
    private final static int BASE_ATK = 12;
    
    public Skinless(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "Skinless",
        "Gaunt figures wrapped in flayed skin, shivering violently. They radiate intense internal heat.",
        "The Skinless collapses, its internal heat finally fading into the cold.",
        new FleshSiphon(),
        new HeatLeach());
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| " + this.getName() + " lashes out with raw, frozen muscle.");
        dmgAttack(opponent, atk);
    }
}