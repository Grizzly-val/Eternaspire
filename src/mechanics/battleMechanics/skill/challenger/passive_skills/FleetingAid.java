package mechanics.battleMechanics.skill.challenger.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class FleetingAid extends PassiveSkill{

    public FleetingAid() {
        super("Fleeting Aid", "Swift healing with a 80% chance of granting a small, immediate 7% HP recovery.");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        if(user.getHp() < user.getMaxHp() && Math.random() < 0.80){
            System.out.println("| " + user.getName() + " activated Fleeting aid. " + (user.getMaxHp() * 0.07) + "hp restored! (Passive Skill)");
            user.heal((int)(user.getMaxHp() * 0.07));
        }
    }
    
}
