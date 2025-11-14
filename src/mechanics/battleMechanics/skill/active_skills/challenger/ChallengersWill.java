package mechanics.battleMechanics.skill.active_skills.challenger;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class ChallengersWill extends ActiveSkill{

    public ChallengersWill() {
        super("Challenger's Will", "Replenish HP to full", 3);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        System.out.println("| Damage undone! The Challenger's Will grants a complete reversal.");
        System.out.println("| HP Replenished");
        user.heal(10000);
    }
    
}
