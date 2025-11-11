package ui;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class OptionSelect {
    static Scanner sc = new Scanner(System.in);


    public static int intInput(int n){
            System.out.print("Enter choice: ");

            try{
                n = sc.nextInt();
            }catch(InputMismatchException ime){
                System.out.println("\n!! Error - " + ime + " !!");
                sc.nextLine();
                return -1;
            }
            sc.nextLine();
            return n;
    }

    public static int getArrIndex(int size){
        int index = -1;

        while(index <= 0 || index > size){
            try{
                System.out.print("Choose: ");
                index = sc.nextInt();
            }catch(InputMismatchException ime){
                System.out.println("\n!! Error - " + ime + " !!");
                index = -1;
                sc.nextLine();
            }
            if(index <= 0 || index > size){
                System.out.println("!! Invalid index !!");
                System.out.println();
            }
        }
        sc.nextLine();
        return index;
    }

    public static char charInput(char c){
        try{
            System.out.print("Choose: ");
            c = sc.nextLine().charAt(0);
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
                System.out.print("(y/n): ");
                choice = sc.nextLine().trim().toLowerCase().charAt(0);
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
            System.out.print("Choose: ");
            s = sc.nextLine();
        }catch(Exception e){
            System.out.println("\n!! Error - " + e + " !!");
            return "";
        }
        return s;
    }

}
