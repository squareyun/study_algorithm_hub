import java.util.*;
import java.io.*;

public class Main {

	static int N, K;
	static int[] bags;
	static PriorityQueue<Jewelry> jewelries;
	static PriorityQueue<Integer> pq;
	static long answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new StringReader(input));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		jewelries = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jewelries.offer(new Jewelry(m, v));
		}

		bags = new int[K];
		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);

		pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < K; i++) {
			while (!jewelries.isEmpty() && jewelries.peek().m <= bags[i]) {
				pq.offer(jewelries.poll().v);
			}

			if (!pq.isEmpty()) {
				answer += pq.poll();
			}
		}
		System.out.println(answer);
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

	static String input = "3 2\n"
		+ "1 65\n"
		+ "5 23\n"
		+ "2 99\n"
		+ "10\n"
		+ "2";
}