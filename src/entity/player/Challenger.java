package entity.player;

import java.util.ArrayList;

import entity.Entity;
import mechanics.battleMechanics.skill.ActiveSkill;
import mechanics.battleMechanics.skill.PassiveSkill;
import mechanics.battleMechanics.skill.Skill;
import mechanics.inventory.PlayerInventory;
import mechanics.pstate.AreaNavigationState;
import mechanics.pstate.FloorNavigationState;
import mechanics.pstate.IdleAreaState;
import mechanics.pstate.PlayerState;
import ui.Format;
import ui.OptionSelect;
import world.item.Item;
import world.item.consumables.Key;
import world.item.wpn.Weapon;
import world.location.Area;
import world.location.Floor;
import world.location.locationData.FloorData;

public abstract class Challenger extends Entity{
    
    private final PlayerState floorNavigationState = new FloorNavigationState();
    private final PlayerState areaNavigationState = new AreaNavigationState();
    private final PlayerState idleAreaState = new IdleAreaState();

    public PlayerState getFloorNavState(){return floorNavigationState;}
    public PlayerState getAreaNavState(){return areaNavigationState;}
    public PlayerState getIdleAreaState(){return idleAreaState;}

    private PlayerState currentState = floorNavigationState;

    private Floor currentFloor = FloorData.getFloor(0);
    private Area currentArea = FloorData.getFloor(0).getFloorArea(1);

    private ArrayList<ActiveSkill> activeSkillSet = new ArrayList<>();
    private ArrayList<PassiveSkill> passiveSkillSet = new ArrayList <>();
    private Weapon equippedWeapon = null;

    private PlayerInventory inventory = new PlayerInventory(this.getName() + "'s Inventory");

    private String job;
    private int skillPts = 0;
    private int xp = 0;
    private int maxXp = 100;
    private int maxHp;  

    public Challenger(String name, String description, String story, String job, int hp, int maxHp, int atk, Weapon equippedWeapon){
        super(name, description, story, 1, hp, atk);
        this.maxHp = maxHp;
        this.job = job;
        this.equippedWeapon = equippedWeapon;

        System.out.println("Hello, Challenger!");
        System.out.println("Hmm... A " + job + "...");
        System.out.println("I wonder if you'll meet the same fate as them?");

        System.out.println();
        displayData();
    }

    public Weapon getEquippedWeapon(){return equippedWeapon;}
    public Floor getCurrentFloor(){return currentFloor;}
    public Area getCurrentArea(){return currentArea;}
    public PlayerInventory getInventory(){return inventory;}

    public void dropItem(PlayerInventory destinationInventory, Item item){
        System.out.println("Dropped " + item.getName());
        inventory.remove(item);
    }

    public void storeItem(Item item){
        inventory.add(item);
        System.out.println(item.getName() + " stored in " + this.inventory.getName());
    }

    public void learnSkill(Skill newSkill){
        if(newSkill instanceof PassiveSkill){
            passiveSkillSet.add((PassiveSkill) newSkill);
        }
        else if(newSkill instanceof ActiveSkill){
            activeSkillSet.add((ActiveSkill) newSkill);
        }

    }

    public void displayData(){
        System.out.println("웃 Challenger Data:");
        System.out.println("Name: " + getName());
        System.out.println("> " + getDescription());
        System.out.println("> " + getStory());
        System.out.println("HP: " + getHp());
        System.out.println("ATK: " + getAtk());
        System.out.println("LVL: " + getLvl());
    }

    private void levelUp(){
        System.out.println("You have leveled up!");
        this.lvl += 1;
        System.out.println(this.lvl - 1 + " -> " + this.lvl);

        maxXp += (int)(maxXp * 0.27);

        System.out.println("2 Skill points Acuired");
        System.out.println("Skill Points: " + skillPts + " -> ");
        skillPts += 2;
        System.out.println(skillPts);

        System.out.print("MAX HP: " + maxHp + " -> ");
        maxHp += (int)(maxHp * 0.17);
        System.out.println(maxHp);

        System.out.print("ATK: " + atk + " -> ");
        atk += (int)(atk * 0.11);
        System.out.println(atk);

        System.out.println("HP replenished");
        hp = maxHp;
        System.out.println("HP: " + hp);
    }

    public void gainXp(int xpGained){
        xp += xpGained;
        while(xp >= maxXp){
            xp -= maxXp;
            levelUp();
        }
    }

    @Override
    public void usePassiveSkill() {
        for(PassiveSkill passiveSkill : passiveSkillSet){
            passiveSkill.autoActivate(this);
        }
    }

    @Override
    public void useActiveSkill() {
        if(!activeSkillSet.isEmpty()){
            for(int i = 0; i < activeSkillSet.size(); i++){
                System.out.println(i + 1 + " - " + activeSkillSet.get(i).getName() + " [" + activeSkillSet.get(i).getPtUse() + "pt/s]");
            }

            System.out.print("Pick a skill: ");
            int choice = -1;
            choice = OptionSelect.intInput(choice);
            ActiveSkill chosenSkill = activeSkillSet.get(choice);
            if(chosenSkill != null){
                if(skillPts - chosenSkill.getPtUse() >= 0){
                    System.out.println("Used " + chosenSkill.getName() + "-" + chosenSkill.getPtUse());
                    System.out.print("Skill point/s: " + skillPts + " -> " + (skillPts - chosenSkill.getPtUse()));
                    skillPts -= chosenSkill.getPtUse();
                    chosenSkill.activate(this);
                }

                else{
                    System.out.println("You do not have enough Skill Points!");
                    System.out.println(chosenSkill.getName() + "[" + chosenSkill.getPtUse() + "]");
                    System.out.println("Your Skill Point/s: " + skillPts);
                }
                
            }
            else System.out.println("Invalid skill choice!");
        }
        
        else System.out.println("No skill in skill set!");

    }

    @Override
    public void heal(int healthpts){
        if(hp + healthpts >= maxHp){
            hp = maxHp;
        }
        else hp += healthpts;
    }

    public void goUp(){
        if(getCurrentFloor().getNextFloor().isLocked()){
            System.out.println(getCurrentFloor().getNextFloor().getName() + " is locked");
            Key key = inventory.getKey();
            if(key != null) key.consume(this, getCurrentFloor().getNextFloor());
            else System.out.println("Try to explore the " + Format.getOrdinal(getCurrentFloor().getNumber()) + " first to find the key.");
        }

        else if(currentFloor.getNextFloor() != null){
            currentFloor = currentFloor.getNextFloor();
            System.out.println("Ascended to the next floor\n(Floor " + currentFloor.getPrevFloor().getNumber() + " -> Floor " + currentFloor.getNumber() + ")");
        }
        else System.out.println("No next floor");
    }

    public void goDown(){
        if(currentFloor.getPrevFloor() != null){
            currentFloor = currentFloor.getPrevFloor();
            System.out.println("Descended to the previous floor\n(Floor " + currentFloor.getNextFloor().getNumber() + " -> Floor " + currentFloor.getNumber() + ")");
        }
        else System.out.println("No previous floor");
    }

    public void moveArea(Area newArea){
        currentArea = newArea;
    }
    public void setState(PlayerState state){
        this.currentState = state;
        play();
    }

    public void play(){
        currentState.enterState(this);
    }


    
    @Override
    public void defeated(){

    }

}
