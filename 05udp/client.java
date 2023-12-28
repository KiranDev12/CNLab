import java.net.*;

class client {
    public static void main(String args[]) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(4000);
        byte[] buffer;
        DatagramPacket datagramPacket;
        System.out.println("Received Messages: ");
        int cnt = 0;
        while (true) {
            buffer = new byte[65555];
            datagramPacket = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(datagramPacket);
            String received = new String(buffer).trim();
            System.out.println(received);
            cnt++;
            if (cnt == 999)
                break;
        }
        datagramSocket.close();
    }
}