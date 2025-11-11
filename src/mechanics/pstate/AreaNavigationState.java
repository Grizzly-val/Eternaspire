package mechanics.pstate;

import java.util.Map.Entry;

import entity.player.Challenger;
import ui.Format;
import ui.OptionSelect;
import world.item.consumables.Key;
import world.location.Area;

public class AreaNavigationState implements PlayerState {

    @Override
    public void enterState(Challenger player) {

        System.out.println();
        System.out.println("-----------------------");
        System.out.println("| | Area Navigation | |");
        System.out.println("-----------------------");
        System.out.println("| You're in Eternaspire " + Format.getOrdinal(player.getCurrentFloor().getNumber()) + " floor: " + player.getCurrentFloor().getName() + "...");

        System.out.println("------------------------------------------------------------");
        System.out.println();
        System.out.println("| What would you like to do?");
        System.out.println("------------------------------------------------------------");
        char choice = '\0';

        while(choice != 'b' && choice != 'e'){
            System.out.println("[b] - Go back                 (Floor navigation)");
            System.out.println("[e] - Explore Floor           (Area navigation)");
            System.out.println("[i] - Inventory               (Open inventory)");
            System.out.println("------------------------------------------------------------");
            choice = OptionSelect.charInput(choice);
            System.out.println("------------------------------------------------------------");

            switch(choice){
                case 'i':
                    player.getInventoryState().enterState(player);
                    break;
                case 'b':
                    System.out.println();
                    System.out.println();
                    System.out.println("| Going back to floor navigation >>");
                    System.out.println();
                    player.setState(player.getFloorNavState());
                    break;
                case 'e':
                    System.out.println();
                    System.out.println("| Exploring floor " + player.getCurrentFloor().getNumber() + " >>");
                    System.out.println();
                    Area newArea = chooseFloorAreas(player);   // later implement player.moveArea(newArea);
                    if(newArea != null){
                        System.out.println();
                        System.out.println();
                        System.out.println("| Entering Area \"" + player.getCurrentArea().getName() + "\" >>");
                        player.moveArea(newArea);
                        player.setState(player.getIdleAreaState());
                    }
                    else{
                        player.setState(player.getAreaNavState());
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println("!! Invalid Input !!");
                    break;
            }
        }


    }


    public Area chooseFloorAreas(Challenger player){
        Area areaEntered = null;

        System.out.println();
        while(areaEntered == null){
            System.out.println("          | Floor Areas |");
            System.out.println("------------------------------------");
            for(Entry<Integer, Area> parentAreaEntry : player.getCurrentFloor().getAreas().entrySet()){
                System.out.println(parentAreaEntry.getKey() + " - " + parentAreaEntry.getValue().getName());
            }
            System.out.println("------------------------------------");

            System.out.print("| Select area >> ");
            areaEntered = player.getCurrentFloor().getFloorArea(OptionSelect.intInput(-1));
            if(areaEntered == null) System.out.println("!! Area not found !!\n\n");
            System.out.println("------------------------------------");
        }

        if(areaEntered.isLocked()){
            System.out.println();
            System.out.println("| " + areaEntered.getName() + " is locked");
            System.out.println();
            Key key = player.getInventory().getKey();
            if(key != null){
                key.consume(player, areaEntered);
            } else System.out.println("| You do not have any key.\n| The key must be somewhere in Eternaspire\n");

            return null;
        }
        else{
            return areaEntered;
        }
        

    }

    
}
