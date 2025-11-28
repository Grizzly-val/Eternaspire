package mechanics.battleMechanics.skill.active_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class HydroJet extends ActiveSkill {
    public HydroJet() {
        super("Hydro Jet", "Powerful water blast. <%> 120% attack increase", 2);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        System.out.println("| " + user.getName() + " blasts water at high pressure!");
        // 120% ATK damage
        user.dmgAttack(opponent, (int)(user.getAtk() * 1.2));
    }
}
