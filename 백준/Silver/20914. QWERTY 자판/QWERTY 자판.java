import java.io.*;
import java.util.*;

public class Main {
    static final int R = 3, C = 10;
    static final int[][] DIR = {{-1,0},{1,0},{0,-1},{0,1},{1,-1},{-1,1}};
    static final char[][] KB = {
            {'Q','W','E','R','T','Y','U','I','O','P'},
            {'A','S','D','F','G','H','J','K','L',' '},
            {'Z','X','C','V','B','N','M',' ',' ',' '}
    };
    static int[] ry = new int[26], rx = new int[26];

    public static void main(String[] args) throws Exception {
        mapKeys();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String s = br.readLine().trim();
            int time = 1;
            for (int i = 1; i < s.length(); i++) {
                time += bfs(s.charAt(i - 1), s.charAt(i)) + 1;
            }
            sb.append(time).append('\n');
        }
        System.out.print(sb);
    }

    private static int bfs(char a, char b) {
        boolean[][] v = new boolean[R][C];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{ry[a - 'A'], rx[a - 'A'], 0});
        v[ry[a - 'A']][rx[a - 'A']] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == ry[b - 'A'] && cur[1] == rx[b - 'A']) return cur[2] * 2;

            for (int[] d : DIR) {
                int ny = cur[0] + d[0], nx = cur[1] + d[1];
                if (ny < 0 || ny >= R || nx < 0 || nx >= C || KB[ny][nx] == ' ' || v[ny][nx]) continue;
                v[ny][nx] = true;
                q.add(new int[]{ny, nx, cur[2] + 1});
            }
        }
        return 0;   // 같은 키
    }

    private static void mapKeys() {
        for (int y = 0; y < R; y++)
            for (int x = 0; x < C; x++)
                if (KB[y][x] != ' ') {
                    int idx = KB[y][x] - 'A';
                    ry[idx] = y;
                    rx[idx] = x;
                }
    }
}
