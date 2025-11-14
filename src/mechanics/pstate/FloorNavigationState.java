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
        System.out.println("------------------------");
        System.out.println("| | Floor Navigation | |");
        System.out.println("------------------------");
        System.out.println(">   Eternaspire's " + Format.getOrdinal(pCurrFloor.getNumber()) + " floor - \""+ pCurrFloor.getName() + "\"");
        System.out.println(">   " + pCurrFloor.getDescription());
        System.out.println();
        System.out.println("                | Floor Navigation |");

            char choice = '\0';
            while(choice != 's'){
                System.out.println("------------------------------------------------------------");
                System.out.println("[a] - Ascend\n[d] - Descend\n[s] - Stay on current floor\n[i] - Open inventory\n\n[0] - EXIT GAME");
                System.out.println("------------------------------------------------------------");
                choice = OptionSelect.charInput(choice);
                System.out.println("------------------------------------------------------------");
                System.out.println();
                switch(choice){
                    case '0':
                        System.out.println("EXITING GAME.");
                        return;
                    case 'i':
                        new InventoryState().enterState(player);
                        break;
                    case 'a':
                        System.out.println();
                        player.goUp();
                        System.out.println("| You are at floor " + player.getCurrentFloor().getNumber() + ": " + player.getCurrentFloor().getName());
                        break;
                    case 'd':
                        System.out.println();
                        player.goDown();
                        System.out.println("| You are at floor " + player.getCurrentFloor().getNumber() + ": " + player.getCurrentFloor().getName());
                        break;
                    case 's':
                        System.out.println();
                        new AreaNavigationState().enterState(player);
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
