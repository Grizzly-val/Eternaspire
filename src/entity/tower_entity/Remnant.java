package entity.tower_entity;


import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;
import mechanics.battleMechanics.skill.PassiveSkill;

public abstract class Remnant extends TowerEntity{

    private ActiveSkill aSkill;
    private PassiveSkill pSkill;
    
    public Remnant(int hp, int maxHp, int atk, int lvl, String name, String description, String defeatMessage, ActiveSkill aSkill, PassiveSkill pSkill){
        super(name, description, lvl, hp, maxHp, atk, defeatMessage);
        this.aSkill = aSkill;
        this.pSkill = pSkill;
    }

    @Override
    public void usePassiveSkill(Entity opponent, Battle battle){
        if(pSkill != null){
            System.out.println("| " + this.getName() + " used " + pSkill.getName() + " (Passive Skill)");
            pSkill.autoActivate(this, opponent, battle);
        }
    }

    @Override
    public void useActiveSkill(Entity opponent, Battle battle){
        if(aSkill != null){
            if(Math.random() < 0.4) { 
                System.out.println("| " + this.getName() + " used " + aSkill.getName() + " (Active Skill)");
                aSkill.activate(this, opponent, battle);
                return;
            }
        }
        basicAttack(battle.getChallenger());
    }
    

}
