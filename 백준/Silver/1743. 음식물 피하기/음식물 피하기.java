import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int[][] map = new int[N][M];
        boolean[][] v = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            map[a][b] = 1;
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<Integer[]> q;
        Integer[] cur;
        int nx, ny;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (v[i][j]) {
                    continue;
                }

                int cnt = 0;
                if (map[i][j] == 1) {
                    q = new ArrayDeque<>();
                    q.offer(new Integer[]{i, j});
                    v[i][j] = true;

                    while (!q.isEmpty()) {
                        cur = q.poll();

                        cnt++;

                        for (int d = 0; d < 4; d++) {
                            nx = cur[0] + dx[d];
                            ny = cur[1] + dy[d];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                                continue;
                            }

                            if (v[nx][ny]) {
                                continue;
                            }

                            if (map[nx][ny] == 1) {
                                v[nx][ny] = true;
                                q.offer(new Integer[]{nx, ny});
                            }
                        }
                    }
                }

                if (ans < cnt) {
                    ans = cnt;
                }
            }
        }

        System.out.println(ans);
    }
}