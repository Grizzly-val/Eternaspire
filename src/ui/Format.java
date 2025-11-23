package ui;

public final class Format{
    public static String getOrdinal(int n) {
        if (n >= 11 && n <= 13) {
            return n + "th";
        }
        switch (n % 10) {
            case 1:  return n + "st";
            case 2:  return n + "nd";
            case 3:  return n + "rd";
            default: return n + "th";
        }
    }


    public static void printSection(String label){
        String temp = "|------------------------|    " + label + "    |------------------------|";
        String border = String.valueOf("=").repeat(temp.length());
        System.out.println(border);
        System.out.println(temp);
        System.out.println(border);
    }

    public static void boxify(String content){
        String temp = "     " + content + "     ";
        String border = String.valueOf("=").repeat(temp.length());
        System.out.println(border);
        System.out.println(temp);
        System.out.println(border);
    }
}