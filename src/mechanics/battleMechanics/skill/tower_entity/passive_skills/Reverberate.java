package mechanics.battleMechanics.skill.tower_entity.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class Reverberate extends PassiveSkill{

    public Reverberate() {
        super("Reverberate", "Repeat turn allowing for two or move consequetive turns \n<%> 19% chance passive activation");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        if(Math.random() < 0.19){
            System.out.println("| " + user.getName() + " Revertebrates for another strike (Passive Skill)");
            battle.repeatTurn(user);
        }
    }
    
}
