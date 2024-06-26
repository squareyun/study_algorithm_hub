import java.util.*;
import java.io.*;

public class Main {

	static int N, M, V;
	static List<Integer>[] adj;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj[from].add(to);
			adj[to].add(from);
		}

		for (int i = 0; i <= N; i++) {
			Collections.sort(adj[i]);
		}

		v = new boolean[N + 1];
		dfs(V);
		sb.append("\n");

		v = new boolean[N + 1];
		bfs();
		System.out.println(sb);
	}

	static void dfs(int cur) {
		if (v[cur]) return;

		v[cur] = true;
		sb.append(cur).append(' ');

		for (int i : adj[cur]) {
			if (v[i]) continue;
			dfs(i);
		}
	}

	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(V);
		v[V] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			sb.append(cur).append(' ');

			for (int i : adj[cur]) {
				if (v[i]) continue;
				q.offer(i);
				v[i] = true;
			}
		}
	}
}