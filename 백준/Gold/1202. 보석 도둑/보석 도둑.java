import java.util.*;
import java.io.*;

public class Main {

	static int N, K;
	static PriorityQueue<Jewelry> jewelries = new PriorityQueue<>();
	static int[] C;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = new int[K];
		int m, v;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			jewelries.add(new Jewelry(m, v));
		}
		for (int i = 0; i < K; i++) {
			C[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(C);

		long ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < K; i++) {
			while (!jewelries.isEmpty() && jewelries.peek().m <= C[i]) {
				pq.offer(jewelries.poll().v);
			}

			if (!pq.isEmpty()) {
				ans += pq.poll();
			}
		}
		System.out.println(ans);
	}

	static class Jewelry implements Comparable<Jewelry> {
		int m, v;

		public Jewelry(int m, int v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(Jewelry o) {
			return Integer.compare(this.m, o.m);
		}
	}
}