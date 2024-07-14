import java.util.*;
import java.io.*;

public class Main {

	static int N, E;
	static List<Edge>[] adj;
	static int v1, v2;

	private static final int INF = 987654321;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		int from, to, w;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			adj[from].add(new Edge(to, w));
			adj[to].add(new Edge(from, w));
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		int dist1 = solve(v1, v2);
		int dist2 = solve(v2, v1);
		int answer = Math.min(dist1, dist2);
		System.out.println((answer == INF) ? -1 : answer);
	}

	private static int solve(int first, int second) {
		int a = dijkstra(1, first);
		if (a == INF) return INF;
		int b = dijkstra(first, second);
		if (b == INF) return INF;
		int c = dijkstra(second, N);
		if (c == INF) return INF;
		return a + b + c;
	}

	static int dijkstra(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int[] dp = new int[N + 1];
		Arrays.fill(dp, INF);
		dp[start] = 0;
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (cur.w > dp[cur.v]) continue;

			for (Edge next : adj[cur.v]) {
				if (dp[next.v] > dp[cur.v] + next.w) {
					dp[next.v] = dp[cur.v] + next.w;
					pq.offer(new Edge(next.v, dp[next.v]));
				}
			}
		}

		return dp[end];
	}

	static class Edge implements Comparable<Edge> {
		int v, w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
}