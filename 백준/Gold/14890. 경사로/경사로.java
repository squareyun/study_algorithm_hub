import java.util.*;
import java.io.*;

public class Main {

	static int N, L;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {0, 0, 1, -1}; // 동서남북
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 2 * N;

		// 가로
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (Math.abs(map[i][j] - map[i][j-1]) > 1) {
					answer--;
					break;
				}
				if (map[i][j] - map[i][j-1] == -1) {
					if (check(i, j, 0)) {
						j += L - 1;
					} else {
						answer--;
						break;
					}
				} else if (map[i][j] - map[i][j - 1] == 1) {
					if (!check(i, j-1, 1)) {
						answer--;
						break;
					}
				}
			}
		}


		// 세로
		v = new boolean[N][N];
		for (int j = 0; j < N; j++) {
			for (int i = 1; i < N; i++) {
				if (Math.abs(map[i][j] - map[i-1][j]) > 1) {
					answer--;
					break;
				}

				if (map[i][j] - map[i-1][j] == -1) {
					if (check(i, j, 2)) {
						i += L - 1;
					} else {
						answer--;
						break;
					}
				} else if (map[i][j] - map[i-1][j] == 1) {
					if (!check(i-1, j, 3)) {
						answer--;
						break;
					}
				}
			}
		}

		System.out.println(answer);

	}

	private static boolean check(int x, int y, int d) {
		int tempL = 1;

		if (v[x][y]) return false;
		v[x][y] = true;
		if (tempL == L) return true;

		while (true) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N || v[nx][ny])
				return false;
			if (map[nx][ny] != map[x][y])
				return false;
			tempL++;
			v[nx][ny] = true;
			if (tempL == L) return true;

			x = nx;
			y = ny;
		}
	}
}