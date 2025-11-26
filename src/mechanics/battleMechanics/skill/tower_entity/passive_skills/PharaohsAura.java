package mechanics.battleMechanics.skill.tower_entity.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class PharaohsAura extends PassiveSkill {
    public PharaohsAura() {
        super("Pharaoh's Aura", "The very presence of the pharaoh feels painful and heavy.");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        int dmg = 15;

        System.out.println("| " + user.getName() + "\'s presence damages your very soul. " + dmg + " damage inflicted.");
        user.dmgAttack(opponent, dmg);
    }
}
