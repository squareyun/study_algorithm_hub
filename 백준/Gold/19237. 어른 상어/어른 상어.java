import java.util.*;
import java.io.*;

public class Main {

	static int N, M, k;
	static int[][] mapSmell;
	static int[][] mapTime;

	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};

	static int[][][] priority;
	static Shark[] shark;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		mapSmell = new int[N + 1][N + 1];
		mapTime = new int[N + 1][N + 1];
		shark = new Shark[M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int cur = Integer.parseInt(st.nextToken());

				if (cur > 0) {
					shark[cur] = new Shark(i, j);
					mapTime[i][j] = k;
					mapSmell[i][j] = cur;
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			shark[i].d = Integer.parseInt(st.nextToken());
		}

		priority = new int[M + 1][5][4];
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) {
					priority[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		System.out.println(solve());
	}

	private static int solve() {
		int time = 0;

		while (time <= 1000) {

			// 1번 상어 혼자 남은 경우 종료
			int cnt = 0;
			for (int i = 1; i <= M; i++) {
				if (shark[i] != null) cnt++;
			}
			if (cnt == 1 && shark[1] != null)
				return time;

			// 상어 이동
			int[][] nextMap = new int[N + 1][N + 1];
			for (int i = 1; i <= M; i++) {
				if (shark[i] != null)
					moveShark(nextMap, i);
			}

			// 시간 감소
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (mapTime[i][j] > 0)
						mapTime[i][j]--;

					if (mapTime[i][j] == 0)
						mapSmell[i][j] = 0;
				}
			}

			// 냄새 남기기
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (nextMap[i][j] > 0) {
						mapTime[i][j] = k;
						mapSmell[i][j] = nextMap[i][j];
					}
				}
			}

			time++;
		}

		return -1;
	}

	private static void moveShark(int[][] nextMap, int m) {

		int d = 0, nx = -1, ny = -1;
		boolean flag = false;

		for (int i = 0; i < 4; i++) {
			d = priority[m][shark[m].d][i];
			nx = shark[m].x + dx[d];
			ny = shark[m].y + dy[d];

			if ((1 <= nx && nx <= N) && (1 <= ny && ny <= N) && mapSmell[nx][ny] == 0) {
				flag = true;
				break;
			}
		}

		// 내 냄새 찾기
		if (!flag) {
			for (int i = 0; i < 4; i++) {
				d = priority[m][shark[m].d][i];
				nx = shark[m].x + dx[d];
				ny = shark[m].y + dy[d];

				if ((1 <= nx && nx <= N) && (1 <= ny && ny <= N) && mapSmell[nx][ny] == m) {
					break;
				}
			}
		}

		if (nextMap[nx][ny] != 0) {
			shark[m] = null;
			return;
		}

		nextMap[nx][ny] = m;
		shark[m].x = nx;
		shark[m].y = ny;
		shark[m].d = d;
	}

	static class Shark {
		int x, y, d;

		public Shark(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Shark(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

}