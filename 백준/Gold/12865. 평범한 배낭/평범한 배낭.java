import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] weights = new int[N + 1];
		int[] values = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			values[i] = sc.nextInt();
		}

		int[][] dp = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= K; w++) {
				if (weights[i] > w)
					dp[i][w] = dp[i - 1][w];
				else
					dp[i][w] = Math.max(dp[i - 1][w], values[i] + dp[i - 1][w - weights[i]]);
			}
		}
		System.out.println(dp[N][K]);
	}

}