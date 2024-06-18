import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] S;
	static boolean[] v;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N + 1][N + 1];
		v = new boolean[N + 1];

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 이전 문제와 다르게 부분 집합으로 계산
		dfs(0);
		System.out.println(answer);
	}

	static void dfs(int cnt) {
		if (cnt == N) {
			int start = 0;
			int link = 0;

			for (int i = 1; i <= N; i++) {
				for (int j = i + 1; j <= N; j++) {
					if (v[i] != v[j]) continue;

					if (v[i]) start += S[i][j] + S[j][i];
					else link += S[i][j] + S[j][i];
				}
			}

			answer = Math.min(answer, Math.abs(start - link));
			return;
		}

		v[cnt + 1] = true;
		dfs(cnt + 1);
		v[cnt + 1] = false;
		dfs(cnt + 1);
	}
}