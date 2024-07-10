import java.util.*;
import java.io.*;

public class Main {

	static final int INF = 987654321;

	static int N, M;
	static char[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	static Pos red = new Pos(0, 0);
	static Pos blue = new Pos(0, 0);
	static Pos goal = new Pos(0, 0);
	static boolean[][][][] v = new boolean[11][11][11][11];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);

				if (map[i][j] == 'R')
					red = new Pos(i, j);
				else if (map[i][j] == 'B')
					blue = new Pos(i, j);
				else if (map[i][j] == 'O')
					goal = new Pos(i, j);

				if (map[i][j] != '#')
					map[i][j] = '.';
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		v[red.x][red.y][blue.x][blue.y] = true;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(red, blue, 0));

		while (!q.isEmpty()) {
			Pair cur = q.poll();

			if (cur.cnt > 10)
				return -1;
			if (cur.red.isSame(goal))
				return cur.cnt;

			for (int d = 0; d < 4; d++) {
				Pos nextRed = new Pos(cur.red.x, cur.red.y);
				Pos nextBlue = new Pos(cur.blue.x, cur.blue.y);
				int movedCntRed = move(nextRed, d);
				int movedCntBlue = move(nextBlue, d);

				// 파란 구슬 빠지면 실패
				if (nextBlue.isSame(goal))
					continue;

				// 위치가 같은 경우 재조정
				if (nextBlue.isSame(nextRed)) {
					if (movedCntRed > movedCntBlue) {
						nextRed.x -= dx[d];
						nextRed.y -= dy[d];
					} else {
						nextBlue.x -= dx[d];
						nextBlue.y -= dy[d];
					}
				}

				if (!v[nextRed.x][nextRed.y][nextBlue.x][nextBlue.y]) {
					v[nextRed.x][nextRed.y][nextBlue.x][nextBlue.y] = true;
					q.add(new Pair(nextRed, nextBlue, cur.cnt + 1));
				}

			}

		}

		return -1;
	}

	private static int move(Pos next, int d) {
		int cnt = 0;
		int x = next.x;
		int y = next.y;

		while (map[x + dx[d]][y + dy[d]] != '#') {
			x += dx[d];
			y += dy[d];
			cnt++;
			if (x == goal.x && y == goal.y)
				break;
		}

		next.x = x;
		next.y = y;
		return cnt;
	}

	static class Pair {
		Pos red, blue;
		int cnt;

		public Pair(Pos red, Pos blue, int cnt) {
			this.red = red;
			this.blue = blue;
			this.cnt = cnt;
		}
	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public boolean isSame(Pos o) {
			return o.x == this.x && o.y == this.y;
		}
	}
}