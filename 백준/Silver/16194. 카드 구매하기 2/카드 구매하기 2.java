import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// dp[i] = i장 구매할 때 최소 금액
		dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.min(dp[i], arr[j] + dp[i - j]);
			}
		}
		// System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	}
}