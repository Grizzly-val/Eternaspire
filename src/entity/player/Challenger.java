package entity.player;

import java.util.ArrayList;

import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
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
    private int skillPts = 5;
    private int maxSkillPts = 5;
    private int xp = 0;
    private int maxXp = 100;


    public Challenger(String name, String description, String story, String job, int hp, int maxHp, int atk, Weapon equippedWeapon){
        super(name, description, story, 1, hp, maxHp, atk);
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
    public int getSkillPts(){return skillPts;}

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

        System.out.println("+1 Max Skill Point");
        System.out.println("Max Skill Points: " + maxSkillPts + " -> ");
        maxSkillPts += 1;
        System.out.println(maxSkillPts);

        System.out.print("MAX HP: " + maxHp + " -> ");
        maxHp += (int)(maxHp * 0.17);
        System.out.println(maxHp);

        System.out.print("ATK: " + atk + " -> ");
        atk += (int)(atk * 0.11);
        System.out.println(atk);

        System.out.println("HP replenished");
        hp = maxHp;
        System.out.println("HP: " + hp);

        System.out.println("Skill Points replenished");
        skillPts = maxSkillPts;
        System.out.println("SP: " + skillPts);
    }

    public void gainXp(int xpGained){
        System.out.println("\nYou gained " + xpGained + " xp!");
        System.out.print("xp: " + xp + " -> ");
        xp += xpGained;
        System.out.println(xpGained + "\n");
        
        while(xp >= maxXp){
            xp -= maxXp;
            levelUp();
        }
    }

    @Override
    public void usePassiveSkill(Battle battle) {
        for(PassiveSkill passiveSkill : passiveSkillSet){
            passiveSkill.autoActivate(battle);
        }
    }

    @Override
    public void useActiveSkill(Battle battle) {
        if(!activeSkillSet.isEmpty()){
            for(int i = 0; i < activeSkillSet.size(); i++){
                System.out.println(i + 1 + " - " + activeSkillSet.get(i).getName() + " [" + activeSkillSet.get(i).getPtUse() + "pt/s]");
            }

            System.out.print("Pick a skill: ");
            int choice = OptionSelect.getArrIndex(activeSkillSet.size());
            ActiveSkill chosenSkill = activeSkillSet.get(choice - 1);
            if(chosenSkill != null){
                if(skillPts - chosenSkill.getPtUse() >= 0){
                    System.out.println("Used " + chosenSkill.getName() + " - " + chosenSkill.getPtUse());
                    System.out.print("Skill point/s: " + skillPts + " -> " + (skillPts - chosenSkill.getPtUse()));
                    skillPts -= chosenSkill.getPtUse();
                    chosenSkill.activate(battle);
                }

                else{
                    System.out.println("You do not have enough Skill Points!");
                    System.out.println(chosenSkill.getName() + "[" + chosenSkill.getPtUse() + "]");
                    System.out.println("Your Skill Point/s: " + skillPts);
                    System.out.println("Using normal attack instead...");
                    basicAttack(battle.getTowerEntity());
                }
                
            }
            else System.out.println("Invalid skill choice!");
        }
        
        else System.out.println("No skill in skill set!");

    }


    public void goUp(){
        if(getCurrentFloor().getNextFloor().isLocked()){
            System.out.println(getCurrentFloor().getNextFloor().getName() + " is locked");
            Key key = inventory.getKey();
            if(key != null) key.consume(this, getCurrentFloor().getNextFloor());
            else System.out.println("Try to explore the " + Format.getOrdinal(getCurrentFloor().getNumber()) + " floor first to find the key.\n");
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
    public void defeated(Battle battle){
    }

    @Override
    public void basicAttack(Entity opponent) {
        if(equippedWeapon != null){
            System.out.println("| " + this.getName() + " used " + this.getEquippedWeapon().getBasicAtkName() + " with " + this.getEquippedWeapon().getName());
            opponent.takeDamage(getAtk() + this.getEquippedWeapon().getAddAtk());
        }
    }

}
