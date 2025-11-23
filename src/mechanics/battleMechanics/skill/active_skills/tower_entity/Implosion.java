package mechanics.battleMechanics.skill.active_skills.tower_entity;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class Implosion extends ActiveSkill{

    public Implosion() {
        super("Implosion", "Ignites core and explodes, damaging self and target.", 1);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        System.out.println("| " + user.getName() + " set an " + this.getName());
        user.dmgAttack(opponent, (int)(user.getAtk() + (2 + user.getLvl()) +(user.getAtk() * 0.25)));
        user.takeDamage((int)(user.getMaxHp()));
    }
    
}