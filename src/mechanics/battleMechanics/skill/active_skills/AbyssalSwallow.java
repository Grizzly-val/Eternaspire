package mechanics.battleMechanics.skill.active_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class AbyssalSwallow extends ActiveSkill {
    public AbyssalSwallow() {
        super("Abyssal Swallow", "Chance to instant kill. <%> 5% instant kill chance", 3);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        if (Math.random() < 0.05) {
            System.out.println("| "+ user.getName() + " swallows " + opponent.getName() + " whole! (OHKO)");
            user.dmgAttack(opponent, opponent.getMaxHp() + 5); // Deal Max HP damage to ensure kill
        } else {
            System.out.println("| The Angler missed its bite!");
        }
    }
}