import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int l = 0;
        int r = N - 1;
        int gap = Integer.MAX_VALUE;
        int ans1 = 0, ans2 = 0;

        while (l < r) {
            int sum = arr[l] + arr[r];

            if (Math.abs(sum) < gap) {
                gap = Math.abs(sum);
                ans1 = arr[l];
                ans2 = arr[r];
            }

            if (sum > 0) r--;
            else l++;
        }

        System.out.println(ans1 + " " + ans2);
    }
}