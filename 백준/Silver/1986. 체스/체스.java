import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static Queue<int[]> queens, knights;
	static boolean[][] map;
	static boolean[][] notSafe;
	final static int MAX_N_M = 1000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new boolean[n][m];
		notSafe = new boolean[n][m];
		queens = new ArrayDeque<>();
		knights = new ArrayDeque<>();

		input(br, queens);
		input(br, knights);
		input(br, null);

		// check queens
		int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
		int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
		while (!queens.isEmpty()) {
			int[] cur = queens.poll();
			int x = cur[0];
			int y = cur[1];

			for (int d = 0; d < 8; ) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny]) {
					d++;
					x = cur[0];
					y = cur[1];
					continue;
				}
				notSafe[nx][ny] = true;
				x = nx;
				y = ny;
			}
		}

		// check knight;
		dx = new int[] {-2, -2, -1, 1, 2, 2, 1, -1};
		dy = new int[] {-1, 1, 2, 2, 1, -1, -2, -2};
		while (!knights.isEmpty()) {
			int[] cur = knights.poll();
			int x = cur[0];
			int y = cur[1];

			for (int d = 0; d < 8; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny]) continue;
				notSafe[nx][ny] = true;
			}
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!notSafe[i][j]) answer++;
			}
		}
		System.out.println(answer);
	}

	private static void input(BufferedReader br, Queue<int[]> q) throws IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < k; i++) {
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			map[x][y] = true;
			notSafe[x][y] = true;
			if (q != null) q.add(new int[] {x, y});
		}
	}
}