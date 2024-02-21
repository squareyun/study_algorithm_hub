import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] map;
	static int[][] dist;
	static boolean[][] v;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dist = new int[n][m];
		v = new boolean[n][m];
		Pos start = null;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2)
					start = new Pos(i, j);
			}
		}

		Queue<Pos> q = new ArrayDeque<>();
		q.offer(start);
		v[start.x][start.y] = true;

		while (!q.isEmpty()) {
			Pos cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;

				if (v[nx][ny])
					continue;

				if (map[nx][ny] == 0)
					continue;

				q.offer(new Pos(nx, ny));
				v[nx][ny] = true;
				dist[nx][ny] = dist[cur.x][cur.y] + 1;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && dist[i][j] == 0)
					sb.append("-1").append(" ");
				else
					sb.append(dist[i][j]).append(" ");
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}