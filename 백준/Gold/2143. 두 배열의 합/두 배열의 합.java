import java.util.*;
import java.io.*;

public class Main {

	static int T, n, m;
	static int[] A, B;
	static long[] sumA, sumB;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new StringReader(input));
		T = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		m = Integer.parseInt(br.readLine());
		B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int lenSumA = n * (n + 1) / 2;
		int lenSumB	= m * (m + 1) / 2;
		sumA = new long[lenSumA];
		sumB = new long[lenSumB];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			long sum = 0;
			for (int j = i; j < n; j++) {
				sum += A[j];
				sumA[idx++] = sum;
			}
		}

		idx = 0;
		for (int i = 0; i < m; i++) {
			long sum = 0;
			for (int j = i; j < m; j++) {
				sum += B[j];
				sumB[idx++] = sum;
			}
		}

		Arrays.sort(sumA);
		Arrays.sort(sumB);

		long answer = 0;
		int left = 0, right = lenSumB - 1;
		while (left < lenSumA && right >= 0) {
			long sum = sumA[left] + sumB[right];

			if (sum < T) left++;
			else if (sum > T) right--;
			else {
				// 중복 계산
				long cntA = 0, cntB = 0;
				long curSumA = sumA[left], curSumB = sumB[right];
				while (left < lenSumA && curSumA == sumA[left]) {
					cntA++;
					left++;
				}

				while (right >= 0 && curSumB == sumB[right]) {
					cntB++;
					right--;
				}

				answer += cntA * cntB;
			}
		}

		System.out.println(answer);
	}

	static String input = "5\n"
		+ "4\n"
		+ "1 3 1 2\n"
		+ "3\n"
		+ "1 3 2";
}