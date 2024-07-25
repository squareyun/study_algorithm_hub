import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[] parent;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++)
			parent[i] = i;

		PriorityQueue<Data> pq = new PriorityQueue<>();
		int a, b, c;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			pq.offer(new Data(a, b, c));
		}

		if (N == 2) {
			System.out.println(0);
			return;
		}

		int nodeCnt = 0;
		int answer = 0;
		while (!pq.isEmpty()) {
			Data cur = pq.poll();

			if (find(cur.a) == find(cur.b)) continue;

			union(cur.a, cur.b);
			answer += cur.c;
			if (++nodeCnt == (N - 2))
				break;
		}

		System.out.println(answer);

	}

	static class Data implements Comparable<Data> {
		int a, b, c;

		public Data(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.c, o.c);
		}
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA == rootB)
			return;
		parent[rootA] = rootB;
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}
}