package engine;
import java.io.Serializable;

import java.util.HashMap;
import java.util.Map.Entry;

import ui.OptionSelect;


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


    private void selectGame(){
        for(Entry<Integer, Game> g : accountGames.entrySet()){
            System.out.println(g.getKey() + " - " + g.getValue().getName() + "| " + g.getValue().getCreation());
        }
    }

    public void accMenu(){
        System.out.println("----------------------------------");
        System.out.println("| Hello, " + username + "! ");
        System.out.println("----------------------------------");
        char choice = '\0';
        while(choice != 'o'){
            System.out.println("[n] - New game");
            System.out.println("[l] - Load game");
            System.out.println("[d] - Delete game");
            System.out.println("[o] - Log out");
            System.out.println("----------------------------------");
            choice = OptionSelect.charInput(choice);
            System.out.println("----------------------------------");
            switch(choice){
                case 'o':
                    System.out.println("| Bye, " + username + " :c");
                    manager.saveAccounts();
                    return;
                case 'n':
                    String gameName = "";
                    System.out.print("Name your game (10): ");
                    while(gameName.length() > 10 || gameName.length() <= 0){
                        gameName = OptionSelect.stringInput("");
                    }

                    accountGames.put(gameCountChoice++, new Game(gameName, manager));
                    System.out.println("| New game \"" + gameName + "\" added at slot " + (gameCountChoice - 1));
                    manager.saveAccounts();
                    break;
                case 'd':
                    if(accountGames.isEmpty()){
                        System.out.println("| No game found! Nothing to delete");
                        break;
                    }

                    selectGame();
                    System.out.println("----------------------------------");
                    int toDelete = OptionSelect.intInput(-1);
                    System.out.println("----------------------------------");

                    if(toDelete == -1){
                        System.out.println("Cancelling game deletion...");
                        break;
                    }

                    if(accountGames.get(toDelete) == null){
                        System.out.println("Game not found! ");
                        break;
                    }
                    accountGames.get(toDelete).deleteData();
                    System.out.println("| Game \"" + accountGames.get(toDelete).getName() + "\" Deleted");
                    System.out.println("----------------------------------");
                    accountGames.remove(toDelete);
                    manager.saveAccounts();
                    break;
                case 'l':

                    if(accountGames.isEmpty()){
                        System.out.println("| No game found! Start a new game");
                        break;
                    }

                    selectGame();

                    int toEnter = OptionSelect.intInput(-1);

                    if(accountGames.get(toEnter) == null){
                        System.out.println("| Game not found! ");
                        break;
                    }

                    System.out.println("| Entering Eternaspire >>");
                    accountGames.get(toEnter).gameStart();
                    
                    break;
                default:
                    System.out.println("! ! Invalid input ! !");
                    break;
            }

            




        }

    }

}
