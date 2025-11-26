package mechanics.battleMechanics.skill.tower_entity.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class CorruptedAfterTaste extends PassiveSkill{

    public CorruptedAfterTaste() {
        super("Corrupted After Taste", "The lingering rot of a corrupted bite.");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        // Increased trigger chance (40% -> 50%) and Scaling (15% -> 25%)
        if(opponent.getLastDamage() > 0 && Math.random() < 0.5){    
            System.out.println("| " + user.getName() + "'s bite infects " + opponent.getName() + " with rotting sludge! (Passive Skill)");
            user.dmgAttack(opponent, user.getAtk() + (int)(opponent.getLastDamage() * 0.25));
        }
    }
}