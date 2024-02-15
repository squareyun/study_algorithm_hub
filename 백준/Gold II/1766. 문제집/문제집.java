import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static Node[] adjList;
	static int[] inDegree;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		inDegree = new int[N + 1];
		adjList = new Node[N + 1];

		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;
		}

		// topology sort
		ArrayList<Integer> answer = new ArrayList<>();
		Queue<Integer> q = new PriorityQueue<>(); // 기존 ArrayDeque

		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0)
				q.offer(i);
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			answer.add(cur);

			for (Node temp = adjList[cur]; temp != null; temp = temp.link) {
				if (--inDegree[temp.vertex] == 0) {
					q.offer(temp.vertex);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i : answer) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

	static class Node {
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}
}