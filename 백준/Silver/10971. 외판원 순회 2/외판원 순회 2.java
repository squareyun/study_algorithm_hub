import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int ans = Integer.MAX_VALUE;
    static int[][] W;

    static int[] arr;
    static int[] brr;
    static boolean[] v;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W = new int[N][N];
        arr = new int[N];
        brr = new int[N];
        v = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                W[i][j] = sc.nextInt();
            }
            arr[i] = i;
        }

        dfs(0); // 순열
        System.out.println(ans);
    }

    private static void dfs(int cnt) {
        if (cnt == N) {
            int sum = 0;
            for (int i = 1; i < N; i++) {
                if (W[brr[i-1]][brr[i]] == 0) return;
                sum += W[brr[i - 1]][brr[i]];
            }
            if (W[brr[N - 1]][brr[0]] == 0) return;
            sum += W[brr[N - 1]][brr[0]];
            if (ans > sum) {
                ans = sum;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (v[i]) {
                continue;
            }

            brr[cnt] = arr[i];
            v[i] = true;
            dfs(cnt + 1);
            v[i] = false;
        }
    }

}