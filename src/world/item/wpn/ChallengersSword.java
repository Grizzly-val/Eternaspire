package world.item.wpn;

import entity.Entity;
import entity.player.Challenger;

public class ChallengersSword extends Weapon{

    public ChallengersSword() {
        super("Challenger's Sword", "A beginner's best friend. It has seen countless challenges, and survived every single one. Whether you do is up to you.", "cutscene_FirstTimeEquip_ChallengersSword",4);
    }

    @Override
    public void basicAttack(Challenger user, Entity opponent, int atk) {

        if(user.getHp() <= user.getMaxHp() * 0.4){
            System.out.println("| Challenger's Sword gripped with willpower, is swung and carved the air with a resolute swing.");
            user.dmgAttack(opponent, atk + (int)(atk * 0.50));
            user.heal((int)(atk * 0.10));
        } else{
            System.out.println("| The blade of the Challenger's Sword carved the air with a resolute swing.");
            user.dmgAttack(opponent, atk);
        }



    }
    
}
