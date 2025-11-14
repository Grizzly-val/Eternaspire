package world.location.locationData;

import java.io.Serializable;
import java.util.ArrayList;

import entity.tower_entity.Echo;
import entity.tower_entity.Remnant;
import ui.OptionSelect;

public class AreaEntities implements Serializable{
    
    private ArrayList<Remnant> areaRemnants = new ArrayList<>();
    private Echo areaEcho = null;

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
        areaRemnants.add(remnant);
    }

    public void remnantDefeated(Remnant remnant){
        areaRemnants.remove(remnant);
    }

    public void setEcho(Echo echo){
        this.areaEcho = echo;
    }

    public void echoDefeated(){
        System.out.println();
        this.areaEcho = null;
    }


    public Remnant fightRemnant(){
        if(!this.hasRemnant()){
            return null;
        }
        System.out.println("-------------------------------------------------------------");
        for(int i = 0; i < areaRemnants.size(); i++){
            System.out.println("[" + (i + 1) + "] - " + areaRemnants.get(i).getName());
        }
        System.out.println("-------------------------------------------------------------");
        Remnant chosenRemnant = null;

        if(this.hasEcho()){
            System.out.println("An even greater danger awaits... Start with the small fries");
        }

        while(chosenRemnant == null){
            System.out.println("Pick a remnant to fight.");
            System.out.println("-------------------------------------------------------------");
            chosenRemnant = areaRemnants.get(OptionSelect.getArrIndex(areaRemnants.size()) - 1);
            if(chosenRemnant == null) System.out.println("Invalid Remnant Choice!");
        }
        return chosenRemnant;
    }




    public Echo fightEcho(){
        char fightEchoChoice = '\0';
        System.out.println("| The Remnants have perished, leaving behind a single whisper—an Echo that refuses to fade.");
        System.out.println();
        System.out.println("| Echo  :   " + areaEcho.getName());
        System.out.println("| > " + areaEcho.getDescription());
        System.out.println();
        System.out.println("| Would you like to fight echo? (y/n): ");
        System.out.println();
        fightEchoChoice = OptionSelect.charInput(fightEchoChoice);
        System.out.println();
        switch(fightEchoChoice){
            case 'y':
                System.out.println();
                System.out.println("| You challenge a Remnant manifested from the lingering desire of single fallen soul — an Echo. Prepare yourself.");
                return this.areaEcho;
            case 'n':
                System.out.println();
                System.out.println("| Even Eternaspire's Echoes wait for those who hesitate... take your time.");
                System.out.println();
                return null;
            default:
                System.out.println();
                System.out.println("| I sense hesitation, you don't seem to be ready. Your answer must be a straightforward yes or no.");
                System.out.println();
                return null;
            }
    }

}
