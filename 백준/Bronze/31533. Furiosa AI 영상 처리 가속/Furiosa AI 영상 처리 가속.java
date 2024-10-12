import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		if (m > n) {
			int temp = m;
			m = n;
			n = temp;
		}
		double ans = Math.min((double)m / a * 2, n);
		if (ans == Math.floor(ans)) {
			System.out.println((int)ans);
		} else {
			System.out.printf("%.7f", ans);
		}
	}
}