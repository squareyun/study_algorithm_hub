import java.util.*;
import java.io.*;

public class Main {

	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

	static int[][] map = new int[4][4];
	static Fish[] fishes = new Fish[17];
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken()) - 1;
				map[i][j] = a;
				fishes[a] = new Fish(i, j, a, b, true);
			}
		}

		int sx = 0, sy = 0;
		int sd = fishes[map[0][0]].dir;
		int sum = map[0][0];
		fishes[map[0][0]].isAlive = false;
		map[0][0] = -1;

		dfs(sx, sy, sd, sum);

		System.out.println(ans);
	}

	private static void dfs(int sx, int sy, int sd, int sum) {
		ans = Math.max(ans, sum);

		int[][] tempMap = new int[4][4];
		Fish[] tempFishes = new Fish[17];
		copyMap(tempMap, map);
		copyFish(tempFishes, fishes);

		moveFish();

		// 상어
		for (int i = 1; i < 4; i++) {
			int nx = sx + dx[sd] * i;
			int ny = sy + dy[sd] * i;

			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
			if (map[nx][ny] == 0) continue;

			int target = map[nx][ny];
			int nd = fishes[target].dir;
			map[sx][sy] = 0;
			map[nx][ny] = -1;
			fishes[target].isAlive = false;

			dfs(nx, ny, nd, sum + target);

			fishes[target].isAlive = true;
			map[sx][sy] = -1;
			map[nx][ny] = target;
		}

		copyMap(map, tempMap);
		copyFish(fishes, tempFishes);
	}

	private static void moveFish() {
		for (int i = 1; i <= 16; i++) {
			if (!fishes[i].isAlive) continue;

			for (int j = 0; j < 8; j++) {
				int d = (fishes[i].dir + j) % 8;
				int nx = fishes[i].x + dx[d];
				int ny = fishes[i].y + dy[d];

				if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
				if (map[nx][ny] == -1) continue;

				fishes[i].dir = d;

				if (map[nx][ny] == 0) {
					map[fishes[i].x][fishes[i].y] = 0;
				} else {
					int tempFish = fishes[map[nx][ny]].id;
					fishes[tempFish].x = fishes[i].x;
					fishes[tempFish].y = fishes[i].y;
					map[fishes[tempFish].x][fishes[tempFish].y] = tempFish;
				}

				fishes[i].x = nx;
				fishes[i].y = ny;
				map[nx][ny] = i;
				break;
			}
		}
	}

	private static void copyFish(Fish[] temp, Fish[] origin) {
		for (int i = 1; i <= 16; i++) {
			Fish cur = origin[i];
			temp[i] = new Fish(cur.x, cur.y, cur.id, cur.dir, cur.isAlive);
		}
	}

	private static void copyMap(int[][] temp, int[][] origin) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				temp[i][j] = origin[i][j];
			}
		}
	}

	static class Fish {
		int x, y, id, dir;
		boolean isAlive;

		public Fish(int x, int y, int id, int dir, boolean isAlive) {
			this.x = x;
			this.y = y;
			this.id = id;
			this.dir = dir;
			this.isAlive = isAlive;
		}
	}
}