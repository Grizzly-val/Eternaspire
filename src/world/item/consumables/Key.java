package world.item.consumables;

import entity.player.Challenger;
import ui.Format;
import world.location.Area;
import world.location.Floor;

public class Key extends Consumables{

    private String keyID;

    public Key(String name, String description, String id, String cutsceneID) {
        super(name, description, cutsceneID, 1);
        this.keyID = id;
    }

    public String getKeyID(){return keyID;}

    public void consume(Challenger player, Object target) {
        if (target instanceof Area area) {
            if (keyID.equals(area.getLockID())) {
                area.unlock();
                System.out.println("| You unlocked the area: " + area.getName());
                System.out.println("| You can now enter the area \"" + area.getName() + "\"");
                player.getInventory().remove(this); // optional: consume the key
            } else {
                System.out.println("| This key doesn not fit this area.");
            }
        } 
        else if (target instanceof Floor floor) {
            if (keyID.equals(floor.getLockID())) {
                floor.unlock();
                System.out.println("| You unlocked the floor: " + floor.getName());
                System.out.println("| You can now enter the \"" + Format.getOrdinal(floor.getNumber()) + "\"");
                player.getInventory().remove(this);
            } else {
                System.out.println("| This key does not fit this floor.");
            }
        } 
        else {
            System.out.println("| This key cannot be used here.");
        }
    }

    @Override
    public void consume(Challenger player) {
        // Not used directly — keys need a target
        System.out.println("You must select a target to use this key.");
    }
}
