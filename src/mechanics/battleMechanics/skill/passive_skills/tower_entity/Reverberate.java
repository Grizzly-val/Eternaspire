package mechanics.battleMechanics.skill.passive_skills.tower_entity;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class Reverberate extends PassiveSkill{

    public Reverberate() {
        super("Reverberate", "Repeat turn allowing for two or move consequetive turns \n<%> 30% chance passive activation");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        if(Math.random() < 0.3){
            System.out.println("| " + user.getName() + " Revertebrates for another strike (Passive Skill)");
            battle.repeatTurn(user);
        }
    }
    
}
