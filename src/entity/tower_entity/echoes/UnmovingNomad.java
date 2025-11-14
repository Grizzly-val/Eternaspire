package entity.tower_entity.echoes;

import entity.Entity;
import entity.tower_entity.Echo;
import entity.tower_entity.TowerEntity;
import mechanics.battleMechanics.battle.Battle;

public class UnmovingNomad extends Echo{

    public UnmovingNomad() {
        super(130, 130, 30,18, "Unmoving Nomad", 
        "The Unmoving Nomad is a restless spirit, confined to a single floor, whose echoes speak of journeys he can no longer take.", 
        "The painful echo dissolves, leaving behind the true, free traveler.", 
        "cutscene_Defeat_UnmovingNomad");
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| The Unmoving Nomad throws a direct jab onto the Challenger");
        dmgAttack(opponent, atk);
    }

    
}
