import java.util.*;

public class Cypher {

	public static void main(final String[] args) {
        Encrypt e = new Encrypt();
        Decrypt d = new Decrypt();
        char c = 'i';
        Scanner scan = new Scanner(System.in);

        while (c  != 'e' && c != 'd') {
            System.out.println("Encrypt or Decrypt?");
            System.out.println("Type \"e\" or \"d\"");
            c=scan.next().charAt(0);
        }
        if(c=='e')
            System.out.println(e.run());
        else
            System.out.println(d.run());

    }

}