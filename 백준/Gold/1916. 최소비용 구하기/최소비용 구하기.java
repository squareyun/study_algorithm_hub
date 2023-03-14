import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, S, T;
	static ArrayList<Node>[] list;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;

	static class Node implements Comparable<Node> {
		int v, w;

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		dist = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
			dist[i] = INF;
		}

		StringTokenizer st = null;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, w));
		}
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		// 입력끝
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(S, 0));
		dist[S] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (cur.w > dist[cur.v]) {
				continue;
			}
			
			for (Node next : list[cur.v]) {
				if (dist[next.v] > dist[cur.v] + next.w) {
					dist[next.v] =  dist[cur.v] + next.w;
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
		
		System.out.println(dist[T]);
	}

}