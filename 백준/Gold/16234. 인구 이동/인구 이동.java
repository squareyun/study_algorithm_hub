import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, L, R;
    static int[][] A;
    static ArrayList<Integer>[] adj;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (open()) {
            move();
            answer++;
        }

        System.out.println(answer);
    }

    static boolean open() {
        boolean isOpen = false;

        adj = new ArrayList[N * N];
        for (int i = 0; i < N * N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                        continue;

                    int diff = Math.abs(A[i][j] - A[nx][ny]);

                    if (L <= diff && diff <= R) {
                        adj[index(i, j)].add(index(nx, ny));
                        adj[index(nx, ny)].add(index(i, j));
                        if (!isOpen)
                            isOpen = true;
                    }
                }
            }
        }

        return isOpen;
    }

    static void move() {
        boolean[] v = new boolean[N * N];

        for (int i = 0; i < N * N; i++) {
            if (adj[i].isEmpty() || v[i])
                continue;

            Queue<Integer> q = new ArrayDeque<>();
            q.offer(i);
            v[i] = true;
            int[] coord = coord(i);
            int total = A[coord[0]][coord[1]];
            int count = 1;
            ArrayList<int[]> update = new ArrayList<>();
            update.add(coord);

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int to : adj[cur]) {
                    if (v[to])
                        continue;
                    q.offer(to);
                    v[to] = true;
                    coord = coord(to);
                    total += A[coord[0]][coord[1]];
                    count++;
                    update.add(coord);
                }
            }

            int ret = total / count;
            for (int[] u : update) {
                A[u[0]][u[1]] = ret;
            }
        }
    }

    static int index(int x, int y) {
        return x * N + y;
    }

    static int[] coord(int index) {
        return new int[]{index / N, index % N};
    }
}