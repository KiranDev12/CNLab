import java.util.ArrayList;
import java.util.Scanner;

public class rsa {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int findCoprime(int phi) {
        int e = 2;
        while (e < phi) {
            if (gcd(e, phi) == 1) {
                return e;
            }
            e++;
        }
        return -1;
    }

    public static int findPrivateKey(int e, int phi) {
        int d = 0;
        int k = 1;
        while (true) {
            d = (1 + (k * phi)) / e;
            if (d * e % phi == 1) {
                return d;
            }
            k++;
        }
    }

    public static int modularExp(int base, int exponent, int mod) {
        int result = 1;
        base = base % mod;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % mod;
            }
            exponent = exponent >> 1;
            base = (base * base) % mod;
        }
        return result;
    }

    public static ArrayList<Integer> rsaEncrypt(String plaintext, int e, int n) {
        ArrayList<Integer> ciphertext = new ArrayList<>();
        for (char c : plaintext.toCharArray()) {
            ciphertext.add(modularExp((int) c, e, n));
        }
        return ciphertext;
    }

    public static String rsaDecrypt(ArrayList<Integer> ciphertext, int d, int n) {
        StringBuilder plaintext = new StringBuilder();
        for (int i : ciphertext) {
            plaintext.append((char) modularExp(i, d, n));
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int p = 109;
        int q = 137;

        int n = p * q;
        int phi = (p - 1) * (q - 1);

        int e = findCoprime(phi);

        int d = findPrivateKey(e, phi);

        System.out.print("Enter plaintext: ");
        String plaintext = scanner.nextLine();

        ArrayList<Integer> ciphertext = rsaEncrypt(plaintext, e, n);

        System.out.print("Ciphertext: ");
        for (int i : ciphertext) {
            System.out.print(i + " ");
        }
        System.out.println();

        String decryptedText = rsaDecrypt(ciphertext, d, n);

        System.out.println("Decrypted Text: " + decryptedText);

        scanner.close();
    }
}
