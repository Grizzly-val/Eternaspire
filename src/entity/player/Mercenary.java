package entity.player;

import world.item.wpn.IronDagger;

public class Mercenary extends Challenger {
    
    public Mercenary(){
        super("MercenaryName", "MercenaryDescription", "Mercenary", 300, 300, 50, new IronDagger());
    }

}
