import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solve());
	}

	static String solve() {
		if (N == 1) {
			if (arr[0] != 0)
				return String.valueOf(arr[0]);
			else
				return "1";
		}

		if (arr[0] == 0) {
			arr[0] = (arr[1] == 1 ? 2 : 1);
		}
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				if (arr[i] == arr[i + 1])
					return "-1";
				continue;
			} else if (i == N - 1) {
				if (arr[i] == arr[i - 1])
					return " -1;";
				continue;
			}

			if (arr[i] != 0 && arr[i - 1] != 0 && arr[i + 1] != 0) {
				if (arr[i] == arr[i - 1])
					return "-1";
				continue;
			}

			if (arr[i] == 0) {
				if (arr[i - 1] == 1) {
					arr[i] = (arr[i + 1] == 2 ? 3 : 2);
				} else if (arr[i - 1] == 2) {
					arr[i] = (arr[i + 1] == 1 ? 3 : 1);
				} else if (arr[i - 1] == 3) {
					arr[i] = (arr[i + 1] == 1 ? 2 : 1);
				}
			}
		}

		if (arr[N - 1] == 0) {
			arr[N - 1] = (arr[N - 2] == 1 ? 2 : 1);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append(" ");
		}
		return sb.toString();
	}
}