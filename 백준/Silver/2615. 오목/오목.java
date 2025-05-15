import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] v;

    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[20][20];
        v = new boolean[20][20];
        for (int i = 1; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                int color = map[i][j];
                if (color == 0) continue;

                for (int d = 0; d < 4; d++) {
                    int px = i - dx[d];
                    int py = j - dy[d];

                    // 이전 칸에 같은 색 돌이면 시작점 X
                    if (px >= 1 && px <= 19 && py >= 1 && py <= 19 && map[px][py] == color)
                        continue;

                    int cnt = 1;
                    int x = i, y = j;
                    while (true) {
                        x += dx[d];
                        y += dy[d];

                        if (x < 1 || x > 19 || y < 1 || y > 19 || map[x][y] != color)
                            break;

                        cnt++;
                    }

                    if (cnt == 5) {
                        System.out.println(color);
                        System.out.print(i + " " + j);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }
}
