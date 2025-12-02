package engine;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import ui.TextTyper;

public class AccountManager implements Serializable{
    // This is where the critical data belongs!

    private HashMap<String, Account> savedAccounts = loadAccounts();



    public void saveAccounts() {
        
        File saveFile = new File("accounts.dat"); // Define file once

        try (FileOutputStream fileOut = new FileOutputStream(saveFile);
            ObjectOutputStream oos = new ObjectOutputStream(fileOut)) 
        {
            oos.writeObject(savedAccounts);
            System.out.println("| Accounts Successfully saved!");
            System.out.println("----------------------------------");

        } catch (FileNotFoundException e) {
            System.err.println("! ! File not found ! !");

        } catch (IOException e) {
            System.err.println("! ! An error occured ! !");
            System.err.println("! ! Failed to Save Accounts ! !");
            e.printStackTrace();
        }


    }

    public HashMap<String, Account> getSavedAccounts(){return savedAccounts;}


@SuppressWarnings("unchecked")
public HashMap<String, Account> loadAccounts() {
    File saveFile = new File("accounts.dat");
    if (!saveFile.exists()) {
        TextTyper.typeText("| No save file found. Starting fresh!", 30, true);
        return new HashMap<>(); // Start with an empty map
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFile))) {

        Object loadedObject = ois.readObject();

        if (loadedObject instanceof HashMap) {
            TextTyper.typeText("| Accounts successfully loaded!", 30, true);
            HashMap<String, Account> loaded = (HashMap<String, Account>) loadedObject;

            // Reattach manager reference to each Account and reattach Games to their Account + manager
            for (Account acc : loaded.values()) {
                acc.setManager(this);

                // reattach each Game's manager and account
                for (Game g : acc.getAccountGames().values()) {
                    // make sure game object is not null
                    if (g != null) {
                        g.setManager(this);
                        g.setAccount(acc);
                    }
                }
            }

            return loaded;
        }

    } catch (Exception e) {
        System.err.println();
        TextTyper.typeText("! ! Error loading accounts: " + e.getMessage() + " ! !", 30, true);
        System.out.println();
        // fall back to empty
    }

    return new HashMap<>();
}
  

 /* 
    public Challenger loadSavedPlayer(String playerFileName) {
        File file = new File(playerFileName);
        if (!file.exists()) return null; // no save yet

        try (FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            Challenger player = (Challenger) ois.readObject();
            return player;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
*/

    
    public void enterAccount(String username, String password){

        if(savedAccounts.get(username) == null){
            System.out.println();
            System.out.println("! ! Account not found ! !");
            System.out.println();
            return;
        }

        if(!savedAccounts.get(username).getPassword().equals(password)){
            System.out.println();
            System.out.println("Invalid password for " + username + "!");
            System.out.println();
            return;
        }

        savedAccounts.get(username).accMenu();
    }

    public void createAccount(String username, String password){

        if(username.length() <= 5 || password.length() <= 5){
            System.out.println("| Username or Password too short");
            System.out.println("| Account cannot be created");
            return;
        }
        
        if(savedAccounts.get(username) != null){
            System.out.println("! ! Account already exists ! !");
            return;
        }

        savedAccounts.put(username, new Account(username, password, this));
        saveAccounts();

    }

}
