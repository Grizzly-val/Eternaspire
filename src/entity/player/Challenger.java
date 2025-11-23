package entity.player;


import java.util.ArrayList;
import java.util.HashSet;

import engine.Game;
import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;
import mechanics.battleMechanics.skill.PassiveSkill;
import mechanics.battleMechanics.skill.Skill;
import mechanics.inventory.PlayerInventory;
import mechanics.pstate.AreaNavigationState;
import ui.Format;
import ui.OptionSelect;
import ui.TextTyper;
import world.item.Item;
import world.item.consumables.Key;
import world.item.wpn.Weapon;
import world.location.Area;
import world.location.Floor;

public abstract class Challenger extends Entity{
    
    private final HashSet<String> ENCOUNTERED_ENTITIES = new HashSet<>();
    public HashSet<String> getEncountered_Entities(){return ENCOUNTERED_ENTITIES;}
    private final HashSet<String> WEAPONS_TRIED = new HashSet<>();
    public HashSet<String> getWeapons_Tried(){return WEAPONS_TRIED;}

    private int currentFloorNumber = 0;
    private int currentAreaIndex = 1;

    private ArrayList<ActiveSkill> activeSkillSet = new ArrayList<>();
    private ArrayList<PassiveSkill> passiveSkillSet = new ArrayList <>();
    private Weapon equippedWeapon = null;

    private PlayerInventory inventory = new PlayerInventory(this.getName() + "'s Inventory");

    private String job;
    private int skillPts;
    private int maxSkillPts;
    private int xp;
    private int maxXp;

    private int baseHp;
    private int baseAtk;

    private transient Game gameManager;


    public Challenger(String name, String description, String job, int hp, int maxHp, int atk){
        super(name, description, 1, hp, maxHp, atk);
        this.job = job;
        this.skillPts = 5;
        this.maxSkillPts = 5;
        this.xp = 0;
        this.maxXp = 100;

        this.baseHp = hp;
        this.baseAtk = atk;

        System.out.println("Hello, Challenger!");
        System.out.println("Hmm... A " + job + "...");
        System.out.println("I wonder if you'll meet the same fate as them?");

        System.out.println();
        displayData();
    }

    public void setGameManager(Game game){this.gameManager = game;}

    public String getJob(){return job;}
    public Weapon getEquippedWeapon(){return equippedWeapon;}
    public Floor getCurrentFloor(){return gameManager.getFloorData().getFloor(currentFloorNumber);}
    public Area getCurrentArea(){return getCurrentFloor().getFloorArea(currentAreaIndex);}
    public PlayerInventory getInventory(){return inventory;}
    public int getSkillPts(){return skillPts;}
    public int getXp(){return xp;}
    public int getMaxXp(){return maxXp;}
    public ArrayList<ActiveSkill> getActiveSkillSet(){return activeSkillSet;}
    public ArrayList<PassiveSkill> getPassiveSkillSet(){return passiveSkillSet;}

    public void equipWeapon(Weapon wpn){
        equippedWeapon = wpn;
        if(wpn != null){
            inventory.remove(wpn);
        }
    }

    public void unequipWeapon(){
        if(equippedWeapon != null){
            inventory.addItem(equippedWeapon);
            System.out.println("| Unequipped " + equippedWeapon.getName());
            equippedWeapon = null;
        }
    }

    public void dropItem(Area playerArea, Item item){
        System.out.println("| Dropped " + item.getName() + " at " + playerArea.getName());
        inventory.remove(item);
        playerArea.getAreaInventories().get(0).addItem(item);
    }

    public void addSkillPoint(int sp){
        System.out.println("| Acquired " + sp + " Skill Point/s!");
        if(skillPts + sp > maxSkillPts){
            skillPts = maxSkillPts;
            System.out.println("| Skill Point Limit Reached");
        }
        
        else skillPts += sp;
        System.out.println("| Skill Point/s : " + skillPts + "/" + maxSkillPts);
    }

    public void storeItem(Item item){
        System.out.println("| " + item.getName() + " stored in " + this.inventory.getName());
        inventory.addItem(item);
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
        System.out.println("HP: " + getHp());
        System.out.println("ATK: " + getAtk());
        System.out.println("LVL: " + getLvl());
    }

    private void levelUp(){
        this.lvl += 1;
        Format.boxify("You have leveled up! " + (this.lvl - 1) + " -> " + this.lvl);
        maxXp += (int)(100 * ((float)lvl * 0.188392));
        System.out.println("---------------------------------------------------------");
        System.out.println("| +1 Max Skill Point");   
        System.out.print("| Max Skill Points: " + maxSkillPts + " -> ");
        maxSkillPts += 1;
        System.out.println(maxSkillPts);
        System.out.println("---------------------------------------------------------");
        System.out.print("| MAX HP: " + maxHp + " -> ");
        maxHp = (int)(maxHp + ((Math.sqrt(lvl) * Math.log(maxHp * lvl * baseHp))));
        System.out.println(maxHp);
        System.out.println("---------------------------------------------------------");

        System.out.print("| ATK: " + atk + " -> ");
        atk = (int)(atk + ((Math.sqrt(lvl * 2) + Math.log(atk * lvl * baseAtk))));
        System.out.println(atk);
        System.out.println("---------------------------------------------------------");
        System.out.println("| HP replenished");
        hp = maxHp;
        System.out.println("| HP: " + hp);
        System.out.println("---------------------------------------------------------");
        System.out.println("| Skill Points replenished");
        skillPts = maxSkillPts;
        System.out.println("| SP: " + skillPts);
        System.out.println("---------------------------------------------------------");
        
    }

