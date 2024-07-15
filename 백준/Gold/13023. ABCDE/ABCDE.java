import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static List<Integer>[] adj;
	static boolean[] v;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N];
		v = new boolean[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}
		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			adj[from].add(to);
			adj[to].add(from);
		}

		boolean res = false;
		for (int i = 0; i < N; i++) {
			v[i] = true;
			res = dfs(i, 1);
			if (res) break;
			v[i] = false;
		}
		System.out.println(res ? 1 : 0);
	}

	static boolean dfs(int cur, int cnt) {
		if (cnt == 5)
			return true;

		for (int i : adj[cur]) {
			if (v[i]) continue;
			v[i] = true;
			boolean res = dfs(i, cnt + 1);
			if (res) return true;
			v[i] = false;
		}

		return false;
	}
}