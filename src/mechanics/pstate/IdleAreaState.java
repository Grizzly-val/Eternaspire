package mechanics.pstate;

import entity.player.Challenger;
import entity.tower_entity.Echo;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.battle.Battle;
import mechanics.inventory.AreaInventory;
import ui.AudioPlayer;
import ui.Format;
import ui.OptionSelect;
import ui.TextTyper;
import world.item.Item;
import world.item.wpn.Weapon;
import world.location.locationData.AreaEntities;

public class IdleAreaState implements PlayerState {

    @Override
    public void enterState(Challenger player, PlayerState prevState) {
        System.out.println();
        System.out.println("| Current Floor : \"" + player.getCurrentFloor().getName() + "\" (" + Format.getOrdinal(player.getCurrentFloor().getNumber()) + " floor)\n| Current Area  : " + player.getCurrentArea().getName());
        System.out.println("--------------------------------------------");
        System.out.println();
        System.out.println("| What would you like to do?");
        System.out.println("--------------------------------------------");

        char choice = '\0';

        while(choice != 'b'){
            System.out.println("| Area Idling |");
            System.out.println("---------------");
            System.out.println("[b] - Go back           (Area Navigation)");
            System.out.println("[e] - Explore area      (Scout area)");                 // battle || loot corpses, chests, etc || uncover mysteries
            System.out.println("[i] - Open inventory    (Inventory)");
            System.out.println("--------------------------------------------");
            choice = OptionSelect.charInput(choice);
            System.out.println("--------------------------------------------");
            System.out.println();
            
            switch(choice){
                case 'i':
                    new InventoryState().enterState(player, this);
                    break;
                case 'b':
                    System.out.println();
                    System.out.println();
                    System.out.println("| Going back to floor entrance >>");
                    System.out.println();
                    System.out.println();
                    return;
                case 'e':
                    System.out.println();
                    System.out.println("| Exploring " + player.getCurrentArea().getName() + " >>");
                    System.out.println();
                    explore(player);
                    this.enterState(player, prevState);
                    return;
                default:
                    System.out.println("!! Invalid choice !!");
                    break;
            }
        }
    }

    public void explore(Challenger player){
        char choice = '\0';
        while(choice != 'b'){
            System.out.println();
            System.out.println("| Floor     :   " + Format.getOrdinal(player.getCurrentFloor().getNumber()) + " floor");
            System.out.println("| Area      :   " + player.getCurrentArea().getName());
            System.out.println("--------------------------------------------");
            System.out.println("| Scouting Area |");
            System.out.println("-------------------");
            System.out.println("[b] Go back         (Area entrance)");
            System.out.println("[f] Danger Foe      (fight)");
            System.out.println("[c] Collectibles    (loot)");
            System.out.println("[i] Inventory       (Open inventory)");
            System.out.println("--------------------------------------------");
            choice = OptionSelect.charInput(choice);
            System.out.println("--------------------------------------------");

            System.out.println();

            switch(choice){
                case 'i':
                    new InventoryState().enterState(player, this);
                    break;
                case 'f':
                    System.out.println();
                    if(!player.getCurrentArea().getAreaEntities().isClear()){
                        System.out.println();
                        System.out.println("---------------------------------------------");
                        System.out.println("| Steel yourself, that's the path forward.  |");
                        System.out.println("| It's the only way to ascend the tower.    |");
                        System.out.println("---------------------------------------------");
                        engageBattle(player);
                    } else System.out.println("| Area is clear of danger");
                    System.out.println();
                    break;
                case 'c':
                    System.out.println();
                    if(player.getCurrentArea().getAreaEntities().isClear()){
                        lootArea(player);
                    } else System.out.println("| Area is still dangerous. You must not let your guard down.");
                    System.out.println();
                    break;
                case 'b':
                    System.out.println();
                    System.out.println("| Going back to area entrance >>");
                    System.out.println();
                    return;
                default:
                    System.out.println();
                    System.out.println("!! Invalid input !!");
                    System.out.println();
                    break;
            }

        }
    }


