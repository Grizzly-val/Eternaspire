package world.item.wpn;

import entity.Entity;
import entity.player.Challenger;

public class SanctifierHammer extends Weapon {
    public SanctifierHammer(){
        super("Sanctifier Hammer", "A holy hammer imbued with divine power, crushing evil with every strike.", "cutscene_FirstTimeEquip_SanctifierHammer", 18);
    }

    @Override
    public void basicAttack(Challenger user, Entity opponent, int atk) {
        System.out.println("Delivers a heavy blow, infused with holy strength.");
        user.dmgAttack(opponent, atk);
    }
}