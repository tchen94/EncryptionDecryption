public class Program {
    public static void main(String[] args) {
        Encryption protect = new Encryption();
        String phrase = "we found a treasure!";

        System.out.println(protect.reverseABCEncryption(phrase));
    }
}
