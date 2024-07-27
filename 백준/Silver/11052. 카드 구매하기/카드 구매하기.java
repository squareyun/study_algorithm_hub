import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] P, dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		P = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], P[j] + dp[i - j]);
			}
		}

		System.out.println(dp[N]);
	}
}