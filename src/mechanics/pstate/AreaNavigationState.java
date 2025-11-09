package mechanics.pstate;

import java.util.Map.Entry;

import entity.player.Challenger;
import ui.Format;
import ui.OptionSelect;
import world.location.Area;

public class AreaNavigationState implements PlayerState {

    @Override
    public void enterState(Challenger player) {

        System.out.println();
        System.out.println("| You're in Eternaspire " + Format.getOrdinal(player.getCurrentFloor().getNumber()) + " floor: " + player.getCurrentFloor().getName() + "...");

        System.out.println("------------------------------------------------------------");
        System.out.println();
        System.out.println("| What would you like to do?");
        System.out.println("------------------------------------------------------------");
        char choice = '\0';

        while(choice != 'b' && choice != 'e'){
            System.out.println("[b] - Go back                 (Floor navigation)");
            System.out.println("[e] - Explore Floor           (Area navigation)");
            System.out.println("------------------------------------------------------------");
            choice = OptionSelect.charInput(choice);
            System.out.println("------------------------------------------------------------");

            switch(choice){
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
                    player.moveArea(chooseFloorAreas(player));
                    System.out.println();
                    System.out.println("| Entering Area \"" + player.getCurrentArea().getName() + "\" >>");
                    System.out.println();
                    player.setState(player.getIdleAreaState());
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

        return areaEntered;

    }

    
}
