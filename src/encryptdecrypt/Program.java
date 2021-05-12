import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Encryption protect = new Encryption();
        // Atbash Cipher
        String phrase = "we found a treasure!";
        System.out.println(protect.atbashCipher(phrase));

        System.out.println(protect.reverseABCEncryption(phrase));
    }
}
