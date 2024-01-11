import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static boolean[] v;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        v = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int cnt, int start) {
        if (cnt == N / 2) {
            answer = Math.min(answer, solve());
            return;
        }

        for (int i = start; i < N; i++) {
            if (!v[i]) {
                v[i] = true;
                dfs(cnt + 1, i + 1);
                v[i] = false;
            }
        }
    }

    static int solve() {
        int start = 0, link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (v[i] && v[j])
                    start += map[i][j] + map[j][i];
                else if (!v[i] && !v[j])
                    link += map[i][j] + map[j][i];
            }
        }

        return Math.abs(start - link);
    }
}