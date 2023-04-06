import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class Node implements Comparable<Node> {
		int x, y, cnt;

		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cnt, o.cnt);
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] map = new int[N][M];
		int[] dx = new int[] { 0, 0, 1, -1 };
		int[] dy = new int[] { 1, -1, 0, 0 };
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		Queue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, 0));
		map[0][0] = 2; // 방문 체크
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.x == N - 1 && cur.y == M - 1) {
				System.out.println(cur.cnt);
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

				if (map[nx][ny] == 2)
					continue;

				pq.offer(new Node(nx, ny, cur.cnt + map[nx][ny]));
				map[nx][ny] = 2;
			}
		}

	}

}