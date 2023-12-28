import java.net.*;
import java.io.*;
import java.util.*;

public class tcpclient {
    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("localhost", 4000);
        Scanner inFromServer = new Scanner(new InputStreamReader(clientSocket.getInputStream()));
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();
        outToServer.writeBytes(fileName + '\n');
        String fileContent = inFromServer.nextLine();
        System.out.println("Server response:\n" + fileContent);
        clientSocket.close();
        sc.close();
    }
}