import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static int minNM;

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		minNM = Math.min(N, M);

		while (R-- > 0) {
			map = rotate();
		}
		print();
	}

	private static int[][] rotate() {
		int[][] newMap = new int[N][M];

		for (int k = 0; k < minNM; k++) {
			int x = k;
			int y = k;

			for (int d = 0; d < 4; ) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < k || ny < k || nx >= N - k || ny >= M - k) {
					d++;
					continue;
				}

				newMap[nx][ny] = map[x][y];
				x = nx;
				y = ny;
			}
		}

		return newMap;
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}