import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m, answer;
    static int[][] data;
    static Queue<Pos> build = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        data = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = sc.nextInt();
            }
        }

        answer = Integer.MIN_VALUE;
        wall(0, 0);

        System.out.println(answer);
        sc.close();
    }

    static void wall(int start, int depth) {
        if (depth == 3) {
            answer = Math.max(answer, bfs());
            return;
        }

        for (int i = start; i < n * m; i++) {
            int x = i / m;
            int y = i % m;

            if (data[x][y] == 0) {
                data[x][y] = 1;
                wall(i + 1, depth + 1);
                data[x][y] = 0;
            }
        }

    }

    static int bfs() {
        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        int[][] tempData = new int[data.length][data[0].length];

        for (int i = 0; i < tempData.length; i++) {
            System.arraycopy(data[i], 0, tempData[i], 0, data[0].length);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempData[i][j] == 2) {
                    q.offer(new Pos(i, j));
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        Pos temp = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = temp.x + dx[k];
                            int ny = temp.y + dy[k];

                            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                                if (tempData[nx][ny] == 0 && !visited[nx][ny]) {
                                    visited[nx][ny] = true;
                                    tempData[nx][ny] = 2;
                                    q.offer(new Pos(nx, ny));
                                }
                            }
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempData[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}