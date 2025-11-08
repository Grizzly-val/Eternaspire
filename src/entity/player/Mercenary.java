package entity.player;

import entity.Entity;
import world.item.wpn.IronDagger;
import world.item.wpn.Weapon;

public class Mercenary extends Challenger {
    
    public Mercenary(){
        super("MercenaryName", "MercenaryDescription", "MercenaryStory", "Mercenary", 100, 100, 20, new IronDagger());
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println(this.getName() + " used " + this.getEquippedWeapon().getBasicAtkName() + " with " + this.getEquippedWeapon().getName());
        opponent.takeDamage(getAtk() + this.getEquippedWeapon().getAddAtk());
    }

}
