import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13549
 * 숨바꼭질 3
 * 0-1 BFS
 */
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] dist = new int[100001];
		Arrays.fill(dist, Integer.MAX_VALUE);

		Deque<Integer> q = new ArrayDeque<>();
		q.offer(N);
		dist[N] = 0;

		while (!q.isEmpty()) {
			int cur = q.pollFirst();

			if (cur == K) {
				System.out.println(dist[K]);
				return;
			}

			int next = cur * 2;
			if (next <= 100000 && dist[next] > dist[cur]) {
				dist[next] = dist[cur];
				q.offerFirst(next);
			}

			next = cur - 1;
			if (next >= 0 && dist[next] > dist[cur] + 1) {
				dist[next] = dist[cur] + 1;
				q.offerLast(next);
			}

			next = cur + 1;
			if (next <= 100000 && dist[next] > dist[cur] + 1) {
				dist[next] = dist[cur] + 1;
				q.offerLast(next);
			}
		}
	}
}