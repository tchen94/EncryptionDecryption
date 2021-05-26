import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Encryption protect = new Encryption();

        for (int x = 0; x < args.length; x++) {
            switch (args[x]) {
                case "-mode":
                    protect.setMode(args[x + 1]);
                    break;
                case "-key":
                    protect.setKey(Integer.parseInt(args[x + 1]));
                    break;
                case "-data":
                    protect.setData(args[x + 1]);
                    break;
            }
        }

        switch (protect.getMode()) {
            case "enc":
                System.out.println(protect.encrypt(protect.getData(), protect.getKey()));
                break;
            case "dec":
                System.out.println(protect.decrypt(protect.getData(), protect.getKey()));
                break;
        }
    }
}
