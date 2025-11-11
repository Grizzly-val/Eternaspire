package mechanics.cutscene;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.w3c.dom.Text;

import entity.player.Challenger;
import ui.TextTyper;
import world.item.consumables.Food;

public final class CutsceneManager {
    public static void checkCutscene(String cutsceneID, Challenger player){

        System.out.println();
        TextTyper.typeText("| Starting cutscene >>", 70);
        System.out.println();


        switch(cutsceneID){
            case "cutscene_FirstEncounterWith_ElementalBlob":
                TextTyper.typeText("| You have just defeated an Elemental Blob for the first time", 20);
                startCutscene(cutsceneID);
                TextTyper.typeText("| You go on with your journey", 80);
                player.getInventory().addItem(new Food("Drumstick", "Yummy meat", 20, "nocutscene"));
                break;
            default:
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


    public static void readFile(String cutsceneFile) throws IOException{

        InputStream inputStream = CutsceneManager.class.getClassLoader().getResourceAsStream(cutsceneFile);

        if (inputStream == null) {
            System.out.println("|! Cutscene does not exist: ");
            throw new IOException("Resource not found on classpath.");
        }


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;

            while((line = reader.readLine()) != null){
                TextTyper.typeText(line, 30);
            }

        } catch(FileNotFoundException e){
            System.out.println("|! Cutscene does not exist " + e);
        } catch(IOException e){
            System.out.println("|! Something went wrong >>! Cutscene Interrupted " + e);
        }


    }
}
