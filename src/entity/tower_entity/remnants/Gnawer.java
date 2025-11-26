package entity.tower_entity.remnants;

import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.skill.tower_entity.passive_skills.AfterTaste;

public class Gnawer extends Remnant{

    private final static int BASE_HP = 20;
    private final static int BASE_ATK = 8;


    public Gnawer(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "Gnawer",
        "A feral remnant of bottomless appetite, shaped like a hunched beast with bone-grinding jaws and frenzied hunger.",
        "The Gnawer crumples with a final, hollow snap—its ravenous jaws falling still at last.",
        null, 
        new AfterTaste());
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| The Gnawer dives with its stomping jaw!");
        dmgAttack(opponent, atk);
    }

    
}
