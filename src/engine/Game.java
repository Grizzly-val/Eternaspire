package engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;


import entity.player.Challenger;
import entity.player.Mercenary;
import mechanics.cutscene.CutsceneManager;
import ui.OptionSelect;
import ui.TextTyper;
import world.location.locationData.AreaEntityData;
import world.location.locationData.AreaInventoryData;
import world.location.locationData.FloorData;

public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime creation;
    private String name;
    private AccountManager manager;
    private Challenger player = null;
    private FloorData floorData = new FloorData();

    public Game(String name, AccountManager manager) {
        this.creation = LocalDateTime.now();
        this.name = name;
        this.manager = manager;
    }

    public LocalDateTime getCreation() { return creation; }
    public String getName() { return name; }
    public Challenger getPlayer() { return player; }
    public FloorData getFloorData(){return floorData;}

    public void gameStart() {
        System.out.println();
        System.out.println();
        loadPlayer();
        manager.saveAccounts();

        if (player != null) {
            System.out.println("\n| Welcome back!");
            saveGame();
            player.play();
            return;
        }

        // No saved player, first time for this account
        TextTyper.typeText("Speaking of...", 50, true);
        TextTyper.typeText("Who are you?", 30, true);
        System.out.println("\n| Choose your character!");

        char choice = '\0';
        while (choice != 'm' && choice != 'k' && choice != 'w') {
            System.out.println("----------------------------");
            System.out.println("[m] - Mercenary");
            System.out.println("[k] - Knight");
            System.out.println("[w] - Wizard");
            System.out.println("----------------------------");
            System.out.print("| Select character >> ");
            choice = OptionSelect.charInput(choice);
            System.out.println("----------------------------");

            switch (choice) {
                case 'm':
                    System.out.println("| You've chosen a Mercenary!");
                    player = new Mercenary();
                    break;
                case 'k':
                    System.out.println("| You've chosen a Knight!");
                    // TODO: implement Knight
                    break;
                case 'w':
                    System.out.println("| You've chosen a Wizard!");
                    // TODO: implement Wizard
                    break;
                default:
                    System.out.println("| Please choose from available Challengers");
            }
        }

        // Set transient fields
        player.setGameManager(this);

        // Initialize world data for first-time players
        floorData.init(this);
        AreaInventoryData.init(floorData);
        AreaEntityData.init(floorData);

        // Run opening cutscenes
        CutsceneManager.checkCutscene("openingScene_00ChallengerBackstory", player);
        CutsceneManager.checkCutscene("openingScene_01NuggetEncounter", player);
        CutsceneManager.checkCutscene("openingScene_02TowerArrival", player);

        // Save the new player
        saveGame();
        player.play();
    }

    // Get the save file for this player
    private File getPlayerSaveFile() {
        String safeName = name.replaceAll("\\s+", "_");
        return new File(safeName + "_game_save.dat");
    }

    // Save the current player
    public void saveGame() {
        if (player == null) {
            System.err.println("! ! No game to save ! !");
            return;
        }

        File saveFile = getPlayerSaveFile();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFile))) {
            oos.writeObject(this);
            System.out.println();
            TextTyper.typeText("| Game saved successfully ✅", 30, true);
            System.out.println("----------------------------------");
        } catch (IOException e) {
            System.err.println("! ! Failed to save game ! !");
            e.printStackTrace();
        }
    }

    public void loadPlayer() {
        File savedFile = getPlayerSaveFile();

        if (!savedFile.exists()) {
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedFile))) {
            // Load the full saved Game object
            Game loadedGame = (Game) ois.readObject(); 
            if (loadedGame.getPlayer() == null) {
                System.err.println("| Save file exists, but player state is null. Starting a new game.");
                return; // 'this.player' remains null, gameStart() proceeds to character creation
            }

            this.creation = loadedGame.getCreation();
            this.name = loadedGame.getName();
            this.manager = loadedGame.manager;
            this.floorData = loadedGame.getFloorData();


            setPlayer(loadedGame.getPlayer()); 

            System.out.println("| Game loaded successfully ✅");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("! ! Failed to load player ! !");
            e.printStackTrace();
        }
    }

    public void deleteData() {
        File saveFile = getPlayerSaveFile();
        if (saveFile.exists()) {
            if (saveFile.delete()) {
                System.out.println("| Save file for \"" + this.name + "\" deleted successfully.");
            } else {
                System.err.println("! ! Failed to delete save file for \"" + this.name + "\" ! !");
            }
        } else {
            System.err.println("| No save file found for deletion for \"" + this.name + "\".");
        }
    }


    public void setPlayer(Challenger player) {
        this.player = player;
        this.player.setGameManager(this);
    }

}
