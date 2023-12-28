import java.util.Scanner;

public class token {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int tokens = 0;
        System.out.println("Enter the rate at which tokens must be added: ");
        int rate = scanner.nextInt(); 
        System.out.println("Enter the capacity of the bucket: ");
        int capacity = scanner.nextInt();

        System.out.print("Enter number of requests: ");
        int n = scanner.nextInt();

        int[] request = new int[n];
        System.out.print("Enter the packets to be send: ");
        for (int i = 0; i < n; i++) {
            request[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            // Add tokens to the bucket at a fixed rate
            tokens = Math.min(tokens + rate, capacity);

            // Wait for 1 second
            Thread.sleep(1000);

            if (tokens >= request[i]) {
                // Remove the requested tokens from the bucket
                tokens -= request[i];
                System.out.println("Request granted, tokens remaining: " + tokens);
            } else {
                System.out.println("Request denied");
            }
        }
        scanner.close();
    }
}