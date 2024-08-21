import java.util.*;
import java.io.*;

public class Main {

	static int[] dp = new int[5001]; // 1: 과잉수, 2: 부족수, 3: 완전수

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n;
		while (T-- > 0) {
			n = Integer.parseInt(br.readLine());
			if (solve(n))
				sb.append("Good Bye");
			else
				sb.append("BOJ 2022");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static boolean solve(int n) {
		if (dp[n] != 0 && dp[n] != 1)
			return false;

		List<Integer> list = divisor(n);
		
		if (dp[n] == 0 && !isGawing(n, list))
			return false;

		for (int a : list) {
			if (a == n) continue;

			if (dp[a] == 1) return false;
			else if (dp[a] == 0 && isGawing(a, divisor(a))) return false;
		}

		return true;
	}

	private static boolean isGawing(int n, List<Integer> list) {

		int sum = 0;
		for (int a : list) {
			if (a != n) sum += a;
		}

		if (sum > n) dp[n] = 1;
		else if (sum < n) dp[n] = 2;
		else dp[n] = 3;

		return dp[n] == 1;
	}

	private static List<Integer> divisor(int n) {
		List<Integer> ret = new ArrayList<>();

		for (int i = 1; i * i <= n; i++) {
			if (i * i == n)
				ret.add(i);
			else if (n % i == 0) {
				ret.add(i);
				ret.add(n / i);
			}
		}

		return ret;
	}

}