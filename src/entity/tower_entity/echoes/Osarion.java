package entity.tower_entity.echoes;

import entity.Entity;
import entity.tower_entity.Echo;
import mechanics.battleMechanics.skill.active_skills.SovereignsGrip;
import mechanics.battleMechanics.skill.passive_skills.PharaohsAura;
import mechanics.battleMechanics.skill.passive_skills.RecoveryProtocol;


public class Osarion extends Echo {

    private static final int BASE_HP = 62;
    private static final int BASE_ATK = 11;

    public Osarion(int lvl) {
        super(BASE_HP, BASE_ATK, lvl,
        "Osarion, The Tyrannical Pharaoh",
        "A tyrant who sacrificed his people to achieve immortality, now imprisoned in the tower eternally.",
        "The tyrannical pharaoh falls to his knees, giving his tortured subjects peace at last.",
        "cutscene_Defeat_Osarion");

        
        this.giveSkill(new RecoveryProtocol()); //passive
        this.giveSkill(new PharaohsAura()); //passive
        this.giveSkill(new SovereignsGrip()); // active

    }
    

    @Override
    public void basicAttack(Entity opponent){
        System.out.println("| " + this.getName() + " conjures a blast of cursed sand.");
        dmgAttack(opponent, atk);
    }


    
}