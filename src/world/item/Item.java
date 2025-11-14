package world.item;

import java.io.Serializable;

import entity.player.Challenger;

public abstract class Item implements Serializable{
    
    private String name;
    private String description;
    private String type;
    private String cutsceneID;
    private final int SIZE;
    
    public Item(String name, String description, String cutsceneID, int size){
        this.name = name;
        this.description = description;
        this.cutsceneID = cutsceneID;
        this.SIZE = size;
    }
    

    public void displayDetails(){
        System.out.println("| name        : " + name);
        System.out.println("| type        : " + type);
        System.out.println("| description : " + description);
    }

    public int getSize(){return SIZE;}
    public String getName(){return name;}
    public String getDescription(){return description;}
    public String getCutsceneID(){return cutsceneID;}

    public abstract void triggerCutscene(String cutsceneID, Challenger player);
}
