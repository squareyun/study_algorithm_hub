import java.util.*;
import java.io.*;

public class Main {

	static final int R = 2;
	static final int L = 6;
	static final int LEN = 8;

	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][8];
		for (int i = 1; i <= 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < LEN; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			boolean dir = Integer.parseInt(st.nextToken()) == 1;
			solve(num, dir);
		}
		int ans = 0;
		int score = 1;
		for (int i = 1; i <= 4; i++) {
			if (map[i][0] == 1)
				ans += score;
			score *= 2;
		}
		System.out.println(ans);
	}

	private static void solve(int num, boolean dir) {
		checkLeft(num, num, dir);
		checkRight(num, num, dir);

		if (dir) turnRight(map[num]);
		else turnLeft(map[num]);
	}

	private static void checkLeft(int num, int numOrigin, boolean dir) {
		if (num > 1 && map[num][L] != map[num - 1][R]) {
			checkLeft(num - 1, numOrigin, !dir);
		}

		if(num == numOrigin) return;

		if (dir) turnRight(map[num]);
		else turnLeft(map[num]);
	}

	private static void checkRight(int num, int numOrigin, boolean dir) {
		if (num < 4 && map[num][R] != map[num + 1][L]) {
			checkRight(num + 1, numOrigin, !dir);
		}

		if(num == numOrigin) return;

		if (dir) turnRight(map[num]);
		else turnLeft(map[num]);
	}

	private static void turnLeft(int[] arr) {
		int temp = arr[0];
		for (int i = 0; i < LEN - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[LEN - 1] = temp;
	}

	private static void turnRight(int[] arr) {
		int temp = arr[LEN - 1];
		for (int i = LEN - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = temp;
	}
}