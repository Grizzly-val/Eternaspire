package world.item.consumables;

import entity.player.Challenger;

public abstract class Potion extends Consumables {

    public Potion(String name, String description, String cutsceneID) {
        super(name, description, "Potion", cutsceneID);
    }

}
