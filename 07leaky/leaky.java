import java.util.Scanner;

public class leaky {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of queries: ");
        int noOfQueries = scanner.nextInt();
        System.out.println("Enter the bucket size: ");
        int bucketSize = scanner.nextInt();
        int inputPacketSize;
        System.out.println("Enter the constant output rate: ");
        int outputPacketSize = scanner.nextInt();
        int storedBufferSize = 0;
        int sizeLeft;

        for (int i = 0; i < noOfQueries; i++) {
            System.out.print("Input Packet Size: ");
            inputPacketSize = scanner.nextInt();

            sizeLeft = bucketSize - storedBufferSize;
            if (inputPacketSize <= sizeLeft) {
                storedBufferSize += inputPacketSize;
            } else {
                System.out.println("Packet Dropped");
            }
            System.out.println("Stored Buffer Size: " + storedBufferSize);
            storedBufferSize -= outputPacketSize;
            System.out.println("---------------");
            System.out.println(outputPacketSize + " packets sent ...");
            System.out.println("---------------");
        }
        scanner.close();
    }
}