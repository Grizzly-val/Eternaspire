package mechanics.battleMechanics.skill.active_skills.tower_entity;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class InfernalStinger extends ActiveSkill{
    public InfernalStinger() {
        super("Infernal Stinger", "A piercing strike imbued with fiery venom", 1);
    }

    int effectLast = 0;

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        System.out.println("| " + user.getName() + " strikes with " + this.getName());
        user.dmgAttack(opponent, user.getAtk() + (3 + user.getLvl()));

    }
  
}