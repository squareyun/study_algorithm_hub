import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] dp = new int[M + 1][N + 1];
			for (int i = 0; i <= M; i++) {
				for (int j = 0, end = Math.min(i, N); j <= end; j++) {
					if (j == 0 || i == j)
						dp[i][j] = 1;
					else
						dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				}
			}
			System.out.println(dp[M][N]);
		}
	}

}