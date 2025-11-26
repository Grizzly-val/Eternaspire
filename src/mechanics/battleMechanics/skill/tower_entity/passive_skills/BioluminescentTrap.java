package mechanics.battleMechanics.skill.tower_entity.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class BioluminescentTrap extends PassiveSkill {
    public BioluminescentTrap() {
        super("Bioluminescent Trap", "Counters attacks.");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        // If user took damage this turn, counter attack
        if (user.getLastDamage() > 0) {
             System.out.println("| " + user.getName() + "\'s lure flashes! It counters!");
             // Deal 50% of received damage back
             int returnDmg = (int)(user.getLastDamage() * 0.5);
             user.dmgAttack(opponent, returnDmg);
        }
    }
}