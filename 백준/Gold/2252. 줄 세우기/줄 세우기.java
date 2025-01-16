import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        inDegree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            inDegree[b]++;
        }

        ArrayList<Integer> ret = topologySort();
        for (Integer r : ret) {
            System.out.printf("%d ", r);
        }
    }

    private static ArrayList<Integer> topologySort() {
        ArrayList<Integer> ret = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            Integer cur = q.poll();
            ret.add(cur);
            for (int next : adj[cur]) {
                if (--inDegree[next] == 0)
                    q.offer(next);
            }
        }

        return ret;
    }
}