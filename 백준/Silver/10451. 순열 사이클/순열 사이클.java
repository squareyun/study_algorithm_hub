import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] adj;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            adj = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                adj[i] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;
            v = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                if (!v[i]) {
                    dfs(i);
                    ans++;
                }

            }
            System.out.println(ans);
        }
    }

    static void dfs(int cur) {
        v[cur] = true;
        if (!v[adj[cur]]) {
            dfs(adj[cur]);
        }
    }

}