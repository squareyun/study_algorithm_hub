import java.util.*;
import java.io.*;

public class Main {

	static long n;
	static final long MOD = 1_000_000_007;
	static HashMap<Long, Long> hm = new HashMap();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Long.parseLong(br.readLine());
		hm.put(0L, 0L);
		hm.put(1L, 1L);
		hm.put(2L, 1L);
		long ans = fibo(n);
		System.out.println(ans);
	}

	static long fibo(long n) {
		if (hm.containsKey(n)) {
			return hm.get(n);
		}

		if ((n & 1) == 0) {
			long fn = fibo(n / 2);
			long fn_m1 = fibo(n / 2 - 1);
			hm.put(n, fn * (fn + 2 * fn_m1) % MOD);
		} else {
			long fn = fibo(n / 2);
			long fn_p1 = fibo(n / 2 + 1);
			hm.put(n, (fn * fn + fn_p1 * fn_p1) % MOD);
		}

		return hm.get(n);
	}
}