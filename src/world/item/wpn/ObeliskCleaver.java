package world.item.wpn;

import entity.Entity;
import entity.player.Challenger;

public class ObeliskCleaver extends Weapon {
    public ObeliskCleaver(){
        super("Obelisk Cleaver", "A heavy obsidian battle axe, its edge dark and well-worn from its past duties.", "cutscene_FirstTimeEquip_ObseliskCleaver", 25);
    }

    @Override
    public void basicAttack(Challenger user, Entity opponent, int atk) {
        System.out.println("| A straightforward chop, letting the axe's weight do the work.");
        user.dmgAttack(opponent, atk);
        if(user.getLastDamage() > 0 && Math.random() < 0.5){
            System.out.println("| "+user.getName()+" Gives back damage received using the Obelisk Cleaver!");
            user.dmgAttack(opponent, user.getLastDamage());
            if(Math.random() < 0.5){
                System.out.println("| Some damage asborbed as life force!");
                user.heal((int)(user.getLastDamage() * Math.random()));
            }

        }
    }
}