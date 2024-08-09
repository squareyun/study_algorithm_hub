import java.util.*;
import java.io.*;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<Data> pq = new PriorityQueue<>();
		int country, num, score;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			country = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			score = Integer.parseInt(st.nextToken());
			pq.offer(new Data(country, num, score));
		}

		HashMap<Integer, Integer> hm = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		int cnt = 3;
		while (cnt > 0) {
			Data cur = pq.poll();
			assert cur != null;
			if (hm.getOrDefault(cur.country, 0) >= 2)
				continue;
			sb.append(cur.country).append(" ").append(cur.num).append("\n");
			hm.put(cur.country, hm.getOrDefault(cur.country, 0) + 1);
			cnt--;
		}
		System.out.println(sb);
	}

	static class Data implements Comparable<Data> {
		int country, num, score;

		public Data(int country, int num, int score) {
			this.country = country;
			this.num = num;
			this.score = score;
		}

		@Override
		public int compareTo(Data o) {
			return Integer.compare(o.score, this.score);
		}
	}

}