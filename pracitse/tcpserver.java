import java.util.*;
import java.io.*;
import java.net.*;
import java.nio.file.*;

public class tcpserver {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4000);
        System.out.println("Server connected waiting for client");
        Socket socket = server.accept();
        System.out.println("Wait for entry of filename");
        Scanner nameread = new Scanner(new InputStreamReader(socket.getInputStream()));
        PrintWriter pwrite = new PrintWriter(socket.getOutputStream(), true);
        String fname = nameread.nextLine();
        Files.lines(Paths.get(fname)).forEach(pwrite::println);
        server.close();
        socket.close();
        nameread.close();
    }
}
