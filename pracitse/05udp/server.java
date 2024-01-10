import java.net.*;
import java.util.Scanner;

class server {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        InetAddress addr = InetAddress.getByName("127.0.0.1");
        DatagramSocket sock = new DatagramSocket();
        String msg;
        byte[] data;
        DatagramPacket packet;
        while (true) {
            System.out.println("Enter the message: ");
            msg = in.nextLine();
            data = msg.getBytes();
            packet = new DatagramPacket(data, data.length, addr, 4000);
            sock.send(packet);
        }
    }
}

