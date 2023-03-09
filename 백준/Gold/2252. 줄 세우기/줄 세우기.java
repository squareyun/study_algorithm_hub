import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static ArrayList<Integer>[] list;
	static int[] inDegree;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		inDegree = new int[N + 1];

		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<>();

		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			inDegree[b]++;
		}

		ArrayList<Integer> ret = topologySort();
		for (Integer r : ret) {
			System.out.printf("%d ", r);
		}
	}

	private static ArrayList<Integer> topologySort() {
		ArrayList<Integer> ret = new ArrayList<>();
		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0)
				q.offer(i);
		}

		Integer cur;
		while (!q.isEmpty()) {
			cur = q.poll();
			ret.add(cur);
			for (int idx : list[cur]) {
				if (--inDegree[idx] == 0)
					q.offer(idx);
			}
		}
		return ret;
	}
}