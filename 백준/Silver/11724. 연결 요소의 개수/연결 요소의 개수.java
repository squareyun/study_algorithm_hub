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
		adj = new ArrayList[N + 1];
		v = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj[from].add(to);
			adj[to].add(from);
		}

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (v[i]) continue;
			dfs(i);
			answer++;
		}
		System.out.println(answer);
	}

	static void dfs(int cur) {
		v[cur]=true;
		for (int next : adj[cur])
			if(!v[next]) dfs(next);
	}

}