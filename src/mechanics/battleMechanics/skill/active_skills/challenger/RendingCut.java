package mechanics.battleMechanics.skill.active_skills.challenger;

import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class RendingCut extends ActiveSkill {

    public RendingCut() {
        super("Rending Cut", "A straight-forward cut attack");
    }

    @Override
    public void activate(Battle battle) {
        System.out.println(battle.getChallenger().getName() + " used " + this.getName());
        battle.getChallenger().dmgAttack(battle.getTowerEntity(), battle.getChallenger().getAtk() + 9);
    }
    
}
