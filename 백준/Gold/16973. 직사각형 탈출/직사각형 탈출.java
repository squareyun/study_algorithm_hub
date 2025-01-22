import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int H, W, sx, sy, fx, fy;

    static List<Pos> walls;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        walls = new ArrayList<>();
        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    map[i][j] = -1;
                    walls.add(new Pos(i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        fx = Integer.parseInt(st.nextToken());
        fy = Integer.parseInt(st.nextToken());

        ans = -1;
        bfs();
        System.out.println(ans);
    }

    private static void bfs() {
        Queue<Pos> q = new ArrayDeque<>();
        boolean[][] v = new boolean[N + 1][M + 1];
        q.add(new Pos(sx, sy));
        v[sx][sy] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            if (cur.x == fx && cur.y == fy) {
                ans = map[cur.x][cur.y];
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 1 || nx > N || ny < 1 || ny > M) continue;
                if (v[nx][ny]) continue;
                if (!isValid(nx, ny)) continue;

                if (map[nx][ny] == 0) {
                    q.add(new Pos(nx, ny));
                    v[nx][ny] = true;
                    map[nx][ny] = map[cur.x][cur.y] + 1;
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        // 사각형 범위
        if (x + H - 1 > N || y + W - 1 > M)
            return false;

        // 벽 존재 여부
        for (Pos wall : walls) {
            int wx = wall.x;
            int wy = wall.y;

            if (wx >= x && wx <= x + H - 1 && wy >= y && wy <= y + W - 1) {
                return false;
            }
        }

        return true;
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}