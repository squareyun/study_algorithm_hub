import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int cnt = 0;

        while ((cnt = check()) < 2) {
            if (cnt == 0) {
                ans = 0;
                break;
            }

            melt();
            ans++;
        }

        System.out.println(ans);
    }

    static void dfs(int x, int y, boolean[][] v) {
        v[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                continue;

            if (v[nx][ny] || map[nx][ny] == 0)
                continue;

            dfs(nx, ny, v);
        }
    }

    static int check() {
        boolean[][] v = new boolean[N][M];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !v[i][j]) {
                    dfs(i, j, v);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static void melt() {
        Queue<Pos> q = new ArrayDeque<>();

        boolean[][] v = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    q.offer(new Pos(i, j));
                    v[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            int near = 0;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;

                if (v[nx][ny] || map[nx][ny] != 0)
                    continue;

                near++;
            }

            map[cur.x][cur.y] -= near;
            if (map[cur.x][cur.y] < 0) map[cur.x][cur.y] = 0;
        }
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}