package mechanics.battleMechanics.skill.active_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class BashReturn extends ActiveSkill{

    public BashReturn() {
        super("Bash Return", "Return 175% of the last received damage to the opponent \n<%> 45% chance of 20% damage kickback upon activation", 4);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        System.out.println("| Enraged by the previous damage taken, the " + user.getName() + " recklessly returns the attack in greater magnitude");
        if(user.getLastDamage() <= 0){
            user.basicAttack(opponent);
        }

        int damageReturn = (int)(user.getLastDamage() * 1.75);
        user.dmgAttack(opponent, damageReturn);
        if(Math.random() < 0.45){
            System.out.println("| " + user.getName() + " takes " + (int)(damageReturn * 0.20) + " of damage kickback in the process");
            user.takeDamage((int)(damageReturn * 0.20));
        }
    }
    
}
