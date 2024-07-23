import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] A, dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 1; j--) {
				if (A[j] < A[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		// System.out.println(Arrays.toString(dp));
		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}