package mechanics.inventory;

import world.item.Item;
import world.item.consumables.Key;
import world.item.consumables.Potion;
import world.item.consumables.SkillScroll;
import world.item.wpn.Weapon;

public abstract class Inventory {
    private String name;
    public Inventory(String name){
        this.name = name;
    }
    public String getName(){return name;}

    public abstract void add(Item item);
    public abstract void remove(Item item);

}
