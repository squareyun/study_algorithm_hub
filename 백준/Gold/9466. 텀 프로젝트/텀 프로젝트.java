import java.util.*;
import java.io.*;

public class Main {

	static int T;
	static int n;
	static List<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			n = Integer.parseInt(br.readLine());
			adj = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++) {
				adj[i] = new ArrayList<>();
			}

			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				int v = Integer.parseInt(st.nextToken());
				if (i != v) adj[i].add(v);
				else answer--;
			}

			// 위상 정렬
			List<Integer> hs = topologicalSort();
			answer += hs.size();
			System.out.println(answer);
		}
	}

	private static List<Integer> topologicalSort() {
		List<Integer> res = new ArrayList<>();
		int[] inDegree = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int v : adj[i]) {
				inDegree[v]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			res.add(cur);

			for (int v : adj[cur]) {
				if (--inDegree[v] == 0) {
					q.offer(v);
				}
			}
		}

		return res;
	}
}