import java.util.*;
import java.io.*;

public class Main {

	static int N, K;
	final static int MAX_N_K = 100_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] dist = new int[MAX_N_K + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(N);
		dist[N] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == K) {
				System.out.println(dist[K]);
				break;
			}

			int next = cur * 2;
			if (next <= MAX_N_K && dist[next] > dist[cur]) {
				dist[next] = dist[cur];
				q.addFirst(next);
			}

			next = cur + 1;
			if (next <= MAX_N_K && dist[next] > dist[cur] + 1) {
				dist[next] = dist[cur] + 1;
				q.addLast(next);
			}

			next = cur - 1;
			if (next >= 0 && dist[next] > dist[cur] + 1) {
				dist[next] = dist[cur] + 1;
				q.addLast(next);
			}
		}
	}
}