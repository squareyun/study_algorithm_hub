import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static final int INF = Integer.MAX_VALUE;

	static int N, M, X;
	static List<Data>[] nList; // 정방향
	static List<Data>[] rList; // 역방향

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		nList = new ArrayList[N + 1];
		rList = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			nList[i] = new ArrayList<>();
			rList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			nList[from].add(new Data(to, w));
			rList[to].add(new Data(from, w));
		}

		int[] go = dijkstra(nList); // 다른 마을 -> X 마을 최단 경로
		int[] back = dijkstra(rList); // X 마을 -> 다른 마을 최단 경로

		int answer = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			answer = Math.max(answer, go[i] + back[i]);
		}

		System.out.println(answer);
	}

	static int[] dijkstra(List<Data>[] list) {
		int[] dist = new int[N + 1];

		Arrays.fill(dist, INF);
		dist[X] = 0;

		PriorityQueue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(X, 0));

		while (!pq.isEmpty()) {
			Data cur = pq.poll();

			if (dist[cur.idx] < cur.w) // 이미 처리된 노드
				continue;

			for (Data next : list[cur.idx]) {
				if (dist[next.idx] > dist[cur.idx] + next.w) {
					dist[next.idx] = dist[cur.idx] + next.w;
					pq.offer(new Data(next.idx, dist[next.idx]));
				}
			}
		}

		return dist;
	}

	static class Data implements Comparable<Data> {
		int idx, w;

		public Data(int idx, int w) {
			this.idx = idx;
			this.w = w;
		}

		@Override
		public int compareTo(Data o) {
			return this.w - o.w;
		}
	}

}