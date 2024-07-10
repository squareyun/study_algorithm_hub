import java.util.*;
import java.io.*;

public class Main {

	static int K, V, E;
	static List<Integer>[] adj;
	static boolean[] v, color;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			init();
			int a, b;
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				adj[b].add(a);
			}

			boolean answer = true;
			for (int i = 1; i <= V; i++) {
				if (!v[i]) {
					v[i] = true;
					boolean res = isBipartite(i);
					if (!res) {
						answer = false;
						break;
					}
				}
			}
			sb.append(answer ? "YES" : "NO").append('\n');
		}
		System.out.println(sb);
	}

	static boolean isBipartite(int cur) {
		for (int next : adj[cur]) {
			if (!v[next]) {
				v[next] = true;
				color[next] = !color[cur];
				boolean res = isBipartite(next);
				if (!res) return false;
			} else if (color[next] == color[cur]) {
				return false;
			}
		}
		return true;
	}

	static void init() {
		adj = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		v = new boolean[V + 1];
		color = new boolean[V + 1];
	}
}