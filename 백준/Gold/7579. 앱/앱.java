import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[] A, C;
	static int[][] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N + 1];
		C = new int[N + 1];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int total = 0;
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st1.nextToken());
			C[i] = Integer.parseInt(st2.nextToken());
			total += C[i];
		}

		dp = new int[N + 1][total + 1];

		for (int i = 1; i <= N; i++) {
			for (int c = 0; c <= total; c++) {
				if (c - C[i] < 0)
					dp[i][c] = dp[i - 1][c];
				else
					dp[i][c] = Math.max(dp[i - 1][c], dp[i - 1][c - C[i]] + A[i]);
			}
		}

		for (int i = 0; i <= total; i++) {
			if (dp[N][i] >= M) {
				System.out.println(i);
				return;
			}
		}
	}

}