import java.util.*;
import java.io.*;

public class Main {

	static int A, B;
	static int m;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		int[] arr = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long num = 0;
		for (int i = 0; i < m; i++) {
			num += (long)(arr[m - i - 1] * Math.pow(A, i));
		}
		List<Long> ans = new ArrayList<>();
		while (num != 0) {
			ans.add(num % B);
			num /= B;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = ans.size() - 1; i >= 0; i--) {
			sb.append(ans.get(i)).append(" ");
		}
		System.out.println(sb);
	}

}