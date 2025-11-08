package world.item.consumables;

import entity.player.Challenger;
import world.location.Area;
import world.location.Floor;

public class Key extends Consumables{

    private String keyID;

    public Key(String name, String description, String id, String cutsceneID) {
        super(name, description, "Key", cutsceneID);
        this.keyID = id;
    }

    public String getKeyID(){return keyID;}

    public void consume(Challenger player, Object target) {
        if (target instanceof Area area) {
            if (keyID.equals(area.getLockID())) {
                area.unlock();
                System.out.println("You unlocked the area: " + area.getName());
                player.getInventory().remove(this); // optional: consume the key
            } else {
                System.out.println("This key doesn not fit this area.");
            }
        } 
        else if (target instanceof Floor floor) {
            if (keyID.equals(floor.getLockID())) {
                floor.unlock();
                System.out.println("You unlocked the floor: " + floor.getName());
                player.getInventory().remove(this);
            } else {
                System.out.println("This key doesn not fit this floor.");
            }
        } 
        else {
            System.out.println("This key can not be used here.");
        }
    }

    @Override
    public void consume(Challenger player) {
        // Not used directly — keys need a target
        System.out.println("You must select a target to use this key.");
    }
}
