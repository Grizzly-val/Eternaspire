package mechanics.pstate;

import world.location.Floor;
import entity.player.Challenger;
import ui.Format;
import ui.OptionSelect;

public class FloorNavigationState implements PlayerState {
    @Override
    public void enterState(Challenger player){
        Floor pCurrFloor = player.getCurrentFloor();
        System.out.println();
        System.out.println("The recursive tower known as Eternaspire—where every step repeats the last.");
        System.out.println();
        System.out.println(">   Eternaspire's " + Format.getOrdinal(pCurrFloor.getNumber()) + " floor - \"The "+ pCurrFloor.getName() + "\"");
        System.out.println(">   " + pCurrFloor.getDescription());
        System.out.println();
        System.out.println("                | Floor Navigation |");

            char choice = '\0';
            while(choice != 's'){
                System.out.println("------------------------------------------------------------");
                System.out.println("[a] - Ascend\n[d] - Descend\n[s] - Stay on current floor");
                System.out.println("------------------------------------------------------------");
                choice = OptionSelect.charInput(choice);
                System.out.println("------------------------------------------------------------");
                System.out.println();
                switch(choice){
                    case 'a':
                        System.out.println();
                        player.goUp();
                        System.out.println("| You are now at floor " + player.getCurrentFloor().getNumber() + ": " + player.getCurrentFloor().getName());
                        break;
                    case 'd':
                        System.out.println();
                        player.goDown();
                        System.out.println("| You are now at floor " + player.getCurrentFloor().getNumber() + ": " + player.getCurrentFloor().getName());
                        break;
                    case 's':
                        System.out.println();
                        player.setState(player.getAreaNavState());
                        break;
                    default:
                        System.out.println("!! Invalid choice !!");
                        break;
                }
            }

        // player navigate between floors (down and up v.v.)
        // If player enter floor, enter idleFloorState
        
    }

}
