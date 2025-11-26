package entity.tower_entity.remnants;

import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.skill.tower_entity.active_skills.DesperateShank;
import mechanics.battleMechanics.skill.tower_entity.passive_skills.SpitefulShatter;

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