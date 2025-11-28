package mechanics.battleMechanics.skill.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class TriadOfAgony extends PassiveSkill {

    public TriadOfAgony() {
        super("Triad of Agony", "The three screaming faces on Malphas's armor shriek in response to pain, sharing the agony with the attacker.");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        // If Malphas took damage this turn
        if (user.getLastDamage() > 0) {
            // Reflect 33% of the damage taken (One for each face)
            int reflectDmg = (int)(user.getLastDamage() * 0.33);
            
            // Ensure at least 1 damage is dealt if hit
            if (reflectDmg < 1) reflectDmg = 1;

            System.out.println("| The three faces scream in unison, reflecting the pain!");
            user.dmgAttack(opponent, reflectDmg);
        }
    }
}