package entity.tower_entity.echoes;

import entity.Entity;
import entity.tower_entity.Echo;
import mechanics.battleMechanics.skill.active_skills.BashReturn;
import mechanics.battleMechanics.skill.passive_skills.RecoveryProtocol;
import mechanics.battleMechanics.skill.passive_skills.Reverberate;

public class LostVanguard extends Echo {

    private static final int BASE_HP = 80;
    private static final int BASE_ATK = 7;

    public LostVanguard(int lvl) {

        super(BASE_HP, BASE_ATK, 11,
        "Lost Vanguard",
        "The lingering echo of a once-proud guardian, forever bound to its duty even in death.",
        "The Lost Vanguard tips forward, momentum carrying it to the earth.",
        "cutscene_Defeat_LostVanguard");

        
        this.giveSkill(new RecoveryProtocol());     //passive
        this.giveSkill(new Reverberate());          //passive
        this.giveSkill(new BashReturn());

    }

    @Override
    public void basicAttack(Entity opponent){
        System.out.println("| " + this.getName() + " charges at the Challenger with Shield Bash");
        dmgAttack(opponent, atk);
    }
    
}
