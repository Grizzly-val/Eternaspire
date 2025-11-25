package entity.tower_entity.remnants;

import entity.Entity;
import entity.tower_entity.Remnant;
import mechanics.battleMechanics.skill.active_skills.tower_entity.HydroJet;
import mechanics.battleMechanics.skill.passive_skills.tower_entity.LiquidBody;

public class Drowner extends Remnant {

    private final static int BASE_HP = 75;
    private final static int BASE_ATK = 18;
    
    public Drowner(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "Drowner",
        "Rotting, bloated reflections of the party members that swim under the ice floor.",
        "The Drowner dissolves into dark, briny water.",
        new HydroJet(),
        new LiquidBody());
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| " + this.getName() + " strikes with a water-logged fist.");
        dmgAttack(opponent, atk);
    }
}
