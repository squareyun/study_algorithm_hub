import java.util.*;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i=0; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            adj[dislike[0]].add(dislike[1]);
            adj[dislike[1]].add(dislike[0]);
        }

        boolean[] v = new boolean[n + 1];
        boolean[] color = new boolean[n + 1];

        for (int i=1; i<=n; i++) {
            if (!v[i]) {
                v[i] = true;
                if (!dfs(i, adj, v, color)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int cur, List<Integer>[] adj, boolean[] v, boolean[] color) {
        for (int i : adj[cur]) {
            if (v[i] && color[cur] == color[i]) return false;
            if (!v[i]) {
                v[i] = true;
                color[i] = !color[cur];
                if (!dfs(i, adj, v, color)) return false;
            }
        }
        return true;
    }
}