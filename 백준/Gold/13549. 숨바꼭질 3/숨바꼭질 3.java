import java.util.*;
import java.io.*;

public class Main {

	static int N, K;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[] v = new boolean[100_001];
		q.offer(new int[] {N, 0});
		v[N] = true;

		while (!q.isEmpty()) {
			int[] data = q.poll();
			int cur = data[0];
			int cnt = data[1];

			if (cur == K) {
				System.out.println(cnt);
				break;
			}

			if (cur * 2 <= K + 2 && !v[cur * 2]) {
				v[cur * 2] = true;
				q.offerFirst(new int[] {cur * 2, cnt});
			}

			if (cur - 1 >= 0 && !v[cur - 1]) {
				v[cur - 1] = true;
				q.offerLast(new int[] {cur - 1, cnt + 1});
			}

			if (cur + 1 <= K && !v[cur + 1]) {
				v[cur + 1] = true;
				q.offerLast(new int[] {cur + 1, cnt + 1});
			}

		}
	}
}