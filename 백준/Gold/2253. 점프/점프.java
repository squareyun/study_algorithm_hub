import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static HashSet<Integer> smallRocks;
	static int[][] dp;

	final static int INF = 987654321;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		smallRocks = new HashSet<>();
		if (M != 0) {
			for (int i = 0; i < M; i++) {
				smallRocks.add(Integer.parseInt(br.readLine()));
			}
		}

		dp = new int[N + 1][(int)(Math.sqrt(2 * N)) + 2];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(dp[i], INF);
		}
		dp[1][0] = 0;

		for (int i = 1; i <= N; i++) {
			if (smallRocks.contains(i)) continue;

			for (int j = 1; j < (int)(Math.sqrt(2 * i)) + 1; j++) {
				dp[i][j] = Math.min(dp[i - j][j - 1], Math.min(dp[i - j][j], dp[i - j][j + 1])) + 1;
			}
		}
		int answer = INF;
		for (int i = 1; i < dp[N].length; i++) {
			answer = Math.min(answer, dp[N][i]);
		}
		System.out.println(answer == INF ? -1 : answer);
	}
}