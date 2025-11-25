package engine;
import java.io.Serializable;
import java.lang.StackWalker.Option;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map.Entry;

import ui.Format;
import ui.OptionSelect;
import ui.TextTyper;


public class Account implements Serializable{

    private String username;
    private String password;
    private AccountManager manager;
    
    private int wins = 0;
    private int losses = 0;
    private int totalGames = 0;

    private HashMap<Integer, Game> accountGames = new HashMap<>();
    private int gameCountChoice = 1;



    public Account(String username, String password, AccountManager manager){
        this.username = username;
        this.password = password;
        this.manager = manager;
    }

    public String getUsername(){return username;}
    public String getPassword(){return password;}
    public HashMap<Integer, Game> getAccountGames(){return accountGames;}


    private void showGames(){
        System.out.println("-------------------------------------");
        for(Entry<Integer, Game> g : accountGames.entrySet()){
            String gameName = g.getValue().getName();
            String creationDate = DateTimeFormatter.ISO_DATE.format(g.getValue().getCreation()) + " | " + DateTimeFormatter.ISO_LOCAL_TIME.format(g.getValue().getCreation()).substring(0,8);

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
        TextTyper.typeText("| Hello, " + username + "! ", 40, true);
        char choice = '\0';
        while(choice != 'o'){
            Format.boxify(" Account Menu || W: " + wins + " | L: " + losses + " ");
            
            System.out.println("[n] - New game      ✨");
            System.out.println("[l] - Load game[" + accountGames.size() + "]  📜");
            System.out.println("[d] - Delete game   🗑️");
            System.out.println("[o] - Log out       🚪");
            System.out.println("----------------------------------");
            choice = OptionSelect.charInput(choice);
            System.out.println("----------------------------------");
            switch(choice){
                case 'o':
                    System.out.println();
                    TextTyper.typeText("| Bye, " + username + " :c", 40, true);
                    System.out.println();
                    manager.saveAccounts();
                    return;
                case 'n':
                    TextTyper.typeText("| Creating new game >>", 40, true);
                    String gameName = "";
                    while(gameName.length() > 7 || gameName.length() < 2){
                        System.out.print("| Name your game (2-7) >> Game name: ");
                        gameName = OptionSelect.stringInput("");
                        System.out.println("----------------------------------");
                        if(gameName.length() > 7 || gameName.length() < 2){
                            System.out.println();
                            System.out.println("| Game name must be 2 to 7 characters long! ⚠️");
                            System.out.println();
                        }
                        System.out.println("----------------------------------");
                    }

                    accountGames.put(gameCountChoice, new Game(gameName, manager, gameCountChoice++, this));
                    System.out.println("| New game \"" + gameName + "\" added at slot " + (gameCountChoice - 1) + " 📥");
                    totalGames += 1;
                    System.out.println("----------------------------------");
                    manager.saveAccounts();
                    break;
                case 'd':
                    if(accountGames.isEmpty()){
                        System.out.println("| No game found! Nothing to delete 👻");
                        break;
                    }

                    showGames();
                    System.out.println("-------------------------------------");
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
                    OptionSelect.waiter();
                    if(totalGames - 1 >= 0){
                        totalGames -= 1;
                    }
                    System.out.println("----------------------------------");
                    accountGames.get(toDelete).deleteData();
                    manager.saveAccounts();
                    break;
                case 'l':

                    if(accountGames.isEmpty()){
                        System.out.println("| No game found! Start a new game 🕳️");
                        OptionSelect.waiter();
                        System.out.println("----------------------------------");
                        break;
                    }

                    showGames();
                    System.out.println("-------------------------------------");
                    int toEnter = OptionSelect.intInput(-1);
                    System.out.println("----------------------------------");
        

                    if(accountGames.get(toEnter) == null){
                        System.out.println("| Game not found! 👻");
                        break;
                    }

                    TextTyper.typeText("| Entering Eternaspire >>", 60, true);
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


    public void addWin(){
        System.out.println();
        wins += 1;
        if(wins > 1) Format.boxify("| Game win added to records! (LOSSES: " + wins + ")");
        else Format.boxify("| Game win added to records! (" + wins + " win)");
        System.out.println();
    }

    public void addLose(){
        System.out.println();
        losses += 1;
        if(losses > 1) Format.boxify("| Game lost added to records! (LOSSES: " + losses + ")");
        else Format.boxify("| Game lost added to records! (" + losses + " loss)");
        System.out.println();
    }

}
