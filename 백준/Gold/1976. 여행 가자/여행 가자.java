import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] p;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		p = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				int flag = Integer.parseInt(st.nextToken());

				if (i == j)
					continue;

				if (flag == 1) {
					unionSet(i, j);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solve(arr));
	}

	private static String solve(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			if (findSet(arr[i]) != findSet(arr[i + 1])) {
				return "NO";
			}
		}

		return "YES";
	}

	static void unionSet(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);

		p[rootB] = rootA;
	}

	static int findSet(int x) {
		if (p[x] == x) {
			return x;
		}

		return p[x] = findSet(p[x]);
	}
}