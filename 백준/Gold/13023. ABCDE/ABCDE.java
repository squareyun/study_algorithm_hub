import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static ArrayList<Integer>[] adjList;
	static boolean[] v;
	static int answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		v = new boolean[N];

		int a, b;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}

		for (int i = 0; i < N; i++) {
			if (answer != 1) dfs(i, 0);
		}

		System.out.println(answer);
	}

	static void dfs(int start, int depth) {
		if (depth == 4) {
			answer = 1;
			return;
		}

		v[start] = true;
		for (int next : adjList[start]) {
			if (v[next])
				continue;
			dfs(next, depth + 1);
		}
		v[start] = false;
	}
}