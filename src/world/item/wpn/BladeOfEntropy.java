package world.item.wpn;

import entity.Entity;
import entity.player.Challenger;

public class BladeOfEntropy extends Weapon {
    public BladeOfEntropy(){
        super("Blade of Entropy", "A shard of negative space that swallows light. It feels heavier than it looks.", "cutscene_FirstTimeEquip_BladeOfEntropy", 45);
    }

    @Override
    public void basicAttack(Challenger user, Entity opponent, int atk) {
        // Passive Effect: Chance to trigger 'Reality Sever' for massive damage
        if (Math.random() < 0.15) {
            System.out.println("The blade severs reality itself!");
            // Deals 150% damage
            user.dmgAttack(opponent, (int)(atk * 1.5));
        } else {
            System.out.println("The blade slices through the air with a hollow sound.");
            user.dmgAttack(opponent, atk);
        }
    }
}