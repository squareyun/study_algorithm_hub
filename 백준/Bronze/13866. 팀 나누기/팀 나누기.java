import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[4];
        int total = 0;
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                int sum = arr[i] + arr[j];
                ans = Math.min(ans, Math.abs((total - sum) - sum));
            }
        }
        System.out.println(ans);
    }

}