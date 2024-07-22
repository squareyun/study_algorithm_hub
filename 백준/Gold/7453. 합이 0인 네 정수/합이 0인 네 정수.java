import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static long[] a, b, c, d;
	static long[] ab, cd;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new long[n];
		b = new long[n];
		c = new long[n];
		d = new long[n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Long.parseLong(st.nextToken());
			b[i] = Long.parseLong(st.nextToken());
			c[i] = Long.parseLong(st.nextToken());
			d[i] = Long.parseLong(st.nextToken());
		}
		ab = new long[n * n];
		cd = new long[n * n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ab[i * n + j] = a[i] + b[j];
				cd[i * n + j] = c[i] + d[j];
			}
		}
		Arrays.sort(ab);
		Arrays.sort(cd);

		int left = 0, right = n * n - 1;
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
				left++;
			} else if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println(answer);
	}
}