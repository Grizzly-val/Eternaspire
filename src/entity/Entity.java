package entity;

import entity.player.Challenger;
import entity.tower_entity.TowerEntity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.Skill;

public abstract class Entity {

    private String name;
    private String description;
    private String story;
    protected int lvl;
    protected int hp;
    protected int atk;
    protected int maxHp;
    private int lastDamage = 0;

    public Entity(String name, String description, String story, int lvl, int hp, int maxHp, int atk){
        this.lvl = lvl;
        this.name = name;
        this.description = description;
        this.story = story;
        this.hp = hp;
        this.maxHp = maxHp;
        this.atk = atk;
    }

    public int getLvl(){return lvl;}
    public int getHp(){return hp;}
    public int getAtk(){return atk;}
    public int getMaxHp(){return maxHp;}

    public String getName(){return name;}
    public String getDescription(){return description;}
    public String getStory(){return story;}

    public abstract void basicAttack(Entity opponent);
    public abstract void usePassiveSkill(Battle battle);
    public abstract void useActiveSkill(Battle battle);
    

    public abstract void defeated(Battle battle);


    public void heal(int healthpts){
        if(hp + healthpts >= maxHp){
            hp = maxHp;
        }
        else hp += healthpts;
    }

    public boolean isAlive(){
        if(hp > 0) return true;
        else return false;
    }

    public void takeDamage(int damageTaken) {
        this.hp -= damageTaken;
        lastDamage = damageTaken;
        System.out.println("| " + name + " took " + damageTaken + " damage! (HP: " + hp + ")");

    }
    public void resetLastDamage(){lastDamage = 0;}
    


    public void dmgAttack(Entity attackReceiver, int damage) {
        damage = (int)((Math.random() * 11) + (damage - 5));
        System.out.println("| " + name + " hits " + attackReceiver.getName() + " for " + damage + " damage!");
        attackReceiver.takeDamage(damage);
    }

    

}
