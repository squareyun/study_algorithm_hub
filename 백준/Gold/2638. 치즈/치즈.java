import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[][] map;
	static int ans = 0;

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (bfs()) {
			ans++;
			// for (int i = 0; i < N; i++) {
			// 	for (int j = 0; j < M; j++) {
			// 		System.out.print(map[i][j] + " ");
			// 	}
			// 	System.out.println();
			// }
			// System.out.println("===================");
		}
		System.out.println(ans);
	}

	static boolean bfs() {
		boolean flag = false;

		Queue<Pos> q = new ArrayDeque<>();
		boolean[][] v = new boolean[N][M];
		q.offer(new Pos(0, 0));
		map[0][0] = 2;
		v[0][0] = true;

		while (!q.isEmpty()) {
			Pos cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (map[nx][ny] == 1) continue;
				if (v[nx][ny]) continue;

				q.offer(new Pos(nx, ny));
				map[nx][ny] = 2;
				v[nx][ny] = true;
			}
		}

		q = new ArrayDeque<>();
		v = new boolean[N][M];
		q.offer(new Pos(0, 0));
		v[0][0] = true;

		while (!q.isEmpty()) {
			Pos cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (v[nx][ny]) continue;

				if (map[nx][ny] == 1) {
					int surround = 0;
					for (int dd = 0; dd < 4; dd++) {
						int nnx = nx + dx[dd];
						int nny = ny + dy[dd];
						if (map[nnx][nny] == 2)
							surround++;
					}
					if (surround >= 2) {
						map[nx][ny] = 3;
						flag = true;
					}
				} else {
					q.offer(new Pos(nx, ny));
				}

				v[nx][ny] = true;
			}
		}

		if (flag) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 2 || map[i][j] == 3)
						map[i][j] = 0;
				}
			}
		}

		return flag;
	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}