import java.util.Scanner;

public class leaky {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of queries: ");
        int n = scanner.nextInt();
        System.out.println("Enter the bucket size: ");
        int size = scanner.nextInt();
        int packetSize;
        System.out.println("Enter the constant output rate: ");
        int constantOutput = scanner.nextInt();
        int buffer = 0;
        int sizeLeft;
        for (int i = 0; i < n; i++) {
            System.out.print("Input Packet Size: ");
            packetSize = scanner.nextInt();
            sizeLeft = size - buffer;
            if (packetSize <= sizeLeft) {
                buffer += packetSize;
                buffer -= constantOutput;
            } else {
                System.out.println("Packet Dropped");
            }
            System.out.println("Stored Buffer Size: " + buffer);
        }
        scanner.close();
    }
}