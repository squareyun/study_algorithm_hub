import java.util.*;
import java.io.*;

public class Main {

	static int N, E;
	static List<Data>[] adj;
	static int must1, must2;
	static int[] dp;
	static final int INF = 987654321;
	static int answer = INF;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[a].add(new Data(b, w));
			adj[b].add(new Data(a, w));
		}
		st = new StringTokenizer(br.readLine());
		must1 = Integer.parseInt(st.nextToken());
		must2 = Integer.parseInt(st.nextToken());

		int a, b, c, res1, res2;
		// 1 -> mx -> my -> N
		a = dijkstra(1, must1);
		b = dijkstra(must1, must2);
		c = dijkstra(must2, N);
		if (a == INF || b == INF || c == INF)
			res1 = INF;
		else
			res1 = a + b + c;

		// 1 -> my -> mx -> N
		a = dijkstra(1, must2);
		b = dijkstra(must2, must1);
		c = dijkstra(must1, N);
		if (a == INF || b == INF || c == INF)
			res2 = INF;
		else
			res2 = a + b + c;

		answer = ((res1 == INF || res2 == INF) ? -1 : Math.min(res1, res2));
		System.out.println(answer);
	}

	static int dijkstra(int s, int e) {
		dp = new int[N + 1];
		Arrays.fill(dp, INF);
		PriorityQueue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(s, 0));
		dp[s] = 0;

		while (!pq.isEmpty()) {
			Data cur = pq.poll();

			if (cur.w > dp[cur.v]) continue;

			for (Data next : adj[cur.v]) {
				if (dp[next.v] > dp[cur.v] + next.w) {
					dp[next.v] = dp[cur.v] + next.w;
					pq.offer(new Data(next.v, dp[next.v]));
				}
			}
		}

		return dp[e];
	}

	static class Data implements Comparable<Data> {
		int v, w;

		public Data(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.w, o.w);
		}
	}
}