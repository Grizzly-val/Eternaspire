package entity.tower_entity;

import java.util.ArrayList;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;
import mechanics.battleMechanics.skill.PassiveSkill;
import mechanics.battleMechanics.skill.Skill;

public abstract class Echo extends TowerEntity{

    private ArrayList<ActiveSkill> aSkillSet = new ArrayList<>();
    private ArrayList<PassiveSkill> pSkillSet = new ArrayList<>();

    private String cutsceneID;

    public Echo(int BASE_HP, int BASE_ATK, int lvl, String name, String description, String defeatMessage, String cutsceneID){
        super(name, description, lvl, 
            
            (int)((BASE_HP + (int)((float)lvl * lvl * 0.28)) * 1.98), 

            (int)((BASE_HP + (int)((float)lvl * lvl * 0.28)) * 1.98), 
            
            (int)(((BASE_ATK + (int)((float)lvl * 0.1982524))) * Math.log(lvl + 5)),
                        
            
            defeatMessage);



        this.cutsceneID = cutsceneID;
    }

    public String getCutsceneID(){return cutsceneID;}

    public void giveSkill(Skill skill){
        if(skill instanceof ActiveSkill) aSkillSet.add((ActiveSkill) skill);
        if(skill instanceof PassiveSkill) pSkillSet.add((PassiveSkill) skill);
    }

    @Override
    public void useActiveSkill(Entity opponent, Battle battle){
        for(ActiveSkill aSkill : aSkillSet){
            if(aSkill != null){
                if(Math.random() < 0.4) {
                    System.out.println("| " + this.getName() + " used " + aSkill.getName() + " (Active Skill)");
                    aSkill.activate(this, opponent, battle);
                    return;
                }
            }
        }
        basicAttack(battle.getChallenger());
    }
    
    @Override
    public void usePassiveSkill(Entity opponent, Battle battle){
        for(PassiveSkill pSkill : pSkillSet){
            
            if(pSkill != null){
                pSkill.autoActivate(this, opponent, battle);
            }
        }
    }


}
