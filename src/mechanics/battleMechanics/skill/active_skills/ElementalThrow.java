package mechanics.battleMechanics.skill.active_skills;

import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class ElementalThrow extends ActiveSkill{

    public ElementalThrow() {
        super("Elemental Throw", "A projectile of concentrated elemental magic");
    }

    @Override
    public void activate(Battle battle) {
        battle.getTowerEntity().dmgAttack(battle.getChallenger(), battle.getTowerEntity().getAtk() + 4);
    }
    
}
