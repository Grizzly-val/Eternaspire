package entity.tower_entity;

import java.util.ArrayList;

import mechanics.battleMechanics.skill.ActiveSkill;
import mechanics.battleMechanics.skill.PassiveSkill;

public abstract class Echo extends TowerEntity {

    private ArrayList<ActiveSkill> aSkillSet = new ArrayList<>();
    private ArrayList<PassiveSkill> pSkillSet = new ArrayList<>();

    public Echo(int hp, int atk, int lvl, String name, String description, String story){
        super(name, description, story,  lvl, hp, atk);
    }

    @Override
    public void usePassiveSkill(){
        for(ActiveSkill aSkill : aSkillSet){
            if(aSkill != null){
                System.out.println(this.getName() + " used " + aSkill.getName() + " (Active Skill)");
                if(Math.random() < 0.4) {
                    aSkill.activate(this);
                    return;
                }
            }
        }
    }
    
    @Override
    public void useActiveSkill(){
        for(PassiveSkill pSkill : pSkillSet){
            if(pSkill != null){
                System.out.println(this.getName() + " used " + pSkill.getName() + " (Passive Skill)");
                pSkill.autoActivate(this);
            }
        }
    }


}
