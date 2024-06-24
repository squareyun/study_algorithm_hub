import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, L;
	static int maxN = Integer.MIN_VALUE;
	static boolean[] v;
	static int answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		v = new boolean[1001];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int idx = Integer.parseInt(st.nextToken());
			v[idx] = true;
			maxN = Math.max(maxN, idx);
		}

		for (int i = 1; i <= maxN; i++) {
			if (!v[i])
				continue;

			int cnt = 0;
			for (int j = i; j < 1001; j++) {
				v[j] = false;
				if (++cnt >= L)
					break;
			}
			answer++;
		}

		System.out.println(answer);
	}
}