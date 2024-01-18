import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] dx = {1, 0, -1, 0, 0, 0};
		int[] dy = {0, 1, 0, -1, 0, 0};
		int[] dz = {0, 0, 0, 0, 1, -1};

		StringBuffer sb = new StringBuffer();
		while (L != 0 && R != 0 && C != 0) {
			char[][][] map = new char[L][R][C];

			Data start = null;
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String s = br.readLine();
					for (int k = 0; k < C; k++) {
						map[i][j][k] = s.charAt(k);
						if (map[i][j][k] == 'S')
							start = new Data(i, j, k, 0);
					}
				}
				br.readLine();
			}

			Queue<Data> q = new ArrayDeque<>();
			boolean[][][] v = new boolean[L][R][C];
			q.offer(start);
			v[start.x][start.y][start.z] = true;

			int answer = -1;
			while (!q.isEmpty()) {
				Data cur = q.poll();

				for (int d = 0; d < 6; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					int nz = cur.z + dz[d];
					
					if (nx < 0 || nx >= L || ny < 0 || ny >= R || nz < 0 || nz >= C)
						continue;

					if (v[nx][ny][nz])
						continue;

					if (map[nx][ny][nz] == '#')
						continue;

					if (map[nx][ny][nz] == 'E') {
						answer = cur.n + 1;
						break;
					}
					q.offer(new Data(nx, ny, nz, cur.n + 1));
					v[nx][ny][nz] = true;
				}

				if (answer != -1)
					break;
			}

			if (answer != -1) {
				sb.append("Escaped in ").append(answer).append(" minute(s).\n");
			} else {
				sb.append("Trapped!\n");
			}

			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
		}

		System.out.println(sb);
	}

	static class Data {
		int x, y, z, n;

		public Data(int x, int y, int z, int n) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.n = n;
		}
	}
}