package world.location.locationData;

import java.util.HashMap;
import java.util.Map.Entry;

import entity.tower_entity.Echo;
import entity.tower_entity.Remnant;
import ui.OptionSelect;

public class AreaEntities {
    private HashMap<Integer, Remnant> areaRemnants = new HashMap<>();
    private Echo areaEcho = null;
    private int areaRemnantsChoice = 1;

    public AreaEntities(){
    }

    public boolean isClear(){
        if(areaEcho == null && areaRemnants.isEmpty()) return true;
        return false;
    }
    public boolean hasEcho(){
        if(areaEcho == null) return false;
        return true;
    }
    public boolean hasRemnant(){
        if(areaRemnants.isEmpty()) return false;
        return true;
    }
    public int getRemnantCount(){return areaRemnants.size();}

    public void addRemnant(Remnant remnant){
        areaRemnants.put(areaRemnantsChoice++, remnant);
    }
    public void setEcho(Echo echo){
        this.areaEcho = echo;
    }

    public Remnant fightRemnant(){
        if(!this.hasRemnant()){
            return null;
        }

        for(Entry<Integer, Remnant> remnant : areaRemnants.entrySet()){
            System.out.println(remnant.getKey() + " - " + remnant.getValue().getName());
        }
        Remnant chosenRemnant = null;

        if(this.hasEcho()){
            System.out.println("An even greater danger awaits... Start with the small fries");
        }

        while(chosenRemnant == null){
            System.out.println("Pick a remnant to fight.");
            chosenRemnant = areaRemnants.get(OptionSelect.intInput(-1));
            if(chosenRemnant == null) System.out.println("Invalid Remnant Choice!");
        }
        return chosenRemnant;
    }

    public Echo fightEcho(){
        char fightEchoChoice = '\0';
        System.out.println("The Remnants have perished, leaving behind a single whisper—an Echo that refuses to fade.");
        System.out.println("Echo: " + areaEcho.getName());
        System.out.println(areaEcho.getDescription());
        System.out.println(areaEcho.getStory());

        System.out.println("Would you like to fight echo? (y/n): ");
        fightEchoChoice = OptionSelect.charInput(fightEchoChoice);
        switch(fightEchoChoice){
            case 'y':
                System.out.println("You challenge a Remnant manifested from the lingering desire of single fallen soul — an Echo. Prepare yourself.");
                return this.areaEcho;
            case 'n':
                System.out.println("Even Eternaspire's Echoes wait for those who hesitate... take your time.");
                return null;
            default:
                System.out.println("I sense hesitation, you don't seem to be ready. Your answer must be a straightforward yes or no.");
                return null;
            }
    }

}
