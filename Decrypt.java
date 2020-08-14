import java.util.*;

public class Decrypt {
    private final int DIGITS_OF_PI = 100;
    private final String PI_DIGITS = "3141592653589793238462643383279502884197169399"
            + "3751058209749445923078164062862089986280348253421170679";
    private int[] PI = new int[DIGITS_OF_PI];
    private Scanner scan = new Scanner(System.in);

    public int digitOfPi(final int i) {
        return PI[i];
    }

    public Decrypt() {
        for (int i = 0; i < DIGITS_OF_PI; i++) {
            PI[i] = Integer.parseInt(PI_DIGITS.charAt(i)+"");
        }
    }

    public String run() {
        System.out.println("\nImput your encoded message.\nMessage must exclusively contain digits and dashes.\n");
        String imput = scan.nextLine().toLowerCase();
        System.out.println("");
        String output="";
        int[] arr = convertToArr(imput);
        int i = 0;
        char c;

        while (arr[i]!=-1){
            if(digitOfPi(i%100)==0) {
                arr[i]=(arr[i]-digitOfPi((i+1)%100));
            } else {
                arr[i]=(arr[i]-digitOfPi((i+1)%100))/digitOfPi(i%100);
            }
            i++;
        }
        for(int j = 0; j < i; j++) {
            if (arr[j] == 27) {
                c = ' ';
            } else if (arr[j] == 28) {
                c = '.';
            } else {
                c = (char)(arr[j]+96);
            }
            output+=c;
        }
        return output;
    }

    private int[] convertToArr(String str) {
        int[] arr = new int[str.length()];
        //This is going to be longer than necessary
        int f=0;
        int count=0;
        //String s = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '-') {
                arr[count]=Integer.parseInt(str.substring(f,i));
                f=i+1;
                //s+=arr[count]+"/";
                count++;
            }
        }
        arr[count]=Integer.parseInt(str.substring(f,str.length()));
        arr[count+1]=-1;
        //System.out.println(s);
        return arr;
    } 
}