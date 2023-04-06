import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class Node {
		int x, y, cnt;

		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

	static int R, C;
	static char[][] map;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static Queue<Node> waters;
	static Node start, end;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];

		waters = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			String s = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'S')
					start = new Node(i, j, 0);
				else if (map[i][j] == 'D')
					end = new Node(i, j, 0);
				else if (map[i][j] == '*')
					waters.offer(new Node(i, j, 0));
			}
		}

		Queue<Node> q = new ArrayDeque<>();
		q.offer(start);
		boolean success = false;
		int ans = 0;

		while (!q.isEmpty()) {
			int size = q.size();

			// 물 전파 (먼저하기)
			goWater();

			for (int i = 0; i < size; i++) {
				Node cur = q.poll();

				// END
				if (cur.x == end.x && cur.y == end.y) {
					success = true;
					ans = cur.cnt;
					break;
				}

				// 고슴도치 이동
				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];

					if (nx < 0 || nx >= R || ny < 0 || ny >= C)
						continue;

					if (map[nx][ny] == 'S')
						continue;

					if ((map[nx][ny] == '.' || map[nx][ny] == 'D')) {
						q.offer(new Node(nx, ny, cur.cnt + 1));
						map[nx][ny] = 'S';
					}
				}
			}

		}

		if (success) {
			System.out.println(ans);
		} else {
			System.out.println("KAKTUS");
		}
	}

	static void goWater() {
		int size = waters.size();

		for (int i = 0; i < size; i++) {
			Node w = waters.poll();
			for (int d = 0; d < 4; d++) {
				int nx = w.x + dx[d];
				int ny = w.y + dy[d];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C)
					continue;

				if (map[nx][ny] == '*')
					continue;

				if (map[nx][ny] == '.' || map[nx][ny] == 'S') {
					map[nx][ny] = '*'; // 물 전파
					waters.offer(new Node(nx, ny, 0));
				}
			}
		}
	}

}