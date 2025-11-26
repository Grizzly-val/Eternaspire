package mechanics.battleMechanics.skill.challenger.active_skills;

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
        user.dmgAttack(opponent, (int)(user.getAtk() + (user.getAtk() * 0.45)));
        if(Math.random() < 0.40 && user instanceof Challenger p){
            p.addSkillPoint(1);
        }
        
    }
    
}
