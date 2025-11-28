package mechanics.battleMechanics.skill.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class AfterTaste extends PassiveSkill{

    public AfterTaste() {
        super("After Taste", "The lingering AfterTaste of recent bite.");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        if(opponent.getLastDamage() > 0 && Math.random() < 0.4){    
            System.out.println("| " + user.getName() + " transfers to " + opponent.getName() + " the sweet After Taste of the last bite! (Passive Skill)");
            user.dmgAttack(opponent, user.getAtk() + (int)(opponent.getLastDamage() * 0.15));
        }
    }
    
}
