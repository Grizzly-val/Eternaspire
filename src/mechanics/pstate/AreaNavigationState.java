package mechanics.pstate;

import java.util.Map.Entry;

import entity.player.Challenger;
import ui.Format;
import ui.OptionSelect;
import world.item.consumables.Key;
import world.location.Area;
import world.location.locationData.FloorData;

public class AreaNavigationState implements PlayerState {

    @Override
    public void enterState(Challenger player) {

        System.out.println();

        System.out.println("| You're in Eternaspire " + Format.getOrdinal(player.getCurrentFloor().getNumber()) + " floor: " + player.getCurrentFloor().getName() + "...");

        System.out.println("------------------------------------------------------------");
        System.out.println();
        System.out.println("| What would you like to do?");
        
        char choice = '\0';
        while(choice != 'f' && choice != 'e'){
            System.out.println("------------------------------------------------------------");
            System.out.println("| Area Navigation 📍|");
            System.out.println("--------------------");
            System.out.println("[f] - Floor Entrance          (Floor navigation)");
            System.out.println("[e] - Explore Floor           (Area navigation)");
            System.out.println("[i] - Inventory               (Open inventory)");
            System.out.println("------------------------------------------------------------");
            choice = OptionSelect.charInput(choice);
            System.out.println("------------------------------------------------------------");

            switch(choice){
                case 'i':
                    new InventoryState().enterState(player);
                    break;
                case 'f':
                    System.out.println();
                    System.out.println();
                    System.out.println("| Entering floor navigation >>");
                    System.out.println();
                    new FloorNavigationState().enterState(player);
                    break;
                case 'e':
                    System.out.println();
                    System.out.println("| Exploring floor " + player.getCurrentFloor().getNumber() + " >>");
                    System.out.println();
                    int newAreaIndex = chooseFloorAreas(player);   // later implement player.moveArea(newArea);
                    if(newAreaIndex != -1){
                        System.out.println();
                        System.out.println();
                        System.out.println("| Entering Area \"" + player.getCurrentFloor().getFloorArea(newAreaIndex).getName() + "\" >>");
                        player.moveArea(newAreaIndex);
                        new IdleAreaState().enterState(player);
                    }
                    else{
                        new AreaNavigationState().enterState(player);
                        return;
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


    public int chooseFloorAreas(Challenger player){
        Area areaEntered = null;

        System.out.println();
        int index = -1;
        while(areaEntered == null){
            System.out.println("------------------------------------");
            System.out.println("| Floor Areas 🗼|");
            System.out.println("-----------------");
            for(Entry<Integer, Area> parentAreaEntry : player.getCurrentFloor().getAreas().entrySet()){
                System.out.println(parentAreaEntry.getKey() + " - " + parentAreaEntry.getValue().getName());
            }
            System.out.println("------------------------------------");

            System.out.print("| Select area >> ");
            index = OptionSelect.intInput(-1);
            areaEntered = player.getCurrentFloor().getFloorArea(index);
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

            return -1;
        }
        else{
            return index;
        }
        

    }

    
}
