package mechanics.battleMechanics.skill.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;


public class HeatLeach extends PassiveSkill {
    public HeatLeach() {
        super("Heat Leach", "Radiates damaging heat.");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        // Unavoidable damage at end of turn logic
        System.out.println("| " + user.getName() + " radiates intense heat! (Passive Skill)");
        // 5% of Opponent's Max HP
        int dmg = (int)(opponent.getMaxHp() * 0.05);
        user.dmgAttack(opponent, dmg);
    }
}