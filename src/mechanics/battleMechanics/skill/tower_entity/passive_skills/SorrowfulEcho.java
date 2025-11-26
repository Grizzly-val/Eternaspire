package mechanics.battleMechanics.skill.tower_entity.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class SorrowfulEcho extends PassiveSkill {

    public SorrowfulEcho() {
        super("Sorrowful Echo", "Her grief is palpable. Attackers suffer Void damage when striking her.");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        // Trigger when User takes damage
        if (user.getLastDamage() > 0) {
            int reflectDmg = (int)(user.getLastDamage() * 0.30); // Reflects 30%
            if (reflectDmg < 1) reflectDmg = 1;

            System.out.println("| The void screams back at the attacker!");
            user.dmgAttack(opponent, reflectDmg);
        }
    }
}