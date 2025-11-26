package mechanics.battleMechanics.skill.tower_entity.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class EntropyAura extends PassiveSkill {
    public EntropyAura() {
        super("Entropy Aura", "Drains HP and heals self.");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        // 10% of Opponent's CURRENT HP
        int drain = (int)(opponent.getHp() * 0.10);
        
        System.out.println("| " + user.getName() + "\'s presence withers " + opponent.getName() + "...");
        user.dmgAttack(opponent, drain);
        user.heal(drain);
    }
}
