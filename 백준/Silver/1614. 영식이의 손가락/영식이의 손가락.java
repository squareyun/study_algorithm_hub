import java.util.*;
import java.io.*;

public class Main {

	static int broken;
	static long K;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		broken = Integer.parseInt(br.readLine());
		K = Long.parseLong(br.readLine());

		// 1234 -> 5432 -> 1234 -> 반복
		System.out.println(solve());
	}

	private static long solve() {
		long ans = 0;
		switch (broken) {
			case 1:
				return ans += K * 8L;
			case 5:
				return ans = 4 + K * 8L;
			case 2:
				ans += 1;
				ans += (K / 2) * 8;
				ans += (K % 2) * 6;
				return ans;
			case 3:
				ans += 2;
				ans += (K / 2) * 8;
				ans += (K % 2) * 4;
				return ans;
			case 4:
				ans += 3;
				ans += (K / 2) * 8;
				ans += (K % 2) * 2;
				return ans;
		}
		return ans;
	}

}