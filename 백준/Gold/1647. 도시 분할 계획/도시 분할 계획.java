import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static List<Edge> edges = new ArrayList<>();
	static int[] parent;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int from, to, w;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			edges.add(new Edge(from, to, w));
		}

		if (N == 2) {
			System.out.println(0);
			return;
		}

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		Collections.sort(edges);

		int totalCost = 0;
		int cnt = 0;
		for (Edge e : edges) {
			if (find(e.from) != find(e.to)) {
				union(e.from, e.to);
				totalCost += e.w;
				if (++cnt == N - 2) break;
			}
		}
		System.out.println(totalCost);
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB) return;
		parent[rootB] = parent[rootA];
	}

	static int find(int a) {
		if (parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}

	static class Edge implements Comparable<Edge> {
		int from, to, w;

		public Edge(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
}