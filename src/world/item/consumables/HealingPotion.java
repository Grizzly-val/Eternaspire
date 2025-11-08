package world.item.consumables;

import entity.player.Challenger;

public class HealingPotion extends Potion {

    public HealingPotion(String cutsceneID) {
        super("Healing Potion", "Heals for 30hp upon consumption", cutsceneID);
    }
    
    @Override
    public void consume(Challenger player) {
        // TODO Auto-generated method stub
        System.out.println("Consuming " + this.getName() + "...");
        
    }
}
