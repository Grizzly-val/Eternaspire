package entity.tower_entity.echoes;

import entity.Entity;
import entity.tower_entity.Echo;
import mechanics.battleMechanics.skill.active_skills.DesperateShank;
import mechanics.battleMechanics.skill.passive_skills.RecoveryProtocol;

public class UnmovingNomad extends Echo{

    private static final int BASE_HP = 100;
    private static final int BASE_ATK = 9;

    public UnmovingNomad(int lvl) {
        super(BASE_HP, BASE_ATK,16, 
        "Unmoving Nomad", 
        "The Unmoving Nomad is a restless spirit, confined to a single floor, whose echoes speak of journeys he can no longer take.", 
        "The painful echo dissolves, leaving behind the true, free traveler.", 
        "cutscene_Defeat_UnmovingNomad");

        this.giveSkill(new RecoveryProtocol());
        this.giveSkill(new DesperateShank());
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| The Unmoving Nomad throws a direct jab onto the Challenger");
        dmgAttack(opponent, atk);
    }

    
}
