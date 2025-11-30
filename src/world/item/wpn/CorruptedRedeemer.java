package world.item.wpn;

import entity.Entity;
import entity.player.Challenger;

public class CorruptedRedeemer extends Weapon {
    public CorruptedRedeemer(){
        super("Corrupted Redeemer", 
              "A massive mace that once shattered darkness, now fused with it. It strikes with the crushing weight of a fallen star.", 
              "cutscene_FirstTimeEquip_CorruptedRedeemer", 
              65); // Very High Base Attack
    }

    @Override
    public void basicAttack(Challenger user, Entity opponent, int atk) {
        System.out.println("| The Redeemer falls like a judgment from the void.");
        
        // Passive: Eclipse Crush
        // 20% Chance to deal triple damage (Critical Smite)
        if (Math.random() < 0.20) {
            System.out.println("| BLACK LIGHTNING ERUPTS!");
            user.dmgAttack(opponent, (int)(atk * 3));
            user.addSkillPoint(2);
        } else {
            user.dmgAttack(opponent, atk);
        }
    }
}