package world.item.wpn;

import entity.Entity;
import entity.player.Challenger;

public class GalacticSeverance extends Weapon {
    public GalacticSeverance(){
        super("Galactic Severance", "A powerful sword that radiates cosmic power, stuck in stone, it seems to be once wielded by a powerful challenger.", "cutscene_FirstTimeEquip_GalacticSeverance", 40);
    }

    @Override
    public void basicAttack(Challenger user, Entity opponent, int atk) {
        System.out.println("| A swing from the sword slices through reality.");
        
      //Passive Effect: If opponent is an Echo class entity, deal extra damage
        if(opponent instanceof entity.tower_entity.Echo){
            int extraDamage = atk * 5; // 50% extra damage
            System.out.println("| The Galactic Severance glows brightly against " + opponent.getName() + ", dealing an extra " + extraDamage + " damage!");
            user.dmgAttack(opponent, atk + extraDamage);
        } else {
            user.dmgAttack(opponent, atk);
            
        }
    }
}