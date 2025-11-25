package entity.tower_entity.echoes;

import entity.Entity;
import entity.tower_entity.Echo;
import mechanics.battleMechanics.skill.passive_skills.tower_entity.RecoveryProtocol;

public class Osarion extends Echo {

    private static final int BASE_HP = 62;
    private static final int BASE_ATK = 11;

    public Osarion() {
        super(BASE_HP, BASE_ATK, 26,
        "Osarion, The Tyrannical Pharaoh",
        "write description here",
        "The tyrannical pharaoh falls to his knees, giving his tortured subjects peace at last.",
        "cutscene_Defeat_Osarion");

        
        this.giveSkill(new RecoveryProtocol()); //passive
    }
    

    @Override
    public void basicAttack(Entity opponent){
        System.out.println("| " + this.getName() + " conjures a blast of cursed sand.");
        dmgAttack(opponent, atk);
    }


    
}