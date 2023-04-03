import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static final int INF = 987654321;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] g = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					g[i][j] = sc.nextInt();
					if (i != j && g[i][j] == 0)
						g[i][j] = INF;
				}
			}

			// floyd washall
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (i == k) continue;
					for (int j = 0; j < N; j++) {
						if (i == j || j ==k ) continue;
						g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
					}
				}
			}

			int[] cc = new int[N];
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != j) {
						cc[i] += g[i][j];
					}
				}
				ans = Math.min(ans, cc[i]);
			}

			System.out.printf("#%d %d\n", tc, ans);

		}
	}

}