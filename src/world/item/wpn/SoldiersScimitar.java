package world.item.wpn;

import entity.Entity;
import entity.player.Challenger;

public class SoldiersScimitar extends Weapon {
    public SoldiersScimitar(){
        super("Soldier's Scimitar", "The fallen soldiers scimitar lay half-buried in the dust, its curved blade dulled but still echoing the battles it had survived.", "cutscene_FirstTimeEquip_SoldiersScimitar", 15);
    }

    @Override
    public void basicAttack(Challenger user, Entity opponent, int atk) {
        System.out.println("| A scimitar slices the enemy with swift motion.");
        user.dmgAttack(opponent, atk);
    }
}