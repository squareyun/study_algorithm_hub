import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static long[][] abcd;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new StringReader(input));
		n = Integer.parseInt(br.readLine());
		abcd = new long[4][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				abcd[j][i] = Long.parseLong(st.nextToken());
			}
		}

		long[] ab = new long[n * n];
		long[] cd = new long[n * n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ab[i * n + j] = abcd[0][i] + abcd[1][j];
				cd[i * n + j] = abcd[2][i] + abcd[3][j];
			}
		}
		Arrays.sort(ab);
		Arrays.sort(cd);
		// System.out.println(Arrays.toString(ab));
		// System.out.println(Arrays.toString(cd));

		int left = 0;
		int right = n * n - 1;
		long answer = 0;

		while (left < n * n && right >= 0) {
			long sum = ab[left] + cd[right];

			if (sum == 0) {
				long leftCnt = 1, rightCnt = 1;
				while (left + 1 < n * n && ab[left] == ab[left + 1]) {
					left++;
					leftCnt++;
				}
				while (right - 1 >= 0 && cd[right] == cd[right - 1]) {
					right--;
					rightCnt++;
				}
				answer += leftCnt * rightCnt;
				right--;
			} else if (sum > 0) {
				right--;
			} else {
				left++;
			}
		}

		System.out.println(answer);
	}

	static String input = "6\n"
		+ "-45 22 42 -16\n"
		+ "-41 -27 56 30\n"
		+ "-36 53 -37 77\n"
		+ "-36 30 -75 -46\n"
		+ "26 -38 -10 62\n"
		+ "-32 -54 -6 45";
}