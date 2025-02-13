import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        int ans = Math.min(N, M);
        while (ans > 1) {
            for (int i = 0; i <= N - ans; i++) {
                for (int j = 0; j <= M - ans; j++) {
                    int num = map[i][j];
                    if (num == map[i][j + ans - 1] && num == map[i + ans - 1][j] && num == map[i + ans - 1][j + ans - 1]) {
                        System.out.println(ans * ans);
                        return;
                    }
                }
            }
            ans--;
        }
        System.out.println(ans * ans);
    }

}