import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static char[][] map;
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};
	static int answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		// find diff
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				char first = map[i][j];

				for (int d = 0; d < 2; d++) {
					int nx = i + dx[d], ny = j + dy[d];

					if (nx >= N || ny >= N)
						continue;
					char second = map[nx][ny];

					if (first != second) {
						map[i][j] = second;
						map[nx][ny] = first;
						calculate();
						map[i][j] = first;
						map[nx][ny] = second;
					}
				}
			}
		}

		System.out.println(answer);
	}

	static void calculate() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				for (int d = 0; d < 2; d++) {
					int nx = i + dx[d], ny = j + dy[d];
					int count = 1;

					while ((nx < N && ny < N) && (map[i][j] == map[nx][ny])) {
						count++;
						nx = nx + dx[d];
						ny = ny + dy[d];
					}

					answer = Math.max(answer, count);
				}
			}
		}
	}
}