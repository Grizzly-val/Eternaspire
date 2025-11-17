package mechanics.cutscene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import entity.player.Challenger;
import ui.TextTyper;

public final class CutsceneManager {
    public static void checkCutscene(String cutsceneID, Challenger player){

        System.out.println();
        TextTyper.typeText("| Starting cutscene >>", 70, true);
        System.out.println();

        cutsceneID += "_as" + player.getJob().replace(" ", "");

        switch(cutsceneID){
            case "openingScene_00ChallengerBackstory_asMercenary":
                startCutscene(cutsceneID);
                break;
            case "openingScene_01NuggetEncounter_asMercenary":
                startCutscene(cutsceneID);
                break;
            case "openingScene_02TowerArrival_asMercenary":
                startCutscene(cutsceneID);
                break;


            case "cutscene_UseKey_TheWhetstoneClavis_asMercenary":
                startCutscene(cutsceneID);
                break;
            case "cutscene_RemnantDefeat_ElementalBlob_asMercenary":
                startCutscene(cutsceneID);  
                break;
            case "cutscene_FirstEncounterWith_ElementalBlob_asMercenary":
                TextTyper.typeText("| You have encountered an elemental blob for the first time", 20, true);
                startCutscene(cutsceneID);
                TextTyper.typeText("| Engaging battle with Elemental Blob...", 80, true);
                break;
            case "cutscene_Learn_ChallengersWill_asMercenary":
                TextTyper.typeText("| The scroll unfurls by itself. Its text burns away line by line, searing into the mercenary's shadow instead of his skin.", 20, true);
                startCutscene(cutsceneID);
                TextTyper.typeText("| Skill unlocked: “Challenger's Will.” The Tower trembles faintly, as if it noticed.", 80, true);
                break;
            case "cutscene_UseKey_TheWhetstoneClavis":
                TextTyper.typeText("| The jagged key hums as it's pressed into the lock. Sparks race along its edge, like metal being sharpened on stone.", 20, true);
                startCutscene(cutsceneID);
                TextTyper.typeText("| The lift seals behind them. The next floor rumbles awake, echoing with the sound of metal on metal.", 80, true);
                break;
            case "cutscene_FirstTimeEquip_ChallengersSword_asMercenary":
                TextTyper.typeText("| The sword slides halfway out of its sheath — chipped, plain, and old. Yet when the Challenger grips it, the metal hums faintly, responding to his pulse.", 20, true);
                startCutscene(cutsceneID);
                TextTyper.typeText("| Challenger's Sword in hand. Somewhere in the Tower, a quiet resonance stirs.", 80, true);                
                break;
            default:
                TextTyper.typeText("Cutscene " + cutsceneID + " not found", 100, true);
                break;
        }

        System.out.println();
        System.out.println();




    }

    public static void startCutscene(String cutsceneID){
        try {
            readFile("resources/" + cutsceneID + ".txt");
        } catch (IOException e) {
            System.out.println("|! Cutscene loading sequence ended.");
        }
    }


    
    public static void readFile(String cutsceneFile) throws IOException {

        int lineDelay = 0;

        InputStream inputStream = CutsceneManager.class.getClassLoader().getResourceAsStream(cutsceneFile);

        if (inputStream == null) {
            System.out.println("|! Cutscene does not exist: " + cutsceneFile);
            throw new IOException("|! Resource not found on classpath: " + cutsceneFile);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;

            while ((line = reader.readLine()) != null) {
                TextTyper.typeText(line, 0, true);
                
                lineDelay = (int)(line.length() / 0.02) - (int)(line.length() * 30);

                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); 
                }
            }

        } catch (IOException e) {
             System.out.println("|! Something went wrong >>! Cutscene Interrupted: " + e.getMessage());
        }
    }
}
