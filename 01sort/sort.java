import java.util.ArrayList;
import java.util.Scanner;

public class sort {
    static class Frame {
        int frameNo;
        int data;

        public Frame(int frameNo, int data) {
            this.frameNo = frameNo;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        ArrayList<Frame> frameList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of frames:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int x = (int) (Math.random() * 100);
            System.out.println("Enter the data of the frame(" + x + "):");
            int data = scanner.nextInt();
            frameList.add(new Frame(x, data));
        }

        System.out.println("Before sorting frames:");
        for (Frame frame : frameList) {
            System.out.println("Frame" + frame.frameNo + ": data is: " + frame.data);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (frameList.get(j).frameNo > frameList.get(j + 1).frameNo) {
                    Frame temp = frameList.get(j);
                    frameList.set(j, frameList.get(j + 1));
                    frameList.set(j + 1, temp);
                }
            }
        }

        System.out.println("After sorting frames:");
        for (Frame frame : frameList) {
            System.out.println("Frame" + frame.frameNo + ": data is: " + frame.data);
        }

        scanner.close();
    }
}
