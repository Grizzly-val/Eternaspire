package mechanics.battleMechanics.skill.tower_entity.active_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class SovereignsGrip extends ActiveSkill {
    public SovereignsGrip() {
        super("Sovereign's Grip", "Phantasmal ghost hands emerges from the pharoah's back.", 1);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        int dmg = (int)(user.getAtk() * 0.3);
        System.out.println("| " + user.getName() + " phantasmal ghost hands rushes towards " + opponent.getName() + "!");

        user.dmgAttack(opponent, dmg);

        user.heal(dmg);
        System.out.println("| " + user.getName() + " stole some of your soul essences, regaining " + dmg + " HP.");
    }
}