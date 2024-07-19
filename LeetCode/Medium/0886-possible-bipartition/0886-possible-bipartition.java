import java.util.*;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i=0; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            adj[dislike[0]].add(dislike[1]);
            adj[dislike[1]].add(dislike[0]);
        }

        boolean[] v = new boolean[n + 1];
        boolean[] color = new boolean[n + 1];
        for (int i=0; i<n; i++) {
            if (!v[i]) {
                v[i] = true;
                boolean res = bipartition(i, adj, v, color);
                if (!res) return false;
            }
        }
        return true;
    }

    private boolean bipartition(int cur, ArrayList<Integer>[] adj, boolean[] v, boolean[] color) {

        for (int i : adj[cur]) {
            if (v[i] && color[i] == color[cur]) return false;
            if (!v[i]) {
                v[cur] = true;
                color[i] = !color[cur];
                boolean res = bipartition(i, adj, v, color);
                if (!res) return false;
            }
        }
        return true;
    }
}