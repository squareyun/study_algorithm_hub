import java.util.*;
import java.io.*;

public class Main {

	static int N, idx;
	static int[] A, dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N + 1];

		idx = 0;
		for (int i = 0; i < N; i++) {
			if (dp[idx] < A[i]) {
				dp[++idx] = A[i];
			} else {
				int pos = lowerBound(0, idx, A[i]);
				dp[pos] = A[i];
			}
		}
		System.out.println(idx);
	}

	private static int lowerBound(int lo, int hi, int K) {
		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;

			if (!(K <= dp[mid]))
				lo = mid;
			else
				hi = mid;
		}
		return hi;
	}
}