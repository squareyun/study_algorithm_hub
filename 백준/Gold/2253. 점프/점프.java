import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static HashSet<Integer> hs = new HashSet<>();
	static HashSet<Integer>[] v;

	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		if (M != 0) {
			for (int i = 0; i < M; i++) {
				hs.add(Integer.parseInt(br.readLine()));
			}
		}

		v = new HashSet[N + 1];
		for (int i = 0; i <= N; i++) {
			v[i] = new HashSet<>();
		}

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{1, 0, 0});
		int answer = INF;
		int[] dx = {-1, 0, 1};
		while (!q.isEmpty()) {
			int[] data = q.poll();
			int cur = data[0];
			int x = data[1];
			int cnt = data[2];

			// System.out.println(cur + " " + x + " " + cnt);

			for (int d = 0; d < 3; d++) {
				int nextX = x + dx[d];

				if (nextX < 1) continue;

				if (cur + nextX == N) {
					answer = Math.min(answer, cnt + 1);
					break;
				}

				int next = cur + nextX;
				if (next > N || hs.contains(next) || v[next].contains(nextX))
					continue;
				q.offer(new int[] {next, nextX, cnt + 1});
				v[next].add(nextX);
			}

		}
		System.out.println(answer == INF ? -1 : answer);
	}
}