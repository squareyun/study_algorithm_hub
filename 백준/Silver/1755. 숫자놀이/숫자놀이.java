import java.util.*;
import java.io.*;

public class Main {

	static int M, N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(1, "one");
		hm.put(2, "two");
		hm.put(3, "three");
		hm.put(4, "four");
		hm.put(5, "five");
		hm.put(6, "six");
		hm.put(7, "seven");
		hm.put(8, "eight");
		hm.put(9, "nine");
		hm.put(0, "zero");

		PriorityQueue<Data> pq = new PriorityQueue<Data>();
		for (int i = M; i <= N; i++) {
			if (i / 10 == 0) {
				pq.offer(new Data(i, hm.get(i)));
			} else {
				String first = hm.get(i / 10);
				String second = hm.get(i % 10);
				pq.offer(new Data(i, first + " " + second));
			}
		}

		StringBuilder sb = new StringBuilder();
		int idx = 0;
		while (!pq.isEmpty()) {
			sb.append(pq.poll().x).append(" ");

			if (++idx == 10) {
				sb.append("\n");
				idx = 0;
			}
		}
		System.out.println(sb);
	}

	static class Data implements Comparable<Data> {
		int x;
		String str;

		public Data(int x, String str) {
			this.x = x;
			this.str = str;
		}

		@Override
		public int compareTo(Data o) {
			return str.compareTo(o.str);
		}
	}
}