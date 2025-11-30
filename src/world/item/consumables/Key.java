package world.item.consumables;

import entity.player.Challenger;
import mechanics.cutscene.CutsceneManager;
import ui.AudioPlayer;
import ui.Format;
import ui.OptionSelect;
import world.location.Area;
import world.location.Floor;

public class Key extends Consumables{

    private String keyID;

    public Key(String name, String description, String keyID, String cutsceneID) {
        super(name, description, cutsceneID, 1);
        this.keyID = keyID;
    }

    public String getKeyID(){return keyID;}

    public void consume(Challenger player, Object target) {
        if (target instanceof Area area) {
            if (keyID.equals(area.getLockID())) {
                triggerCutscene(this.getCutsceneID(), player);
                area.unlock();
                System.out.println("| You unlocked the area: " + area.getName());
                System.out.println("| You can now enter the area \"" + area.getName() + "\"");
                AudioPlayer.playOverlay("unlock.wav");
                player.getInventory().remove(this);
            } else {
                System.out.println("| This key doesn not fit this area.");
                AudioPlayer.playOverlay("unavailable.wav");
            }
        } 
        else if (target instanceof Floor floor) {
            if (keyID.equals(floor.getLockID())) {
                triggerCutscene(this.getCutsceneID(), player);
                floor.unlock();
                System.out.println("| You unlocked the floor: " + floor.getName());
                System.out.println("| You can now enter the " + Format.getOrdinal(floor.getNumber()) + " Floor");
                AudioPlayer.playOverlay("unlock.wav");
                player.getInventory().remove(this);
            } else {
                System.out.println("| This key does not fit this floor.");
                AudioPlayer.playOverlay("unavailable.wav");
            }
        } 
        else {
            System.out.println("| This key cannot be used here.");
        }


        OptionSelect.waiter();
        System.out.println();
        System.out.println();
    }

    @Override
    public void consume(Challenger player) {
        // Not used directly — keys need a target
        System.out.println("You must select a target to use this key.");
    }

    @Override
    public void triggerCutscene(String cutsceneID, Challenger player) {
        System.out.println();
        CutsceneManager.checkCutscene(cutsceneID, player, this);
        System.out.println();
    }
}
