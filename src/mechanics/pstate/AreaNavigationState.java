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
        System.out.println();

        System.out.println("You're in Eternaspire " + Format.getOrdinal(player.getCurrentFloor().getNumber()) + " floor: " + player.getCurrentFloor().getName() + "...");


        System.out.println("What would you like to do?");
        char choice = '\0';

        while(choice != 'b' && choice != 's'){
            System.out.println();
            System.out.println("b - Go back                 (Floor navigation)");
            System.out.println("s - Explore Floor           (Area navigation)");
            System.out.println();
            choice = OptionSelect.charInput(choice);

            switch(choice){
                case 'b':
                    System.out.println("Going back to floor navigation...");
                    player.setState(player.getFloorNavState());
                    break;
                case 's':
                    player.moveArea(chooseFloorAreas(player));
                    System.out.println();
                    System.out.println("Entering " + player.getCurrentArea().getName());
                    System.out.println();
                    player.setState(player.getIdleAreaState());
                    break;
                default:
                    System.out.println("Invalid Input!");
                    break;
            }
        }


    }


    public Area chooseFloorAreas(Challenger player){
        for(Entry<Integer, Area> parentAreaEntry : player.getCurrentFloor().getAreas().entrySet()){
            System.out.println(parentAreaEntry.getKey() + " - " + parentAreaEntry.getValue().getName());
        }

        Area areaEntered = null;

        System.out.println();
        while(areaEntered == null){
            System.out.print("Move area: ");
            areaEntered = player.getCurrentFloor().getFloorArea(OptionSelect.intInput(-1));
            if(areaEntered == null) System.out.println("Area not found");
        }

        return areaEntered;

    }

    
}
