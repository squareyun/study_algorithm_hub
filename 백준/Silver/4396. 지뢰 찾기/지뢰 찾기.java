import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] map = new char[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		char[][] res = new char[n][n];
		boolean xxx = false;
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (input[j] == '.') {
					res[i][j] = '.';
				} else {
					if (map[i][j] == '*')
						xxx = true;
					res[i][j] = find(i, j, map);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (xxx && map[i][j] == '*')
					System.out.print('*');
				else {
					System.out.print(res[i][j]);
				}
			}
			System.out.println();
		}
	}

	private static char find(int i, int j, char[][] map) {
		int[] dx = {1, 0, -1, 0, -1, -1, 1, 1};
		int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};
		int cnt = 0;
		for (int d = 0; d < 8; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			if (nx < 0 || nx >= map.length || ny < 0 || ny >= map.length)
				continue;
			if (map[nx][ny] == '*')
				cnt++;
		}
		return (char)('0' + cnt);
	}
}