import java.util.*;
import java.io.*;
import java.math.*;

public class rsa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int bitlength = 128;
        BigInteger p = BigInteger.probablePrime(bitlength, r);
        BigInteger q = BigInteger.probablePrime(bitlength, r);
        BigInteger n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = BigInteger.probablePrime(bitlength / 2, r);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0) {
            e.add(BigInteger.ONE);
        }
        BigInteger d = e.modInverse(phi);
        System.out.println("Enter the string: ");
        String msg = sc.nextLine();
        BigInteger data = new BigInteger(msg.getBytes());
        byte[] cipher = data.modPow(e, n).toByteArray();
        for (int i = 0; i < cipher.length; i++) {
            System.out.print(cipher[i]);
        }
        System.out.println();
        BigInteger text = new BigInteger(cipher);
        byte[] decrypted = text.modPow(d, n).toByteArray();
        System.out.println("The original string is "+ new String(decrypted));
        sc.close();
    }
}