package entity.tower_entity.echoes;

import entity.Entity;
import entity.tower_entity.Echo;
import mechanics.battleMechanics.skill.challenger.active_skills.EclipseSmite;

public class FallenPaladin extends Echo {

    private final static int BASE_HP = 68; 
    private final static int BASE_ATK = 15;

    public FallenPaladin(int lvl) {
        super(BASE_HP, 
              BASE_ATK, 
              lvl, 
              "Fallen Paladin", 
              "Once a beacon of hope who sought to cleanse the tower. Now, his armor is fused to his skin, and his prayers are screamed into the abyss.", 
              "The Fallen Paladin drops to one knee, his corrupted hammer slipping from his grasp. 'The light... was it ever real?'", 
              "cutscene_Defeat_FallenPaladin"); 
              this.giveSkill(new EclipseSmite());

    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| " + this.getName() + " swings his heavy maul with zealous fury.");
        dmgAttack(opponent, atk);
    }
}
