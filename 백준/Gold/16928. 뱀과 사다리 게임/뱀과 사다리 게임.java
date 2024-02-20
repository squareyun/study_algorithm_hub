import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr = new int[101];
    static boolean[] v = new boolean[101];
    static int[] answer = new int[101];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u] = v;
        }

        bfs();
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        v[1] = true;
        answer[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == 100) {
                System.out.println(answer[100]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = cur + i;

                if (next > 100)
                    continue;

                if (v[next])
                    continue;

                if (arr[next] != 0) {
                    if (v[arr[next]])
                        continue;
                    q.offer(arr[next]);
                    v[arr[next]] = true;
                    answer[arr[next]] = answer[cur] + 1;
                } else {
                    q.offer(next);
                    v[next] = true;
                    answer[next] = answer[cur] + 1;
                }
            }
        }
    }
}