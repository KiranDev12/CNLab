import java.util.ArrayList;
import java.util.Scanner;

class Frame {
    int seqno;
    int data;

    Frame(int data, int seqno) {
        this.data = data;
        this.seqno = seqno;
    }
}

public class sort {
    public static void main(String[] args) {
        ArrayList<Frame> frames = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of frames: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter the data of the " + i + " frame: ");
            int data = sc.nextInt();
            int seqno = (int) (Math.random() * 100);
            frames.add(new Frame(data, seqno));
        }
        System.out.println("The frame list before sorting is: ");
        System.out.println("Number|Data");
        for (Frame frame : frames) {
            System.out.println(frame.seqno + "    |   " + frame.data);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (frames.get(j).seqno > frames.get(j + 1).seqno) {
                    Frame temp = frames.get(j);
                    frames.set(j, frames.get(j + 1));
                    frames.set(j + 1, temp);
                }
            }
        }
        System.out.println("The frame list after sorting is: ");
        System.out.println("Number|Data");
        for (Frame frame : frames) {
            System.out.println(frame.seqno + "    |   " + frame.data);
        }
        sc.close();
    }
}
