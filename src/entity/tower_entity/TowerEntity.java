package entity.tower_entity;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.Iterator;

import entity.Entity;
import entity.player.Challenger;
import mechanics.battleMechanics.battle.Battle;
import mechanics.cutscene.CutsceneManager;
import ui.OptionSelect;
import ui.TextTyper;
import world.item.Item;
import world.location.Area;


public abstract class TowerEntity extends Entity{
    
    private ArrayList<Item> itemDrops = new ArrayList<>();
    private String defeatMessage;

    public TowerEntity(String name, String description, int lvl, int hp, int maxHp, int atk, String defeatMessage){
        super(name, description, lvl, hp, maxHp, atk);
        this.defeatMessage = defeatMessage;

        

    }


    public TowerEntity addDrops(Item... items){ // WOWW! I JUST LEARNED ABOUT THIS
        for (Item item : items) {
            this.itemDrops.add(item);
        }

        return this; // I am returning TowerEntity because we will be using this method inside an argument passing where TowerEntity is expected, so it can't be void
    }

    public void dropAll(Area dropArea){
        if(itemDrops.isEmpty()){
            System.out.println("| " + getName() + " has no drops");
            return;
        }


    // Use the Iterator to safely remove items while looping
        Iterator<Item> iterator = itemDrops.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            
            dropArea.getAreaInventories().get(0).addItem(item);
            System.out.println("| " + getName() + " dropped " + item.getName());
            
            // **FIX:** Use the iterator to remove the item from the list
            iterator.remove(); 
        }


        
    }

    @Override
    public void defeated(Challenger player, Battle battle){
        
        System.out.println();
        TextTyper.typeText("| " + getName() + " has been defeated.", 18, true);
        TextTyper.typeText("| " + defeatMessage, 18, true);
        System.out.println();

        if(this instanceof Remnant rmnt){
            player.getCurrentArea().getAreaEntities().remnantDefeated(rmnt);
            if(!player.getEncountered_Entities().contains(rmnt.getName())){
                player.getEncountered_Entities().add(rmnt.getName());
                afterBattleCutscene(
                    "cutscene_RemnantDefeat_" + rmnt.getName().replace(" ", ""), 
                    player);            // pass which challenger the player is as cutsceneID
            }
        }
        else if(this instanceof Echo echo){
            player.getCurrentArea().getAreaEntities().echoDefeated();
            if(!player.getEncountered_Entities().contains(echo.getName())){
                player.getEncountered_Entities().add(echo.getName());
                afterBattleCutscene("cutscene_EchoDefeat_" + echo.getName().replace(" ", ""), player);
            }
        }

        player.resetLastDamage();
        player.gainXp((int) ((Math.sqrt((maxHp + atk + lvl) * 5) * Math.log(maxHp * atk))  * (Math.random() + 0.20)));
        dropAll(player.getCurrentArea());
        OptionSelect.waiter();
    }



    public void afterBattleCutscene(String cutsceneID, Challenger player){
        System.out.println();
        CutsceneManager.checkCutscene(cutsceneID, player, this);
        System.out.println();
    }


}
