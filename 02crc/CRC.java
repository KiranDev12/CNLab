import java.util.Scanner;

public class CRC {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // Input Data Stream
        System.out.print("Enter message to be transmitted(in bits): ");
        String message = sc.nextLine();
        System.out.print("Enter divisor: ");
        String generator = sc.nextLine();

        int data[] = new int[message.length() + generator.length() - 1];
        // the whole divident is of length message + (divisor-1) -- padding of 0s
        int divisor[] = new int[generator.length()];

        for (int i = 0; i < message.length(); i++)
            data[i] = message.charAt(i) - '0';

        for (int i = 0; i < generator.length(); i++)
            divisor[i] = generator.charAt(i) - '0';

        // Calculation of CRC
        for (int i = 0; i < message.length(); i++) {
            if (data[i] == 1)
                for (int j = 0; j < divisor.length; j++)
                    data[i + j] ^= divisor[j];
        }

        // Display CRC
        System.out.print("The checksum code is: ");
        for (int i = 0; i < message.length(); i++)
            data[i] = message.charAt(i) - '0';
        for (int i = 0; i < data.length; i++)
            System.out.print(data[i]);
        System.out.println();

        // Check for input CRC code
        System.out.print("Enter checksum code: ");
        message = sc.nextLine();
        System.out.print("Enter generator: ");
        generator = sc.nextLine();
        
        data = new int[message.length() + generator.length() - 1];
        divisor = new int[generator.length()];
        for (int i = 0; i < message.length(); i++)
            data[i] = message.charAt(i) - '0';
        for (int i = 0; i < generator.length(); i++)
            divisor[i] = generator.charAt(i) - '0';

        // Calculation of remainder
        for (int i = 0; i < message.length(); i++) {
            if (data[i] == 1)
                for (int j = 0; j < divisor.length; j++)
                    data[i + j] ^= divisor[j];
        }

        boolean valid = true;
        for (int i = 0; i < data.length; i++)
            if (data[i] == 1) {
                valid = false;
                break;
            }

        if (valid == true)
            System.out.println("Data stream is valid");
        else
            System.out.println("Data stream is invalid. CRC error occurred.");
        sc.close();
    }
}
