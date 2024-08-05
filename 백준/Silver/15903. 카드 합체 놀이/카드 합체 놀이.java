import java.util.*;
import java.io.*;

public class Main {

	static int n, m;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pq.offer(Long.parseLong(st.nextToken()));
		}

		for (int i = 0; i < m; i++) {
			long a = pq.poll();
			long b = pq.poll();
			long sum = a + b;
			pq.offer(sum);
			pq.offer(sum);
		}

		long ans = 0;
		while (!pq.isEmpty()) {
			ans += pq.poll();
		}
		System.out.println(ans);
	}

}