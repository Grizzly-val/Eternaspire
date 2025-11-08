package entity.tower_entity;

import mechanics.battleMechanics.skill.ActiveSkill;
import mechanics.battleMechanics.skill.PassiveSkill;

public abstract class Remnant extends TowerEntity{

    private ActiveSkill aSkill = null;
    private PassiveSkill pSkill = null;
    
    public Remnant(int hp, int atk, int lvl, String name, String description, String story, ActiveSkill aSkill, PassiveSkill pSkill){
        super(name, description, story,  lvl, hp, atk);
        this.aSkill = aSkill;
        this.pSkill = pSkill;
    }

    @Override
    public void usePassiveSkill(){
        if(pSkill != null){
            System.out.println(this.getName() + " used " + pSkill.getName());
            pSkill.autoActivate(this);
        }
    }

    @Override
    public void useActiveSkill(){
        if(aSkill != null){
            System.out.println(this.getName() + " used " + aSkill.getName());
            if(Math.random() < 0.4) { aSkill.activate(this); }
        }
    }
    

}
