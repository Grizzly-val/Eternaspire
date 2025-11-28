package mechanics.battleMechanics.skill.active_skills.dropped;

import entity.Entity;
import entity.player.Challenger;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class RendingCut extends ActiveSkill {
    // this is for Mercenary

    public RendingCut() {
        super("Rending Cut", "A straight-forward cut attack. | <%> 15% chance of stealing 1 skill point.", 2);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        System.out.println("| " + user.getName() + " dove bladefirst to land a " + this.getName());
        user.dmgAttack(opponent, (int)(user.getAtk() * 2.3));
        if(user instanceof Challenger p && Math.random() < 0.45){
            p.addSkillPoint(3);
        } else{
            int ct = 1;
            for(int i = 0; i < 5; i++){
                if(Math.random() < 0.3){
                    System.out.println("| Rending cut combo #" + ct++);
                    user.dmgAttack(opponent, user.getAtk() + 5);
                }
            }
        }
        
    }
    
}
