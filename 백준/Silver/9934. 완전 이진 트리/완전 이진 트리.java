import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int K, idx, SZ;
	static int[] arr;
	static StringBuffer[] ans;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		int SZ = (int)Math.pow(2, K) - 1;
		arr = new int[SZ];
		for (int i = 0; i < SZ; i++) {
			arr[i] = sc.nextInt();
		}
		ans = new StringBuffer[K];
		for (int i = 0; i < K; i++) {
			ans[i] = new StringBuffer();
		}

		dfs(0, SZ - 1, 0);
		for (int i = 0; i < K; i++) {
			System.out.println(ans[i].toString());
		}
	}

	static void dfs(int s, int e, int depth) {
		if (depth == K)
			return;


		ans[depth].append(arr[(s + e) / 2]).append(" ");

		dfs(s, (s + e) / 2 - 1, depth + 1);
		dfs((s + e) / 2 + 1, e, depth + 1);
	}

}