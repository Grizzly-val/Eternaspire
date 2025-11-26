package mechanics.battleMechanics.skill.challenger.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class TemporalJitter extends PassiveSkill {
    public TemporalJitter() {
        super("Temporal Jitter", "The Banished Knight phases out of reality, dodging any attack.");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        if (Math.random() < 0.3) {
            //Heals damage taken so that it seems like the attack was dodged.
            System.out.println("| "+ user.getName() + " phases out of reality. Dodging the attack!");
            int dmg = opponent.getLastDamage();
            user.heal(dmg);
        } else {
            System.out.println("| " + user.getName() + " fails to phase out in time!");
            user.takeDamage(opponent.getLastDamage());
        }
    }
}