import java.net.*;
import java.util.Scanner;

class udpserver {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress clientAddress = InetAddress.getByName("127.0.0.1");
        String message;
        byte[] buffer;
        DatagramPacket datagramPacket;
        int cnt = 0;
        System.out.println("Enter messages to send: ");
        while (true) {
            message = in.nextLine();
            buffer = message.getBytes();
            datagramPacket = new DatagramPacket(buffer, buffer.length, clientAddress, 4000);
            datagramSocket.send(datagramPacket);
            cnt++;
            if (cnt == 999)
                break;
        }
        in.close();
        datagramSocket.close();
    }
}

// import java.net.*;

// class udpclient {
//     public static void main(String args[]) throws Exception {
//         DatagramSocket datagramSocket = new DatagramSocket(4000);
//         byte[] buffer;
//         DatagramPacket datagramPacket;
//         System.out.println("Received Messages: ");
//         int cnt = 0;
//         while (true) {
//             buffer = new byte[65555];
//             datagramPacket = new DatagramPacket(buffer, buffer.length);
//             datagramSocket.receive(datagramPacket);
//             String received = new String(buffer).trim();
//             System.out.println(received);
//             cnt++;
//             if (cnt == 999)
//                 break;
//         }
//         datagramSocket.close();
//     }
// }
