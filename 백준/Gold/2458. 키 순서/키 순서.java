import java.util.*;
import java.io.*;

public class Main {

    static List<Integer>[] adj;
    static List<Integer>[] adjR;
    static boolean[] v;
    static int count, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        adjR = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            adjR[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adjR[b].add(a);
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            v = new boolean[N + 1];
            count = 0;
            dfs(adj, i);
            int taller = count - 1;

            v = new boolean[N + 1];
            count = 0;
            dfs(adjR, i);
            int smaller = count - 1;

            if (taller + smaller == N - 1)
                ans++;
        }

        System.out.println(ans);
    }

    static void dfs(List<Integer>[] g, int cur) {
        v[cur] = true;
        count++;
        for (int next : g[cur]) {
            if (!v[next])
                dfs(g, next);
        }
    }

}