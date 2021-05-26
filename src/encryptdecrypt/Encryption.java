import java.util.Scanner;

public class Encryption {

    final private char[] abc;
    final private char[] cba;
    private String mode;
    private int key;
    private String data;

    public Encryption() {
        this.abc = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        this.cba = new char[]{'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n',
                'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
        this.mode = "enc";
        this.key = 0;
        this.data = "";
    }

    public void setMode(String option) {
        this.mode = option.isEmpty() ? "enc" : option;
    }

    public String getMode() {
        return mode;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setData(String data) {
        this.data = data.isEmpty() ? "" : data;
    }

    public String getData() {
        return data;
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

    public String encrypt(String phrase, int offset) {
        StringBuilder encrypted = new StringBuilder();

        for (char character : phrase.toCharArray()) {
            int currentPos = character - ' ';
            int newPos = (currentPos + offset) % 126; //94 is the Unicode difference from SPACE to ~
            char newChar = (char)(' ' + newPos);
            encrypted.append(newChar);
        }
        return encrypted.toString();
    }

    public String decrypt(String phrase, int offset) {
        return encrypt(phrase, 126 - (offset % 126));
    }
}
