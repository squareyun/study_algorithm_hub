import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];
		dp[1] = 1;

		int temp = 0;
		for (int i = 2; i <= n; i++) {
			temp = Integer.MAX_VALUE;

			for (int j = 1; j * j <= i; j++) {
				temp = Math.min(temp, dp[i - j * j]);
			}

			dp[i] = temp + 1;
		}

		System.out.println(dp[n]);
	}

}