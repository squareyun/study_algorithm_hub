import java.util.*;
import java.io.*;

public class Main {

	static int T, N;
	static int[] arr;
	static int answer;
	static HashSet<Integer> hs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			answer = 0;
			hs = new HashSet<>();

			st = new StringTokenizer(br.readLine());
			int x;
			for (int i = 0; i < N; i++) {
				x = Integer.parseInt(st.nextToken());
				arr[i] = x;
				hs.add(x);
			}
			Arrays.sort(arr);
			// System.out.println(Arrays.toString(arr));

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (hs.contains(2 * arr[j] - arr[i])) {
						answer++;
					}
				}
			}

			System.out.println(answer);
		}
	}
}