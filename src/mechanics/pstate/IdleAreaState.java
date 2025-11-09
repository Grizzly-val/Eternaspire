package mechanics.pstate;

import java.util.ArrayList;

import entity.player.Challenger;
import entity.tower_entity.Echo;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.battle.Battle;
import mechanics.inventory.AreaInventory;
import ui.Format;
import ui.OptionSelect;
import world.item.Item;
import world.location.locationData.AreaEntities;

public class IdleAreaState implements PlayerState {

    @Override
    public void enterState(Challenger player) {
        System.out.println();
        System.out.println("Eternaspire " + Format.getOrdinal(player.getCurrentFloor().getNumber()) + " floor\nCurrent Area: " + player.getCurrentArea().getName());
        System.out.println("--------------------------------------------");
        System.out.println();
        System.out.println("| What would you like to do?");
        System.out.println("--------------------------------------------");

        char choice = '\0';

        while(choice != 'b'){
            System.out.println("[b] - Go back");
            System.out.println("[e] - Explore area");                 // battle || loot corpses, chests, etc || uncover mysteries
            System.out.println("--------------------------------------------");
            choice = OptionSelect.charInput(choice);
            System.out.println("--------------------------------------------");
            System.out.println();
            
            switch(choice){
                case 'b':
                    System.out.println();
                    System.out.println();
                    System.out.println("| Going back to floor entrance >>");
                    player.setState(player.getAreaNavState());
                    break;
                case 'e':
                    System.out.println("| Exploring  " + player.getCurrentArea().getName() + " >>");
                    explore(player);
                    player.setState(player.getIdleAreaState());
                    break;
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
            System.out.println("| " + Format.getOrdinal(player.getCurrentFloor().getNumber()) + " floor");
            System.out.println("| " + player.getCurrentArea().getName());
            System.out.println("--------------------------------------------");
            System.out.println("[b] Go back         (,,,)");
            System.out.println("[f] Danger Foe      (fight)");
            System.out.println("[c] Collectibles    (loot)");
            System.out.println("--------------------------------------------");
            choice = OptionSelect.charInput(choice);
            System.out.println("--------------------------------------------");

            System.out.println();

            switch(choice){
                case 'f':
                    System.out.println();
                    if(!player.getCurrentArea().getAreaEntities().isClear()){
                        System.out.println();
                        System.out.println("| Steel yourself, that's the path forward.");
                        System.out.println("| It's the only way to ascend the tower.");
                        System.out.println("--------------------------------------------");
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
                    break;
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
            System.out.println("[r] - Remnants (" + pAreaEntities.getRemnantCount() + ")");
            System.out.println("[e] - Area Echo");
            System.out.println("--------------------------------------------");
            choice = OptionSelect.charInput(choice);
            System.out.println("--------------------------------------------");

            System.out.println();
            switch(choice){
                case 'r':
                    if(!pAreaEntities.hasRemnant() && pAreaEntities.hasEcho()) System.out.println("A quiet yet loud echo is all that's left in this area");
                    else if(!pAreaEntities.hasRemnant()) System.out.println("Area is clear of wandering Remnants");
                    else{
                        Remnant chosenRemnant = pAreaEntities.fightRemnant();
                        System.out.println("| Engaging battle with " + chosenRemnant.getName());
                        System.out.println("| Level " + chosenRemnant.getLvl());
                        new Battle(player, chosenRemnant);
                    }
                    if(pAreaEntities.hasRemnant()){
                        break;
                    }
                case 'e':
                    if(!pAreaEntities.hasEcho()) System.out.println("| This area holds no Echo.");
                    
                    else{
                        if(!pAreaEntities.hasRemnant()){
                            Echo chosenEcho = pAreaEntities.fightEcho();
                            if(chosenEcho != null){
                                new Battle(player, chosenEcho);
                            }
                        } else{
                            System.out.println("| Haste will not grant victory; the Echo waits for the worthy.");
                            System.out.println("| Deal with the Remnants first.");
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
        if(player.getCurrentArea().getAreaInventories().isEmpty()){
            System.out.println("| There is nothing here.");
            return;
        }


        char continueChoice = '\0';

        while(continueChoice != 'n'){

            for(int i = 0; i < player.getCurrentArea().getAreaInventories().size(); i++){
                System.out.println(i + 1 + " - " + player.getCurrentArea().getAreaInventories().get(i).getName());
            }

            int choice = -1;
            AreaInventory areaInv = null;
            System.out.println("| Loot your heart out!");
            while(areaInv == null){
                choice = OptionSelect.getArrIndex(player.getCurrentArea().getAreaInventories().size());
                areaInv = player.getCurrentArea().getAreaInventories().get(choice - 1);
                if(areaInv == null){
                    System.out.println("!! Invalid input !!");
                }
            }


            
            System.out.println("| You approached a " + areaInv.getName());
            if(areaInv.getItems().isEmpty()){
                System.out.println();
                System.out.println("| " + areaInv.getName() + " is empty");
            }
            
            else{
                char choiceWithItem = '\0';
                Item selectedItem = areaInv.selectItem();
                System.out.println("| You've selected " + selectedItem.getName());
                System.out.println(selectedItem.getDescription());

                while(choiceWithItem != 't' && choiceWithItem != 'p'){
                    System.out.println("[t] take item");
                    System.out.println("[p] put it back");
                    choiceWithItem = OptionSelect.charInput(choiceWithItem);
                    switch(choiceWithItem){
                        case 't':
                            player.getInventory().add(selectedItem);
                            areaInv.remove(selectedItem);
                            break;
                        case 'p':
                            System.out.println("| Can't take them all");
                            break;
                        default:
                            break;
                    }
                }

            }

            System.out.print("| Would you like to continue looting?\ny/n: ");
            continueChoice = OptionSelect.charInput(continueChoice);
            System.out.println();
            switch(continueChoice){
                case 'y':
                    System.out.println("| Collecting is fun, but don't forget what you came here for.");
                    break;
                case 'n':
                    System.out.println("| Going back >>");
                    return;
                default:
                    System.out.println("!! Invalid input !!");
                    break;
            }
            System.out.println();
        
        }

        
        

    }

}
