import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static char[][] map;
	static Data s, e;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		s = new Data(0, 0, 0);
		st = new StringTokenizer(br.readLine());
		s.x = Integer.parseInt(st.nextToken()) - 1;
		s.y = Integer.parseInt(st.nextToken()) - 1;

		e = new Data(0, 0, 0);
		e.x = Integer.parseInt(st.nextToken()) - 1;
		e.y = Integer.parseInt(st.nextToken()) - 1;

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		ArrayDeque<Data> q = new ArrayDeque<>();
		boolean[][] v = new boolean[N][M];
		q.offer(s);
		v[s.x][s.y] = true;

		while (!q.isEmpty()) {
			Data cur = q.poll();

			if (cur.x == e.x && cur.y == e.y) {
				System.out.println(cur.cnt);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (v[nx][ny]) continue;
				v[nx][ny] = true;

				if (map[nx][ny] == '0') {
					q.addFirst(new Data(nx, ny, cur.cnt));
				} else {
					q.addLast(new Data(nx, ny, cur.cnt + 1));
				}
			}
		}
	}

	static class Data {
		int x, y, cnt;

		public Data(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}