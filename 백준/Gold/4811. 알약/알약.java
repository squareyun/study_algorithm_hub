import java.util.Scanner;

public class Main {

	static long[][] dp = new long[31][31];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();
		while (true) {
			int N = sc.nextInt();
			if (N == 0)
				break;
			sb.append(dfs(N, 0)).append('\n');
		}
		System.out.println(sb);
	}

	static long dfs(int w, int h) {
		if (w == 0)
			return 1;

		if (dp[w][h] > 0)
			return dp[w][h];

		dp[w][h] = dfs(w - 1, h + 1); // 큰 알약 먹기
		if (h > 0) {
			dp[w][h] += dfs(w, h - 1); // 작은 알약 먹기
		}
		return dp[w][h];
	}
}