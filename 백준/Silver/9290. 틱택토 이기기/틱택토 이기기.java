import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			char[][] map = new char[3][3];
			for (int i = 0; i < 3; i++) {
				map[i] = br.readLine().toCharArray();
			}
			char target = br.readLine().charAt(0);
			solve(map, target);
			print(sb, t, map);
		}
		System.out.println(sb);
	}

	private static void solve(char[][] map, char target) {
		// 가로
		for (int i = 0; i < 3; i++) {
			int cnt = 0;
			int jMemo = 0;
			for (int j = 0; j < 3; j++) {
				if (map[i][j] == target) cnt++;
				else jMemo = j;
			}
			if (cnt == 2) {
				map[i][jMemo] = target;
				return;
			}
		}

		// 세로
		for (int i = 0; i < 3; i++) {
			int cnt = 0;
			int jMemo = 0;
			for (int j = 0; j < 3; j++) {
				if (map[j][i] == target) cnt++;
				else jMemo = j;
			}
			if (cnt == 2) {
				map[jMemo][i] = target;
				return;
			}
		}

		// 대각선
		int cnt = 0;
		int iMemo = 0;
		for (int i = 0; i < 3; i++) {
			if (map[i][i] == target) cnt++;
			else iMemo = i;
		}
		if (cnt == 2) {
			map[iMemo][iMemo] = target;
			return;
		}
		if (map[0][2] != target)
			map[0][2] = target;
		else if (map[1][1] != target)
			map[1][1] = target;
		else if (map[2][0] != target)
			map[2][0] = target;
	}

	private static void print(StringBuilder sb, int t, char[][] map) {
		sb.append("Case ").append(t).append(":").append("\n");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
	}

}