package entity.tower_entity.echoes;

import entity.Entity;
import entity.tower_entity.Echo;
import mechanics.battleMechanics.skill.active_skills.BashReturn;
import mechanics.battleMechanics.skill.passive_skills.SorrowfulEcho;
import mechanics.battleMechanics.skill.passive_skills.UndyingDevotion;

public class VoidboundAeliana extends Echo {

    private final static int BASE_HP = 40;
    private final static int BASE_ATK = 15;

    public VoidboundAeliana(int lvl) {
        super(BASE_HP, BASE_ATK, lvl, 
              "Aeliana, The Voidbound", 
              "Once the lover of the Lost Vanguard, she cast herself into the abyss to find him. Now, she is merely a vessel for the void's hunger, weeping black tears.", 
              "Aeliana reaches out with a fading hand, whispering a name that the void swallowed long ago...",
              "cutscene_Defeat_VoidboundAeliana");

              this.giveSkill(new UndyingDevotion());
              this.giveSkill(new SorrowfulEcho()); 
              this.giveSkill(new BashReturn());
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| " + this.getName() + " lashes out with a tendril of pure sorrow.");
        dmgAttack(opponent, atk);
    }
}
