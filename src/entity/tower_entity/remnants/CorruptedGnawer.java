package entity.tower_entity.remnants;

import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.skill.passive_skills.CorruptedAfterTaste;

public class CorruptedGnawer extends Remnant{

    private final static int BASE_HP = 40; // Buffed HP
    private final static int BASE_ATK = 20; // Buffed ATK

    public CorruptedGnawer(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "Corrupted Gnawer",
        "Its jaw hangs loose, unhinged, leaking void energy. It eats not out of hunger, but to destroy matter itself.",
        "The Gnawer's jaw snaps off completely as it dissolves into dust.",
        null, 
        new CorruptedAfterTaste());
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| The Corrupted Gnawer tears flesh with void-infused teeth!");
        dmgAttack(opponent, atk);
    }
}