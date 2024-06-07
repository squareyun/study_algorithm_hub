import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] brr;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		brr = new int[N];
		v = new boolean[N];

		dfs(0);
		System.out.println(sb);
	}

	static void dfs(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(brr[i]).append(' ');
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (v[i]) continue;

			v[i] = true;
			brr[cnt] = i + 1;
			dfs(cnt + 1);
			v[i] = false;
		}
	}
}