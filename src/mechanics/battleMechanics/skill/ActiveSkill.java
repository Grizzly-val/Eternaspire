package mechanics.battleMechanics.skill;

import entity.Entity;

public abstract class ActiveSkill extends Skill{
    private int ptUsage;
    public abstract void activate(Entity user);

    public int getPtUse(){
        return ptUsage;
    }
}
