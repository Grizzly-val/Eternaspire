package entity.tower_entity;

import java.util.ArrayList;
import java.util.Iterator;

import entity.Entity;
import entity.player.Challenger;
import mechanics.battleMechanics.battle.Battle;
import mechanics.cutscene.CutsceneManager;
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

    public TowerEntity addDrop(Item item){
        itemDrops.add(item);
        return this;
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
    public void defeated(Battle battle){
        
        TextTyper.typeText("| " + getName() + " has been defeated.", 18);
        TextTyper.typeText("| " + defeatMessage, 18);

        if(battle.getTowerEntity() instanceof Remnant rmnt){
            battle.getChallenger().getCurrentArea().getAreaEntities().remnantDefeated(rmnt);
            if(!battle.getChallenger().getEncountered_Remnant().contains(rmnt.getName())){
                battle.getChallenger().getEncountered_Remnant().add(rmnt.getName());
                afterBattleCutscene("cutscene_FirstEncounterWith_" + rmnt.getName().replace(" ", ""), battle.getChallenger());
            }
        }
        else if(battle.getTowerEntity() instanceof Echo echo){
            battle.getChallenger().getCurrentArea().getAreaEntities().echoDefeated();
            afterBattleCutscene(echo.getCutsceneID(), battle.getChallenger());
        }

        battle.getChallenger().resetLastDamage();
        battle.getChallenger().gainXp((int)(lvl * (1.00 + Math.random())));
        dropAll(battle.getChallenger().getCurrentArea());
    }


    public void afterBattleCutscene(String cutsceneID, Challenger player){
        System.out.println();
        CutsceneManager.checkCutscene(cutsceneID, player);
        System.out.println();
    }


}
