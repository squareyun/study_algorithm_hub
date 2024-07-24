import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] A, dp;
	static int pointer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = N - 1; i >= 0; i--) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N + 1];
		for (int i = 0; i < N; i++) {
			if (dp[pointer] < A[i]) {
				dp[++pointer] = A[i];
			} else {
				int idx = lowerBound(0, pointer, A[i]);
				dp[idx] = A[i];
			}
		}
		// System.out.println(Arrays.toString(dp));
		System.out.println(pointer);
	}

	static int lowerBound(int lo, int hi, int K) {
		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;

			if (!(K <= dp[mid])) lo = mid;
			else hi = mid;
		}
		return hi;
	}
}