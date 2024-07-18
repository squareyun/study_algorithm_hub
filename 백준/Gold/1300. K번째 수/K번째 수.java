import java.util.*;
import java.io.*;

public class Main {

	static int N, K;
	static int[][] A;
	static int[] B;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		// B[K] = x 에 대해, x의 값을 역으로 추정하는 이분 탐색
		long left = 1;
		long right = K; // x <= K
		long answer = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			long cnt = 0;

			for (int i = 1; i <= N; i++) {
				cnt += Math.min(N, mid / i);
			}

			if (cnt < K) {
				left = mid + 1;
			} else {
				answer = mid;
				right = mid - 1;
			}
		}

		System.out.println(answer);
	}
}