import java.io.*;
import java.math.*;
import java.util.*;

public class rsa {
    public static void main(String[] args) throws IOException {
        int bitLength = 128;
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the plain text: ");
        String input = sc.nextLine();
        System.out.println("Input string: " + input);

        BigInteger p = BigInteger.probablePrime(bitLength, r);
        BigInteger q = BigInteger.probablePrime(bitLength, r);
        BigInteger N = p.multiply(q); // p * q
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)); // (p-1) * (q-1)
        BigInteger e = BigInteger.probablePrime(bitLength / 2, r); // e another random prime

        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0) {
            e = e.add(BigInteger.ONE); // e++
        }
        BigInteger d = e.modInverse(phi); // private key is inverse of public key in phi

        BigInteger inputBigInt = new BigInteger(input.getBytes());
        byte[] cipher = inputBigInt.modPow(e, N).toByteArray(); // cipher = (msg)^e % N
        System.out.println("Ciphertext is: ");
        for (int i = 0; i < cipher.length; i++) {
            System.out.print(cipher[i] + " ");
        }
        BigInteger cipherBigInt = new BigInteger(cipher);
        byte[] decrypted = cipherBigInt.modPow(d, N).toByteArray(); // plain = (cipher)^d % N
        System.out.println("\nOriginal string is: " + new String(decrypted));
        sc.close();
    }
}