package entity;

import entity.player.Challenger;
import entity.tower_entity.TowerEntity;

public abstract class Entity {

    private String name;
    private String description;
    private String story;
    protected int lvl;
    protected int hp;
    protected int atk;

    public Entity(String name, String description, String story, int lvl, int hp, int atk){
        this.lvl = lvl;
        this.name = name;
        this.description = description;
        this.story = story;
        this.hp = hp;
        this.atk = atk;
    }

    public int getLvl(){return lvl;}
    public int getHp(){return hp;}
    public int getAtk(){return atk;}

    public String getName(){return name;}
    public String getDescription(){return description;}
    public String getStory(){return story;}

    public abstract void basicAttack(Entity opponent);
    public abstract void usePassiveSkill();
    public abstract void useActiveSkill();
    

    public void heal(int healthpts){
        hp += healthpts;
    }

    public void takeDamage(int damageTaken) {
        this.hp -= damageTaken;
        System.out.println(name + " took " + damageTaken + " damage! (HP: " + hp + ")");

        if (hp <= 0) {
            hp = 0; // avoid negative values
            System.out.println(name + " has fallen!");

            if (this instanceof Challenger) {
                System.out.println("Game Over — the Challenger has died.");
                this.defeated(); // call a game-ending method
            } 
            else if (this instanceof TowerEntity) {
                System.out.println(name + " was defeated!");
                this.defeated(); // optional — handle drops, exp, etc.
            }
        }
    }
    public abstract void defeated();



    public void dmgAttack(Entity attackReceiver, int damage) {
        damage = (int)((Math.random() * 11) + (damage - 5));
        System.out.println(name + " hits " + attackReceiver.getName() + " for " + damage + " damage!");
        attackReceiver.takeDamage(damage);
    }

    

}
