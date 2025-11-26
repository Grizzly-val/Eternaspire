package entity.tower_entity.echoes;

import entity.Entity;
import entity.tower_entity.Echo;

public class MasterBlob extends Echo {

    private final static int BASE_HP = 170;
    private final static int BASE_ATK = 35;

    public MasterBlob(int lvl) {
        super(BASE_HP, 
              BASE_ATK, 
              60, 
              "Master Blob", 
              "The Tower Master of Eternaspire. A shifting, swirling mass of fire, ice, lightning, void, and code. The Prime State.", 
              "The Master Blob destabilizes, splashing onto the floor in a chaotic puddle of raw data.", 
              "cutscene_EchoDefeat_MasterBlob_asMercenary");
    }

    @Override
    public void basicAttack(Entity opponent) {

        if(Math.random() < 0.40){
            System.out.println("| " + this.getName() + " misses its blobly shot");
        }

        // The Master Blob can use any element. We randomize the description.
        String[] elements = {"Molten Fire", "Glacial Ice", "Void Static", "Arcane Lightning"};
        String element = elements[(int)(Math.random() * elements.length)];

        System.out.println("| " + this.getName() + " shifts its form and lashes out with " + element + "!");
        dmgAttack(opponent, atk);
    }
}