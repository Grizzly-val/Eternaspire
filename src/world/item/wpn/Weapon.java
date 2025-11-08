package world.item.wpn;

import world.item.Item;

public class Weapon extends Item{
    private int weaponStr;
    private String basicAtkName;

    public Weapon(String name, String description, String cutsceneID, int weaponStr, String basicAtkName){
        super(name, description, "Weapon", cutsceneID);
        this.weaponStr = weaponStr;
        this.basicAtkName = basicAtkName;
    }

    public String getBasicAtkName(){return basicAtkName;}
    public int getAddAtk(){return weaponStr;}

}
