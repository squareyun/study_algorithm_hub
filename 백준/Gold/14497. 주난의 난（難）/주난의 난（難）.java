import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int sx, sy, ex, ey;
	static char[][] map;
	static int[][] dist;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;
		ex = Integer.parseInt(st.nextToken()) - 1;
		ey = Integer.parseInt(st.nextToken()) - 1;

		map = new char[N][M];
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		map[sx][sy] = '0';
		map[ex][ey] = '1';

		dijkstra();
	}

	static void dijkstra() {
		PriorityQueue<Data> pq = new PriorityQueue<Data>();
		pq.offer(new Data(sx, sy, 0));
		dist[sx][sy] = 0;

		while (!pq.isEmpty()) {
			Data cur = pq.poll();

			if (cur.x == ex && cur.y == ey) {
				System.out.println(dist[ex][ey]);
				return;
			}

			if (cur.w > dist[cur.x][cur.y]) continue;

			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

				if (dist[nx][ny] > dist[cur.x][cur.y] + (map[nx][ny] - '0')) {
					dist[nx][ny] = dist[cur.x][cur.y] + (map[nx][ny] - '0');
					pq.offer(new Data(nx, ny, dist[nx][ny]));
				}
			}
		}

	}

	static class Data implements Comparable<Data> {
		int x, y, w;

		public Data(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.w, o.w);
		}
	}
}