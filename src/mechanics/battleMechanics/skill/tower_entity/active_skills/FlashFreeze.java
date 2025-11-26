package mechanics.battleMechanics.skill.tower_entity.active_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class FlashFreeze extends ActiveSkill {
    public FlashFreeze() {
        super("Flash Freeze", "Massive Cold Damage.", 4);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        // High damage scaling (250% ATK)
        System.out.println("| " + user.getName() + " unleashes a blinding blue light!");
        int dmg = (int)(user.getAtk() * 2.5);
        user.dmgAttack(opponent, dmg);
    }
}