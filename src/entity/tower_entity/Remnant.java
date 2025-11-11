package entity.tower_entity;

import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;
import mechanics.battleMechanics.skill.PassiveSkill;

public abstract class Remnant extends TowerEntity{

    private ActiveSkill aSkill = null;
    private PassiveSkill pSkill = null;
    
    public Remnant(int hp, int maxHp, int atk, int lvl, String name, String description, String defeatMessage, ActiveSkill aSkill, PassiveSkill pSkill){
        super(name, description, lvl, hp, maxHp, atk, defeatMessage);
        this.aSkill = aSkill;
        this.pSkill = pSkill;
    }

    @Override
    public void usePassiveSkill(Battle battle){
        if(pSkill != null){
            pSkill.autoActivate(battle);
        }
    }

    @Override
    public void useActiveSkill(Battle battle){
        if(aSkill != null){
            if(Math.random() < 0.4) { 
                aSkill.activate(battle);
                return;
            }
        }
        basicAttack(battle.getChallenger());
    }
    

}
