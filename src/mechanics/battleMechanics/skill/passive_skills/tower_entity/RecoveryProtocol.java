package mechanics.battleMechanics.skill.passive_skills.tower_entity;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class RecoveryProtocol extends PassiveSkill{

    public RecoveryProtocol() {
        super("Recovery Protocol", "Recover HP lost from recent damage \n<%> 30% chance passive activation");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        if(user.getLastDamage() > 0 && Math.random() < 0.3){
            System.out.println("| The " + user + " stabilized, immediately initiating a Recovery Protocol! (Passive Skill)");
            user.heal(user.getLastDamage());
        }

    }
    
}
