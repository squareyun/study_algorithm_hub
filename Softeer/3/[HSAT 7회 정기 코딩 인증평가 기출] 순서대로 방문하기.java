import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] v;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer;
    static Pos start;

    static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        v = new boolean[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=2; i<m+2; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            // target.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            map[x][y] = i;
            if (i == 2) start = new Pos(x, y);
        }

        v[start.x][start.y] = true;
        dfs(start.x, start.y, 3);
        System.out.println(answer);
    }

    static void dfs(int x, int y, int target) {
    
        // System.out.println((x + 1) + " " + (y + 1) + ", target: " + target);

        if (target == m + 2) {
            answer++;
            return;
        }
        
        for (int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (v[nx][ny]) continue;
            if (map[nx][ny] == 1) continue;
            if (map[nx][ny] != 0 && map[nx][ny] != target) continue;

            v[nx][ny] = true;
            if (map[nx][ny] == target) dfs(nx, ny, target + 1);
            else dfs(nx, ny, target);
            v[nx][ny] = false;
        }
    }
}