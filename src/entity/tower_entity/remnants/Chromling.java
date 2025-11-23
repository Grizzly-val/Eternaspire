package entity.tower_entity.remnants;

import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.skill.passive_skills.tower_entity.AfterTaste;

public class Chromling extends Remnant {


    private final static int BASE_HP = 22;
    private final static int BASE_ATK = 8;


    public Chromling(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "Chromling",
        "A shimmering elemental entity that reflects light and adapts to the last damage it received.",
        "The Chromling shatters into a million colorless fragments, leaving only polished air.",
        null, 
        new AfterTaste());
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| The Chromling lands a Shimmering Slap, dealing physical damage.");
        dmgAttack(opponent, atk);
    }

    
}
