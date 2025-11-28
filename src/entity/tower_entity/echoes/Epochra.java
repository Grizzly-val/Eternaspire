package entity.tower_entity.echoes;

import entity.Entity;
import entity.tower_entity.Echo;
import mechanics.battleMechanics.skill.active_skills.BashReturn;
import mechanics.battleMechanics.skill.active_skills.EclipseSmite;
import mechanics.battleMechanics.skill.passive_skills.TemporalJitter; 

public class Epochra extends Echo {

    private static final int BASE_HP = 90;
    private static final int BASE_ATK = 30;

    public Epochra(int lvl) {

        super(BASE_HP, BASE_ATK, 55,
        "Epochra, Keeper of Eternity",
        "Once a powerful conqueror of worlds now bound to the tower as its caretaker, It gives off aura you've never felt before.",
        "Epochra falls to its knees, changing back into the form it took when it was your companion.",
        "cutscene_Defeat_Epochra");

        this.giveSkill(new TemporalJitter());
        this.giveSkill(new EclipseSmite());  
        this.giveSkill(new BashReturn()); 

    }

    @Override
    public void basicAttack(Entity opponent){
        System.out.println("| " + this.getName() + " summons temporal energy to strike at " + opponent.getName() + ", distorting time around the impact.");
        dmgAttack(opponent, atk);
    }
    
}