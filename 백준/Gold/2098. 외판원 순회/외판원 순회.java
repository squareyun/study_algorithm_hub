import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] W;
	static int[][] dp;

	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		dp = new int[N][(1 << N) - 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dp[i], -1);
		}

		// 0번째 도시부터 방문, 0번째 도시 방문 처리
		System.out.println(tsp(0, 1));
	}

	static int tsp(int cur, int visited) {
		// 현재 위치에서 출발점(0)으로 돌아가기
		if (visited == (1 << N) - 1) {
			if (W[cur][0] == 0) return INF;
			else return W[cur][0];
		}

		// memorization
		if (dp[cur][visited] != -1)
			return dp[cur][visited];

		dp[cur][visited] = INF;

		for (int i = 0; i < N; i++) {
			if (W[cur][i] == 0 || (visited & (1 << i)) != 0) continue;
			dp[cur][visited] = Math.min(dp[cur][visited], W[cur][i] + tsp(i, (visited | (1 << i))));
		}

		return dp[cur][visited];
	}
}