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
        Scanner nameRead = new Scanner(new InputStreamReader(sock.getInputStream()));
        PrintWriter pwrite = new PrintWriter(sock.getOutputStream(), true);
        String fname = nameRead.nextLine();
        Files.lines(Paths.get(fname)).forEach(pwrite::println);
        System.out.println("Closing connection");
        nameRead.close();
        sock.close();
        sersock.close();
    }
}