    public void engageBattle(Challenger player){

        AreaEntities pAreaEntities =  player.getCurrentArea().getAreaEntities();



        char choice = '\0';

        while(choice != 'r' && choice  != 'e'){
            System.out.println("| Engage battle |");
            System.out.println("--------------------");

            System.out.println("[r] - Remnants  (" + pAreaEntities.getRemnantCount() + ")");
            



            if(pAreaEntities.hasEcho())
                System.out.println("[e] - Echo");
            else System.out.println("[e] - Echo (Area has no Echo)");


            System.out.println("--------------------------------------------");
            choice = OptionSelect.charInput(choice);
            System.out.println("--------------------------------------------");

            System.out.println();
            switch(choice){
                case 'r':
                    if(!pAreaEntities.hasRemnant() && pAreaEntities.hasEcho()) System.out.println("| A quiet yet loud echo is all that's left in this area");
                    else if(!pAreaEntities.hasRemnant()) System.out.println("| Area is clear of wandering Remnants");
                    else{
                        Remnant chosenRemnant = pAreaEntities.fightRemnant();
                        System.out.println();
                        System.out.println("===============================================================");
                        System.out.println("| Engaging battle with " + chosenRemnant.getName());
                        System.out.println("| Level " + chosenRemnant.getLvl());
                        System.out.println("===============================================================");
                        new Battle(player, chosenRemnant);
                    }
                    if(pAreaEntities.hasRemnant())
                        break;
                case 'e':
                    System.out.println();
                    if(!pAreaEntities.hasEcho()) TextTyper.typeText("\n| This area holds no Echo.\n", 40, true);
                    
                    else{
                        if(!pAreaEntities.hasRemnant()){
                            Echo chosenEcho = pAreaEntities.fightEcho();
                            if(chosenEcho != null){
                                new Battle(player, chosenEcho);
                            }
                        } else{
                            System.out.println("----------------------------------------------------------------");
                            System.out.println("| Haste will not grant victory; the Echo waits for the worthy. |");
                            System.out.println("| Deal with the Remnants first.                                |");
                            System.out.println("----------------------------------------------------------------");
                        }
                    }
                    break;
                default:
                    System.out.println("!! Invalid choice !!");
                    break;
            }
            System.out.println("--------------------------------------------");
        }
    }
    




    public void lootArea(Challenger player){
        if(player.getCurrentArea().getAreaInventories().size() == 1 && player.getCurrentArea().getAreaInventories().get(0).getItems().isEmpty()){
            System.out.println("| There is nothing here.");
            System.out.println("--------------------------------------------");
            return;
        }



        int choice = -1;
        AreaInventory areaInv = null;
        System.out.println("| Choose where to search");
        System.out.println("--------------------------------------------");
        for(int i = 0; i < player.getCurrentArea().getAreaInventories().size(); i++){
            System.out.println(i + 1 + " - " + player.getCurrentArea().getAreaInventories().get(i).getName());
        }

        System.out.println("--------------------------------------------");
        choice = OptionSelect.getArrIndex(player.getCurrentArea().getAreaInventories().size());
        System.out.println();
        areaInv = player.getCurrentArea().getAreaInventories().get(choice - 1);
        
        System.out.println();


        
        System.out.println("| You approached a " + areaInv.getName());
        if(areaInv.getItems().isEmpty()){
            System.out.println("| " + areaInv.getName() + " is empty");
            System.out.println("--------------------------------------------");
            OptionSelect.waiter();
            return;
        }
        
        else{
            System.out.println("--------------------------------------------");
            char choiceWithItem = '\0';
            Item selectedItem = areaInv.selectItem();
            System.out.println("--------------------------------------------");
            System.out.println();
            System.out.println("| You've selected " + selectedItem.getName());
            System.out.println("|? " + selectedItem.getDescription());
            System.out.println("--------------------------------------------");

            while(choiceWithItem != 't' && choiceWithItem != 'p'){
                System.out.println();
                System.out.println("| Do you need the item?");
                System.out.println("--------------------------------------------");
                System.out.println("[t] take item");
                System.out.println("[p] put it back");
                System.out.println("--------------------------------------------");
                choiceWithItem = OptionSelect.charInput(choiceWithItem);
                System.out.println("--------------------------------------------");
                switch(choiceWithItem){
                    case 't':
                        if(selectedItem instanceof Weapon wpn){
                            if(!player.getWeapons_Tried().contains(wpn.getName())){
                                System.out.println();
                                player.getWeapons_Tried().add(wpn.getName());
                                wpn.triggerCutscene(wpn.getCutsceneID(), player);
                            }
                        }
                        System.out.println();
                        
                        
                        if(selectedItem.getSize() + player.getInventory().getOccupiedSpace() > player.getInventory().getCapacity()){
                            System.out.println();
                            AudioPlayer.playOverlay("unavailable.wav");
                            System.out.println("! ! Not enough space in Inventory ! !");
                            System.out.println("| Item Size : " + selectedItem.getSize() + "    Inventory : " + player.getInventory().getOccupiedSpace() + "/" + player.getInventory().getCapacity() + "(" + (player.getInventory().getCapacity() - player.getInventory().getOccupiedSpace()) + "left)");
                            System.out.println();
                        } else{
                            player.storeItem(selectedItem);
                            AudioPlayer.playOverlay("collect.wav");
                            System.out.println("| Item collected");
                            System.out.println();
                            areaInv.remove(selectedItem);
                        } 
                        System.out.println("--------------------------------------------");
                        break;
                    case 'p':
                        System.out.println();
                        System.out.println("| Can't take them all...");
                        System.out.println("--------------------------------------------");
                        break;
                    default:
                        break;
                }
                OptionSelect.waiter();
                System.out.println();
                System.out.println();
            }

        }
        System.out.println();
    


        
        

    }

}
