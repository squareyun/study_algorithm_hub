import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Integer>[] adj = new ArrayList[n + 1];
        boolean[] v = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        int ans = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 0});
        v[1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int depth = cur[1];

            if (depth >= 2)
                continue;

            for (int next : adj[node]) {
                if (v[next]) continue;
                v[next] = true;
                ans++;
                q.add(new int[]{next, depth + 1});
            }
        }

        System.out.println(ans);
    }

}