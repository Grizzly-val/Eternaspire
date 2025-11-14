package mechanics.inventory;

import java.io.Serializable;

import world.item.Item;


public abstract class Inventory implements Serializable{
    private String name;
    public Inventory(String name){
        this.name = name;
    }
    public String getName(){return name;}

    public abstract void addItem(Item item);
    public abstract void remove(Item item);

}
