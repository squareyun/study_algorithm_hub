import java.util.*;
import java.io.*;

public class Main {

	static int N, S;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int s = 0, e = 0;
		int sum = 0;
		int len = Integer.MAX_VALUE;
		while (s <= e && e <= N) {
			if (sum >= S) {
				len = Math.min(len, e - s);
				sum -= arr[s++];
			} else {
				sum += arr[e++];
			}
		}
		System.out.println((len == Integer.MAX_VALUE) ? 0 : len);
	}
}