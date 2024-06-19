import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		int answer = Integer.MIN_VALUE;
		for (int b = 0; b < (1 << (N * M)); b++) {
			int sum = 0;

			// 가로 조각 계산
			for (int i = 0; i < N; i++) {
				int partSum = 0;
				for (int j = 0; j < M; j++) {
					int idx = (N * M) - (i * M + j) - 1;
					if ((b & (1 << idx)) == 0) {
						partSum *= 10;
						partSum += map[i][j];
					} else {
						sum += partSum;
						partSum = 0;
					}
				}
				sum += partSum;
			}

			// 세로 조각 계산
			for (int j = 0; j < M; j++) {
				int partSum = 0;
				for (int i = 0; i < N; i++) {
					int idx = (N * M) - (i * M + j) - 1;
					if ((b & (1 << idx)) != 0) {
						partSum *= 10;
						partSum += map[i][j];
					} else {
						sum += partSum;
						partSum = 0;
					}
				}
				sum += partSum;
			}

			answer = Math.max(answer, sum);
		}

		System.out.println(answer);
	}
}