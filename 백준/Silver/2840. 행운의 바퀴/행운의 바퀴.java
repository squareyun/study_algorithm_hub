import java.util.*;
import java.io.*;

public class Main {

	static int N, K;
	static char[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new char[N];
		for (int i = 0; i < N; i++) {
			arr[i] = '?';
		}

		boolean flag = false;
		int idx = 0;
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			idx = idx - S % N;
			if (idx < 0) idx = N - Math.abs(idx);
			if (arr[idx] == '?' || arr[idx] == C)
				arr[idx] = C;
			else {
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println("!");
			return;
		}


		int[] alpha = new int[26];
		StringBuilder sb = new StringBuilder();
		for (int i = idx; i < N; i++) {
			sb.append(arr[i]);
			if (arr[i] == '?') continue;

			if (alpha[arr[i] - 'A'] > 0) {
				flag = true;
				break;
			}
			alpha[arr[i] - 'A']++;
		}
		for (int i = 0; i < idx; i++) {
			sb.append(arr[i]);
			if (arr[i] == '?') continue;

			if (alpha[arr[i] - 'A'] > 0) {
				flag = true;
				break;
			}
			alpha[arr[i] - 'A']++;
		}
		if (flag) System.out.println("!");
		else System.out.println(sb);
	}

}