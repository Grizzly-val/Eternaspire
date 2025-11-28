package mechanics.battleMechanics.skill.active_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class TrinityStrike extends ActiveSkill {
    public TrinityStrike() {
        super("Trinity Strike", "Malphas unleashes the fury of his three faces, striking the opponent three times in rapid succession.",  6);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        System.out.println("| " +  user.getName() + "'s three faces scream orders simultaneously!");
        
        int hits = 3;
        int damagePerHit = (int)(user.getAtk() * 0.6); // Each hit is 60% of ATK

        for(int i = 1; i <= hits; i++) {
            System.out.println("| Strike " + i + " lands heavy!");
            user.dmgAttack(opponent, damagePerHit);
        }
    }
}