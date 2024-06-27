import java.util.*;
import java.io.*;

public class Main {

	static int N, M, x, y, K;
	static int[][] map;
	static int[] dx = {0, 0, -1, 1}; // 동 서 북 남
	static int[] dy = {1, -1, 0, 0};
	static int[] dice = new int[6]; // 윗, 앞, 밑, 뒤, 좌, 우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int d = Integer.parseInt(st.nextToken()) - 1;

			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M)
				continue;

			roll(d);
			x = nx;
			y = ny;
			if (map[x][y] == 0) {
				map[x][y] = dice[2];
			} else {
				dice[2] = map[x][y];
				map[x][y] = 0;
			}
			sb.append(dice[0]).append("\n");
		}
		System.out.println(sb);
	}

	static void roll(int d) {
		switch (d) {
			case 0:
				dice = updateDice(0, 5, 2, 4, false);
				return;
			case 1:
				dice = updateDice(0, 5, 2, 4, true);
				return;
			case 2:
				dice = updateDice(0, 1, 2, 3, true);
				return;
			case 3:
				dice = updateDice(0, 1, 2, 3, false);
		}
	}

	static int[] updateDice(int a, int b, int c, int d, boolean reverse) {
		int[] newDice = dice.clone();
		int[] order = {a, b, c, d};

		for (int i = 0; i < 4; i++) {
			if (!reverse)
				newDice[order[i]] = dice[order[(i + 3) % 4]];
			else
				newDice[order[i]] = dice[order[(i + 1) % 4]];
		}

		return newDice;
	}
}