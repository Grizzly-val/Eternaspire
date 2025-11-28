package entity.tower_entity.echoes;

import entity.Entity;
import entity.tower_entity.Echo;
import mechanics.battleMechanics.skill.active_skills.RealitySever;
import mechanics.battleMechanics.skill.passive_skills.TemporalJitter; 


public class BanishedKnight extends Echo {

    private static final int BASE_HP = 56;
    private static final int BASE_ATK = 20;

    public BanishedKnight(int lvl) {

        super(BASE_HP, BASE_ATK, 48,
        "Banished Knight",
        "The Banished Knight, once a proud challenger whose goal was to conquer the tower and regain his lost honour, now bound to the tower for eternity.",
        "The reflection fades, the weapon he wielded falling silent as the echo of what might have been is finally laid to rest. There is only one protagonist left standing in this universe.",
        "cutscene_Defeat_BanishedKnight");

        this.giveSkill(new RealitySever());
        this.giveSkill(new TemporalJitter());

    }

    @Override
    public void basicAttack(Entity opponent){
        System.out.println("| " + this.getName() + " swings his spectral blade with a mournful wail, tearing a momentary rift in the air.");
        dmgAttack(opponent, atk);
    }
    
}