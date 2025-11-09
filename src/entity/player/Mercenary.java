package entity.player;

import entity.Entity;
import world.item.wpn.IronDagger;
import world.item.wpn.Weapon;

public class Mercenary extends Challenger {
    
    public Mercenary(){
        super("MercenaryName", "MercenaryDescription", "MercenaryStory", "Mercenary", 100, 100, 20, new IronDagger());
    }

}
