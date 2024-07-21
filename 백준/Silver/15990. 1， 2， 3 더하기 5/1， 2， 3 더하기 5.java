import java.util.*;
import java.io.*;

public class Main {

	static int T;
	static final long MOD = 1_000_000_009;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		long[][] dp = new long[100001][4];
		dp[1] = new long[] {0, 1, 0, 0};
		dp[2] = new long[] {0, 0, 1, 0};
		dp[3] = new long[] {0, 1, 1, 1};
		for (int i = 4; i < 100001; i++) {
			dp[i][1] = (dp[i - 1][2] % MOD + dp[i - 1][3] % MOD) % MOD;
			dp[i][2] = (dp[i - 2][1] % MOD + dp[i - 2][3] % MOD) % MOD;
			dp[i][3] = (dp[i - 3][1] % MOD + dp[i - 3][2] % MOD) % MOD;
		}

		int n;
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			n = Integer.parseInt(br.readLine());
			sb.append((dp[n][1] % MOD + dp[n][2] % MOD + dp[n][3] % MOD) % MOD).append("\n");
		}
		System.out.println(sb);
	}
}