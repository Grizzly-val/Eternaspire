package entity.tower_entity;

import entity.Entity;

public abstract class TowerEntity extends Entity{
    
    public TowerEntity(String name, String description, String story, int lvl, int hp, int atk){
        super(name, description, story, lvl, hp, atk);
    }

    @Override
    public void defeated(){
        
    }

}
