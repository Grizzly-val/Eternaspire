package world.item.wpn;

import entity.player.Challenger;
import mechanics.battleMechanics.skill.PassiveSkill;
import world.item.Item;

public class Weapon extends Item{
    private int weaponStr;
    private String basicAtkName;
    private PassiveSkill wpnSkill;

    public Weapon(String name, String description, String cutsceneID, int weaponStr, String basicAtkName){
        super(name, description, cutsceneID, 6);
        this.weaponStr = weaponStr;
        this.basicAtkName = basicAtkName;
    }

    public PassiveSkill getWpnSkill(){return wpnSkill;}

    public void useSkill(Challenger player){

    }
    
    public void equip(Challenger player){
        if(player.getEquippedWeapon() == null){
            player.setWeapon(this);
        }
        else{
            player.unequipWeapon();
            player.setWeapon(this);
            System.out.println("| Equipped " + this.getName());
        }
    }

    public String getBasicAtkName(){return basicAtkName;}
    public int getAddAtk(){return weaponStr;}

}
