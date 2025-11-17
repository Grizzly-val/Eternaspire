package engine;

import ui.OptionSelect;
import ui.TextTyper;

public class Main {
    public static void main(String[] args){

        

        System.out.println();
        TextTyper.typeText("Welcome, to Eternaspire! ⏳", 50, false);
        System.out.println();
        System.out.println();

        AccountManager accManager = new AccountManager();

        char choice = '\0';
        while(choice != 'e'){
            System.out.println("----------------------------------");
            System.out.println("| Home menu |");
            System.out.println("-------------");
            System.out.println("[p] - play          ⚔️");
            System.out.println("[e] - exit game     ⚔️");
            System.out.println("----------------------------------");
            choice = OptionSelect.charInput(choice);
            System.out.println("------------------------------------");
            System.out.println();
            switch(choice){
                case 'e':
                    System.out.println();
                    accManager.saveAccounts();
                    System.exit(0);
                    break;
                case 'p':
                    System.out.println("| Do you have an existing account? |");
                    System.out.println("------------------------------------");
                    System.out.print("| Confirm >> ");
                    String username = "";
                    String password = "";
                    if(OptionSelect.yesOrNo()){
                        System.out.println("----------------------------------");
                        if(accManager.getSavedAccounts().isEmpty()){
                            System.out.println();
                            System.out.println("| No accounts in record");
                            System.out.println();
                            break;
                        }
                        System.out.println("== Accessing Account ==");
                        System.out.println("----------------------------------");
                        System.out.print("Please enter username : ");
                        username = OptionSelect.stringInput("\0");
                        System.out.print("Please enter password : ");
                        password = OptionSelect.stringInput("\0");
                        System.out.println("----------------------------------");
                        accManager.enterAccount(username, password);
                    
                    } else{
                        System.out.println("----------------------------------");
                        boolean temp = false;
                        System.out.println("== Creating Account ==");
                        System.out.println("----------------------------------");
                        System.out.print("Please enter username : ");
                        username = OptionSelect.stringInput("\0");
                        System.out.print("Please enter password : ");
                        password = OptionSelect.stringInput("\0");
                        System.out.print("| Confirm Account Creation >> ");
                        temp = OptionSelect.yesOrNo();
                        System.out.println("----------------------------------");

                        if(temp) accManager.createAccount(username, password);
                        else System.out.println("\n| Cancelling account creation\n");

                    }
            }
        }
    }
}