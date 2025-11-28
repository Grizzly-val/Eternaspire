package world.item.wpn;

import entity.Entity;
import entity.player.Challenger;

public class TheCuratorsNeedle extends Weapon {
    public TheCuratorsNeedle(){
        super("The Curator's Needle", "A massive floating needle resized for human hands. It hums with cold energy.", "cutscene_FirstTimeEquip_TheCuratorsNeedle", 25);
    }

    @Override
    public void basicAttack(Challenger user, Entity opponent, int atk) {
        System.out.println("| The needle hums, seeking the target's vital points.");
        
        // Passive Effect: Deals 20% bonus damage if target is below 50% HP
        if (opponent.getHp() < (opponent.getMaxHp() * 0.5)) {
            System.out.println("| The needle detects weakness and strikes deeper!");
            user.dmgAttack(opponent, (int)(atk * 1.8));
        } else {
            user.dmgAttack(opponent, atk);
        }

    }
}