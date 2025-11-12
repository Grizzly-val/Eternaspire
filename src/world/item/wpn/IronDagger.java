package world.item.wpn;

import entity.Entity;
import entity.player.Challenger;

public class IronDagger extends Weapon {
    public IronDagger(){
        super("Iron Dagger", "A reliable weight for the pocket. It won't win you a duel, but it's perfect for when subtlety is more important than strength.", "cutscene_FirstTimeEquip_IronDagger", 9);
    }

    @Override
    public void basicAttack(Challenger user, Entity opponent, int atk) {
        System.out.println("A silent jab with the crude Iron Dagger's blade.");
        user.dmgAttack(opponent, atk);
    }
}
