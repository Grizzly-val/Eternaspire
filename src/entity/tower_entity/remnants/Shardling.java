package entity.tower_entity.remnants;

import entity.Entity;
import entity.tower_entity.Remnant;
// Adjust these imports to match where you saved the skills
import mechanics.battleMechanics.skill.active_skills.tower_entity.DesperateShank;
import mechanics.battleMechanics.skill.passive_skills.tower_entity.SpitefulShatter;

public class Shardling extends Remnant {

    private final static int BASE_HP = 30;
    private final static int BASE_ATK = 8;
    
    public Shardling(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "Shardling",
        "Frozen corpses shattered and imperfectly reassembled. They drag themselves with ice picks.",
        "Shardling cries and completely shatters into icy fragments.",
        new DesperateShank(),
        new SpitefulShatter());
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| " + this.getName() + " drags itself forward and stabs with an ice pick.");
        dmgAttack(opponent, atk);
    }
}