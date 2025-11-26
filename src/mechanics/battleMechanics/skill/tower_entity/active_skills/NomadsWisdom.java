package mechanics.battleMechanics.skill.tower_entity.active_skills;

import entity.Entity;
import entity.player.Challenger;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;

public class NomadsWisdom extends ActiveSkill {
    public NomadsWisdom() {
        super("Nomad's Wisdom", "Harness the ancient wisdom of the nomads to boost your mental fortitude.", 0);
    }

    @Override
    public void activate(Entity user, Entity target, Battle battle) {
        System.out.println("| " + user.getName() + " invokes the Nomad's Wisdom, enhancing their resolve!");
        if(user instanceof Challenger player){
          player.addSkillPoint(2);
        }
    }
}