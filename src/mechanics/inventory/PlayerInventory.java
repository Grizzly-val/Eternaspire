// Inventory.java
package mechanics.inventory;

import java.util.ArrayList;

import ui.OptionSelect;
import world.item.Item;
import world.item.consumables.Key;
import world.item.consumables.Potion;
import world.item.wpn.Weapon;
import world.item.consumables.SkillScroll;

public class PlayerInventory extends Inventory {

    public PlayerInventory(String name){
        super(name);
    }

    private ArrayList<Weapon> wpnInventory = new ArrayList<>();
    private ArrayList<Potion> potionInventory = new ArrayList<>();
    private ArrayList<Key> keyInventory = new ArrayList<>();
    private ArrayList<SkillScroll> skillScrollInventory = new ArrayList<>();

    public ArrayList<Weapon> getWpnInventory(){return wpnInventory;}
    public ArrayList<Potion> getPotionInventory(){return potionInventory;}
    public ArrayList<Key> getKeyInventory(){return keyInventory;}
    public ArrayList<SkillScroll> getSkillScrollInventory(){return skillScrollInventory;}

    @Override
    public void add(Item item){
        if(item instanceof Weapon){
            wpnInventory.add((Weapon) item);
            System.out.println(item.getName() + " added to Weapons.");
        }
        else if(item instanceof Potion){
            potionInventory.add((Potion) item);
            System.out.println(item.getName() + " added to Potions.");
        }
        else if(item instanceof Key){
            keyInventory.add((Key) item);
            System.out.println(item.getName() + " added to Keys.");
        }
        else if(item instanceof SkillScroll){
            skillScrollInventory.add((SkillScroll) item);
            System.out.println(item.getName() + " added to Skill Scrolls.");
        }
        else{
            System.out.println("Unknown item type: " + item.getName() + ". Cannot add.");
        }
    }

    @Override
    public void remove(Item item){
        if(item instanceof Weapon){
            if(wpnInventory.remove(item)){
                System.out.println(item.getName() + " removed from Weapons.");
            }
        }
        else if(item instanceof Potion){
            if(potionInventory.remove(item)){
                System.out.println(item.getName() + " removed from Potions.");
            }
        }
        else if(item instanceof Key){
            if(keyInventory.remove(item)){
                System.out.println(item.getName() + " removed from Keys.");
            }
        }
        else if(item instanceof SkillScroll){
            if(skillScrollInventory.remove(item)){
                System.out.println(item.getName() + " removed from Skill Scrolls.");
            }
        }
        else{
            System.out.println("Unknown item type: " + item.getName() + ". Cannot remove.");
        }
    }


    public Weapon getWpn(){

        Weapon item = null;
        for(int i = 0; i < wpnInventory.size(); i++){
            System.out.println(i + " - " + getWpnInventory().get(i).getName());
        }
        int choice = -1;

        while(item == null){
            choice = OptionSelect.intInput(choice);
            item = wpnInventory.get(choice);
        }

        return item;
    }


    public Potion getPotion(){
        Potion item = null;
        for(int i = 0; i < potionInventory.size(); i++){
            System.out.println(i + " - " + potionInventory.get(i).getName());
        }
        int choice = -1;

        while(item == null){
            choice = OptionSelect.intInput(choice);
            item = potionInventory.get(choice);
        }

        return item;
    }


    public Key getKey(){
        if(!keyInventory.isEmpty()){
            Key item = null;
            for(int i = 0; i < keyInventory.size(); i++){
                System.out.println(i + " - " + keyInventory.get(i).getName());
            }
            int choice = -1;

            while(item == null){
                choice = OptionSelect.intInput(choice);
                item = keyInventory.get(choice);
            }

            return item;
        }
        else return null;
    }

    public SkillScroll getSkillScroll(){

        SkillScroll item = null;
        for(int i = 0; i < skillScrollInventory.size(); i++){
            System.out.println(i + " - " + skillScrollInventory.get(i).getName());
        }
        int choice = -1;

        while(item == null){
            choice = OptionSelect.intInput(choice);
            item = skillScrollInventory.get(choice);
        }

        return item;
    }

}
