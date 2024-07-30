import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}

		ArrayList<Integer> answer = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					int ret = bfs(i, j);
					answer.add(ret);
				}
			}
		}
		Collections.sort(answer);

		StringBuilder sb = new StringBuilder();
		sb.append(answer.size()).append("\n");
		for (int i : answer) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

	static int bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] v = new boolean[N][N];
		q.offer(new int[] {x, y});
		v[x][y] = true;

		int cnt = 0;
		while (!q.isEmpty()) {
			int[] data = q.poll();
			int cx = data[0];
			int cy = data[1];
			cnt++;

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if (!v[nx][ny] && map[nx][ny] == 1) {
					v[nx][ny] = true;
					map[nx][ny] = 2;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		return cnt;
	}

}