import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

	static int N, N2, K;
	static int[] A;
	static boolean[] robots;
	static long answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		N2 = N * 2;
		K = Integer.parseInt(st.nextToken());
		A = new int[N2];
		robots = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N2; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		do {
			answer++;
			rotate();
			moveRobots();
			if (A[0] > 0) {
				robots[0] = true;
				A[0]--;
			}
		} while (!exit());
		System.out.println(answer);
	}

	private static void rotate() {
		// 벨트 이동
		int tempA = A[N2 - 1];
		for (int i = N2 - 1; i > 0; i--) {
			A[i] = A[i - 1];
		}
		A[0] = tempA;

		// 로봇 이동
		for (int i = N - 1; i > 0; i--) {
			robots[i] = robots[i - 1];
		}
		robots[0] = false; // 회전하면 첫번째 무조건 빔
		robots[N - 1] = false; // 내리는 위치면 무조건 내림
	}

	private static void moveRobots() {
		for (int i = N - 1; i > 0; i--) {
			if (robots[i - 1]) {
				if (!robots[i] && A[i] >= 1) {
					A[i]--;
					robots[i] = true;
					robots[i - 1] = false;
				}
			}
		}
	}

	private static boolean exit() {
		int cnt = 0;
		for (int i = 0; i < N2; i++) {
			if (A[i] <= 0)
				cnt++;
		}
		return cnt >= K;
	}

}