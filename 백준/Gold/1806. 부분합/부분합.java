import java.util.*;
import java.io.*;

public class Main {

	static int N, S;
	static long[] cum;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		cum = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cum[i] = cum[i - 1] + Integer.parseInt(st.nextToken());
		}

		// System.out.println(Arrays.toString(cum));
		int left = 0, right = 1;
		while (right <= N) {
			long sum = cum[right] - cum[left];

			if (sum >= S) {
				answer = Math.min(answer, right - left);
				left++;
			} else {
				right++;
			}
		}

		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}
}