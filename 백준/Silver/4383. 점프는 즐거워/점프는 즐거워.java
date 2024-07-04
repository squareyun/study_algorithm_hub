import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input;
		while ((input = br.readLine()) != null && !input.isBlank()) {
			StringTokenizer st = new StringTokenizer(input);
			N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			boolean[] v = new boolean[N];
			arr[0] = Integer.parseInt(st.nextToken());
			for (int i = 1; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				int diff = Math.abs(arr[i-1] - arr[i]);
				if (diff < N) v[diff] = true;
			}

			boolean flag = true;
			for (int i = 1; i < N; i++) {
				if (!v[i]) {
					System.out.println("Not jolly");
					flag = false;
					break;
				}
			}
			if (flag) System.out.println("Jolly");
		}
	}
}