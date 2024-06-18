import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

	static int N, M;
	static int[] arr, brr;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = IntStream.rangeClosed(1, N).toArray();
		brr = new int[M];
		v = new boolean[N];

		dfs(0, 0);
		System.out.println(sb);
	}

	static void dfs(int cnt, int start) {
		if (cnt == M) {
			for (int b : brr)
				sb.append(b).append(' ');
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			brr[cnt] = arr[i];
			dfs(cnt + 1, i);
		}
	}
}