package mechanics.pstate;

import java.util.ArrayList;

import entity.player.Challenger;
import entity.tower_entity.Echo;
import entity.tower_entity.Remnant;
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
        System.out.println("What would you like to do?");

        char choice = '\0';

        while(choice != 'b'){
            System.out.println("b - Go back");
            System.out.println("e - Explore area");                 // battle || loot corpses, chests, etc || uncover mysteries

            choice = OptionSelect.charInput(choice);
            System.out.println();
            
            switch(choice){
                case 'b':
                    System.out.println("Going back...");
                    player.setState(player.getAreaNavState());
                    break;
                case 'e':
                    explore(player);
                    player.setState(player.getIdleAreaState());
                    break;
                default:
                    break;
            }
        }
    }

    public void explore(Challenger player){
        char choice = '\0';
        while(choice != 'b'){
            System.out.println();
            System.out.println("[b] Go back         (,,,)");
            System.out.println("[f] Danger Foe      (fight)");
            System.out.println("[c] Collectibles    (loot)");
            System.out.println();
            choice = OptionSelect.charInput(choice);

            switch(choice){
                case 'f':
                    if(!player.getCurrentArea().getAreaEntities().isClear()){
                        System.out.println("It's the only way to ascend the tower.");
                        engageBattle(player);
                    }
                    else
                        System.out.println("Area is clear of danger");
                    break;

                case 'c':
                    if(player.getCurrentArea().getAreaEntities().isClear()){
                        lootArea(player);
                    }
                    else
                        System.out.println("Area is still dangerous. You must not let your guard down.");
                    break;
                case 'b':
                    System.out.println();
                    System.out.println("...");
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }

        }
    }



    public void lootArea(Challenger player){
        if(player.getCurrentArea().getAreaInventories().isEmpty()){
            System.out.println("There's nothing here.");
            return;
        }


        char continueChoice = '\0';

        while(continueChoice != 'n'){

            for(int i = 0; i < player.getCurrentArea().getAreaInventories().size(); i++){
                System.out.println(i + 1 + " - " + player.getCurrentArea().getAreaInventories().get(i).getName());
            }

            int choice = -1;
            AreaInventory areaInv = null;
            System.out.println("Loot your heart out!");
            while(areaInv == null){
                choice = OptionSelect.intInput(choice);
                areaInv = player.getCurrentArea().getAreaInventories().get(choice - 1);
                if(areaInv == null){
                    System.out.println("Invalid input");
                }
            }


            
            System.out.println("You approached a " + areaInv.getName());
            if(areaInv.getItems().isEmpty()){
                System.out.println();
                System.out.println(areaInv.getName() + " is empty");
            }
            
            else{
                char choiceWithItem = '\0';
                Item selectedItem = areaInv.selectItem();
                System.out.println("You've selected " + selectedItem.getName());
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
                            System.out.println("Can't take them all");
                            break;
                        default:
                            break;
                    }
                }

            }

            System.out.print("Would you like to continue looting?\ny/n: ");
            continueChoice = OptionSelect.charInput(continueChoice);
            switch(continueChoice){
                case 'y':
                    System.out.println("Collecting is fun, but don't forget what you came here for.");
                    break;
                case 'n':
                    System.out.println("Going back...");
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        
        }

        
        

    }

    public void engageBattle(Challenger player){

        AreaEntities pAreaEntities =  player.getCurrentArea().getAreaEntities();



        char choice = '\0';

        while(choice != 'r' && choice  != 'e'){
            System.out.println("r - Remnants [" + pAreaEntities.getRemnantCount() + "]");
            System.out.println("e - Echo");
            choice = OptionSelect.charInput(choice);


            switch(choice){
                case 'r':
                    if(!pAreaEntities.hasRemnant() && pAreaEntities.hasEcho()) System.out.println("A quiet yet loud echo is all that's left in this area");
                    else if(!pAreaEntities.hasRemnant()) System.out.println("Area is clear of wandering Remnants");
                    else{
                        Remnant chosenRemnant = pAreaEntities.fightRemnant();
                        System.out.println("Engaging battle with " + chosenRemnant.getName());
                        System.out.println("Level " + chosenRemnant.getLvl());
                        //Implement battle
                    }
                    break;
                case 'e':
                    if(!pAreaEntities.hasEcho()) System.out.println("Consider yourself lucky each No-Echo area you enter.");
                    
                    else{
                        Echo chosenEcho = pAreaEntities.fightEcho();
                        if(chosenEcho != null){
                            //Implement battle
                        }
                    }
                    break;
                default:
                    break;
            }



            
        }




    }
    
}
