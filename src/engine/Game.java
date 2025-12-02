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
import entity.player.Knight;
import entity.player.Mercenary;
import entity.player.Paladin;
import mechanics.cutscene.CutsceneManager;
import ui.AudioPlayer;
import ui.OptionSelect;
import ui.TextTyper;
import world.location.locationData.AreaEntityData;
import world.location.locationData.AreaInventoryData;
import world.location.locationData.FloorData;



public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime creation;
    private String name;
    private transient AccountManager manager;
    private Challenger player = null;
    private FloorData floorData = new FloorData();
    private int gameKey;
    private transient Account account;

    public Game(String name, AccountManager manager, int gameKey, Account account) {
        this.creation = LocalDateTime.now();
        this.name = name;
        this.manager = manager;
        this.gameKey = gameKey;
        this.account = account;
    }

    public LocalDateTime getCreation() { return creation; }
    public String getName() { return name; }
    public Challenger getPlayer() { return player; }
    public FloorData getFloorData(){return floorData;}

    public void setManager(AccountManager accManager){
        this.manager = accManager;
    }

    public void setAccount(Account acc){
        this.account = acc;
    }
    
    public void gameStart() {
        System.out.println();
        System.out.println();
        loadPlayer();
        System.out.println();

        manager.saveAccounts();
    
        System.out.println();

        System.out.println();

        if (player != null) {
            System.out.println("\n| Welcome back!");
            saveGame();
            player.play();
            return;
        }

        // No saved player, first time for this account. No return :)
        TextTyper.typeText("| Daring challenger, ", 50, true);
        TextTyper.typeText("| Name yourself.", 30, true);
        TextTyper.typeText("\n| Choose your character!", 40, true);

        char choice = '\0';
        while (choice != 'm' && choice != 'k' && choice != 'p') {
            System.out.println("----------------------------");
            System.out.println("[m] - Mercenary");
            System.out.println("[k] - Knight");
            System.out.println("[p] - Paladin");
            System.out.println("----------------------------");
            System.out.print("| Select character >> ");
            choice = OptionSelect.charInput(choice);
            System.out.println("----------------------------");
            switch (choice) {
                case 'm':
                    TextTyper.typeText("| You've chosen a Mercenary!", 70, true);
                    player = new Mercenary();
                    break;




                case 'k':
                    TextTyper.typeText("| You've chosen a Knight!", 70, true);
                    player = new Knight();
                    break;




                case 'p':
                    TextTyper.typeText("| You've chosen a Paladin!", 70, true);
                    player = new Paladin();
                    break;




                default:
                    System.out.println();
                    System.out.println("| Please choose from available Challengers");
                    System.out.println();
            }

        }

        AudioPlayer.playOverlay("select_character.wav");

        // Set transient fields
        player.setGameManager(this);

        // Initialize world data for first-time players
        floorData.init(this);
        AreaInventoryData.init(floorData);
        AreaEntityData.init(floorData);
        

        AudioPlayer.play("opening.wav");
        // Run opening cutscenes
        CutsceneManager.checkCutscene("openingScene_00ChallengerBackstory", player, this);
        CutsceneManager.checkCutscene("openingScene_01NuggetEncounter", player, this);
        CutsceneManager.checkCutscene("openingScene_02TowerArrival", player, this);

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
            TextTyper.typeText("| Game saved successfully", 30, true);
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

            // Copy only the serializable / safe fields from the saved object.
            // DO NOT overwrite transient references (manager/account) — they should remain
            // the same as the owning Account/AccountManager in memory.
            this.creation = loadedGame.getCreation();
            this.name = loadedGame.getName();
            this.floorData = loadedGame.getFloorData();
            // note: we DO NOT set this.manager = loadedGame.manager; // manager is transient

            // set player and reattach transient references on player
            setPlayer(loadedGame.getPlayer()); 

            System.out.println("| Game loaded successfully");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("! ! Failed to load player ! !");
            e.printStackTrace();
        }
    }


    public void gameOver(GameResult result){
        switch(result){
            case LOSE:
                account.addLose();
                System.out.println();
                TextTyper.typeText("| Better luck next time, " + player.getName() + ".", 70, true);
                System.out.println();
                break;
            case WIN:
                account.addWin();
                System.out.println();
                TextTyper.typeText("| Job well done, " + player.getName() + "!", 70, true);
                System.out.println();
                break;
            default:
                System.out.println("| Unknown Game Conclusion!");
        }
        account.getManager().saveAccounts();
        TextTyper.typeText("| Bye, " + account.getUsername() + " :c", 40, true);
        TextTyper.typeText("| Bye, " + player.getName() + " :c", 40, true);
        switch(result){
            case LOSE:
                AudioPlayer.play("battle_lose.wav");
                break;
            case WIN:
                AudioPlayer.play("battle_win.wav");
                break;
            default:
                System.out.println("| ?");
        }
        TextTyper.typeText("\n\n| Exiting game...\n", 100, true);
        System.exit(0);
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
        if(account.getAccountGames().get(gameKey) != null){
            account.getAccountGames().remove(gameKey);
        }
    }


    public void setPlayer(Challenger player) {
        this.player = player;
        this.player.setGameManager(this);
    }

}
