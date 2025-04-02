import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int l = 0, r = N - 1;
        int cnt = 0;
        while (l < r) {
            int sum = arr[l] + arr[r];

            if (sum == M) {
                cnt++;
                l++;
                r--;
            } else if (sum < M) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println(cnt);
    }

}