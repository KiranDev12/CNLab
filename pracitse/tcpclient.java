import java.util.*;
import java.io.*;
import java.net.*;
import java.nio.file.*;

public class tcpclient {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("localhost", 4000);
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(new InputStreamReader(client.getInputStream()));
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        System.out.println("Enter the file name: ");
        String fname = sc.nextLine();
        output.writeBytes(fname + '\n');
        String fileContent = input.nextLine();
        System.out.println("Server response:\n" + fileContent);
        sc.close();
        client.close();
    }
}
