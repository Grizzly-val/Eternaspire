package world.item.consumables;

import entity.player.Challenger;

public class Food extends Consumables {

    private int hpAdd;
    public Food(String name, String description, int hpAdd, String cutsceneID) {
        super(name, description, cutsceneID, 3);
        this.hpAdd = hpAdd;
    }

    @Override
    public void consume(Challenger player){
        System.out.println("| You consumed " + getName());
        System.out.println("| " + hpAdd + " hp replenished\n| (" + player.getHp() + " -> " + player.getHp() + hpAdd + ")");
        player.heal(hpAdd);
        player.getInventory().remove(this);
        
    }

}
