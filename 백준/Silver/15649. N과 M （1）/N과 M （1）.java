import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] arr, brr;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        for (int i = 1; i <= N; i++) {
            arr[i - 1] = i;
        }
        brr = new int[M];
        v = new boolean[N];
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int cur) {
        if (cur == M) {
            for (int i = 0; i < M; i++) {
                sb.append(brr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (v[i]) {
                continue;
            }

            v[i] = true;
            brr[cur] = arr[i];
            dfs(cur + 1);
            v[i] = false;
        }
    }
}