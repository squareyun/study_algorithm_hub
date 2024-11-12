import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (a + b + c >= 100) {
            System.out.println("OK");
        } else {
            int[] arr = {a, b, c};
            int minV = 101;
            int minIdx = -1;
            for (int i = 0; i < 3; i++) {
                if (arr[i] < minV) {
                    minV = arr[i];
                    minIdx = i;
                }
            }
            switch(minIdx) {
                case 0 -> {
                    System.out.println("Soongsil");
                }
                case 1 -> {
                    System.out.println("Korea");
                }
                case 2 -> {
                    System.out.println("Hanyang");
                }
            }
        }

    }

}