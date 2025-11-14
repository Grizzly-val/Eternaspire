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

import entity.player.Challenger;

public class AccountManager implements Serializable{
    // This is where the critical data belongs!
    private HashMap<String, Account> savedAccounts = loadAccounts();



    public void saveAccounts() {
        
        File saveFile = new File("accounts.dat"); // Define file once

        try (FileOutputStream fileOut = new FileOutputStream(saveFile);
            ObjectOutputStream oos = new ObjectOutputStream(fileOut)) 
        {
            oos.writeObject(savedAccounts);
            System.out.println("| Accounts Successfully saved! ✅"); 

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
            System.out.println("| No save file found. Starting fresh!");
            return new HashMap<>(); // Start with an empty map
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFile))) {
            
            // This line reads the entire HashMap object from the file
            Object loadedObject = ois.readObject(); 
            
            // Safety check and cast
            if (loadedObject instanceof HashMap) {
                System.out.println("| Accounts successfully loaded!");
                return (HashMap<String, Account>) loadedObject; 
            }
            
        } catch (Exception e) {
            System.err.println("! ! Error loading accounts: " + e.getMessage() + " ! !");
            // If anything goes wrong, we fall back to a fresh start
        }
        
        return new HashMap<>();
    }    


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



    
    public void enterAccount(String username, String password){

        if(savedAccounts.get(username) == null){
            System.out.println("! ! Account not found ! !");
            return;
        }

        if(!savedAccounts.get(username).getPassword().equals(password)){
            System.out.println("Invalid password for " + username + "!");
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
