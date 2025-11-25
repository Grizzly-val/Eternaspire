// Inventory.java
package mechanics.inventory;

import java.util.ArrayList;

import ui.OptionSelect;
import world.item.Item;
import world.item.consumables.Key;
import world.item.consumables.Food;
import world.item.wpn.Weapon;
import world.item.consumables.SkillScroll;

public class PlayerInventory extends Inventory{

    private final int CAPACITY = 75;
    private int occupiedSpace = 0;

    public PlayerInventory(String name){
        super(name);
    }

    private ArrayList<Weapon> wpnInventory = new ArrayList<>();
    private ArrayList<Food> potionInventory = new ArrayList<>();
    private ArrayList<Key> keyInventory = new ArrayList<>();
    private ArrayList<SkillScroll> skillScrollInventory = new ArrayList<>();

    public ArrayList<Weapon> getWpnInventory(){return wpnInventory;}
    public ArrayList<Food> getPotionInventory(){return potionInventory;}
    public ArrayList<Key> getKeyInventory(){return keyInventory;}
    public ArrayList<SkillScroll> getSkillScrollInventory(){return skillScrollInventory;}
    public int getCapacity(){return CAPACITY;}
    public int getOccupiedSpace(){return occupiedSpace;}

    @Override
    public void addItem(Item item){

        if(occupiedSpace + item.getSize() > CAPACITY){
            System.out.println();
            System.out.println("! ! Not enough space in Inventory ! !");
            System.out.println("| Item Size : " + item.getSize() + "    Inventory : " + occupiedSpace + "/" + CAPACITY + "(" + (CAPACITY - occupiedSpace) + "left)");
            System.out.println();
            return;
        }

        System.out.println("| " + item.getName() + " obtained!");

        if(item instanceof Weapon){
            wpnInventory.add((Weapon) item);
            System.out.println("| " + item.getName() + " added to Weapons.");
        }
        else if(item instanceof Food){
            potionInventory.add((Food) item);
            System.out.println("| " + item.getName() + " added to Potions.");
        }
        else if(item instanceof Key){
            keyInventory.add((Key) item);
            System.out.println("| " + item.getName() + " added to Keys.");
        }
        else if(item instanceof SkillScroll){
            skillScrollInventory.add((SkillScroll) item);
            System.out.println("| " + item.getName() + " added to Skill Scrolls.");
        }
        else{
            System.out.println("| Unknown item type: " + item.getName() + ". Cannot add.");
            return;
        }
        
        occupiedSpace += item.getSize();
        System.out.println("| Inventory    :   " + occupiedSpace + "/" + CAPACITY);
        System.out.println();
    }

    @Override
    public void remove(Item item){
        if(item instanceof Weapon){
            if(wpnInventory.remove(item)){
                System.out.println("| " + item.getName() + " removed from Weapons.");
            }
        }
        else if(item instanceof Food){
            if(potionInventory.remove(item)){
                System.out.println("| " + item.getName() + " removed from Foods.");
            }
        }
        else if(item instanceof Key){
            if(keyInventory.remove(item)){
                System.out.println("| " + item.getName() + " removed from Keys.");
            }
        }
        else if(item instanceof SkillScroll){
            if(skillScrollInventory.remove(item)){
                System.out.println("| " + item.getName() + " removed from Skill Scrolls.");
            }
        }
        else{
            System.out.println("Unknown item type: " + item.getName() + ". Cannot remove.");
        }

        occupiedSpace -= item.getSize();
        System.out.println("| Inventory    :   " + occupiedSpace + "/" + CAPACITY);
        System.out.println();

    }


    public Weapon getWpn(){
        if(!wpnInventory.isEmpty()){
            System.out.println();
            System.out.println("| Select weapon from inventory");
            System.out.println("==========================================================");
            Weapon item = null;
            for(int i = 0; i < wpnInventory.size(); i++){
                System.out.println("| " + (i + 1) + " - " + wpnInventory.get(i).getName());
            }
            System.out.println("==========================================================");
            int choice = -1;

            while(item == null){
                choice = OptionSelect.getArrIndex(wpnInventory.size());
                item = wpnInventory.get(choice - 1);
            }

            return item;
        } else return null;
    }


    public Food getFood(){
        if(!potionInventory.isEmpty()){
            System.out.println();
            System.out.println("| Select food from inventory");
            System.out.println("==========================================================");
            Food item = null;
            for(int i = 0; i < potionInventory.size(); i++){
                System.out.println("| " + (i + 1) + " - " + potionInventory.get(i).getName());
            }
            System.out.println("==========================================================");
            int choice = -1;

            while(item == null){
                choice = OptionSelect.getArrIndex(potionInventory.size());
                item = potionInventory.get(choice - 1);
            }

            return item;
        } else return null;
    }


    public Key getKey(){
        if(!keyInventory.isEmpty()){
            System.out.println();
            System.out.println("| Select key from inventory");
            System.out.println("==========================================================");
            Key item = null;
            for(int i = 0; i < keyInventory.size(); i++){
                System.out.println("| " + (i + 1) + " - " + keyInventory.get(i).getName());
            }
            System.out.println("==========================================================");
            int choice = -1;

            while(item == null){
                choice = OptionSelect.getArrIndex(keyInventory.size());
                item = keyInventory.get(choice - 1);
            }

            return item;
        }
        else return null;
    }
    
    public SkillScroll getSkillScroll(){
        if(!skillScrollInventory.isEmpty()){
            System.out.println();
            System.out.println("| Select skill scroll from inventory");
            System.out.println("==========================================================");
            SkillScroll item = null;
            for(int i = 0; i < skillScrollInventory.size(); i++){
                System.out.println("| " + (i + 1) + " - " + skillScrollInventory.get(i).getName());
            }
            System.out.println("==========================================================");
            int choice = -1;

            while(item == null){
                choice = OptionSelect.getArrIndex(skillScrollInventory.size());
                item = skillScrollInventory.get(choice - 1);
            }

            return item;
        } else return null;
    }

}
