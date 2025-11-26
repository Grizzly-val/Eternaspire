package mechanics.battleMechanics.skill.tower_entity.passive_skills;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.PassiveSkill;

public class TheCollection extends PassiveSkill {
    private int turnCount = 0;

    public TheCollection() {
        super("The Collection", "Launches a free needle attack every 3 turns.");
    }

    @Override
    public void autoActivate(Entity user, Entity opponent, Battle battle) {
        turnCount++;
        if (turnCount % 3 == 0) {
            System.out.println("| Vorthos's collection grows... A needle flies out! (Passive Skill)");
            // Bonus attack, slightly weaker than normal
            user.dmgAttack(opponent, (int)(user.getAtk() * 0.8)); 
        }
    }
}