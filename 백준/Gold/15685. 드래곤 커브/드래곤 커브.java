import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static boolean[][] map = new boolean[101][101];

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			List<Integer> dirList = makeDragonCurve(d, g);
			drawDragon(dirList, x, y);
		}

		int answer = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1])
					answer++;
			}
		}
		System.out.println(answer);
	}

	private static void drawDragon(List<Integer> dirList, int x, int y) {
		map[x][y] = true;

		int nx = x, ny = y;
		for (int d : dirList) {
			nx += dx[d];
			ny += dy[d];
			map[nx][ny] = true;
		}
	}

	private static List<Integer> makeDragonCurve(int d, int g) {
		List<Integer> dirList = new ArrayList<>();

		dirList.add(d); // 0세대 방향
		while (g-- > 0) {
			for (int i = dirList.size() - 1; i >= 0; i--) {
				dirList.add((dirList.get(i) + 1) % 4);
			}
		}
		return dirList;
	}
}