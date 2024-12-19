import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int ans = 0;
        int ansDiff = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            int sum = arr[i];
            for (int j = 0; j < i; j++) {
                sum += arr[j];
            }
            int diff = Math.abs(100 - sum);
            if (ansDiff > diff) {
                ansDiff = diff;
                ans = sum;
            } else if (ansDiff == diff) {
                ans = Math.max(ans, sum);
            }
        }
        System.out.println(ans);
    }
}