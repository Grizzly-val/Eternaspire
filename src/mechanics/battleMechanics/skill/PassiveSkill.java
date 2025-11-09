package mechanics.battleMechanics.skill;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;

public abstract class PassiveSkill extends Skill{
    
    public PassiveSkill(String name, String description) {
        super(name, description);
    }

    public abstract void autoActivate(Battle battle);
}
