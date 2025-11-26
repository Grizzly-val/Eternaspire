package entity.tower_entity.echoes;

import entity.Entity;
import entity.tower_entity.Echo;

public class Malphas extends Echo {

    private final static int BASE_HP = 55;
    private final static int BASE_ATK = 7;

    public Malphas(int lvl) {
        super(BASE_HP, 
              BASE_ATK, 
              lvl, 
              "Malphas, The Distorted Visage", 
              "A hulking mass of fused armor plates and rotting flesh. Inside its metal head hide, is the head of a crow.", 
              "Malphas falls apart, the screaming faces finally silenced.",
                "cutscene_Defeat_Malphas"); 

    }

    @Override
    public void basicAttack(Entity opponent) {
        System.out.println("| Malphas strikes with a weapon that phases through reality.");
        dmgAttack(opponent, atk);
    }
}