import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// DP 방식으로 풀어보기
			int N = sc.nextInt();
			int L = sc.nextInt();
			int[] points = new int[N + 1];
			int[] cals = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				points[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}

			int[][] dp = new int[N + 1][L + 1];

			for (int i = 1; i <= N; i++) {
				for (int w = 1; w <= L; w++) {
					if (cals[i] > w) {
						dp[i][w] = dp[i - 1][w];
					} else {
						dp[i][w] = Math.max(dp[i - 1][w], points[i] + dp[i - 1][w - cals[i]]);
					}
				}
			}

			System.out.printf("#%d %d\n", tc, dp[N][L]);
		}
	}

}