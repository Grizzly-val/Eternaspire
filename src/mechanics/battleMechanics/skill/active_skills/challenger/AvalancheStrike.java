package mechanics.battleMechanics.skill.active_skills.challenger;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class AvalancheStrike extends ActiveSkill {
    public AvalancheStrike() {
        super("Avalanche Strike", "A chaotic attack that strikes 3 times with low accuracy but high potential damage.", 8);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        int hits = 3;
        System.out.println("| " + user.getName() + " unleashes an avalanche of blows!");
        
        for(int i = 0; i < hits; i++){
            // 70% Hit Chance per strike
            if(Math.random() > 0.3){ 
                // Each hit deals 80% ATK
                int dmg = (int)(user.getAtk() * 0.8);
                user.dmgAttack(opponent, dmg);
            } else {
                System.out.println("| A strike missed!");
            }
        }
    }
}
