package mechanics.battleMechanics.skill.passive_skills.dropped;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class HiredBladesSiphon extends PassiveSkill{

    public HiredBladesSiphon() {
        super("Hired Blade's Siphon", "Take an opponent's HP by means of HP steal from last damage dealt. <%> 40% passive activation chance (60% if HP is below 20%)");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        if(opponent.getLastDamage() > 0){
            if(user.getHp() < user.getHp() * 0.2){
                if(Math.random() < 0.6){
                    System.out.println("| " + user.getName() + " displayed a hired blade's greed. Siphoned " + opponent.getLastDamage() + "HP. (Passive Skill)");
                    user.heal(opponent.getLastDamage());
                }
            } else{
                if(Math.random() < 0.4){
                    System.out.println("| " + user.getName() + " displayed a hired blade's greed. Siphoned " + opponent.getLastDamage() + "HP. (Passive Skill)");
                    user.heal(opponent.getLastDamage());
                }
            }
        }
    }
    
}
