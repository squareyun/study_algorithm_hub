import java.util.*;
import java.io.*;

public class Main {

	static int[][] map;
	static boolean[] v = new boolean[10];
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new StringReader(input));
		map = new int[3][3];
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		System.out.println(answer);
	}

	static void dfs(int idx, int cost) {
		if (check()) {
			// System.out.println(map[0][0] + map[0][1] + map[0][2] + " " + idx);
			answer = Math.min(answer, cost);
			return;
		}

		if (idx == 9)
			return;

		int x = idx / 3;
		int y = idx % 3;

		// 값 변경
		int origin = map[x][y];
		for (int i = 1; i <= 9; i++) {
			if (v[i]) continue;
			v[i] = true;
			map[x][y] = i;
			int newCost = cost + Math.abs(origin - i);
			dfs(idx + 1, newCost);
			v[i] = false;
			map[x][y] = origin;
		}
	}

	private static boolean check() {
		int target = 15;
		int tempSum = 0;

		// 가로
		for (int i = 0; i < 3; i++) {
			tempSum = 0;
			for (int j = 0; j < 3; j++) {
				tempSum += map[i][j];
			}
			if (tempSum != target)
				return false;
		}

		// 세로
		for (int j = 0; j < 3; j++) {
			tempSum = 0;
			for (int i = 0; i < 3; i++) {
				tempSum += map[i][j];
			}
			if (tempSum != target)
				return false;
		}

		// 대각선
		if (map[0][0] + map[1][1] + map[2][2] != target)
			return false;
		if (map[2][0] + map[1][1] + map[0][2] != target)
			return false;

		return true;
	}

	static String input = "4 8 2\n"
		+ "4 5 7\n"
		+ "6 1 6";
}