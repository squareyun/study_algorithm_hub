import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
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

		st = new StringTokenizer(br.readLine());
		while (R-- > 0) {
			int op = Integer.parseInt(st.nextToken());
			switch (op) {
				case 1:
					map = reverseUpDown();
					break;
				case 2:
					map = reverseLeftRight();
					break;
				case 3:
					map = rotateRight90();
					swapNM();
					break;
				case 4:
					map = rotateLeft90();
					swapNM();
					break;
				case 5:
					map = rotatePartClockwise();
					break;
				case 6:
					map = rotatePartCounterClockwise();
					break;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	// 상하 반전
	static int[][] reverseUpDown() {
		int[][] newMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			newMap[i] = map[N - i - 1];
		}
		return newMap;
	}

	// 좌우 반전
	static int[][] reverseLeftRight() {
		int[][] newMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][M - j - 1];
			}
		}
		return newMap;
	}

	// 오른쪽 90도
	static int[][] rotateRight90() {
		int[][] newMap = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[j][N - i - 1] = map[i][j];
			}
		}
		return newMap;
	}

	// 왼쪽 90도
	static int[][] rotateLeft90() {
		int[][] newMap = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[M - j - 1][i] = map[i][j];
			}
		}
		return newMap;
	}

	static int[][] rotatePartClockwise() {
		int[][] newMap = new int[N][M];
		int hN = N / 2;
		int hM = M / 2;
		for (int i = 0; i < hN; i++) {
			for (int j = 0; j < hM; j++) {
				newMap[i][j + hM] = map[i][j];
				newMap[i + hN][j + hM] = map[i][j + hM];
				newMap[i + hN][j] = map[i + hN][j + hM];
				newMap[i][j] = map[i + hN][j];
			}
		}
		return newMap;
	}

	static int[][] rotatePartCounterClockwise() {
		int[][] newMap = new int[N][M];
		int hN = N / 2;
		int hM = M / 2;
		for (int i = 0; i < hN; i++) {
			for (int j = 0; j < hM; j++) {
				newMap[i+hN][j] = map[i][j];
				newMap[i+hN][j+hM] = map[i+hN][j];
				newMap[i][j + hM] = map[i + hN][j + hM];
				newMap[i][j] = map[i][j + hM];
			}
		}
		return newMap;
	}

	static void swapNM() {
		int temp = N;
		N = M;
		M = temp;
	}
}