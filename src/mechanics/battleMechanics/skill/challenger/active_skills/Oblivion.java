package mechanics.battleMechanics.skill.challenger.active_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class Oblivion extends ActiveSkill {

    public Oblivion() {
        super("Oblivion", "Summons a black hole that annihilates everything in its path.", 20);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        System.out.println("| " + user.getName() + " casts " + this.getName());
       // If opponent is a remnant class entity, deal massive damage
        if(opponent instanceof entity.tower_entity.Remnant){
            int damage = 9999; // Massive damage
            System.out.println("| The Oblivion engulfs " + opponent.getName() + ", dealing " + damage + " damage!");
            opponent.takeDamage(damage);
        } else {
            int damage = (int)(user.getAtk() * 2); // Standard damage
            System.out.println("| The Oblivion swirls around " + opponent.getName() + ", dealing " + damage + " damage!");
            opponent.takeDamage(damage);
        }
        
    }
}