package mechanics.cutscene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import engine.Game;
import entity.player.Challenger;
import entity.tower_entity.Echo;
import entity.tower_entity.Remnant;
import ui.OptionSelect;
import ui.TextTyper;
import world.item.consumables.Food;
import world.item.consumables.Key;
import world.item.consumables.SkillScroll;
import world.item.wpn.Weapon;

public final class CutsceneManager {
    public static void checkCutscene(String cutsceneID, Challenger player, Object obj){

        System.out.println();
        TextTyper.typeText("| Starting cutscene >>", 70, true);
        System.out.println();

        cutsceneID += "_as" + player.getJob().replace(" ", "");

        String dir = player.getJob().replace(" ", "") + "/";
        if(obj instanceof Key){
            dir += "key";
        }
        else if(obj instanceof Weapon){
            dir += "weapon";
        }
        else if(obj instanceof Food){
            dir += "food";
        }
        else if(obj instanceof SkillScroll){
            dir += "skill_scroll";
        }
        else if(obj instanceof Echo){
            dir += "echo";
        }
        else if(obj instanceof Remnant){
            dir += "remnant";
        }
        else if(obj instanceof Game){
            dir += "game";
        }
        else{
            System.out.println("! ! Unknown type ! !");
        }


        switch(cutsceneID){

            case "openingScene_00ChallengerBackstory_asMercenary":
                startCutscene(cutsceneID, dir);
                break;


            case "openingScene_01NuggetEncounter_asMercenary":
                startCutscene(cutsceneID, dir);
                break;

                
            case "openingScene_02TowerArrival_asMercenary":
                startCutscene(cutsceneID, dir);
                break;


            case "cutscene_UseKey_TheWhetstoneClavis_asMercenary":
                startCutscene(cutsceneID, dir);
                break;


            case "cutscene_RemnantDefeat_ElementalBlob_asMercenary":
                startCutscene(cutsceneID, dir);  
                break;


            case "cutscene_FirstEncounterWith_ElementalBlob_asMercenary":
                TextTyper.typeText("| You have encountered an elemental blob for the first time", 20, true);
                startCutscene(cutsceneID, dir);
                TextTyper.typeText("| Engaging battle with Elemental Blob...", 80, true);
                break;


            case "cutscene_Learn_ChallengersWill_asMercenary":
                TextTyper.typeText("| The scroll unfurls by itself. Its text burns away line by line, searing into the mercenary's shadow instead of his skin.", 20, true);
                startCutscene(cutsceneID, dir);
                TextTyper.typeText("| Skill unlocked: “Challenger's Will.” The Tower trembles faintly, as if it noticed.", 80, true);
                break;


            case "cutscene_UseKey_TheWhetstoneClavis":
                TextTyper.typeText("| The jagged key hums as it's pressed into the lock. Sparks race along its edge, like metal being sharpened on stone.", 20, true);
                startCutscene(cutsceneID, dir);
                TextTyper.typeText("| The lift seals behind them. The next floor rumbles awake, echoing with the sound of metal on metal.", 80, true);
                break;



            case "cutscene_FirstTimeEquip_ChallengersSword_asMercenary":
                startCutscene(cutsceneID, dir);
                TextTyper.typeText("| Challenger's Sword in hand. Somewhere in the Tower, a quiet resonance stirs.", 80, true);                
                break;


            case "cutscene_UseKey_TheLatchBreaker_asMercenary":
                startCutscene(cutsceneID, dir);            
                break;

            case "cutscene_FirstEncounterWith_Gnawer_asMercenary":
                startCutscene(cutsceneID, dir);
                break;

            case "cutscene_RemnantDefeat_Gnawer_asMercenary":
                startCutscene(cutsceneID, dir);
                break;

            case "cutscene_UseKey_TheDisfragmenter_asMercenary":
                startCutscene(cutsceneID, dir);
                break;

            case "cutscene_FirstEncounterWith_LostVanguard_asMercenary":
                startCutscene(cutsceneID, dir);
                break;

            case "cutscene_EchoDefeat_LostVanguard_asMercenary":
                startCutscene(cutsceneID, dir);
                break;

            case "cutscene_UseKey_TheAscendantsToken_asMercenary":
                startCutscene(cutsceneID, dir);
                break;
            case "cutscene_FirstEncounterWith_UnmovingNomad_asMercenary":
                startCutscene(cutsceneID, dir);
                break;

            default:
                TextTyper.typeText("Cutscene " + cutsceneID + " not found", 100, true);
                break;

        }

        System.out.println();
        System.out.println();
        OptionSelect.waiter();
        System.out.println();
        System.out.println();




    }

    public static void startCutscene(String cutsceneID, String dir){
        try {
            readFile("resources/" + dir + "/" + cutsceneID + ".txt");
        } catch (IOException e) {
            System.out.println("|! Cutscene loading sequence ended.");
        }
    }


    
    public static void readFile(String cutsceneFile) throws IOException {

        InputStream inputStream = CutsceneManager.class.getClassLoader().getResourceAsStream(cutsceneFile);

        if (inputStream == null) {
            System.out.println("|! Cutscene does not exist: " + cutsceneFile);
            throw new IOException("|! Resource not found on classpath: " + cutsceneFile);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;

            while ((line = reader.readLine()) != null) {
                TextTyper.typeText(line, 40, true);
            }

        } catch (IOException e) {
             System.out.println("|! Something went wrong >>! Cutscene Interrupted: " + e.getMessage());
        }
    }
}
