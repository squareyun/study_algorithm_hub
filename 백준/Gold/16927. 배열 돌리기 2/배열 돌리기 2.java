import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R, minNM;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		minNM = Math.min(N, M);

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < minNM / 2; i++) {
			int[] layer = extractLayer(i, i, i);
			int[] rotatedLayer = rotateLayer(layer);
			copyToMap(i, rotatedLayer);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void copyToMap(int depth, int[] layer) {
		int x = depth;
		int y = depth;
		int idx = 0;

		map[x][y] = layer[idx++];

		for (int d = 0; d < 4; ) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < depth || ny < depth || nx >= N - depth || ny >= M - depth) {
				d++;
				continue;
			}

			if (idx >= layer.length)
				break;

			map[nx][ny] = layer[idx++];
			x = nx;
			y = ny;
		}
	}

	static int[] rotateLayer(int[] layer) {
		int len = layer.length;
		int r = R % len;

		int[] newLayer = new int[len];
		for (int i = 0; i < len; i++) {
			newLayer[(i + r) % len] = layer[i];
		}

		return newLayer;
	}

	static int[] extractLayer(int depth, int x, int y) {
		// 둘레
		int[] layer = new int[2 * (N - depth - 1 - depth) + 2 * (M - depth - 1 - depth)];
		layer[0] = map[x][y];

		int idx = 1;
		for (int d = 0; d < 4; ) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < depth || ny < depth || nx >= N - depth || ny >= M - depth) {
				d++;
				continue;
			}

			if (idx >= layer.length)
				break;

			layer[idx++] = map[nx][ny];
			x = nx;
			y = ny;
		}

		return layer;
	}
}