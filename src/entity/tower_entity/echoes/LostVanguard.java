package entity.tower_entity.echoes;

import entity.Entity;
import entity.tower_entity.Echo;

public class LostVanguard extends Echo {

    public LostVanguard(int hp, int atk, int lvl, String description) {
        super(hp, atk, lvl, "Lost Vanguard", "write description here", "write story here");
    }

    @Override
    public void basicAttack(Entity opponent){

    }

    
}
