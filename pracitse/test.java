import java.util.*;

public class test {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the stream of bits of data: ");
        String polynomial = sc.nextLine();
        System.out.println("Enter the divisor: ");
        String divisor = sc.nextLine();
        int[] data = new int[polynomial.length() + divisor.length() - 1];
        int[] generator = new int[divisor.length()];
        for (int i = 0; i < polynomial.length(); i++) {
            data[i] = polynomial.charAt(i) - '0';
        }
        for (int i = 0; i < divisor.length(); i++) {
            generator[i] = divisor.charAt(i) - '0';
        }
        for (int i = 0; i < polynomial.length(); i++) {
            if (data[i] == 1) {
                for (int j = 0; j < divisor.length(); j++) {
                    data[i + j] ^= generator[j];
                }
            }
        }
        System.out.print("The checksum code is: ");
        for (int i = 0; i < polynomial.length(); i++)
            data[i] = polynomial.charAt(i) - '0';
        for (int i = 0; i < data.length; i++)
            System.out.print(data[i]);
        System.out.println();

        System.out.println("Enter the CRC: ");
        polynomial = sc.nextLine();
        System.out.println("Enter the divisor: ");
        divisor = sc.nextLine();
        data = new int[polynomial.length() + divisor.length() - 1];
        generator = new int[divisor.length()];
        for (int i = 0; i < polynomial.length(); i++) {
            data[i] = polynomial.charAt(i) - '0';
        }
        for (int i = 0; i < divisor.length(); i++) {
            generator[i] = divisor.charAt(i) - '0';
        }
        for (int i = 0; i < polynomial.length(); i++) {
            if (data[i] == 1) {
                for (int j = 0; j < divisor.length(); j++) {
                    data[i + j] ^= generator[j];
                }
            }
        }

        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) {
                System.out.println("The stream of data is corrupted");
                return;
            }
        }
        System.out.println("Data stream is valid");
        sc.close();
    }
}