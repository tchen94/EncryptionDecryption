public class Encryption {

    final private char[] abc;
    final private char[] cba;

    public Encryption() {
        this.abc = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        this.cba = new char[]{'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n',
                'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
    }

    public String atbashCipher(String phrase) {
        StringBuilder encrypted = new StringBuilder(phrase);

        for (int x = 0; x < phrase.length(); x++) {
            for (int y = 0; y < abc.length; y++) {
                if (phrase.charAt(x) == abc[y]) {
                    encrypted.setCharAt(x, cba[y]);
                }
            }
        }
        return encrypted.toString();
    }

    public String caesarCipher(String phrase, int num) {
        StringBuilder encrypted = new StringBuilder(phrase);

        for (int x = 0; x < phrase.length(); x++) {
            for (int y = 0; y < abc.length; y++) {
                if (phrase.charAt(x) == abc[y] && y + num > abc.length) {
                    encrypted.setCharAt(x, abc[(y + num) - 26]);
                } else if (phrase.charAt(x) == abc[y]) {
                    encrypted.setCharAt(x, abc[y + num]);
                }
            }
        }
        return encrypted.toString();
    }
}
