package mechanics.battleMechanics.skill.challenger.active_skills;

import mechanics.battleMechanics.skill.ActiveSkill;
import entity.Entity;
import mechanics.battleMechanics.battle.Battle;

public class EclipseSmite extends ActiveSkill {
    public EclipseSmite() {
        super("Eclipse Smite", "A corrupted holy smite. It no longer burns with light, but crushes with the weight of absolute darkness.", 6);
    }

    @Override
    public void activate(Entity user, Entity opponent, Battle battle) {
        System.out.println("| " + user.getName() + " raises his weapon, black lightning crackling around it!");
        
        // Deals heavy damage (180% ATK)
        int damage = (int)(user.getAtk() * 1.8);
        System.out.println("| JUDGEMENT FALLS!");
        user.dmgAttack(opponent, damage);
    }
}