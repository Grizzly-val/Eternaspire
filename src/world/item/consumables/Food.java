package world.item.consumables;

import entity.player.Challenger;
import mechanics.cutscene.CutsceneManager;

public class Food extends Consumables {

    private int effectAmount;
    FoodEffect effect;
    public Food(String name, String description, int effectAmount, String cutsceneID, FoodEffect effect) {
        super(name, description, cutsceneID, 3);
        this.effectAmount = effectAmount;
        this.effect = effect;
    }

    @Override
    public void consume(Challenger player){
        switch(this.effect){
            case HP:
                System.out.println("| You consumed " + getName());
                System.out.println("| " + effectAmount + " hp gained!");
                player.heal(effectAmount);
                player.getInventory().remove(this);
                break;
            case XP:
                System.out.println("| You consumed " + getName());
                System.out.println("| " + effectAmount + " xp added!");
                player.gainXp(effectAmount);
                player.getInventory().remove(this);
                break;
            case SP:
                System.out.println("| You consumed " + getName());
                System.out.println("| " + effectAmount + " sp recovered!");
                player.addSkillPoint(effectAmount);
                player.getInventory().remove(this);
                break;
            default:
                System.out.println("| Food filled Challenger's stomach");
                break;
        }
        if(this.getCutsceneID() != "nocutscene"){
            triggerCutscene(getCutsceneID(), player);
        }

        
    }

    @Override
    public void triggerCutscene(String cutsceneID, Challenger player) {
        System.out.println();
        CutsceneManager.checkCutscene(cutsceneID + "_as" + player.getJob(), player);
        System.out.println();
    }

}
