package world.item.wpn;

import entity.Entity;
import entity.player.Challenger;

public class ObeliskCleaver extends Weapon {
    public ObeliskCleaver(){
        super("Obelisk Cleaver", "A heavy obsidian battle axe, its edge dark and well-worn from its past duties.", "cutscene_FirstTimeEquip_ObseliskCleaver", 25);
    }

    @Override
    public void basicAttack(Challenger user, Entity opponent, int atk) {
        System.out.println("A straightforward chop, letting the axe's weight do the work.");
        user.dmgAttack(opponent, atk);
    }
}