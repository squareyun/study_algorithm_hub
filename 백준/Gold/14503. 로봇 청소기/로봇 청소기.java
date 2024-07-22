import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int answer = 0;
	static int sx, sy, dir;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(sx, sy));

		int x, y, nx, ny;
		boolean find;
		while (true) {
			Pos cur = q.poll();
			x = cur.x;
			y = cur.y;

			if (map[x][y] == 0) {
				map[x][y] = 2;
				answer++;
			}

			find = false;
			for (int i = dir + 3, dcnt = 0; dcnt < 4; i += 3, dcnt++) {
				nx = x + dx[i % 4];
				ny = y + dy[i % 4];

				if (map[nx][ny] == 0) {
					q.offer(new Pos(nx, ny));
					dir = i % 4;
					find = true;
					break;
				}
			}
			if (find) continue;

			// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
			nx = x - dx[dir];
			ny = y - dy[dir];
			if (map[nx][ny] == 1)
				break;
			q.offer(new Pos(nx, ny));
		}

		System.out.println(answer);
	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}