    public void gainXp(int xpGained){

        Format.boxify("You gained " + xpGained + " xp!");

        System.out.print("| xp: " + xp + " -> ");
        xp += xpGained;
        System.out.println(xp + "");
        System.out.println("----------------");
        
        while(xp >= maxXp){
            xp -= maxXp;
            levelUp();
        }
    }

    @Override
    public void usePassiveSkill(Entity opponent, Battle battle) {
        for(PassiveSkill passiveSkill : passiveSkillSet){
            passiveSkill.autoActivate(this, opponent, battle);
        }
    }

    @Override
    public void useActiveSkill(Entity opponent, Battle battle) {
        if(!activeSkillSet.isEmpty()){
            for(int i = 0; i < activeSkillSet.size(); i++){
                System.out.println(i + 1 + " - " + activeSkillSet.get(i).getName() + " [" + activeSkillSet.get(i).getPtUse() + "pt/s]");
            }
            System.out.println("-----------------------------------------------------------");
            System.out.print("| Pick a skill >> ");
            int choice = OptionSelect.getArrIndex(activeSkillSet.size());
            System.out.println("-----------------------------------------------------------");
            ActiveSkill chosenSkill = activeSkillSet.get(choice - 1);
            if(chosenSkill != null){
                if(skillPts - chosenSkill.getPtUse() >= 0){
                    System.out.println("| Used " + chosenSkill.getName() + " [" + chosenSkill.getPtUse() + "]");
                    if(chosenSkill.getPtUse() != 0)
                        System.out.println("| Skill point/s: " + skillPts + " -> " + (skillPts - chosenSkill.getPtUse()));
                    skillPts -= chosenSkill.getPtUse();
                    chosenSkill.activate(this, opponent, battle);
                }

                else{
                    System.out.println("| You do not have enough Skill Points!");
                    System.out.println("| Can't use " + chosenSkill.getName() + " [" + chosenSkill.getPtUse() + "sp]");
                    System.out.println("| Your Skill Point/s: " + skillPts);
                    System.out.println("| Using normal attack instead...");
                    System.out.println();
                    basicAttack(battle.getTowerEntity());
                }
                
            }
            else System.out.println("| Invalid skill choice!");
        }
        
        else{
            System.out.println("| No skill in skill set!");
            System.out.println("| Using basic attack instead.");
            this.basicAttack(battle.getTowerEntity());
            System.out.println("-----------------------------------------------------------");
        }

    }

    public Floor getNextFloor(){
        return gameManager.getFloorData().getFloor(currentFloorNumber + 1);
    }

    public Floor getPrevFloor(){
        return gameManager.getFloorData().getFloor(currentFloorNumber - 1);
    }

    public void goUp(){
        if(getNextFloor() == null){
            System.out.println("| No next floor ");
            return;
        }

        if(getNextFloor() != null){
            if(getNextFloor().isLocked()){
                System.out.println("| " + getNextFloor().getName() + " is locked");
                System.out.println();
                Key key = inventory.getKey();
                System.out.println("------------------------------------------------------------");
                if(key != null){
                    System.out.println("------------------------------------------------------------");
                    key.consume(this, getNextFloor());
                    System.out.println("------------------------------------------------------------");
                }
                else System.out.println("| You do not have any key.\n| Try to explore the " + Format.getOrdinal(getCurrentFloor().getNumber()) + " floor first to find the key.\n");

                return;
            }
            currentFloorNumber += 1;
            System.out.println("| Ascended to the next floor\n| (Floor " + getPrevFloor().getNumber() + " -> Floor " + getCurrentFloor().getNumber() + ")\n");
            return;
        }
    
    }

    public void goDown(){
        if(getPrevFloor() == null){
            System.out.println("| No previous floor");
            return;
        }

        if(getPrevFloor() != null){
            currentFloorNumber -= 1;
            System.out.println("| Descended to the previous floor\n(Floor " + getNextFloor().getNumber() + " -> Floor " + getCurrentFloor().getNumber() + ")\n");
        }
    }

    public void moveArea(int newAreaIndex){
        System.out.println();
        currentAreaIndex = newAreaIndex;
    }


    public void play(){
        new AreaNavigationState().enterState(this);
    }
    
    @Override
    public void defeated(Challenger player, Battle battle){
        if(!player.isAlive()){
            TextTyper.typeText("You have fallen.", 100, true);
            TextTyper.typeText("| " + player.getName(), 50, true);
            TextTyper.typeText("| " + player.getJob(), 50, true);
            TextTyper.typeText("| " + player.getLvl(), 50, true);
            TextTyper.typeText("| Active Skills : " + player.activeSkillSet.size() + "  | Passive Skills : " + player.passiveSkillSet.size(), 80, true);
            TextTyper.typeText("| Deleting game data ...", 70, true);

            gameManager.deleteData();

        }
    }

    @Override
    public void basicAttack(Entity opponent) {
        if(equippedWeapon != null){
            equippedWeapon.basicAttack(this, opponent, atk);
        }
        else{
            System.out.println("| You don't have a weapon equipped");
            System.out.println("| " + this.getName() + " used bare fists");
            this.dmgAttack(opponent, (int)(atk / 2));
        }
    }

    public void saveState(){
        gameManager.saveGame();
    }

}
