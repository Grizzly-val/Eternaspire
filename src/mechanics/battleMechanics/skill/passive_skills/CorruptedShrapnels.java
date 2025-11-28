package mechanics.battleMechanics.skill.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class CorruptedShrapnels extends PassiveSkill{

    public CorruptedShrapnels() {
        super("Corrupted Shrapnels", "The Corrupted Spinefiend is unstable. Upon reaching critical damage, it detonates violently.");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        // Triggers earlier (15% HP) and deals significantly more damage (150 flat)
        if(user.getHp() <= user.getMaxHp() * 0.15){
            System.out.println("| " + user.getName() + " glows with unstable void energy and DETONATES! (Passive Skill)");
            user.dmgAttack(opponent, 150); 
            user.takeDamage(user.getMaxHp()); // Suicide
        }
    }
}