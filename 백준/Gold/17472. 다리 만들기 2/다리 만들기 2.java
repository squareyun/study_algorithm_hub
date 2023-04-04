import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static ArrayList<Node>[] list; // 각 섬의 개별 좌표
	static int cnt = 1; // 섬의 개수
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static PriorityQueue<Node> pq;
	static int[] parents;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		v = new boolean[N][M];
		list = new ArrayList[7]; // 섬 최대 6개
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 섬 개수 및 번호 붙이기 (bfs)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!v[i][j] && map[i][j] == 1) {
					list[cnt] = new ArrayList<>();
					bfs(i, j);
					cnt++;
				}
			}
		}
		cnt--; // 하나 감소

		// 각 섬 연결할 수 있는 방법 구하기 (dfs)
		pq = new PriorityQueue<>();
		for (int i = 1; i < cnt; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				Node cur = list[i].get(j);
				// 각 섬 리스트를 확인하며 모든 곳 다 알아보기
				for (int d = 0; d < 4; d++) {
					dfs(cur.x, cur.y, i, d, -1);
				}
			}
		}

		// kruskal algorithm을 이용해 최소 신장 트리 구성
		System.out.println(kruskal());

	}

	private static int kruskal() {
		parents = new int[cnt + 1];
		for (int i = 1; i <= cnt; i++)
			parents[i] = i;

		int result = 0, count = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (union(cur.x, cur.y)) {
				result += cur.w;
				if (++count == cnt - 1) { // N - 1개 연결하면 끝
					break;
				}
			}
		}

		if (count != cnt - 1)
			return -1;
		else if (result == 0) {
			return -1;
		}
		return result;
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parents[aRoot] = bRoot;
		return true;
	}

	private static int find(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	private static void dfs(int x, int y, int curIsland, int d, int len) {
		// 다른 섬 만날 경우 다리 연결 성공
		if (map[x][y] != 0 && map[x][y] != curIsland) {
			if (len >= 2)
				pq.offer(new Node(curIsland, map[x][y], len)); // a번 섬에서 b번 섬으로 길이 len
			return;
		}

		int nx = x + dx[d];
		int ny = y + dy[d];
		if (nx < 0 || nx >= N || ny < 0 || ny >= M)
			return;
		if (map[nx][ny] == curIsland)
			return;
		dfs(nx, ny, curIsland, d, len + 1);
	}

	private static void bfs(int i, int j) {
		Queue<Node> q = new ArrayDeque<>();
		list[cnt].add(new Node(i, j));
		q.offer(new Node(i, j));
		v[i][j] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();
			map[cur.x][cur.y] = cnt;
			list[cnt].add(new Node(cur.x, cur.y));

			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

				if (v[nx][ny] || map[nx][ny] != 1)
					continue;

				v[nx][ny] = true;
				q.offer(new Node(nx, ny));
			}
		}
	}

	static class Node implements Comparable<Node> {
		int x, y, w;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Node(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}

	}
}