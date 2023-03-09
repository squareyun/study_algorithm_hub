import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		int[] inDegree = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		int K;
		int[] singer;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			singer = new int[K];
			for (int j = 0; j < K; j++) {
				singer[j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 1; j < K; j++) {
				list[singer[j - 1]].add(singer[j]);
				inDegree[singer[j]]++;
			}
		}

		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0)
				q.offer(i);
		}

		ArrayList<Integer> ans = new ArrayList<>();
		int cur;
		while (!q.isEmpty()) {
			cur = q.poll();
			ans.add(cur);
			for (int idx : list[cur]) {
				if (--inDegree[idx] == 0)
					q.offer(idx);
			}
		}

		if (ans.size() != N) {
			System.out.println(0);
		} else {
			StringBuilder sb = new StringBuilder();
			for (int a : ans) {
				sb.append(a).append("\n");
			}
			System.out.println(sb);
		}

	}

}