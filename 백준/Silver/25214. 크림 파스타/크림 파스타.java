import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int minVal = Integer.parseInt(st.nextToken());
        int[] dp = new int[N];
        dp[0] = 0;

        for (int i = 1; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());

            dp[i] = Math.max(dp[i - 1], x - minVal);

            if (x < minVal) {
                minVal = x;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int v : dp) {
            sb.append(v).append(' ');
        }
        System.out.print(sb);
    }
}
