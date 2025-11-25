package entity.tower_entity.echoes;

import entity.Entity;
import entity.tower_entity.Echo;
import mechanics.battleMechanics.skill.active_skills.tower_entity.AbyssalSwallow;
import mechanics.battleMechanics.skill.passive_skills.tower_entity.BioluminescentTrap;

public class TheAngler extends Echo {

    private final static int BASE_HP = 50;
    private final static int BASE_ATK = 21;
    
    public TheAngler(int lvl) {
        super(BASE_HP, 
        BASE_ATK, 
        lvl,
        "The Angler",
        "A colossal invisible leviathan using a crying angel as a lure.",
        "The massive beast surfaces and dies, sinking back into the abyss.",
        "cutscene_Defeat_TheAngler");
        
        giveSkill(new AbyssalSwallow());
        giveSkill(new BioluminescentTrap());
    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| " + this.getName() + " bites with invisible jaws.");
        dmgAttack(opponent, atk);
    }
}