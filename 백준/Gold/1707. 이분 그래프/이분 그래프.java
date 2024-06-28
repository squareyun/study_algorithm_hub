import java.util.*;
import java.io.*;

public class Main {

	static int K, V, E;
	static List<Integer>[] adj;
	static boolean[] v, color;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st;

		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			adj = new ArrayList[V + 1];
			v = new boolean[V + 1];
			color = new boolean[V + 1];
			for (int i = 0; i <= V; i++) {
				adj[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from].add(to);
				adj[to].add(from);
			}

			boolean isBipartite = true;
			for (int i = 1; i <= V; i++) {
				if (v[i]) continue;
				v[i] = true;
				boolean ret = dfs(i);
				if (!ret) {
					isBipartite = false;
					break;
				}
			}
			System.out.println(isBipartite ? "YES" : "NO");
		}
	}

	private static boolean dfs(int cur) {
		for (int next : adj[cur]) {
			if (!v[next]) {
				v[next] = true;
				color[next] = !color[cur];
				boolean ret = dfs(next);
				if (!ret) return false;
			} else if (color[cur] == color[next]) {
				return false;
			}
		}
		return true;
	}

}