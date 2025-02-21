import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] arr, brr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long F = Long.parseLong(br.readLine());
        long base = (N / 100) * 100;
        for (int i = 0; i < 100; i++) {
            if ((base + i) % F == 0) {
                System.out.println(i > 9 ? i : "0" + i);
                break;
            }
        }
    }

}