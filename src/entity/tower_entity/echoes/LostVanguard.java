package entity.tower_entity.echoes;

import entity.Entity;
import entity.tower_entity.Echo;
import mechanics.battleMechanics.skill.passive_skills.tower_entity.RecoveryProtocol;
import mechanics.battleMechanics.skill.passive_skills.tower_entity.Reverberate;

public class LostVanguard extends Echo {

    public LostVanguard() {
        super(134, 134, 20, 24,
        "Lost Vanguard",
        "write description here",
        "The Lost Vanguard tips forward, momentum carrying it to the earth.",
        "cutscene_LostVanguard");

        
        this.giveSkill(new RecoveryProtocol()); //passive
        this.giveSkill(new Reverberate());      //passive

    }

    @Override
    public void basicAttack(Entity opponent){
        System.out.println("| " + this.getName() + " charges at you with Shield Bash");
        dmgAttack(opponent, atk);
    }
    
}
