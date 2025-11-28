package mechanics.battleMechanics.skill.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class SpitefulShatter extends PassiveSkill {
    public SpitefulShatter() {
        super("Spiteful Shatter", "Explodes when HP reaches below 15%.");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        // Trigger only if user just died
        if (user.getHp() <= user.getMaxHp() * 0.15) {
            System.out.println("| " + user.getName() + " shatters into jagged shards! (Passive Skill)");
            // Deals 20% of OPPONENT'S Max HP
            int dmg = (int)(opponent.getMaxHp() * 0.20);
            user.dmgAttack(opponent, dmg);
            user.takeDamage(user.getMaxHp());
        }
    }
}
