package mechanics.battleMechanics.skill.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class Mimic extends PassiveSkill {
    public Mimic() {
        super("Mimic", "Copies the damaging move the challenger does.");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        if (user.getLastDamage() > 0) {
            System.out.println("| " + user.getName() + " mimics the attack!");
            user.dmgAttack(opponent, user.getLastDamage());
        }else {
            System.out.println("| " + user.getName() + " tried to mimic, but it failed.");
        }
    }
}