import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		StringTokenizer st;
		int x, y;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			pq.offer(new Pos(x, y));
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Pos cur = pq.poll();
			sb.append(cur.x).append(" ").append(cur.y).append("\n");
		}
		System.out.println(sb);
	}

	static class Pos implements Comparable<Pos> {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pos o) {
			if (this.x == o.x) {
				return Integer.compare(this.y, o.y);
			}
			return Integer.compare(this.x, o.x);
		}
	}

}