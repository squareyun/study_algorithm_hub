import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> q = new ArrayDeque<>();
		int[] arr = new int[100_001];
		int[] dx = {1, -1, 2};
		q.offer(N);

		int cur;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (cur == K) {
				System.out.println(arr[K]);
				break;
			}

			for (int d = 0; d < 3; d++) {
				int nx = (d == 2) ? (cur * dx[d]) : (cur + dx[d]);

				if (nx < 0 || nx > 100_000) continue;
				if (arr[nx] != 0) continue;
				arr[nx] = arr[cur] + 1;
				q.offer(nx);
			}
		}
	}
}