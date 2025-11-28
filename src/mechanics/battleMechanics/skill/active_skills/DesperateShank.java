package mechanics.battleMechanics.skill.active_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class DesperateShank extends ActiveSkill {
    public DesperateShank() {
        super("Desperate Shank", "Attacks twice if HP is low. <%> 30% hp required to activate", 1);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        int baseDmg = user.getAtk();
        
        // First hit
        System.out.println("| " + user.getName() + " stabs with an ice pick!");
        user.dmgAttack(opponent, baseDmg);

        // Second hit logic: Check if user is below 50% HP
        if (user.getHp() < (user.getMaxHp() * 0.3)) {
             System.out.println("| " + user.getName() + " is desperate and strikes again!");
             user.dmgAttack(opponent, baseDmg);
        }
    }
}