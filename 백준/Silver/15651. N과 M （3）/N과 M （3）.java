import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] arr;
	static int[] brr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		brr = new int[M];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		dfs(0);

		System.out.println(sb);
	}

	static void dfs(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(brr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			brr[cnt] = arr[i];
			dfs(cnt + 1);
		}
	}
}