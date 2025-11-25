package mechanics.battleMechanics.skill.passive_skills.tower_entity;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class RecoveryProtocol extends PassiveSkill{

    public RecoveryProtocol() {
        super("Recovery Protocol", "Recover HP lost from recent damage \n<%> 25% chance passive activation");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        
        if(user.getLastDamage() > 0 && Math.random() < 0.25){
            System.out.println("| The " + user.getName() + " stabilized, immediately initiating a Recovery Protocol! (Passive Skill)");
            user.heal(user.getLastDamage());
        }

    }
    
}
