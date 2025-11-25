package ui;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class OptionSelect {
    private final static Scanner SC = new Scanner(System.in);


    public static int intInput(int n){
            System.out.print("| Enter choice: ");

            try{
                n = SC.nextInt();
            }catch(InputMismatchException ime){
                System.out.println("\n!! Error - " + ime + " !!");
                SC.nextLine();
                return -1;
            }
            SC.nextLine();
            return n;
    }

    public static int getArrIndex(int size){
        int index = -1;

        while(index <= 0 || index > size){
            try{
                System.out.print("| Choose: ");
                index = SC.nextInt();
            }catch(InputMismatchException ime){
                System.out.println("\n!! Error - " + ime + " !!");
                index = -1;
                SC.nextLine();
            }
            if(index <= 0 || index > size){
                System.out.println("!! Invalid index !!");
                System.out.println();
            }
        }
        SC.nextLine();
        return index;
    }

    public static char charInput(char c){
        try{
            System.out.print("| Choose: ");
            c = SC.nextLine().charAt(0);
        }catch(Exception e){
            System.out.println("\n!! Error - " + e + " !!");
            return '\0';
        }
        return c;
    }

    public static boolean yesOrNo(){
        char choice = '\0';

        while(true){
            try{
                System.out.print("| (y/n): ");
                choice = SC.nextLine().trim().toLowerCase().charAt(0);
            }catch(Exception e){
                System.out.println("\n!! Error - " + e + " !!");
                continue;
            }

            if(choice == 'y') return true;
            else if(choice == 'n') return false;
            else{
                System.out.println("\n!! Invalid choice. Please enter y or n !!");
            }
        }
    }

    public static String stringInput(String s){
        try{
            s = SC.nextLine();
        }catch(Exception e){
            System.out.println("\n!! Error - " + e + " !!");
            return "";
        }
        return s;
    }

    public static void waiter(){
        System.out.print("| Press Enter to Continue >> ");
        SC.nextLine();
        System.out.println();
        System.out.println();
    }

}
