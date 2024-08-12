import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static char[][] matrix;
	static int[] arr;
	static boolean found;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		matrix = new char[n][n];
		String s = br.readLine();
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				matrix[i][j] = s.charAt(idx++);
			}
		}
		arr = new int[n];
		dfs(0);

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	static void dfs(int cnt) {
		if (cnt > 0 && cnt <= n) {
			for (int i = 0; i < cnt; i++) {
				int sum = 0;
				for (int j = i; j < cnt; j++) {
					sum += arr[j];
					if (!valid(sum, i, j)) return;
				}
			}

			if (cnt == n) {
				found = true;
				return;
			}
		}

		for (int i = -10; i <= 10; i++) {
			arr[cnt] = i;
			dfs(cnt + 1);
			if (found) return;
		}
	}

	static boolean valid(int sum, int i, int j) {
		if (sum > 0) {
			return matrix[i][j] == '+';
		} else if (sum < 0) {
			return matrix[i][j] == '-';
		} else {
			return matrix[i][j] == '0';
		}
	}
}