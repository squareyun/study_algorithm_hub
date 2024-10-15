import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Data> pq = new PriorityQueue<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int a, b;
		char c;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = st.nextToken().charAt(0);
			pq.offer(new Data(a, b, c));
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			sb.append(pq.poll().c);
		}
		System.out.println(sb);
	}

	static class Data implements Comparable<Data> {
		int id, t;
		char c;

		public Data(int id, int t, char c) {
			this.id = id;
			this.t = t;
			this.c = c;
		}

		@Override
		public int compareTo(Data o) {
			if (this.t == o.t)
				return Integer.compare(this.id, o.id);
			else
				return Integer.compare(this.t, o.t);
		}
	}

}