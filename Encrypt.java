import java.util.*;

public class Encrypt {
    private final int DIGITS_OF_PI = 100;
    private final String PI_DIGITS = "3141592653589793238462643383279502884197169399"
            + "3751058209749445923078164062862089986280348253421170679";
    private int[] PI = new int[DIGITS_OF_PI];
    private Scanner scan = new Scanner(System.in);

    public int digitOfPi(final int i) {
        return PI[i];
    }

    public Encrypt() {
        for (int i = 0; i < DIGITS_OF_PI; i++) {
            PI[i] = Integer.parseInt(PI_DIGITS.charAt(i)+"");
        }
    }

    public String run() {
        System.out.println("\nImput your desired message.\nMessage must exclusively contain lowercase alphabetic characters, spaces, and periods.\n");
        String imput = scan.nextLine().toLowerCase();
        System.out.println("");
        String output = "";
        int[] arr = convertToInt(imput);
        for (int i = 0; i<arr.length; i++) {
            if(digitOfPi(i%100)==0){
                output+=arr[i]+digitOfPi((i+1)%100)+"-";
            } else {
                output+=arr[i]*(digitOfPi(i%100))+digitOfPi((i+1)%100)+"-";
            }
        }
        return output.substring(0, output.length()-1);
    }

    private int[] convertToInt(String str) {
        int[]arr = new int[str.length()];
        //String prin="";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==' ') {
                arr[i]=27;
            } else if (str.charAt(i)=='.') {
                arr[i]=28;
            } else {
                arr[i]=(int)str.charAt(i)-96;
            }
            //prin+=arr[i]+"-";
        }
        //System.out.println(prin.substring(0,prin.length()-1));
        return arr;
    }
}