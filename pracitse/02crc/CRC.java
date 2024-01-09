import java.util.*;

public class CRC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message: ");
        String msg = sc.nextLine();
        System.out.println("Enter the generator: ");
        String gen = sc.nextLine();
        int[] data = new int[msg.length() + gen.length() - 1];
        int[] divisor = new int[gen.length()];

        for (int i = 0; i < msg.length(); i++) {
            data[i] = msg.charAt(i) - '0';
        }
        for (int i = 0; i < gen.length(); i++) {
            divisor[i] = gen.charAt(i) - '0';
        }
        for (int i = 0; i < msg.length(); i++) {
            if (data[i] == 1) {
                for (int j = 0; j < gen.length(); j++) {
                    data[i + j] ^= divisor[j];
                }
            }
        }
        for (int i = 0; i < msg.length(); i++) {
            data[i] = msg.charAt(i) - '0';
        }
        System.out.println("Checksum is as follows: ");
        for (int i = 0; i < msg.length() + gen.length() - 1; i++) {
            System.out.print(data[i]);
        }
        System.out.println("Enter the checksum: ");
        String checksum = sc.nextLine();
        System.out.println("Enter the generator: ");
        gen = sc.nextLine();
        data = new int[checksum.length()];
        divisor = new int[gen.length()];

        for (int i = 0; i < checksum.length(); i++) {
            data[i] = checksum.charAt(i) - '0';
        }
        for (int i = 0; i < gen.length(); i++) {
            divisor[i] = gen.charAt(i) - '0';
        }
        for (int i = 0; i < msg.length(); i++) {
            if (data[i] == 1) {
                for (int j = 0; j < gen.length(); j++) {
                    data[i + j] ^= divisor[j];
                }
            }
        }
        boolean valid = true;
        for (int i = 0; i < msg.length() + gen.length() - 1; i++) {
            if (data[i] == 1) {
                valid = false;
                break;
            }
        }
        if (valid == true) {
            System.out.println("The data stream is valid");
        } else {
            System.out.println("Datastream is corrupted");
        }
        sc.close();
    }
}
