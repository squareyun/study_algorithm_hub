import java.util.*;
import java.io.*;

public class Main {

	static int T, K;
	static int[][] map;
	static int ans;
	static final int L = 6, R = 2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		map = new int[T][8];
		for (int i = 0; i < T; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		K = Integer.parseInt(br.readLine());
		while (K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			turn(target, (dir == 1), 0);
			// print();
		}

		for (int i = 0; i < T; i++) {
			if (map[i][0] == 1) ans++;
		}
		System.out.println(ans);
	}

	/**
	 *
	 * @param target 돌릴 톱니바퀴 번호
	 * @param clockwise 방향
	 * @param flag 0(양쪽다) 1(오른쪽만) -1(왼쪽만)
	 */
	private static void turn(int target, boolean clockwise, int flag) {
		// 왼쪽 방향
		if (flag == 0 || flag == -1) {
			int left = target - 1;
			if (left >= 0 && map[left][R] != map[target][L]) {
				turn(left, !clockwise, -1);
				// rotate(target, clockwise);
			}
		}

		// 오른쪽 방향
		if (flag == 0 || flag == 1) {
			int right = target + 1;
			if (right < T && map[right][L] != map[target][R]) {
				turn(right, !clockwise, 1);
				// rotate(target, clockwise);
			}
		}

		rotate(target, clockwise);
	}

	private static void rotate(int target, boolean clcokwise) {
		int[][] newMap = new int[T][8];
		for (int i = 0; i < T; i++) {
			System.arraycopy(map[i], 0, newMap[i], 0, 8);
		}

		if (clcokwise) {
			for (int i = 0; i < 8; i++) {
				newMap[target][(i + 1) % 8] = map[target][i];
			}
		}
		else {
			for (int i = 0; i < 8; i++) {
				newMap[target][(i + 7) % 8] = map[target][i];
			}
		}
		map = newMap;
	}

	private static void print() {
		System.out.println("===========");

		for (int i = 0; i < T; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}