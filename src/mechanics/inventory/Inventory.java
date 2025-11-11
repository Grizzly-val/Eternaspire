package mechanics.inventory;

import world.item.Item;


public abstract class Inventory {
    private String name;
    public Inventory(String name){
        this.name = name;
    }
    public String getName(){return name;}

    public abstract void addItem(Item item);
    public abstract void remove(Item item);

}
