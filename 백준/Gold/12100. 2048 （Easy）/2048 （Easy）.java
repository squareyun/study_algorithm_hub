import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, answer;
	static int[][] map;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		arr = new int[5];
		dfs(0); // 조합 찾기
		System.out.println(answer);
	}

	static void dfs(int cnt) {
		if (cnt == 5) {
			int[][] newMap = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					newMap[i][j] = map[i][j];
				}
			}

			// 이동
			for (int i = 0; i < 5; i++) {
				move(arr[i], newMap);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					answer = Math.max(answer, newMap[i][j]);
				}
			}

			return;
		}

		for (int i = 0; i < 4; i++) {
			arr[cnt] = i;
			dfs(cnt + 1);
		}
	}

	private static void move(int d, int[][] newMap) {
		switch (d) {
			case 0: // 상
				for (int i = 0; i < N; i++) {
					int idx = 0;
					int block = 0; // 이전에 확인한 블록의 숫자
					for (int j = 0; j < N; j++) {
						if (newMap[j][i] == 0)
							continue;

						if (newMap[j][i] == block) {
							newMap[idx - 1][i] = block * 2;
							block = 0;
							newMap[j][i] = 0;
						} else {
							block = newMap[j][i];
							newMap[j][i] = 0;
							newMap[idx][i] = block;
							idx++;
						}
					}
				}
				break;
			case 1: // 하
				for (int i = 0; i < N; i++) {
					int idx = N - 1;
					int block = 0;
					for (int j = N - 1; j >= 0; j--) {
						if (newMap[j][i] == 0)
							continue;

						if (newMap[j][i] == block) {
							newMap[idx + 1][i] = block * 2;
							block = 0;
							newMap[j][i] = 0;
						} else {
							block = newMap[j][i];
							newMap[j][i] = 0;
							newMap[idx][i] = block;
							idx--;
						}
					}
				}
				break;
			case 2: // 좌
				for (int i = 0; i < N; i++) {
					int idx = 0;
					int block = 0;
					for (int j = 0; j < N; j++) {
						if (newMap[i][j] == 0)
							continue;

						if (newMap[i][j] == block) {
							newMap[i][idx - 1] = block * 2;
							block = 0;
							newMap[i][j] = 0;
						} else {
							block = newMap[i][j];
							newMap[i][j] = 0;
							newMap[i][idx] = block;
							idx++;
						}
					}
				}
				break;
			case 3: // 우
				for (int i = 0; i < N; i++) {
					int idx = N - 1;
					int block = 0;
					for (int j = N - 1; j >= 0; j--) {
						if (newMap[i][j] == 0)
							continue;

						if (newMap[i][j] == block) {
							newMap[i][idx + 1] = block * 2;
							block = 0;
							newMap[i][j] = 0;
						} else {
							block = newMap[i][j];
							newMap[i][j] = 0;
							newMap[i][idx] = block;
							idx--;
						}
					}
				}
				break;
		}
	}
}