package mechanics.battleMechanics.skill;

import mechanics.battleMechanics.battle.Battle;

public abstract class ActiveSkill extends Skill{
    
    public ActiveSkill(String name, String description) {
        super(name, description);
    }

    private int ptUsage;
    public abstract void activate(Battle battle);

    public int getPtUse(){
        return ptUsage;
    }
}
