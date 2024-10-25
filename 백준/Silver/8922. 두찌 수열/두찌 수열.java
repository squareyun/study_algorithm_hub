import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            if (check(arr, n)) sb.append("ZERO");
            else sb.append("LOOP");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean check(int[] arr, int n) {
        int cnt = 0;
        do {
            cnt++;

            int[] brr = new int[n];
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                brr[i] = Math.abs(arr[i + 1] - arr[i]);
                sum += brr[i];
            }
            brr[n - 1] = Math.abs(arr[n - 1] - arr[0]);
            sum += brr[n - 1];

            arr = Arrays.copyOf(brr, n);

            if (sum == 0)
                return true;

        } while (cnt < 1000);

        return false;
    }
}