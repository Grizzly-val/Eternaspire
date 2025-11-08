package world.item;

import entity.player.Challenger;

public abstract class Item {
    
    private String name;
    private String description;
    private String type;
    private String cutsceneID;
    
    public Item(String name, String description, String type, String cutsceneID){
        this.name = name;
        this.description = description;
        this.type = type;
        this.cutsceneID = cutsceneID;
    }
    
    
    

    public void displayDetails(){
        System.out.println("name        : " + name);
        System.out.println("type        : " + type);
        System.out.println("description : " + description);
    }

    public String getName(){return name;}
    public String getDescription(){return description;}

    public void triggerCutscene(){
        
    }



}
