import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] arr;
	static int[][] dp;
	static int[] answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		dp = new int[N][3];
		answer = new int[3];

		for (int k = 0; k < 3; k++) { // 첫 집에 k 색 칠하기
			for (int i = 0; i < 3; i++) {
				if (i == k)
					dp[0][i] = arr[0][i];
				else
					dp[0][i] = 1001;
			}

			for (int i = 1; i < N; i++) {
				dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
				dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
				dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
			}

			if (k == 0)
				answer[0] = Math.min(dp[N - 1][1], dp[N - 1][2]);
			if (k == 1)
				answer[1] = Math.min(dp[N - 1][0], dp[N - 1][2]);
			if (k == 2)
				answer[2] = Math.min(dp[N - 1][0], dp[N - 1][1]);


			// for (int i = 0; i < N; i++) {
			// 	System.out.println(Arrays.toString(dp[i]));
			// }
			// System.out.println("=======");
		}

		// System.out.println(Arrays.toString(answer));
		System.out.println(Arrays.stream(answer).min().getAsInt());
	}
}