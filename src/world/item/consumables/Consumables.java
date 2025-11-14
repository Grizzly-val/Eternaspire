package world.item.consumables;

import java.io.Serializable;

import entity.player.Challenger;
import world.item.Item;

public abstract class Consumables extends Item implements Serializable{
    public Consumables(String name, String description, String cutsceneID, int size) {
        super(name, description, cutsceneID, size);
    }
    public abstract void consume(Challenger player);
}
