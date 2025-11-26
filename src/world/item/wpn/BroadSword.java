package world.item.wpn;

import entity.Entity;
import entity.player.Challenger;

public class BroadSword extends Weapon {
    public BroadSword(){
        super("Broad Sword", "A heavy sword with a wide blade, designed for powerful slashes and crushing blows.", "cutscene_FirstTimeEquip_BroadSword", 20);
    }

    @Override
    public void basicAttack(Challenger user, Entity opponent, int atk) {
        System.out.println("| A downward slash strikes the enemy.");
        
        if(Math.random() < 0.20){
            System.out.println("| Weapon strength tripled.");
            user.dmgAttack(opponent, atk + this.getAddAtk() + this.getAddAtk() + this.getAddAtk());
        } else{
            user.dmgAttack(opponent, atk + this.getAddAtk());
        }

    }
}