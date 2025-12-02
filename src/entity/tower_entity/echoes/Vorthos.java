package entity.tower_entity.echoes;

import entity.Entity;
import entity.tower_entity.Echo;
import mechanics.battleMechanics.skill.active_skills.FlashFreeze;
import mechanics.battleMechanics.skill.passive_skills.TheCollection;

public class Vorthos extends Echo {

    // Boss stats are significantly higher
    private final static int BASE_HP = 57; 
    private final static int BASE_ATK = 4;
    
    public Vorthos(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "Vorthos, The Curator",
        "A massive, floating torso fused with a jagged throne of black ice. Empty sockets weep liquid nitrogen.",
        "Vorthos crumbles, his collection finally complete in death.",
        "cutscene_Defeat_Vorthos"
        );


        giveSkill(new FlashFreeze());
        giveSkill(new TheCollection());
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| " + this.getName() + " throws a sharp icicle from his throne.");
        dmgAttack(opponent, atk);
    }
}