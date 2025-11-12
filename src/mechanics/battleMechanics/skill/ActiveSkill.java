package mechanics.battleMechanics.skill;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;

public abstract class ActiveSkill extends Skill{
    
    public ActiveSkill(String name, String description, int ptUsage) {
        super(name, description);
        this.ptUsage = ptUsage;
    }

    private int ptUsage;
    public abstract void activate(Entity user, Entity opponent, Battle battle);

    public int getPtUse(){
        return ptUsage;
    }
}
