package mechanics.battleMechanics.skill.active_skills.dropped;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class ThermalSiphon extends ActiveSkill {
    public ThermalSiphon() {
        super("Thermal Siphon", "Deals fire damage to a single target and heals the user for half the damage dealt.", 3);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        System.out.println("| " + user.getName() + " drains warmth from " + opponent.getName() + "!");
        // Deals 150% ATK damage
        int dmg = (int)(user.getAtk() * 1.5);
        
        user.dmgAttack(opponent, dmg);
        
        // Heal for 50% of damage dealt
        int healAmount = dmg;

        user.heal(healAmount);
        System.out.println("| " + user.getName() + " recovered " + healAmount + " HP.");
    }
}
