import java.util.*;
import java.io.*;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int ans = 0;
		if (N > 18) {
			ans += 2 * (N / 18);
			N %= 18;
		}
		ans += solve(N);
		System.out.println(ans);
	}

	private static int solve(int n) {
		if (n == 0) return 0;

		if (n < 10) return 1;

		for (int i = 9; i >= 1; i--) {
			if (n - (i + i) >= 0) {
				return 2 + solve(n - (i + i));
			}
		}

		return -100;
	}

}