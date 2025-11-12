package world.item.consumables;

import entity.player.Challenger;
import mechanics.cutscene.CutsceneManager;

public class Food extends Consumables {

    private int hpAdd;
    public Food(String name, String description, int hpAdd, String cutsceneID) {
        super(name, description, cutsceneID, 3);
        this.hpAdd = hpAdd;
    }

    @Override
    public void consume(Challenger player){
        if(this.getCutsceneID() != "nocutscene"){
            triggerCutscene(getCutsceneID(), player);
        }
        System.out.println("| You consumed " + getName());
        System.out.println("| " + hpAdd + " hp replenished\n| (" + player.getHp() + " -> " + player.getHp() + hpAdd + ")");
        player.heal(hpAdd);
        player.getInventory().remove(this);
        
    }

    @Override
    public void triggerCutscene(String cutsceneID, Challenger player) {
        System.out.println();
        CutsceneManager.checkCutscene(cutsceneID + "_as" + player.getJob(), player);
        System.out.println();
    }

}
