package mechanics.battleMechanics.skill.passive_skills.challenger;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class Photosynthesis extends PassiveSkill{

    public Photosynthesis() {
        super("Photosynthesis", "Absorb rays from the sun, heals 10hp per turn. <%> 100% activation chance");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        System.out.println("| " + user.getName() + " absorbs the rays of the sun. " + 10 + "hp restored through Photosynthesis! (Passive Skill)");
        user.heal((int)(10.0));
    }
    
}
