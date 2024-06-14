import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static int[] arr, brr;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		brr = new int[N];
		v = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		dfs(0);
		System.out.println(sb);
	}

	static void dfs(int cnt) {
		if (cnt == N) {
			for (int b : brr)
				sb.append(b).append(' ');
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (v[i]) continue;

			brr[cnt] = arr[i];
			v[i] = true;
			dfs(cnt + 1);
			v[i] = false;
		}
	}
}