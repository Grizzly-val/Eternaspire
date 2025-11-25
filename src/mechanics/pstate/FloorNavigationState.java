package mechanics.pstate;

import world.location.Floor;
import entity.player.Challenger;
import ui.Format;
import ui.OptionSelect;
import ui.TextTyper;

public class FloorNavigationState implements PlayerState {
    @Override
    public void enterState(Challenger player, PlayerState prevState){
        Floor pCurrFloor = player.getCurrentFloor();
        System.out.println();
        Format.boxify("Eternaspire's " + Format.getOrdinal(pCurrFloor.getNumber()) + " floor - \""+ pCurrFloor.getName() + "\"");
        System.out.println("|> " + pCurrFloor.getDescription() + " |");
        System.out.println(String.valueOf("=").repeat(pCurrFloor.getDescription().length() + 5));

        System.out.println();
        OptionSelect.waiter();
        System.out.println();
            char choice = '\0';
            while(choice != '0'){
                System.out.println("------------------------------------------------------------");
                System.out.println("| Floor Navigation ⏳|");
                System.out.println("---------------------");
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
                        new InventoryState().enterState(player, this);
                        break;
                    case 'a':
                        System.out.println();
                        player.goUp();
                        Format.boxify("You are at floor " + player.getCurrentFloor().getNumber() + ": " + player.getCurrentFloor().getName());
                        System.out.println();
                        OptionSelect.waiter();
                        break;
                    case 'd':
                        System.out.println();
                        player.goDown();
                        Format.boxify("You are at floor " + player.getCurrentFloor().getNumber() + ": " + player.getCurrentFloor().getName());
                        System.out.println();
                        OptionSelect.waiter();
                        break;
                    case 's':
                        System.out.println();
                        TextTyper.typeText("| Entering area navigation >>", 30, true);
                        prevState.enterState(player, this);
                        this.enterState(player, prevState);
                        return;
                    default:
                        System.out.println("!! Invalid choice !!");
                        break;
                }
            }

        // player navigate between floors (down and up v.v.)
        // If player enter floor, enter idleFloorState
        
    }

}
