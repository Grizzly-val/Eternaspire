package entity.tower_entity.remnants;

import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.skill.passive_skills.CorruptedShrapnels;

public class CorruptedSpinefiend extends Remnant {

    private final static int BASE_HP = 55; // Buffed HP
    private final static int BASE_ATK = 45; // Buffed ATK
    
    public CorruptedSpinefiend(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "Corrupted Spinefiend",
        "The cactus flesh has rotted away to reveal black, pulsating veins. The mustache is now drooping and dripping with black ichor.",
        "The Spinefiend explodes into black sludge, its mustache dissolving into nothingness.",
        null,
        new CorruptedShrapnels());
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| " + this.getName() + " fires dark, infected needles.");
        dmgAttack(opponent, atk);
    }
}