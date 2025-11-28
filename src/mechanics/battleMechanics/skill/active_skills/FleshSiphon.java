package mechanics.battleMechanics.skill.active_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class FleshSiphon extends ActiveSkill {
    public FleshSiphon() {
        super("Flesh Siphon", "Deals damage and heals self.", 1);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        int dmg = user.getAtk(); // Standard attack damage
        System.out.println("| " + user.getName() + " rips warmth from " + opponent.getName() + "!");
        
        user.dmgAttack(opponent, dmg);
        
        // Heal for 100% of damage dealt
        user.heal(dmg); 
        System.out.println("| " + user.getName() + " recovered " + dmg + " HP.");
    }
}