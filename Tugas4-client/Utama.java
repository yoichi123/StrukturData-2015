import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Utama {
    public static void main(String[] args) {
        try {
            Scanner in = new  Scanner(System.in);
            DomainSiapa tanya = new DomainSiapa();
            System.out.print("Kata:");
            String kirim= in.nextLine();
            tanya.whois(kirim);
        }
        catch (UnknownHostException ex) {
            System.err.println(ex);
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
