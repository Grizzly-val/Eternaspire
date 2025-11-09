package entity.tower_entity.echoes;

import entity.Entity;
import entity.tower_entity.Echo;
import mechanics.battleMechanics.battle.Battle;

public class LostVanguard extends Echo {

    public LostVanguard() {
        super(200, 200, 45, 34, "Lost Vanguard", "write description here", "write story here");
    }

    @Override
    public void basicAttack(Entity opponent){
        System.out.println("| " + this.getName() + " charges at you with Shield Bash");
        dmgAttack(opponent, atk);
    }

    @Override
    public void defeated(Battle battle){
        System.out.println("| " + getName() + " has been defeated.");
        System.out.println("| It bends at the knees, finally yielding to the surface beneath.");
        battle.getChallenger().resetLastDamage();
        battle.getChallenger().gainXp((int)(lvl * (1.00 + Math.random())));
    }


    
}
