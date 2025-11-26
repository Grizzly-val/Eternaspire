package entity.tower_entity.echoes;

import entity.Entity;
import entity.tower_entity.Echo;
import mechanics.battleMechanics.skill.challenger.active_skills.RealitySever;
import mechanics.battleMechanics.skill.tower_entity.passive_skills.EntropyAura;

public class Nihil extends Echo {

    // Final Boss stats
    private final static int BASE_HP = 76;
    private final static int BASE_ATK = 8;
    
    public Nihil(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "Nihil, The Heart of Stillness",
        "A walking silhouette of static. The air around it dies.",
        "Nihil fades into true nothingness, leaving only silence.",
        "cutscene_Defeat_Nihil");
        
        giveSkill(new RealitySever());
        giveSkill(new EntropyAura());
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| " + this.getName() + " touches with a hand of absolute zero.");
        dmgAttack(opponent, atk);
    }
}