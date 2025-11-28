package world.item.wpn;

import entity.Entity;
import entity.player.Challenger;

public class SanctifierHammer extends Weapon {
    public SanctifierHammer(){
        super("Sanctifier Hammer", "A holy hammer imbued with divine power, crushing evil with every strike.", "cutscene_FirstTimeEquip_SanctifierHammer", 100);
    }

        @Override
        public void basicAttack(Challenger user, Entity opponent, int atk) {

            System.out.println("| A holy blow descends with heavy impact, radiating purifying light.");
            int dmg = atk * 3;
            user.dmgAttack(opponent, dmg);
            if(Math.random() < 0.3){
                System.out.println("| Some damage bounced back in exchange for the heavy attack!");
                user.dmgAttack(user, (int)(dmg * Math.random()));
            }
            else{
                System.out.println("| Blow delivered safely.");
            }
        }
}