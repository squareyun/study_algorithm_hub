import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		final int K_MAX = 100_000;

		int[] arr = new int[K_MAX + 1];
		int[] prev = new int[K_MAX + 1];

		Queue<Integer> q = new ArrayDeque<>();
		int[] dx = {1, -1, 2};

		q.offer(N);

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == K)
				break;

			for (int d = 0; d < 3; d++) {
				int nx = (d == 2 ? cur * dx[d] : cur + dx[d]);

				if (nx < 0 || nx > K_MAX)
					continue;
				if (arr[nx] > 0)
					continue;

				arr[nx] = arr[cur] + 1;
				prev[nx] = cur;
				q.offer(nx);
			}
		}

		int[] history = new int[arr[K] + 1];
		history[history.length - 1] = K;

		int idx = history.length - 2;
		int temp = K;
		while (idx >= 0) {
			history[idx--] = prev[temp];
			temp = prev[temp];
		}

		StringBuilder sb = new StringBuilder();
		sb.append(arr[K]).append("\n");
		for (int h : history) {
			sb.append(h).append(" ");
		}
		System.out.println(sb);
	}
}