package world.item.wpn;

import entity.Entity;
import entity.player.Challenger;
import mechanics.battleMechanics.skill.PassiveSkill;
import mechanics.cutscene.CutsceneManager;
import world.item.Item;

public abstract class Weapon extends Item{
    private int weaponStr;
    private PassiveSkill wpnSkill;

    public Weapon(String name, String description, String cutsceneID, int weaponStr){
        super(name, description, cutsceneID, 6);
        this.weaponStr = weaponStr;
    }

    public PassiveSkill getWpnSkill(){return wpnSkill;}

    public void useSkill(Challenger player){

    }

    public abstract void basicAttack(Challenger user, Entity opponent, int atk);

    
    public void equip(Challenger player){
        if(player.getEquippedWeapon() == null){
            player.equipWeapon(this);
        }
        else{
            player.unequipWeapon();
            player.equipWeapon(this);
        }
        System.out.println("| Equipped " + this.getName());

    }

    public int getAddAtk(){return weaponStr;}

    @Override
    public void triggerCutscene(String cutsceneID, Challenger player){
        System.out.println();
        CutsceneManager.checkCutscene(cutsceneID, player, this);
        System.out.println();
    }

}
