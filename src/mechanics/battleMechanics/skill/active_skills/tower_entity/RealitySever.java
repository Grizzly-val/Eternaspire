package mechanics.battleMechanics.skill.active_skills.tower_entity;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class RealitySever extends ActiveSkill {
    public RealitySever() {
        super("Reality Sever", "Fixed True Damage. <%> 200% damage deal", 1);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        // Fixed damage (200% Atk), ignoring defense conceptually
        int trueDmg = (int)(user.getAtk() * 2.0);
        System.out.println("| " + user.getName() +" charges and cuts reality itself!");
        user.dmgAttack(opponent, trueDmg);
    }
}
