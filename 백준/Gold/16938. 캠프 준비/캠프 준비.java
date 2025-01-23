import java.util.*;
import java.io.*;

public class Main {

    static int N, L, R, X, ans;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        ans = 0;
        solve();
        System.out.println(ans);

    }

    static void solve() {

        int cnt, l, r, sum;

        for (int i = 1; i < (1 << N); i++) {
            cnt = 0;
            l = Integer.MAX_VALUE;
            r = Integer.MIN_VALUE;
            sum = 0;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    cnt++;
                    l = Math.min(l, A[j]);
                    r = Math.max(r, A[j]);
                    sum += A[j];
                }
            }

            if (cnt < 2 || sum < L || sum > R || r - l < X) continue;
            ans++;
        }
    }

}