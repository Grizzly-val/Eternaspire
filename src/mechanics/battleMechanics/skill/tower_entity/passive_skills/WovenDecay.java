package mechanics.battleMechanics.skill.tower_entity.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class WovenDecay extends PassiveSkill {
    public WovenDecay() {
        super("Woven Decay", "Weaving it's very essence from the fabric of decay, this entity reduces incoming damage.");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        // Simulates 75% damage reduction by healing back half the damage taken immediately
        if (user.getLastDamage() > 0) {
            System.out.println("| " + user.getName() + " regenerates from decay!");
            user.heal((int)(user.getLastDamage() * 0.75));
        }
    }
}