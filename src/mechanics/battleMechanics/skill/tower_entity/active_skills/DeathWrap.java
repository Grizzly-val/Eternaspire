package mechanics.battleMechanics.skill.tower_entity.active_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class DeathWrap extends ActiveSkill{
    public DeathWrap() {
        super("Death Wrap", "A rapid coil of segmented limbs that squeezes the life from its prey.", 1);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        System.out.println("| " + user.getName() + " coils " + opponent.getName() + " in a Death Wrap");
        user.dmgAttack(opponent, user.getAtk() + 3 + user.getLvl());
    }
  
}