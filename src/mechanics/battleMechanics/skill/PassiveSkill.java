package mechanics.battleMechanics.skill;

import entity.Entity;

public abstract class PassiveSkill extends Skill{
    public abstract void autoActivate(Entity user);
}
