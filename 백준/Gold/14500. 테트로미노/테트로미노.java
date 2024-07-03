import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[][] map;
	static int ans = -1;

	static int[][][] tetrominoes = {
		// | 모양 테트로미노
		{{0,0}, {0,1}, {0,2}, {0,3}},
		{{0,0}, {1,0}, {2,0}, {3,0}},

		// ㅁ 모양 테트로미노
		{{0,0}, {0,1}, {1,0}, {1,1}},

		// T 모양 테트로미노
		{{0,0},{1,0},{2,0},{1,1}},
		{{0,0},{0,1},{0,2},{1,1}},
		{{0,0},{-1,0},{1,0},{0,-1}},
		{{0,0},{0,1},{0,2},{-1,1}},

		// L 모양 테트로미노
		{{0,0},{1,0},{2,0},{2,1}},
		{{0,0},{0,1},{0,2},{1,2}},
		{{0,0},{1,0},{1,1},{1,2}},
		{{0,0},{0,-1},{1,-1},{2,-1}},
		{{0,0},{1,0},{2,0},{2,-1}},
		{{0,0},{0,-1},{0,-2},{1,-2}},
		{{0,0},{1,0},{1,-1},{1,-2}},
		{{0,0},{0,1},{1,1},{2,1}},

		// S 모양 테트로미노
		{{0,0},{1,0},{1,1},{2,1}},
		{{0,0},{0,1},{-1,1},{-1,2}},
		{{0,0},{0,1},{1,1},{1,2}},
		{{0,0},{-1,0},{-1,1},{-2,1}},
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int[][] tetromino : tetrominoes) {
					cal(i, j, tetromino);
				}
			}
		}
		System.out.println(ans);
	}

	static void cal(int x, int y, int[][] shape) {
		int sum = 0;
		for (int[] d : shape) {
			int nx = x + d[0];
			int ny = y + d[1];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;
			sum += map[nx][ny];
		}
		ans = Math.max(ans, sum);
	}
}