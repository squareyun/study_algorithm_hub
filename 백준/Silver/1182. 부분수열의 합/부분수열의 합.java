import java.util.Scanner;

public class Main {

    static int N, S, ans;
    static int[] arr;
    static boolean[] v;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        v = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        if (S == 0) ans--; // 공집합 제거
        dfs(0, 0);

        System.out.println(ans);

    }

    private static void dfs(int cur, int sum) {
        if (cur == N) {
            if (sum == S) ans++;
            return;
        }

        v[cur] = true;
        dfs(cur + 1, sum + arr[cur]);
        v[cur] = false;
        dfs(cur + 1, sum);
    }
}