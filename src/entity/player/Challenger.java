package entity.player;


import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.HashSet;

import engine.Game;
import engine.GameResult;
import entity.Entity;
import mechanics.battleMechanics.battle.Battle;
import mechanics.battleMechanics.skill.ActiveSkill;
import mechanics.battleMechanics.skill.PassiveSkill;
import mechanics.battleMechanics.skill.Skill;
import mechanics.inventory.PlayerInventory;
import mechanics.pstate.AreaNavigationState;
import mechanics.pstate.FloorNavigationState;
import ui.AudioPlayer;
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


    public Challenger(String name, String description, String job, int maxHp, int atk){
        super(name, description, 1, maxHp, maxHp, atk);
        this.job = job;
        this.skillPts = 5;
        this.maxSkillPts = 5;
        this.xp = 0;
        this.maxXp = 100;

        this.baseHp = hp;
        this.baseAtk = atk;



        System.out.println();
        System.out.println();
        TextTyper.typeText("Hello, ", 20, false);
        TextTyper.typeText(" Challenger!", 35, true);
        System.out.println();
        TextTyper.typeText("Hmm...", 26, false);
        TextTyper.typeText(" A " + job, 35, false);
        TextTyper.typeText(" ...", 40, true);
        System.out.println();
        TextTyper.typeText("I wonder if you'll meet the same fate as them?", 50, true);
        System.out.println();
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
            TextTyper.typeText("| Unequipped " + equippedWeapon.getName(), 40, true);
            equippedWeapon = null;
        }
    }

    public void dropItem(Area playerArea, Item item){
        TextTyper.typeText("| Dropped " + item.getName() + " at " + playerArea.getName(), 40, true);
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
        TextTyper.typeText("웃 Challenger Data:", 60, true);
        System.out.println("Name: " + getName());
        System.out.println("> " + getDescription());
        System.out.println("HP: " + getHp());
        System.out.println("ATK: " + getAtk());
        System.out.println("LVL: " + getLvl());
        TextTyper.typeText("-------------------", 60, true);
    }

    private void levelUp(){
        this.lvl += 1;
        Format.boxify("You have leveled up! " + (this.lvl - 1) + " -> " + this.lvl);
        maxXp += (int)(86 + ((float)Math.sqrt(lvl * lvl) * Math.log(lvl + 10)));
        System.out.println("---------------------------------------------------------");
        System.out.println("| +1 Max Skill Point");   
        System.out.print("| Max Skill Points: " + maxSkillPts + " -> ");
        maxSkillPts += 1;
        System.out.println(maxSkillPts);
        OptionSelect.waiter();
        System.out.println();


        System.out.println("---------------------------------------------------------");
        System.out.print("| MAX HP: " + maxHp + " -> ");
        maxHp = (int)(maxHp + ((Math.sqrt(lvl) * Math.log(maxHp * lvl * baseHp))));
        System.out.println(maxHp);
        OptionSelect.waiter();
        System.out.println();

        System.out.println("---------------------------------------------------------");

        System.out.print("| ATK: " + atk + " -> ");
        atk = (int)(atk + Math.sqrt(lvl) + 2);
        System.out.println(atk);
        OptionSelect.waiter();
        System.out.println();

        System.out.println("---------------------------------------------------------");
        System.out.println("| HP replenished");
        hp = maxHp;
        System.out.println("| HP: " + hp);
        OptionSelect.waiter();
        System.out.println();

        System.out.println("---------------------------------------------------------");
        System.out.println("| Skill Points replenished");
        skillPts = maxSkillPts;
        System.out.println("| SP: " + skillPts);
        System.out.println("---------------------------------------------------------");
        OptionSelect.waiter();
        System.out.println();
        
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
            System.out.println("----------------");
            System.out.println("| No next floor|");
            AudioPlayer.playOverlay("unavailable.wav");
            return;
        }

        if(getNextFloor() != null){
            if(getNextFloor().isLocked()){
                System.out.println("| " + getNextFloor().getName() + " is locked");
                Key key = inventory.getKey();
                System.out.println("------------------------------------------------------------");
                if(key != null){
                    System.out.println("------------------------------------------------------------");
                    key.consume(this, getNextFloor());
                    System.out.println("------------------------------------------------------------");
                }
                else{
                    System.out.println("| You do not have any key.\n| Try to explore the available floors first to find the key.\n");
                    AudioPlayer.playOverlay("unavailable.wav");
                    System.out.println("------------------------------------------------------------");
                    OptionSelect.waiter();
                }

                return;
            }
            currentFloorNumber += 1;
            System.out.println("------------------------------");
            System.out.println("| Ascended to the next floor\n| (Floor " + getPrevFloor().getNumber() + " -> Floor " + getCurrentFloor().getNumber() + ")");
            System.out.println("------------------------------");
            
            return;
        }
    
    }

    public void goDown(){
        if(getPrevFloor() == null){
            System.out.println("--------------------");
            System.out.println("| No previous floor|");
            AudioPlayer.playOverlay("unavailable.wav");
            return;
        }

        if(getPrevFloor() != null){
            currentFloorNumber -= 1;
            System.out.println("----------------------------------");
            System.out.println("| Descended to the previous floor\n| (Floor " + getNextFloor().getNumber() + " -> Floor " + getCurrentFloor().getNumber() + ")");
            System.out.println("----------------------------------");
        }
    }

    public void moveArea(int newAreaIndex){
        System.out.println();
        currentAreaIndex = newAreaIndex;
    }


    public void play(){
        AudioPlayer.play("in_game.wav");
        new FloorNavigationState().enterState(this, new AreaNavigationState());
    }
    
    @Override
    public void defeated(Challenger player, Battle battle){
        if(!player.isAlive()){
            AudioPlayer.playOverlay("battle_lose.wav");
            AudioPlayer.play("in_menu.wav");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            TextTyper.typeText("| You have fallen.", 100, true);
            TextTyper.typeText("| Name : " + player.getName(), 50, true);
            TextTyper.typeText("| Job  : " + player.getJob(), 50, true);
            TextTyper.typeText("| LVL  : " + player.getLvl(), 50, true);
            System.out.println();
            TextTyper.typeText("| Active Skills : " + player.activeSkillSet.size() + "  | Passive Skills : " + player.passiveSkillSet.size(), 80, true);
            System.out.println();
            TextTyper.typeText("-----------------------\n|- G A M E  O V E R -|\n-----------------------", 80, true);
            OptionSelect.waiter();
            gameManager.deleteData();
            gameManager.gameOver(GameResult.LOSE);

        }
    }

    public void gameComplete(){
            AudioPlayer.play("game_win.wav");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            TextTyper.typeText("...", 80, true);
            System.out.println("=======================================================================");
            TextTyper.typeText("Eternaspire Cleared!!", 100, true);
            TextTyper.typeText("| Name : " + getName(), 50, true);
            TextTyper.typeText("| Job  : " + getJob(), 50, true);
            TextTyper.typeText("| LVL  : " + getLvl(), 50, true);
            TextTyper.typeText("| Active Skills : " + activeSkillSet.size() + "  | Passive Skills : " + passiveSkillSet.size(), 80, true);
            System.out.println("======================================================================");
            System.out.println();
            TextTyper.typeText("-----------------------\n|- G A M E  O V E R -|\n-----------------------", 80, true);
            OptionSelect.waiter();
            gameManager.deleteData();
            gameManager.gameOver(GameResult.WIN);
            
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
