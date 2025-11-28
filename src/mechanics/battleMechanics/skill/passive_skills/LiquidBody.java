package mechanics.battleMechanics.skill.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class LiquidBody extends PassiveSkill {
    public LiquidBody() {
        super("Liquid Body", "Reduces incoming damage.");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        // Simulates 50% damage reduction by healing back half the damage taken immediately
        if (user.getLastDamage() > 0) {
            System.out.println("| " + user.getName() + "'s liquid body absorbed the blow!");
            user.heal((int)(user.getLastDamage() * 0.5));
        }
    }
}
