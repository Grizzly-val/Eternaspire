package ui;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class OptionSelect {
    private final static Scanner SC = new Scanner(System.in);


    public static int intInput(int n){
            System.out.print("| Enter choice: ");

            try{
                n = SC.nextInt();
                AudioPlayer.playOverlay("click.wav");
            }catch(InputMismatchException ime){
                System.out.println("\n!! Oops! Invalid Input !!\n");
                SC.nextLine();
                AudioPlayer.playOverlay("error.wav");
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
                AudioPlayer.playOverlay("click.wav");
            }catch(InputMismatchException ime){
                System.out.println("\n!! Oops! Invalid Input !!\n");
                AudioPlayer.playOverlay("error.wav");
                index = -1;
                SC.nextLine();
            }
            if(index <= 0 || index > size && (index != -1)){
                System.out.println("\n!! Oops! Invalid index !!\n");
                AudioPlayer.playOverlay("error.wav");
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
            AudioPlayer.playOverlay("click.wav");
        }catch(Exception e){
            System.out.println("\n!! Oops! Invalid Input !!\n");
            AudioPlayer.playOverlay("error.wav");
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
                AudioPlayer.playOverlay("click.wav");
            }catch(Exception e){
                System.out.println("\n!! Oops! Invalid Input !!\n");
                AudioPlayer.playOverlay("error.wav");
                continue;
            }

            if(choice == 'y') return true;
            else if(choice == 'n') return false;
            else{
                AudioPlayer.playOverlay("error.wav");
                System.out.println("\n!! Invalid choice. Please enter y or n !!");
            }
        }
    }

    public static String stringInput(String s){
        try{
            s = SC.nextLine();
            AudioPlayer.playOverlay("enter.wav");
        }catch(Exception e){
            System.out.println("\n!! Oops! Invalid Input !!\n");
            AudioPlayer.playOverlay("error.wav");
            return "";
        }
        return s;
    }

    public static void waiter(){
        System.out.print("| Press Enter to Continue >> ");
        SC.nextLine();
        AudioPlayer.playOverlay("click.wav");
        System.out.println();
        System.out.println();
    }

}
