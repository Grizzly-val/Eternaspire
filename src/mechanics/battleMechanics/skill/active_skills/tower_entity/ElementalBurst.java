package mechanics.battleMechanics.skill.active_skills.tower_entity;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class ElementalBurst extends ActiveSkill{

    public ElementalBurst() {
        super("Elemental Burst", "A shot of concentrated consequetive elemental magic", 1);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        System.out.println("| " + user.getName() + " shoots an " + this.getName());
        user.dmgAttack(opponent, user.getAtk() + (2 + user.getLvl()));
    }
    
}
