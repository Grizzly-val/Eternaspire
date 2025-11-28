package mechanics.battleMechanics.skill.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class VoidBody extends PassiveSkill {

    public VoidBody() {
        super("Void Body", "The body flickers in and out of reality, making it hard to hit effectively.");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        // Corrupted version of LiquidBody. 
        // If hit, chance to phase out and heal back 60% of damage taken
        if (user.getLastDamage() > 0) {
            System.out.println("| " + user.getName() + " flickers like static, rejecting the damage!");
            user.heal((int)(user.getLastDamage() * 0.6));
        }
    }
}