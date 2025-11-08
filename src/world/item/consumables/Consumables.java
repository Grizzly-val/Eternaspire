package world.item.consumables;

import entity.player.Challenger;
import world.item.Item;

public abstract class Consumables extends Item{
    public Consumables(String name, String description, String type, String cutsceneID) {
        super(name, description, type, cutsceneID);
    }
    public abstract void consume(Challenger player);
}
