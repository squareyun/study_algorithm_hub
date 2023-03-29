import java.util.Scanner;

public class Main {

	static int N, cnt;
	static int[][] map;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dfs(1, 2, 0);
		System.out.println(cnt);
	}

	// status 0: 가로, 1: 대각선, 2: 세로
	private static void dfs(int r, int c, int status) {
		if (r > N || c > N) {
			return;
		}
		if (status == 1) {
			if (map[r-1][c] == 1 || map[r][c-1] == 1)
				return;
		}
		
		if (map[r][c] == 1) {
			return;
		}
		
		// 기저 조건
		if (r == N && c == N) {
			cnt += 1;
			return;
		}

		if (status == 0) {
			dfs(r, c + 1, 0);
			dfs(r + 1, c + 1, 1);
		} else if (status == 1) {
			dfs(r, c + 1, 0);
			dfs(r + 1, c, 2);
			dfs(r + 1, c + 1, 1);
		} else if (status == 2) {
			dfs(r + 1, c, 2);
			dfs(r + 1, c + 1, 1);
		}
	}

}