package engine;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map.Entry;

import ui.OptionSelect;
import ui.TextTyper;


public class Account implements Serializable{

    private String username;
    private String password;
    private AccountManager manager;

    private HashMap<Integer, Game> accountGames = new HashMap<>();
    private int gameCountChoice = 1;



    public Account(String username, String password, AccountManager manager){
        this.username = username;
        this.password = password;
        this.manager = manager;
    }

    public String getUsername(){return username;}
    public String getPassword(){return password;}


    private void showGames(){
        System.out.println("----------------------------------");
        for(Entry<Integer, Game> g : accountGames.entrySet()){
            String gameName = g.getValue().getName();
            LocalDateTime creationDate = g.getValue().getCreation();

            // Use String.format to build the entire formatted line
            String formattedLine = String.format(
                "%d.) %-8s - %s", 
                g.getKey(), 
                gameName, 
                creationDate
            );
            
            // Print the single, complete, formatted string
            System.out.println(formattedLine);
        }
    }

    public void accMenu(){
        System.out.println();
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("| Hello, " + username + "! ");
        System.out.println("----------------------------------");
        char choice = '\0';
        while(choice != 'o'){
            System.out.println("| Account Menu |");
            System.out.println("----------------");
            System.out.println("[n] - New game      ✨");
            System.out.println("[l] - Load game     📜");
            System.out.println("[d] - Delete game   🗑️");
            System.out.println("[o] - Log out       🚪");
            System.out.println("----------------------------------");
            choice = OptionSelect.charInput(choice);
            System.out.println("----------------------------------");
            switch(choice){
                case 'o':
                    System.out.println("| Bye, " + username + " :c");
                    manager.saveAccounts();
                    return;
                case 'n':
                    System.out.println("| Creating new game >>");
                    String gameName = "";
                    System.out.print("| Name your game (10) >> Game name: ");
                    while(gameName.length() > 7 || gameName.length() < 2){
                        gameName = OptionSelect.stringInput("");
                        System.out.println("----------------------------------");
                        if(gameName.length() > 7 || gameName.length() < 2){
                            System.out.println();
                            System.out.println("| Game name must be 2 to 7 characters long! ⚠️");
                            System.out.println();
                        }
                        System.out.println("----------------------------------");
                    }

                    accountGames.put(gameCountChoice++, new Game(gameName, manager));
                    System.out.println("| New game \"" + gameName + "\" added at slot " + (gameCountChoice - 1) + " 📥");
                    System.out.println("----------------------------------");
                    manager.saveAccounts();
                    break;
                case 'd':
                    if(accountGames.isEmpty()){
                        System.out.println("| No game found! Nothing to delete 👻");
                        break;
                    }

                    showGames();
                    System.out.println("----------------------------------");
                    int toDelete = OptionSelect.intInput(-1);
                    System.out.println("----------------------------------");

                    if(toDelete == -1){
                        System.out.println("| Cancelling game deletion... 💨");
                        System.out.println("----------------------------------");
                        break;
                    }

                    if(accountGames.get(toDelete) == null){
                        System.out.println("| Game not found! 👻");
                        System.out.println("----------------------------------");
                        break;
                    }
                    accountGames.get(toDelete).deleteData();
                    System.out.println("| Game \"" + accountGames.get(toDelete).getName() + "\" Deleted 🗑️");
                    System.out.println("----------------------------------");
                    accountGames.remove(toDelete);
                    manager.saveAccounts();
                    break;
                case 'l':

                    if(accountGames.isEmpty()){
                        System.out.println("| No game found! Start a new game 🕳️");
                        System.out.println("----------------------------------");
                        break;
                    }

                    showGames();
                    System.out.println("----------------------------------");
                    int toEnter = OptionSelect.intInput(-1);
                    System.out.println("----------------------------------");
        

                    if(accountGames.get(toEnter) == null){
                        System.out.println("| Game not found! 👻");
                        break;
                    }

                    TextTyper.typeText("| Entering Eternaspire >>", 50, true);
                    accountGames.get(toEnter).gameStart();
                    System.out.println("----------------------------------");
                    
                    break;
                default:
                    System.out.println("! ! Invalid input ! ! ❓");
                    System.out.println("----------------------------------");
                    break;
            }

            




        }

    }

}
