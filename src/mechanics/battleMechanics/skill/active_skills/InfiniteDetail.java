package mechanics.battleMechanics.skill.active_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class InfiniteDetail extends ActiveSkill {
    public InfiniteDetail() {
        super("Infinite Detail", "Overwhelms beings with knowledge causing mental damage or death.", 2);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        System.out.println("| " + user.getName() + " sends knowledge of infinite detail to " + opponent.getName() + "!");
        
        if (Math.random() < 0.01) {
          System.out.println("| " + opponent.getName() + " is overwhelmed by the infinite detail and succumbs to madness!");
          opponent.takeDamage(opponent.getHp()); // Defeat opponent
      } else {
          System.out.println("| " + opponent.getName() + " resists the infinite detail but is mentally damaged.");
          user.dmgAttack(opponent, user.getAtk()); // Deal mental damage
      }
      
    }
}