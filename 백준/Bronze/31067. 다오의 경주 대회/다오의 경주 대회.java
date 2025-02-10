import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        if (N == 1)
            System.out.println(0);
        else System.out.println(solve(A, N, K));
    }

    static int solve(int[] A, int N, int K) {
        int ans = 0;

        for (int i = 0; i < N - 1; i++) {
            if (A[i] >= A[i + 1]) {
                ans++;
                A[i + 1] += K;
            }

            if (i > 0 && A[i - 1] >= A[i]) return -1;
        }

        if (A[N - 2] >= A[N - 1])
            return -1;

        return ans;
    }

}