import java.util.*;
import java.io.*;

public class Main {

	static int N, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int all = N;
		int even = N / 2;
		int odd = (N % 2 == 0) ? N / 2 : N / 2 + 1;
		int k3 = N / 3 + ((N % 3 >= 1) ? 1 : 0);

		int ans = 1;
		if (m >= all) ans++;
		if (m >= even && N > 1) ans++;
		if (m >= odd && N > 1) ans++;
		if (m >= k3 && N > 2) ans++;
		if (m >= k3 + all && N > 2) ans++;
		if (m >= k3 + even && N > 2) ans++;
		if (m >= k3 + odd && N > 2) ans++;

		System.out.println(ans);
	}
}