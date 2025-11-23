package mechanics.battleMechanics.skill.passive_skills.tower_entity;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class Shrapnels extends PassiveSkill{

    public Shrapnels() {
        super("Shrapnels", "The Cactus Fiend explodes in a burst of flying spines, scattering deadly shrapnel in all directions while its mustache lays on the ground, still flawless?");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        if(user.getHp() < user.getMaxHp() * 0.1){
            System.out.println("| " + user.getName() + " explodes and scatters into damaging Shrapnels (Passive Skill)");
            user.dmgAttack(opponent, 100);
            user.takeDamage(user.getMaxHp());
        }
    }
    
}