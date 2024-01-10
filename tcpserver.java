import java.net.*;
import java.io.*;
import java.util.*;
import java.nio.file.*;

public class tcpserver {
    public static void main(String[] args) throws Exception {
        ServerSocket sersock = new ServerSocket(4000);
        System.out.println("Server Connected, waiting for client");
        Socket sock = sersock.accept();
        System.out.println("Connection successful, waiting for filename");
        Scanner in = new Scanner(new InputStreamReader(sock.getInputStream()));
        PrintWriter pwrite = new PrintWriter(sock.getOutputStream(), true);
        String fname = in.nextLine();
        Files.lines(Paths.get(fname)).forEach(pwrite::println);
        System.out.println("Closing connection");
        Thread.sleep(1000);
        in.close();
        sock.close();
        sersock.close();
    }
}

// import java.net.*;
// import java.io.*;
// import java.util.*;

// public class tcpclient {
//     public static void main(String[] args) throws Exception {
//         Socket clientSocket = new Socket("localhost", 4000);
//         Scanner sc = new Scanner(System.in);
//         Scanner in = new Scanner(new InputStreamReader(clientSocket.getInputStream()));
//         DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
//         System.out.print("Enter file name: ");
//         String fileName = sc.nextLine();
//         out.writeBytes(fileName + '\n');
//         // String fileContent = in.nextLine();
//         StringBuilder fileContent = new StringBuilder();
//         while (in.hasNextLine()) {
//             fileContent.append(in.nextLine()).append("\n");
//         }
//         System.out.println("Server response:\n" + fileContent);
//         clientSocket.close();
//     }
// }