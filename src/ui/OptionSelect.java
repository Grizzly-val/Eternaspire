package ui;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class OptionSelect {
    static Scanner sc = new Scanner(System.in);


    public static int intInput(int n){
            System.out.print("Enter choice: ");

            try{
                n = sc.nextInt();
                System.out.println();
            }catch(InputMismatchException ime){
                System.out.println("\nError!\n" + ime);
                sc.nextLine();
                return -1;
            }
            sc.nextLine();
            return n;
    }

    public static char charInput(char c){
        try{
            System.out.print("Choose: ");
            c = sc.nextLine().charAt(0);
        }catch(Exception e){
            System.out.println(e);
            return '\0';
        }
        return c;
    }

    public static String stringInput(String s){
        try{
            System.out.print("What do you want to do here?\nChoose: ");
            s = sc.nextLine();
        }catch(Exception e){
            System.out.println(e);
            return "";
        }
        return s;
    }

}
