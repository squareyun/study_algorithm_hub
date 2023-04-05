import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, adj[][], cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N + 1][N + 1]; // 자신보다 키가 큰 관계를 표현

			int a, b;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adj[a][b] = 1; // 유향
			}

			int ans = 0;
			for (int k = 1; k <= N; k++) {
				cnt = 0;
				gtDFS(k, new boolean[N + 1]);
				ltDFS(k, new boolean[N + 1]);
				if (cnt == N - 1) {
					ans++;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	// 자신보다 큰 애를 따라서 DFS 수행
	static void gtDFS(int cur, boolean[] visited) {
		// cur 정점 기준으로 자신보다 큰 정점 탐색
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if (adj[cur][i] == 1 && !visited[i]) {
				cnt++;
				gtDFS(i, visited);
			}
		}
	}

	// 자신보다 작은애 애를 따라서 DFS 수행
	static void ltDFS(int cur, boolean[] visited) {
		// cur 정점 기준으로 자신보다 큰 정점 탐색
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if (adj[i][cur] == 1 && !visited[i]) {
				cnt++;
				ltDFS(i, visited);
			}
		}
	}

}