package mechanics.pstate;

import java.util.Map.Entry;

import entity.player.Challenger;
import ui.Format;
import ui.OptionSelect;
import ui.TextTyper;
import world.item.consumables.Key;
import world.location.Area;
import world.location.locationData.FloorData;

public class AreaNavigationState implements PlayerState {

    @Override
    public void enterState(Challenger player, PlayerState prevState) {
    
        System.out.println();

        Format.boxify("| You're in Eternaspire " + Format.getOrdinal(player.getCurrentFloor().getNumber()) + " floor: " + player.getCurrentFloor().getName() + "...");
        System.out.println();
        System.out.println("| What would you like to do?");
        
        char choice = '\0';
        while(choice != 'f'){
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
                    new InventoryState().enterState(player, this);
                    break;
                case 'f':
                    System.out.println();
                    System.out.println();
                    TextTyper.typeText("| Entering floor navigation >>", 30, true);
                    System.out.println();
                    return;
                case 'e':
                    System.out.println();
                    System.out.println();
                    TextTyper.typeText("| Exploring floor " + player.getCurrentFloor().getNumber() + " >>", 30, true);
                    System.out.println();
                    int newAreaIndex = chooseFloorAreas(player);   // later implement player.moveArea(newArea);
                    if(newAreaIndex != -1){
                        System.out.println();
                        System.out.println();
                        TextTyper.typeText("| Entering Area \"" + player.getCurrentFloor().getFloorArea(newAreaIndex).getName() + "\" >>", 30, true);
                        player.moveArea(newAreaIndex);
                        new IdleAreaState().enterState(player, this);
                        this.enterState(player, prevState);
                    }
                    else{
                        this.enterState(player, this);
                        System.out.println();
                    }
                    return;
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
            } else{
                System.out.println("| You do not have any key.\n| The key must be somewhere in Eternaspire\n");

            }
            OptionSelect.waiter();
            System.out.println();
            System.out.println();

            return -1;
        }
        else{
            return index;
        }
        

    }

    
}
