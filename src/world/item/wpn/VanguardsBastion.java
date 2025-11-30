package world.item.wpn;

import entity.Entity;
import entity.player.Challenger;

public class VanguardsBastion extends Weapon {
    public VanguardsBastion(){
        super("Vanguard's Bastion", 
              "A heavy shield-blade fused from Aeliana's sorrow and the Lost Vanguard's armor. It pulses with a protective love that defies the void.", 
              "cutscene_FirstTimeEquip_VanguardsBastion", 
              30); // High Base Attack
    }

    @Override
    public void basicAttack(Challenger user, Entity opponent, int atk) {
        System.out.println("| The Bastion strikes with the weight of a broken promise.");
        
        // Passive: Retribution
        // If the user has taken damage recently (hp < max), strike harder
        if (user.getHp() < user.getMaxHp()) {
            System.out.println("| The weapon glows with protective fury!");
            user.dmgAttack(opponent, (int)(atk * 1.15)); // 15% Bonus Damage
        } else {
            user.dmgAttack(opponent, atk);
        }
    }
}