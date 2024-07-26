import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] arr, dp;

	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][3];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = INF;
		for (int i = 0; i < 3; i++) {
			dp = new int[N + 1][3];
			for (int j = 0; j < 3; j++) {
				if (i == j) dp[1][j] = arr[1][j];
				else dp[1][j] = INF;
			}

			for (int j = 2; j <= N; j++) {
				dp[j][0] = arr[j][0] + Math.min(dp[j - 1][1], dp[j - 1][2]);
				dp[j][1] = arr[j][1] + Math.min(dp[j - 1][0], dp[j - 1][2]);
				dp[j][2] = arr[j][2] + Math.min(dp[j - 1][0], dp[j - 1][1]);
			}

			for (int j = 0; j < 3; j++) {
				if (i == j) dp[N][j] = INF;
			}

			for (int j = 0; j < 3; j++) {
				answer = Math.min(answer, dp[N][j]);
			}
		}
		System.out.println(answer);
	}
}