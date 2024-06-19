import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] A;
	static int[] B;
	static boolean[] v;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		v = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0);
		System.out.println(answer);
	}

	static void dfs(int cnt) {
		if (cnt == N) {
			int cur = 0;
			for (int i = 1; i < N; i++) {
				cur += Math.abs(B[i - 1] - B[i]);
			}
			answer = Math.max(answer, cur);
			return;
		}

		for (int i = 0; i < N; i++) {
			if(v[i]) continue;

			B[cnt] = A[i];
			v[i] = true;
			dfs(cnt + 1);
			v[i] = false;
		}
	}
}