package mechanics.battleMechanics.skill.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class UndyingDevotion extends PassiveSkill {

    public UndyingDevotion() {
        super("Undying Devotion", "Aeliana's love refuses to die, twisting into a hunger for life. She heals for a portion of damage dealt.");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        // Trigger on User's turn when they deal damage (Logic depends on where autoActivate is called)
        // Assuming this is checked after an attack
        if (opponent.getLastDamage() > 0) {
            int healAmt = (int)(opponent.getLastDamage() * 0.40); // 40% Lifesteal
            if (healAmt > 0) {
                System.out.println("| Aeliana draws vitality from her opponent's pain!");
                user.heal(healAmt);
            }
        }
    }
}