import java.util.*;
import java.io.*;

public class Main {

	static int N, K;
	static int[] W, V;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		W = new int[N + 1];
		V = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[K + 1];
		for (int i = 1; i <= N; i++) {
			for (int w = K; w - W[i] >= 0; w--) {
				dp[w] = Math.max(dp[w], dp[w - W[i]] + V[i]);
			}
		}
		System.out.println(dp[K]);
	}
}