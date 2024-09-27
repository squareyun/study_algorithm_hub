import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static char[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		Pos start = findStart();
		Queue<Pos> q = new ArrayDeque<>();
		boolean[][] v = new boolean[N][M];
		q.offer(start);
		v[start.x][start.y] = true;
		int ans = 0;
		while (!q.isEmpty()) {
			Pos cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (v[nx][ny] || map[nx][ny] == 'X')
					continue;

				if (map[nx][ny] == 'P')
					ans++;
				v[nx][ny] = true;
				q.offer(new Pos(nx, ny));
			}
		}
		System.out.println(ans != 0 ? ans : "TT");
	}

	static Pos findStart() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'I') {
					return new Pos(i, j);
				}
			}
		}
		return null;
	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}